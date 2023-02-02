package ru.yandex.academy.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.academy.cart.model.entity.item.SpecialItemEntity;

public interface SpecialItemRepo extends JpaRepository<SpecialItemEntity, Long> { }
