package com.example.praxis.application.repository;

import com.example.praxis.domain.Producto;

public interface ProductoRepository {

	Producto findById(Long id);

}
