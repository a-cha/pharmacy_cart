package ru.yandex.academy.cart.service.searcher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.dao.SpecialItemRepo;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.item.SpecialItemEntity;
import ru.yandex.academy.cart.model.error.ErrorCodes;
import ru.yandex.academy.cart.model.error.ModelException;

@Component
@RequiredArgsConstructor
public class ItemSearcherSpecial implements ItemSearcherStrategy<SpecialItemEntity> {

	private final SpecialItemRepo repo;

	@Override
	public ItemTypeName getStrategyName() {
		return ItemTypeName.special;
	}

	@Override
	public SpecialItemEntity searchItem(Long itemId) {
		return repo.findById(itemId).orElseThrow(() -> new ModelException(ErrorCodes.ITEM_NOT_FOUND.name()));
	}
}
