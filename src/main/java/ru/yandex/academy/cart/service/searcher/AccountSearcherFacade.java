package ru.yandex.academy.cart.service.searcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.academy.cart.dao.AccountRepo;
import ru.yandex.academy.cart.model.entity.account.BaseAccount;
import ru.yandex.academy.cart.model.entity.account.DoctorAccountEntity;
import ru.yandex.academy.cart.model.entity.account.UserAccountEntity;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class AccountSearcherFacade {
	Set<AccountRepo<?>> repositories;

	@Autowired
	public AccountSearcherFacade(AccountRepo<UserAccountEntity> userAccountRepo,
	                             AccountRepo<DoctorAccountEntity> doctorAccountRepo) {
		repositories = new HashSet<>();

		repositories.add(userAccountRepo);
		repositories.add(doctorAccountRepo);
	}

	public BaseAccount searchAccount(Long id) {
		for (AccountRepo<?> repo : repositories) {
			Optional<?> account = repo.findById(id);

			if (account.isPresent()) return (BaseAccount) account.get();
		}
		return null;
	}
}
