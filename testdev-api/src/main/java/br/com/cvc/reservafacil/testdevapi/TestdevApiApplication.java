package br.com.cvc.reservafacil.testdevapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.cvc.reservafacil.testdevapi.controller","br.com.cvc.reservafacil.testdevcore"})
public class TestdevApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestdevApiApplication.class, args);
	}
}