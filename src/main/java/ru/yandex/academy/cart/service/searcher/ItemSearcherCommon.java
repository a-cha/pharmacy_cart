package ru.yandex.academy.cart.service.searcher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.dao.CommonItemRepo;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.item.CommonItemEntity;
import ru.yandex.academy.cart.model.error.ErrorCodes;
import ru.yandex.academy.cart.model.error.ModelException;

@Component
@RequiredArgsConstructor
public class ItemSearcherCommon implements ItemSearcherStrategy<CommonItemEntity> {

	private final CommonItemRepo repo;

	@Override
	public ItemTypeName getStrategyName() {
		return ItemTypeName.common;
	}

	@Override
	public CommonItemEntity searchItem(Long itemId) {
		return repo.findById(itemId).orElseThrow(() -> new ModelException(ErrorCodes.ITEM_NOT_FOUND.name()));
	}
}
