package ru.yandex.academy.cart.service.matcher;

import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.account.DoctorAccountEntity;
import ru.yandex.academy.cart.model.entity.account.UserAccountEntity;
import ru.yandex.academy.cart.model.entity.item.BaseItem;
import ru.yandex.academy.cart.model.entity.item.SpecialItemEntity;
import ru.yandex.academy.cart.model.error.ErrorCodes;
import ru.yandex.academy.cart.model.error.ModelException;

@Component
public class MatcherSpecialItem implements MatcherStrategy {
	@Override
	public ItemTypeName getStrategyName() {
		return ItemTypeName.special;
	}

	@Override
	public void matchNoAccount() {
		throw new ModelException(ErrorCodes.NO_USER_SPECIAL_ITEM.name());
	}

	@Override
	public void matchUser(BaseItem item, UserAccountEntity user) {
		throw new ModelException(ErrorCodes.ITEM_IS_SPECIAL.name());
	}

	@Override
	public void matchDoctor(BaseItem item, DoctorAccountEntity doctor) {
		if (!(doctor.getSpecialty().getItems().contains((SpecialItemEntity) item)))
			throw new ModelException(ErrorCodes.ITEM_SPECIAL_WRONG_SPECIFIC.name());
	}

}
