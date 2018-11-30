package pet.clinic.data;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.repository.OwnerRepository;
import by.tibon.springtraining.repository.PetRepository;
import by.tibon.springtraining.repository.PetTypeRepository;
import by.tibon.springtraining.services.jpa.OwnerServiceJpa;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceJpaTests {

	@InjectMocks
	OwnerServiceJpa ownerService;

	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;

	final Long ownerId = 1L;
	final String lastName = "Jojo";

	Owner returnedOwner;

	@BeforeEach
	void setUp() {
		returnedOwner = Owner.builder().id(ownerId).lastName(lastName).build();
	}

//	@Test
//	void findAll() {
//
//		Set<Owner> owners = ownerRepository.findByLastName(lastName);
//		Assertions.assertNotNull(owners);
//
//		Assertions.assertEquals(1, owners.size());
//	}

	@Test
	void findByLastName() {

		when(ownerRepository.findByLastName(Mockito.any())).thenReturn(returnedOwner);

		Owner owner = ownerService.findByLastName(lastName);

		Assertions.assertNotNull(owner);

		Assertions.assertEquals(lastName, owner.getLastName());
	}

	@Test
	void delete() {
		ownerService.delete(returnedOwner);

		verify(ownerRepository, times(1)).delete(Mockito.any());
	}

}
