package by.tibon.springtraining.services.map;

import by.tibon.springtraining.model.Pet;

public class PetServiceMap extends AbstractMapService<Pet, Long> {

	@Override
	public Pet save(Pet obj) {
		super.save(obj.getId(), obj);
		return obj;
	}

}
