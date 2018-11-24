package by.tibon.springtraining.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Pet;
import by.tibon.springtraining.repository.PetRepository;
import by.tibon.springtraining.services.PetService;

@Service
@Profile("jpa")
public class PetServiceJpa implements PetService {

	private PetRepository petRepository;

	public PetServiceJpa(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;

	}

	@Override
	public Pet findById(Long id) {

		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet obj) {
		return petRepository.save(obj);
	}

	@Override
	public void delete(Pet obj) {
		// TODO Auto-generated method stub
		petRepository.delete(obj);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);

	}

}
