package la.cloudcamp.demo_cicd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class MicroservicesApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	void contextLoads() {
		// Verifica que la aplicación arranca correctamente
	}

	@Test
	void helloEndpointReturnsDefaultMessage() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello World!"));
	}

	@Test
	void helloEndpointHttpStatusOk() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk());
	}

	@Test
	void helloEndpointWithCustomName() throws Exception {
		mockMvc.perform(get("/hello?name=GitHub"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello GitHub!"));
	}

	@Test
	void helloEndpointWithEmptyName() throws Exception {
		mockMvc.perform(get("/hello?name="))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello !"));
	}
}
