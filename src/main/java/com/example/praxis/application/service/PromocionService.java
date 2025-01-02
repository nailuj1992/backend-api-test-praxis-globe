package com.example.praxis.application.service;

import java.util.List;

import com.example.praxis.application.repository.PromocionRepository;
import com.example.praxis.domain.Promocion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PromocionService {

	private final PromocionRepository promocionRepository;

	public PromocionService(PromocionRepository promocionRepository) {
		this.promocionRepository = promocionRepository;
	}

	public Promocion getPromocion(Long id) {

		return promocionRepository.findById(id);
	}

	public List<Promocion> findActualPromotionsForProduct(Long productoId) {
		return promocionRepository.findActualPromotionsForProduct(productoId);
	}

}
