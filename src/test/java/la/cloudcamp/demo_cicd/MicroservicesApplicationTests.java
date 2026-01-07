package la.cloudcamp.demo_cicd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MicroservicesApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void contextLoads() {
		// Verifica que la aplicación arranca correctamente
	}

	@Test
	void helloEndpointReturnsDefaultMessage() {
		webTestClient.get().uri("/hello")
			.exchange()
			.expectStatus().isOk()
			.expectBody(String.class)
			.isEqualTo("Hello World!");
	}

	@Test
	void helloEndpointHttpStatusOk() {
		webTestClient.get().uri("/hello")
			.exchange()
			.expectStatus().isOk();
	}

	@Test
	void helloEndpointWithCustomName() {
		webTestClient.get().uri("/hello?name=GitHub")
			.exchange()
			.expectStatus().isOk()
			.expectBody(String.class)
			.isEqualTo("Hello GitHub!");
	}

	@Test
	void helloEndpointWithEmptyName() {
		webTestClient.get().uri("/hello?name=")
			.exchange()
			.expectStatus().isOk()
			.expectBody(String.class)
			.isEqualTo("Hello !");
	}
}
