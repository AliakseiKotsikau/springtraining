package by.tibon.springtraining.services.map;

import java.util.Map;

import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.model.Pet;
import by.tibon.springtraining.services.OwnerService;
import by.tibon.springtraining.services.PetService;
import by.tibon.springtraining.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner object) {
		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if (pet.getType() != null) {
						if (pet.getType().getId() == null) { // if petType was assigned, but not saved - we save it
							pet.setType(petTypeService.save(pet.getType()));
						}

					} else {
						throw new RuntimeException("Pet Type is required");
					}

					if (pet.getId() == null) { // if pet was assigned, but not saved - we save it
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}

			return super.save(object);
		} else
			return null;
	}

	@Override
	public Owner findByLastName(String lastName) {
		Owner owner = null;
		for (Map.Entry<Long, Owner> entry : map.entrySet()) {
			if (entry.getValue().getLastName().equalsIgnoreCase(lastName)) {
				owner = entry.getValue();
			}
		}
		return owner;
	}

}
