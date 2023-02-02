package ru.yandex.academy.cart.model.entity.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.yandex.academy.cart.model.ItemTypeName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@Getter
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseItem {

	@Id
	@Column(name = "id", nullable = false)
	Long id;

	@Basic
	@Column(name = "name")
	String name;

	@Basic
	@Column(name = "amount")
	Integer amount;

	@Basic
	@Column(name = "price")
	BigDecimal price;

	@Basic
	@Column(name = "dosage_form")
	String dosageForm;

	@Basic
	@Column(name = "manufacturer")
	String manufacturer;

	@Basic
	@Column(name = "barcode")
	String barcode;

	public abstract ItemTypeName getTypeName();
}
