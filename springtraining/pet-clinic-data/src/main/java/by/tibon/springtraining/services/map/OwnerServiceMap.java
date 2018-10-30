package by.tibon.springtraining.services.map;

import java.util.Map;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		Owner owner = null;
		for (Map.Entry<Long, Owner> entry : map.entrySet()) {
			if (entry.getValue().getLastName().equalsIgnoreCase(lastName)) {
				owner = entry.getValue();
			}
		}
		return owner;
	}

	@Override
	public Owner save(Owner obj) {
		super.save(obj.getId(), obj);
		return obj;
	}

}
