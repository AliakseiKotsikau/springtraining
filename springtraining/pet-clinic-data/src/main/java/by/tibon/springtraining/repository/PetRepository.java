package by.tibon.springtraining.repository;

import org.springframework.data.repository.CrudRepository;

import by.tibon.springtraining.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
