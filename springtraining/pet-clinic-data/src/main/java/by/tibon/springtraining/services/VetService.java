package by.tibon.springtraining.services;

import java.util.Set;

import by.tibon.springtraining.model.Vet;

public interface VetService {

	Vet findbyID(Long id);

	Vet save(Vet owner);

	Set<Vet> findAll();

}
