package com.example.praxis.infrastructure.db.springdata.dbo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Promocion")
public class PromocionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "porcentaje_descuento", nullable = false, precision = 5, scale = 2)
	private BigDecimal porcentajeDescuento;

	@Column(name = "fecha_inicio", nullable = false)
	private Date fechaInicio;

	@Column(name = "fecha_fin", nullable = false)
	private Date fechaFin;

	@ManyToMany(mappedBy = "promociones")
	private Set<ProductoEntity> productos;

	public PromocionEntity() {
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

	public Set<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductoEntity> productos) {
		this.productos = productos;
	}

}
