package by.tibon.springtraining.services;

import java.util.Set;

import by.tibon.springtraining.model.Pet;

public interface PetService {

	Pet findbyID(Long id);

	Pet save(Pet owner);

	Set<Pet> findAll();
}
