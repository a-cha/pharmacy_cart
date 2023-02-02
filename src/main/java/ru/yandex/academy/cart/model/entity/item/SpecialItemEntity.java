package ru.yandex.academy.cart.model.entity.item;

import lombok.*;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.account.SpecialtyEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "special_item", schema = "public", catalog = "pharmacy")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class SpecialItemEntity extends BaseItem {

	@ManyToOne
	@JoinColumn(name = "specialty_id", referencedColumnName = "id", nullable = false)
	@ToString.Exclude
	SpecialtyEntity specialty;

	@Override
	public ItemTypeName getTypeName() {
		return ItemTypeName.special;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SpecialItemEntity that)) return false;

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
