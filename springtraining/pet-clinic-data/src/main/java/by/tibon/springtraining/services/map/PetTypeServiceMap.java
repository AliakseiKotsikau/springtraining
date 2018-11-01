package by.tibon.springtraining.services.map;

import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.PetType;
import by.tibon.springtraining.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
