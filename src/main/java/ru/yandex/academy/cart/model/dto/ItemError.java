package ru.yandex.academy.cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter @Setter
public class ItemError {
	private String item_id;
	private String problem;
}
