package com.example.demo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@GetMapping("/")
//	public String\ welcome(@RequestParam(value = "myName", defaultValue = "World") String name) {
//		return String.format("welcome %s!", name);
//	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/ok")
	public String sayello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("ok %s!", name);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping (value="/clickme", headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<JsonNode> ClickMeEndpoint(HttpServletRequest request) throws Exception {
		String input = (String) request.getParameter("name");
		String output = "hello " + input + " :)";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode json = mapper.readTree("{\"id\": \"132\", \"name\": \"Alice\"}");
		return ResponseEntity.ok(json);
	}

}
