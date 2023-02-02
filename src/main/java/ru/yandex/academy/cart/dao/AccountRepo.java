package ru.yandex.academy.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.academy.cart.model.entity.account.BaseAccount;

public interface AccountRepo<T extends BaseAccount> extends JpaRepository<T, Long> { }
