package by.tibon.springtraining.services.map;

import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Visit;
import by.tibon.springtraining.services.VisitService;

@Service
//@Profile("map")
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

}
