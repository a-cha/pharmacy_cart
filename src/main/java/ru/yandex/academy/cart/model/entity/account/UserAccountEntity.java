package ru.yandex.academy.cart.model.entity.account;

import lombok.*;
import ru.yandex.academy.cart.model.entity.item.ReceiptItemEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_account", schema = "public", catalog = "pharmacy")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class UserAccountEntity extends BaseAccount {

	@ManyToMany
	@JoinTable(
			name = "receipt",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "item_id") }
	)
	private Set<ReceiptItemEntity> receiptItems = new HashSet<>();


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserAccountEntity that)) return false;

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
