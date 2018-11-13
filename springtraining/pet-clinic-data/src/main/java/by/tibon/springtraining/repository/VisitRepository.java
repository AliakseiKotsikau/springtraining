package by.tibon.springtraining.repository;

import org.springframework.data.repository.CrudRepository;

import by.tibon.springtraining.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
