package com.example.praxis.infrastructure.db.springdata.mapper;

import org.mapstruct.Mapper;

import com.example.praxis.domain.Producto;
import com.example.praxis.infrastructure.db.springdata.dbo.ProductoEntity;

@Mapper(componentModel = "spring")
public interface ProductoEntityMapper {

	Producto toDomain(ProductoEntity userEntity);

}
