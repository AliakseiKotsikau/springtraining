package by.tibon.springtraining.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.PetType;
import by.tibon.springtraining.repository.PetTypeRepository;
import by.tibon.springtraining.services.PetTypeService;

@Service
@Profile("jpa")
public class PetTypeServiceJpa implements PetTypeService {

	private PetTypeRepository petTypeRepository;

	public PetTypeServiceJpa(by.tibon.springtraining.repository.PetTypeRepository petTypeRepository) {
		super();
		petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> types = new HashSet<>();
		petTypeRepository.findAll().forEach(types::add);
		return types;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType obj) {
		return petTypeRepository.save(obj);
	}

	@Override
	public void delete(PetType obj) {
		petTypeRepository.delete(obj);

	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
