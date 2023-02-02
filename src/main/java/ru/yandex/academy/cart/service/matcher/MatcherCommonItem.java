package ru.yandex.academy.cart.service.matcher;

import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.account.DoctorAccountEntity;
import ru.yandex.academy.cart.model.entity.account.UserAccountEntity;
import ru.yandex.academy.cart.model.entity.item.BaseItem;
import ru.yandex.academy.cart.model.error.ErrorCodes;
import ru.yandex.academy.cart.model.error.ModelException;

@Component
public class MatcherCommonItem implements MatcherStrategy {
	@Override
	public ItemTypeName getStrategyName() {
		return ItemTypeName.common;
	}

	@Override
	public void matchNoAccount() {
		throw new ModelException(ErrorCodes.NO_USER.name());
	}

	@Override
	public void matchUser(BaseItem item, UserAccountEntity user) { }

	@Override
	public void matchDoctor(BaseItem item, DoctorAccountEntity doctor) { }

}
