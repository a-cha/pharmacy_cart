package ru.yandex.academy.cart.model.entity.account;

import lombok.*;
import ru.yandex.academy.cart.model.entity.item.SpecialItemEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialty", schema = "public", catalog = "pharmacy")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class SpecialtyEntity {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Basic
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "specialty")
	Set<SpecialItemEntity> items = new HashSet<>();


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SpecialtyEntity that)) return false;

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
