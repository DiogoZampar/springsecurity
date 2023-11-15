package br.com.diogozampar.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}










@RestController
class HttpController{

	@GetMapping
	String publicRoute(){
		return "Welcome to "+ this.getClass().getName() + "!";
	}


}