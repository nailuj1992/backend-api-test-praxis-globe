package com.example.praxis.infrastructure.rest.spring.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PromocionDto {

	private Long id;
	private BigDecimal porcentajeDescuento;
	private Date fechaInicio;
	private Date fechaFin;

	public PromocionDto() {
	}

	public PromocionDto(Long id, BigDecimal porcentajeDescuento, Date fechaInicio, Date fechaFin) {
		this.id = id;
		this.porcentajeDescuento = porcentajeDescuento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
