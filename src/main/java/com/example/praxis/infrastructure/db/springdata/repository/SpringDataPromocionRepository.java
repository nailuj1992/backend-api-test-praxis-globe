package com.example.praxis.infrastructure.db.springdata.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.praxis.infrastructure.db.springdata.dbo.PromocionEntity;

@Repository
public interface SpringDataPromocionRepository extends JpaRepository<PromocionEntity, Long> {

	@Query("SELECT promo FROM PromocionEntity promo LEFT JOIN promo.productos prod WHERE prod.id = :productoId "
			+ "AND promo.fechaInicio <= :fecha  AND promo.fechaFin >= :fecha")
	List<PromocionEntity> findActualPromotionsForProduct(@Param("productoId") Long productoId,
			@Param("fecha") Date fecha);

}
