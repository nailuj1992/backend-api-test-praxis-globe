package com.example.praxis.infrastructure.db.springdata.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.praxis.domain.Promocion;
import com.example.praxis.infrastructure.db.springdata.dbo.PromocionEntity;

@Mapper(componentModel = "spring")
public interface PromocionEntityMapper {

	Promocion toDomain(PromocionEntity promocionEntity);

	List<Promocion> toDomainList(List<PromocionEntity> promocionesEntity);

}
