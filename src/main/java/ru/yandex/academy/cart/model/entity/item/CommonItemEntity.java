package ru.yandex.academy.cart.model.entity.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.yandex.academy.cart.model.ItemTypeName;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "common_item", schema = "public", catalog = "pharmacy")
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class CommonItemEntity extends BaseItem {

	@Override
	public ItemTypeName getTypeName() {
		return ItemTypeName.common;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CommonItemEntity that)) return false;

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
