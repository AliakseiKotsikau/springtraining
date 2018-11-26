package by.tibon.springtraining.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Pet;
import by.tibon.springtraining.services.PetService;

@Service
@Profile({ "default", "map" })
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
