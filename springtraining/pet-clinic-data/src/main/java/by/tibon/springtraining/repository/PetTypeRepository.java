package by.tibon.springtraining.repository;

import org.springframework.data.repository.CrudRepository;

import by.tibon.springtraining.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
