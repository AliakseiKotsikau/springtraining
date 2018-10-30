package by.tibon.springtraining.services.map;

import java.util.Map;

import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.services.OwnerService;

@Service
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
