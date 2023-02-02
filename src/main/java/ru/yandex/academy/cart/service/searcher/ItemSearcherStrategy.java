package ru.yandex.academy.cart.service.searcher;

import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.item.BaseItem;

public interface ItemSearcherStrategy<T extends BaseItem> {
	ItemTypeName getStrategyName();
	T searchItem(Long itemId);
}
