package by.tibon.springtraining;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import by.tibon.springtraining.controllers.OwnerController;
import by.tibon.springtraining.model.Owner;
import by.tibon.springtraining.services.map.OwnerServiceMap;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTests {
	@Mock
	OwnerServiceMap ownerService;

	@InjectMocks
	OwnerController ownerController;

	Set<Owner> owners;
	MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		owners = new HashSet<>();
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());

		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

	}

	@Test
	void listOfOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);

		mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("owner/index")).andExpect(model().attribute("owners", Matchers.hasSize(2)));
	}

	@Test
	public void findOwners() throws Exception {

		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("notImplementedYet"));

		verifyZeroInteractions(ownerService);
	}

}
