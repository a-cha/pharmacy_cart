package ru.yandex.academy.cart.model.error;

import lombok.Getter;

public enum ErrorCodes {
	WRONG_CATEGORY ("Ошибка парсинга категории товара - категория не найдена, в этом случае id не важен"),
	INCORRECT_ITEM_ID ("Ошибка парсинга id товара (категория спарсилась правильно - но id кривой)"),
	ITEM_NOT_FOUND ("Товар не найден (тип пользователя не важен)"),
	NO_USER ("Пользователь не найден, товар можно продать"),
	NO_USER_NO_RECEIPT ("Пользователь не найден, товар рецептурный"),
	NO_USER_SPECIAL_ITEM ("Пользователь не найден, товар специальный"),
	NO_RECEIPT ("Пользователь найден, товар рецептурный, у пользователя нет рецепта"),
	ITEM_IS_SPECIAL ("Пользователь найден, товар спец. назначения"),
	ITEM_SPECIAL_WRONG_SPECIFIC ("Пользователь врач, товар специальный, но не совпал по сфере работы врача");

	@Getter
	private final String description;

	ErrorCodes(String description) {
		this.description = description;
	}
}
