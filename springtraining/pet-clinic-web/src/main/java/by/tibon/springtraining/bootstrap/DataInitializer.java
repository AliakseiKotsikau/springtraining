package by.tibon.springtraining.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.model.Pet;
import by.tibon.springtraining.model.PetType;
import by.tibon.springtraining.model.Speciality;
import by.tibon.springtraining.model.Vet;
import by.tibon.springtraining.model.Visit;
import by.tibon.springtraining.services.OwnerService;
import by.tibon.springtraining.services.PetTypeService;
import by.tibon.springtraining.services.SpecialityService;
import by.tibon.springtraining.services.VetService;
import by.tibon.springtraining.services.VisitService;

@Component
public class DataInitializer implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;
	private PetTypeService petTypeService;
	private SpecialityService specialityService;
	private VisitService visitService;

	public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		if (petTypeService.findAll().size() == 0)
			loadData();

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Piosik");
		PetType savedDog = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Kotik");
		PetType savedCat = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(radiology);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(radiology);

		Owner owner1 = new Owner();
		owner1.setFirstName("Valera");
		owner1.setLastName("Moiseichik");
		owner1.setAddress("Rotmistrova street 62");
		owner1.setCity("Minsk");
		owner1.setTelephone("555-55-55");

		Pet valerasPet = new Pet();
		valerasPet.setType(savedDog);
		valerasPet.setOwner(owner1);
		valerasPet.setName("Patrik");
		valerasPet.setBirthDate(LocalDate.now());
		owner1.getPets().add(valerasPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Kolia");
		owner2.setLastName("Monarhovich");
		owner2.setAddress("Academicheskay street 3");
		owner2.setCity("Ozero");
		owner2.setTelephone("333-33-33");

		Pet koliasCat = new Pet();
		koliasCat.setName("Poltos");
		koliasCat.setBirthDate(LocalDate.now());
		koliasCat.setType(savedCat);
		koliasCat.setOwner(owner2);
		owner2.getPets().add(koliasCat);

		ownerService.save(owner2);

		Visit catVisit = new Visit();
		catVisit.setPet(koliasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Kotik-Kotik");

		visitService.save(catVisit);

		System.out.println("Owners saved ......");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sasha");
		vet1.setLastName("Shachnovich");
		vet1.getSpecialities().add(savedSurgery);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Dima");
		vet2.setLastName("Sinkevich");
		vet2.getSpecialities().add(savedDentistry);

		vetService.save(vet2);

		System.out.println("Vets saved .......");
	}

}
