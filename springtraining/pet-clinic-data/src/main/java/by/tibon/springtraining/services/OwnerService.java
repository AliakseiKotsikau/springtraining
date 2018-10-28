package by.tibon.springtraining.services;

import java.util.Set;

import by.tibon.springtraining.model.Owner;

public interface OwnerService {

	Owner findByLastName(String lastName);

	Owner findbyID(Long id);

	Owner save(Owner owner);

	Set<Owner> findAll();
}
