package com.darkai.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "forward:/index.html"; // Asegúrate de tener un archivo index.html en src/main/resources/static
	}

	@GetMapping("/principal")
	public String principal() {
		return "forward:/principal.html"; // Se espera un archivo principal.html en templates/
	}

	@GetMapping("/login")
	public String login() {
		return "forward:/login.html"; // Se espera un archivo login.html en templates/
	}

	@GetMapping("/register")
	public String register() {
		return "forward:/register.html"; // Se espera un archivo register.html en templates/
	}

	@GetMapping("/forums")
	public String forums() {
		return "forward:/forums.html"; // Se espera un archivo forums.html en templates/
	}

	@GetMapping("/assistant")
	public String assistant() {
		return "forward:/assistant.html";
	}

	@GetMapping("/materials")
	public String materials() {
		return "forward:/materials.html";
	}

	@GetMapping("/tutoring")
	public String tutoring() {
		return "forward:/tutoring.html";
	}
}





