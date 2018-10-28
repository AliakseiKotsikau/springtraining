package by.tibon.springtraining.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import by.tibon.springtraining.services.CrudService;

public abstract class AbstractMapService<T, ID> implements CrudService<T, ID> {

	protected Map<ID, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	public T save(ID id, T object) {
		map.put(id, object);
		return object;
	}

	public void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	public void deleteById(ID id) {
		map.remove(id);
	}
}