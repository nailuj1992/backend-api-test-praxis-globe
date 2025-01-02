package com.example.praxis.infrastructure.db.springdata.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.praxis.application.repository.PromocionRepository;
import com.example.praxis.domain.Promocion;
import com.example.praxis.infrastructure.db.springdata.dbo.PromocionEntity;
import com.example.praxis.infrastructure.db.springdata.mapper.PromocionEntityMapper;

@Service
public class PromocionDboRepository implements PromocionRepository {

	private final SpringDataPromocionRepository promocionRepository;

	private final PromocionEntityMapper promocionMapper;

	public PromocionDboRepository(SpringDataPromocionRepository promocionRepository,
			PromocionEntityMapper promocionMapper) {
		this.promocionRepository = promocionRepository;
		this.promocionMapper = promocionMapper;
	}

	@Override
	public Promocion findById(Long id) {
		return promocionMapper.toDomain(promocionRepository.findById(id).orElseThrow());
	}

	@Override
	public List<Promocion> findActualPromotionsForProduct(Long productoId) {
		List<Promocion> resp = null;

		List<PromocionEntity> promotions = promocionRepository.findActualPromotionsForProduct(productoId, new Date());
		if (promotions != null && !promotions.isEmpty()) {
			resp = new ArrayList<>();
			resp = promocionMapper.toDomainList(promotions);
		}

		return resp;
	}

}
