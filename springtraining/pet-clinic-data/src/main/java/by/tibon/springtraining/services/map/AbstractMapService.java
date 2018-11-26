package by.tibon.springtraining.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.context.annotation.Profile;

import by.tibon.springtraining.model.BaseEntity;

@Profile({ "default", "map" })
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else
			throw new RuntimeException("Null object");
		return object;
	}

	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	public void deleteById(ID id) {
		map.remove(id);
	}

	private Long getNextId() {
		Long id = null;
		try {
			id = Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			id = 1L;
		}
		return id;
	}
}
