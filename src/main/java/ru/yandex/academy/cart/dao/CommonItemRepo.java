package ru.yandex.academy.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.academy.cart.model.entity.item.CommonItemEntity;

public interface CommonItemRepo extends JpaRepository<CommonItemEntity, Long> { }
