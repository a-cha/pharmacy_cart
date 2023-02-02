package ru.yandex.academy.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.dto.ItemError;
import ru.yandex.academy.cart.model.entity.account.BaseAccount;
import ru.yandex.academy.cart.model.entity.item.BaseItem;
import ru.yandex.academy.cart.model.error.ErrorCodes;
import ru.yandex.academy.cart.model.error.ModelException;
import ru.yandex.academy.cart.service.matcher.MatcherStrategyFactory;
import ru.yandex.academy.cart.service.searcher.AccountSearcherFacade;
import ru.yandex.academy.cart.service.searcher.ItemSearcherStrategyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CheckCartService {

	private final AccountSearcherFacade accountSearcherFacade;
	private final ItemSearcherStrategyFactory itemSearcherStrategyFactory;
	private final MatcherStrategyFactory matcherStrategyFactory;

	public List<ItemError> checkCart(Long accountId, List<String> itemsId) {
		List<ItemError> result = new ArrayList<>(itemsId.size());
		BaseAccount account = accountSearcherFacade.searchAccount(accountId);
		List<BaseItem> items = fillAllItemsAndCatchErrors(itemsId, result);

		items.forEach(item -> {
			try {
				matcherStrategyFactory.getStrategy(item.getTypeName()).match(item, account);
			} catch (ModelException e) {
				result.add(new ItemError(item.getTypeName() + "_" + item.getId(), e.getMessage()));
			}
		});

		return result;
	}

	private List<BaseItem> fillAllItemsAndCatchErrors(List<String> itemsId, List<ItemError> result) {
		List<BaseItem> items;
		items = new ArrayList<>(itemsId.size());
		itemsId.forEach(id -> {
					try {
						BaseItem item = itemSearcherStrategyFactory
								.getStrategy(parseItemType(id))
								.searchItem(parseItemId(id));

						items.add(item);

					} catch (ModelException e) {
						result.add(new ItemError(id, e.getMessage()));
					}
				}
		);
		return items;
	}

	private ItemTypeName parseItemType(String itemId) {
		try {
			return ItemTypeName.valueOf(itemId.split("_")[0].toLowerCase(Locale.ROOT));
		} catch (Exception e) {
			throw new ModelException(ErrorCodes.WRONG_CATEGORY.name());
		}
	}

	private Long parseItemId(String itemId) {
		try {
			return Long.valueOf(itemId.split("_")[1]);
		} catch (Exception e) {
			throw new ModelException(ErrorCodes.INCORRECT_ITEM_ID.name());
		}
	}

}
