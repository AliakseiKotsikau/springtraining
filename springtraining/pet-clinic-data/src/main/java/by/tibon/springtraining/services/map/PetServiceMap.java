package by.tibon.springtraining.services.map;

import by.tibon.springtraining.model.Pet;
import by.tibon.springtraining.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet obj) {
		super.save(obj.getId(), obj);
		return obj;
	}

}
