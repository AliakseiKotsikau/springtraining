package by.tibon.springtraining.services.map;

import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Pet;
import by.tibon.springtraining.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
