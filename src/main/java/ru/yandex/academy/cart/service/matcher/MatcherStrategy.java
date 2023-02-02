package ru.yandex.academy.cart.service.matcher;

import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.account.BaseAccount;
import ru.yandex.academy.cart.model.entity.account.DoctorAccountEntity;
import ru.yandex.academy.cart.model.entity.account.UserAccountEntity;
import ru.yandex.academy.cart.model.entity.item.BaseItem;

public interface MatcherStrategy {
	ItemTypeName getStrategyName();

	void matchNoAccount();
	void matchUser(BaseItem item, UserAccountEntity user);
	void matchDoctor(BaseItem item, DoctorAccountEntity doctor);

	default void match(BaseItem item, BaseAccount account) {
		switch (account) {
			case null -> matchNoAccount();
			case UserAccountEntity user -> matchUser(item, user);
			case DoctorAccountEntity doctor -> matchDoctor(item, doctor);
			default -> throw new IllegalStateException("Unexpected account type");
		}
	}
}
