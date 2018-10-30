package by.tibon.springtraining.services.map;

import by.tibon.springtraining.model.Vet;
import by.tibon.springtraining.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet obj) {
		super.save(obj.getId(), obj);
		return obj;
	}

}
