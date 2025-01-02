package com.example.praxis.infrastructure.db.springdata.repository;

import org.springframework.stereotype.Service;

import com.example.praxis.application.repository.ProductoRepository;
import com.example.praxis.domain.Producto;
import com.example.praxis.infrastructure.db.springdata.mapper.ProductoEntityMapper;

@Service
public class ProductoDboRepository implements ProductoRepository {

	private final SpringDataProductoRepository productoRepository;

	private final ProductoEntityMapper productoMapper;

	public ProductoDboRepository(SpringDataProductoRepository productoRepository, ProductoEntityMapper productoMapper) {
		this.productoRepository = productoRepository;
		this.productoMapper = productoMapper;
	}

	@Override
	public Producto findById(Long id) {
		return productoMapper.toDomain(productoRepository.findById(id).orElseThrow());
	}

}
