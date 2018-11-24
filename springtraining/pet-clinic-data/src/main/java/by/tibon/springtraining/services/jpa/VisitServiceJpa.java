package by.tibon.springtraining.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Visit;
import by.tibon.springtraining.repository.VisitRepository;
import by.tibon.springtraining.services.VisitService;

@Service
@Profile("jpa")
public class VisitServiceJpa implements VisitService {

	private VisitRepository visitRepository;

	public VisitServiceJpa(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {

		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit obj) {

		return visitRepository.save(obj);
	}

	@Override
	public void delete(Visit obj) {

		visitRepository.delete(obj);
	}

	@Override
	public void deleteById(Long id) {

		visitRepository.deleteById(id);
	}

}
