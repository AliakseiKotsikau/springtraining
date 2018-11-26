package by.tibon.springtraining.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Speciality;
import by.tibon.springtraining.services.SpecialityService;

@Service
@Profile({ "default", "map" })
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
