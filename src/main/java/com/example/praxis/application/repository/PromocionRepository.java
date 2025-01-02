package com.example.praxis.application.repository;

import java.util.List;

import com.example.praxis.domain.Promocion;

public interface PromocionRepository {

	Promocion findById(Long id);

	List<Promocion> findActualPromotionsForProduct(Long productoId);

}
