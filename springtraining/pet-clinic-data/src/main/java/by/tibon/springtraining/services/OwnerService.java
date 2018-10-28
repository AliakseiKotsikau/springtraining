package by.tibon.springtraining.services;

import by.tibon.springtraining.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}
