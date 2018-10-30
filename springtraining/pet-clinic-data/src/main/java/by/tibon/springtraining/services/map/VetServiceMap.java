package by.tibon.springtraining.services.map;

import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Vet;
import by.tibon.springtraining.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet obj) {
		super.save(obj.getId(), obj);
		return obj;
	}

}
