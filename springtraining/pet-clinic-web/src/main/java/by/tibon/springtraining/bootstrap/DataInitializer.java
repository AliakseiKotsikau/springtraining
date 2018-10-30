package by.tibon.springtraining.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.model.Vet;
import by.tibon.springtraining.services.OwnerService;
import by.tibon.springtraining.services.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;

	public DataInitializer(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Valera");
		owner1.setLastName("Moiseichik");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Kolia");
		owner2.setLastName("Monarhovich");

		ownerService.save(owner2);

		System.out.println("Owners saved ......");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sasha");
		vet1.setLastName("Shachnovich");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Dima");
		vet2.setLastName("Sinkevich");

		vetService.save(vet2);

		System.out.println("Vets saved .......");

	}

}
