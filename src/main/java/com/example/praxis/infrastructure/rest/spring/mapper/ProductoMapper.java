package com.example.praxis.infrastructure.rest.spring.mapper;

import org.mapstruct.Mapper;

import com.example.praxis.domain.Producto;
import com.example.praxis.infrastructure.rest.spring.dto.ProductoDto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

	ProductoDto toDto(Producto productoEntity);

}
