package com.example.praxis.infrastructure.db.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.praxis.infrastructure.db.springdata.dbo.ProductoEntity;

@Repository
public interface SpringDataProductoRepository extends JpaRepository<ProductoEntity, Long> {

}
