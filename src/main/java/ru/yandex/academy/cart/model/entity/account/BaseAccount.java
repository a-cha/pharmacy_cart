package ru.yandex.academy.cart.model.entity.account;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseAccount {

	@Id
	@Column(name = "id", nullable = false)
	Long id;

	@Basic
	@Column(name = "full_name")
	String fullName;

	@Basic
	@Column(name = "phone")
	String phone;

	@Basic
	@Column(name = "password_hash")
	String passwordHash;

}
