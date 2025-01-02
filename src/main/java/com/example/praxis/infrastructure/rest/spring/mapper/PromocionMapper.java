package com.example.praxis.infrastructure.rest.spring.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.praxis.domain.Promocion;
import com.example.praxis.infrastructure.rest.spring.dto.PromocionDto;

@Mapper(componentModel = "spring")
public interface PromocionMapper {

	PromocionDto toDto(Promocion promocionEntity);

	List<PromocionDto> toDtoList(List<Promocion> promociones);

}
