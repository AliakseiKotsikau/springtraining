package by.tibon.springtraining.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Vet;
import by.tibon.springtraining.repository.VetRepository;
import by.tibon.springtraining.services.VetService;

@Service
@Profile("jpa")
public class VetServiceJpa implements VetService {

	private VetRepository vetRepository;

	public VetServiceJpa(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet obj) {

		return vetRepository.save(obj);
	}

	@Override
	public void delete(Vet obj) {
		vetRepository.delete(obj);

	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);

	}

}
