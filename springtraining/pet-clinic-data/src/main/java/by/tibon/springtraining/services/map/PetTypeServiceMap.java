package by.tibon.springtraining.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.PetType;
import by.tibon.springtraining.services.PetTypeService;

@Service
@Profile({ "default", "map" })
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
