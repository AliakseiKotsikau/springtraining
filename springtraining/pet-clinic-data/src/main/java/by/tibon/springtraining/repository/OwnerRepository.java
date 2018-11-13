package by.tibon.springtraining.repository;

import org.springframework.data.repository.CrudRepository;

import by.tibon.springtraining.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
