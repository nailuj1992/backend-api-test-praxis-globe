package com.example.praxis.infrastructure.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.praxis.application.repository.ProductoRepository;
import com.example.praxis.application.repository.PromocionRepository;
import com.example.praxis.application.service.ProductoService;
import com.example.praxis.application.service.PromocionService;

@Configuration
public class SpringBootServiceConfig {

	@Bean
	public ProductoService productoService(ProductoRepository productoRepository) {
		return new ProductoService(productoRepository);
	}

	@Bean
	public PromocionService promocionService(PromocionRepository promocionRepository) {
		return new PromocionService(promocionRepository);
	}

}
