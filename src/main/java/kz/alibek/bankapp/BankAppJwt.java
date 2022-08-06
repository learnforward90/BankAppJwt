package kz.alibek.bankapp;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "basicauth",
				scheme = "bearer",
				type = SecuritySchemeType.HTTP,
				in = SecuritySchemeIn.HEADER,
				bearerFormat = "JWT")
public class BankAppJwt {
	public static void main(String[] args) {
		SpringApplication.run(BankAppJwt.class, args);
	}
}
