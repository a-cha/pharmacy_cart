package ru.yandex.academy.cart.model.entity.item;

import lombok.*;
import ru.yandex.academy.cart.model.ItemTypeName;
import ru.yandex.academy.cart.model.entity.account.UserAccountEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "receipt_item", schema = "public", catalog = "pharmacy")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class ReceiptItemEntity extends BaseItem {

	@ManyToMany(mappedBy = "receiptItems")
	@ToString.Exclude
	private Set<UserAccountEntity> users = new HashSet<>();

	@Override
	public ItemTypeName getTypeName() {
		return ItemTypeName.receipt;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ReceiptItemEntity that)) return false;

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
