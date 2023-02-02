package ru.yandex.academy.cart.model.entity.account;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_account", schema = "public", catalog = "pharmacy")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString(callSuper = true)
public class DoctorAccountEntity extends BaseAccount {

	@ManyToOne
	@JoinColumn(name = "specialty_id", referencedColumnName = "id", nullable = false)
	SpecialtyEntity specialty;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DoctorAccountEntity that)) return false;

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
