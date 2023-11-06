package com.neidev.ms;

import com.neidev.ms.core.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsApplication.class, args);
	}

}

@RestController
@RequestMapping("/kafka")
class MessagingController {

	private final Producer service;

	public MessagingController(Producer service) {
		this.service = service;
	}

	@GetMapping("/{name}")
	public String message(@PathVariable("name") String name) {
		service.sendMessage(name);
		return "OK";
	}
}
