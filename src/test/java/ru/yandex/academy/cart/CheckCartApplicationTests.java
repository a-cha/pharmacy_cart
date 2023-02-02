package ru.yandex.academy.cart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import javax.transaction.Transactional;

import ru.yandex.academy.cart.dao.AccountRepo;
import ru.yandex.academy.cart.model.error.ErrorCodes;
import ru.yandex.academy.cart.model.entity.account.BaseAccount;
import ru.yandex.academy.cart.model.entity.account.DoctorAccountEntity;
import ru.yandex.academy.cart.model.entity.account.UserAccountEntity;

@SpringBootTest
@AutoConfigureMockMvc
class CheckCartApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private AccountRepo<UserAccountEntity> userAccountRepo;
	@Autowired
	private AccountRepo<DoctorAccountEntity> doctorAccountRepo;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void inheritanceCheck() {
//		Optional<UserAccountEntity> byId = userAccountRepo.findById(1L);
//		UserAccountEntity acc =  userAccountRepo.getById(1L);

		BaseAccount baseUser =  userAccountRepo.getById(1L);
		BaseAccount baseDoctor =  doctorAccountRepo.getById(61L);
		UserAccountEntity user = (UserAccountEntity) baseUser;
		DoctorAccountEntity doctor = (DoctorAccountEntity) baseDoctor;

//		System.out.println(byId);
//		System.out.println(acc);
		System.out.println(baseUser);
		System.out.println(baseDoctor);
//		System.out.println(user);
//		System.out.println(doctor);
		System.out.println();
	}

	@Test
	void testEnum() {
		ErrorCodes error = ErrorCodes.ITEM_NOT_FOUND;

		System.out.println(error.name());
		System.out.println(error.getDescription());
	}
}
