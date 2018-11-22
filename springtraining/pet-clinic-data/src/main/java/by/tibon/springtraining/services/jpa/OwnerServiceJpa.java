package by.tibon.springtraining.services.jpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.repository.OwnerRepository;
import by.tibon.springtraining.repository.PetRepository;
import by.tibon.springtraining.repository.PetTypeRepository;
import by.tibon.springtraining.services.OwnerService;

@Service
@Profile("jpa")
public class OwnerServiceJpa implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerServiceJpa(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {

		Optional<Owner> owner = ownerRepository.findById(id);
		return owner.orElse(null);
	}

	@Override
	public Owner save(Owner obj) {
		Owner owner = ownerRepository.save(obj);
		return owner;
	}

	@Override
	public void delete(Owner obj) {
		ownerRepository.delete(obj);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);

	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
