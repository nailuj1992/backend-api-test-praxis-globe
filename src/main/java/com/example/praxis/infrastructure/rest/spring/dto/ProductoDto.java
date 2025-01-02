package com.example.praxis.infrastructure.rest.spring.dto;

import java.math.BigDecimal;
import java.util.Set;

public class ProductoDto {

	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;

	private Set<PromocionDto> promociones;

	public ProductoDto() {
	}

	public ProductoDto(Long id, String nombre, String descripcion, BigDecimal precio, Set<PromocionDto> promociones) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.promociones = promociones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Set<PromocionDto> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<PromocionDto> promociones) {
		this.promociones = promociones;
	}

}
