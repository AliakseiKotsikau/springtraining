package by.tibon.springtraining.services.map;

import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Speciality;
import by.tibon.springtraining.services.SpecialityService;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
