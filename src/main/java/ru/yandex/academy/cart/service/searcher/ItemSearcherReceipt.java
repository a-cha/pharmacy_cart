package ru.yandex.academy.cart.service.searcher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.dao.ReceiptItemRepo;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.item.ReceiptItemEntity;
import ru.yandex.academy.cart.model.error.ErrorCodes;
import ru.yandex.academy.cart.model.error.ModelException;

@Component
@RequiredArgsConstructor
public class ItemSearcherReceipt implements ItemSearcherStrategy<ReceiptItemEntity> {

 	private final ReceiptItemRepo repo;

	@Override
	public ItemTypeName getStrategyName() {
		return ItemTypeName.receipt;
	}

	@Override
	public ReceiptItemEntity searchItem(Long itemId) {
		return repo.findById(itemId).orElseThrow(() -> new ModelException(ErrorCodes.ITEM_NOT_FOUND.name()));
	}
}
