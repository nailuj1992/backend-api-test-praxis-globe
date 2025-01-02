package com.example.praxis.application.service;

import com.example.praxis.application.repository.ProductoRepository;
import com.example.praxis.domain.Producto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductoService {

	private final ProductoRepository productoRepository;

	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public Producto getProducto(Long id) {

		return productoRepository.findById(id);
	}

}
