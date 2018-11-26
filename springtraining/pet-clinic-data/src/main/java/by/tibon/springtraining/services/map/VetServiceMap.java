package by.tibon.springtraining.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import by.tibon.springtraining.model.Speciality;
import by.tibon.springtraining.model.Vet;
import by.tibon.springtraining.services.SpecialityService;
import by.tibon.springtraining.services.VetService;

@Service
@Profile({ "default", "map" })
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;

	public VetServiceMap(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {

		if (object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(spec -> {
				if (spec.getId() == null) {
					Speciality savedSpec = specialityService.save(spec);
					spec.setId(savedSpec.getId());
				}
			});
		}

		return super.save(object);
	}

}
