package com.tcckaspper.banco.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Value;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

public class ConfigOpenApi {
	
	@Configuration
	public class OpenAPIConfig {
		
		@Value("${tcckaspper.opeanapi.dev-url}")
		public String devUrl;
		
		@Value("${tcckaspper.opeanapi.prod-url}")
		public String prodUrl;
		
		@Bean
		public OpenAPI myOpenAPI() {
			Server devServ = new Server();
			devServ.setUrl(devUrl);
			devServ.setDescription("URL de Desenvolvimento");
			
			Server prodServ = new Server();
			prodServ.setUrl(prodUrl);
			prodServ.setDescription("URL de produção");
			
			Contact contato = new Contact();
			contato.setEmail("tcckaspper@kaspper.com.br");
			contato.setName("TCC Group");
			contato.setUrl("kaspper.com.br");
			
			Info info = new Info()
					.title("API do banco de dados aluguel de buffet ")
					.version("1.0.0")
					.contact(contato)
					.description("API para endpoints de anúncios");
			
			return new OpenAPI()
					.info(info)
					.servers(List.of(devServ,prodServ));

			
		}
	}

}
