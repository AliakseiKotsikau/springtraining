package by.tibon.springtraining.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.model.Vet;
import by.tibon.springtraining.services.OwnerService;
import by.tibon.springtraining.services.VetService;
import by.tibon.springtraining.services.map.OwnerServiceMap;
import by.tibon.springtraining.services.map.VetServiceMap;

@Component
public class DataInitializer implements CommandLineRunner {

	private OwnerService ownerService;
	private VetService vetService;

	public DataInitializer() {
		super();
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Valera");
		owner1.setLastName("Moiseichik");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner1.setId(2L);
		owner1.setFirstName("Kolia");
		owner1.setLastName("Monarhovich");

		ownerService.save(owner2);

		System.out.println("Owners saved ......");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sasha");
		vet1.setLastName("Shachnovich");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet1.setId(2L);
		vet1.setFirstName("Dima");
		vet1.setLastName("Sinkevich");

		vetService.save(vet2);

		System.out.println("Vets saved .......");

	}

}
