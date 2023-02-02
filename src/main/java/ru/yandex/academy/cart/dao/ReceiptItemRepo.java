package ru.yandex.academy.cart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.academy.cart.model.entity.item.ReceiptItemEntity;

public interface ReceiptItemRepo extends JpaRepository<ReceiptItemEntity, Long> { }
