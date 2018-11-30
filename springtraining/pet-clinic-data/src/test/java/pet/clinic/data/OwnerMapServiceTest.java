package pet.clinic.data;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.services.map.OwnerServiceMap;
import by.tibon.springtraining.services.map.PetServiceMap;
import by.tibon.springtraining.services.map.PetTypeServiceMap;

public class OwnerMapServiceTest {

	OwnerServiceMap ownerServiceMap;
	final Long ownerId = 1L;
	final String lastName = "Jojo";

	@BeforeEach
	void setUp() {

		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());

	}

	@Test
	void findAll() {
		Set<Owner> owners = ownerServiceMap.findAll();

		Assertions.assertEquals(1, owners.size());
	}

	@Test
	void findById() {
		Owner owner = ownerServiceMap.findById(ownerId);

		Assertions.assertEquals(ownerId, owner.getId());
	}

	@Test
	void save() {
		Owner owner = Owner.builder().id(2L).build();

		Owner saved = ownerServiceMap.save(owner);

		Assertions.assertEquals(2L, owner.getId().longValue());

	}

	@Test
	void saveNoId() {
		Owner saved = ownerServiceMap.save(Owner.builder().build());

		Assertions.assertNotNull(saved);
		Assertions.assertNotNull(saved.getId());

	}

	@Test
	void findByLastName() {
		Owner owner = ownerServiceMap.findByLastName(lastName);

		Assertions.assertEquals(ownerId, owner.getId());
	}

}
