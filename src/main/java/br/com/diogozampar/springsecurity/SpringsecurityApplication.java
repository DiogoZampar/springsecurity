package br.com.diogozampar.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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



	@GetMapping("/public")
	String publicRoute(){
		return "Welcome to the public route!";
	}



	@GetMapping("/private")
	String privateRoute(@AuthenticationPrincipal OidcUser oidcUser){

		return "<h2>Welcome to the private route, " + oidcUser.getFullName() + "!</h2>" +
		"<h3>Email: " + oidcUser.getEmail() + "</h3>" +
		"<h3>Authorities: " + oidcUser.getAuthorities() + "</h3>" +
		"<h3>Token: " + oidcUser.getIdToken().getTokenValue() + "</h3>";
	}




}