package com.example.praxis.infrastructure.rest.spring.dto;

import java.math.BigDecimal;

public class ProductInfoDto {

	private String nombre;
	private BigDecimal precioOriginal;

	private BigDecimal porcentajeDescuento;
	private BigDecimal valorDescuento;

	private BigDecimal precioFinal;

	public ProductInfoDto() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public BigDecimal getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(BigDecimal valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public BigDecimal getPrecioOriginal() {
		return precioOriginal;
	}

	public void setPrecioOriginal(BigDecimal precioOriginal) {
		this.precioOriginal = precioOriginal;
	}

	public BigDecimal getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}

}
