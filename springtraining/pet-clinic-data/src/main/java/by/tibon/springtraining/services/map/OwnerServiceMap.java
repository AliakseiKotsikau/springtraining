package by.tibon.springtraining.services.map;

import by.tibon.springtraining.model.Owner;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> {

	@Override
	public Owner save(Owner obj) {
		super.save(obj.getId(), obj);
		return obj;
	}

}
