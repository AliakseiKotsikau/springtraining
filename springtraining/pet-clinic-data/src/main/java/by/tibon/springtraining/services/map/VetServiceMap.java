package by.tibon.springtraining.services.map;

import by.tibon.springtraining.model.Vet;

public class VetServiceMap extends AbstractMapService<Vet, Long> {

	@Override
	public Vet save(Vet obj) {
		super.save(obj.getId(), obj);
		return obj;
	}

}
