package by.tibon.springtraining.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Speciality;
import by.tibon.springtraining.repository.SpecialtyRepository;
import by.tibon.springtraining.services.SpecialityService;

@Service
@Profile("jpa")
public class SpecialityServiceJpa implements SpecialityService {

	private SpecialtyRepository specialityRepository;

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specs = new HashSet<>();
		specialityRepository.findAll().forEach(specs::add);
		return specs;
	}

	@Override
	public Speciality findById(Long id) {

		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality obj) {

		return specialityRepository.save(obj);
	}

	@Override
	public void delete(Speciality obj) {
		specialityRepository.delete(obj);

	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);

	}

}
