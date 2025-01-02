package com.example.praxis.infrastructure.rest.spring.resources;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.praxis.application.service.ProductoService;
import com.example.praxis.application.service.PromocionService;
import com.example.praxis.domain.Promocion;
import com.example.praxis.infrastructure.rest.spring.dto.ProductInfoDto;
import com.example.praxis.infrastructure.rest.spring.dto.ProductoDto;
import com.example.praxis.infrastructure.rest.spring.dto.PromocionDto;
import com.example.praxis.infrastructure.rest.spring.mapper.ProductoMapper;
import com.example.praxis.infrastructure.rest.spring.mapper.PromocionMapper;

@RestController
public class Resources {

	private final ProductoService productoService;
	private final ProductoMapper productoMapper;

	private final PromocionService promocionService;
	private final PromocionMapper promocionMapper;

	public Resources(PromocionService promocionService, PromocionMapper promocionMapper,
			ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
		this.promocionService = promocionService;
		this.promocionMapper = promocionMapper;
	}

	@GetMapping("products/product/{id}")
	public ResponseEntity<ProductInfoDto> getProductById(@PathVariable Long id) {
		try {
			ProductoDto productoDto = productoMapper.toDto(productoService.getProducto(id));

			final ProductInfoDto resp = new ProductInfoDto();
			resp.setNombre(productoDto.getNombre());
			resp.setPrecioOriginal(productoDto.getPrecio());

			List<Promocion> promotions = promocionService.findActualPromotionsForProduct(id);
			if (promotions != null && !promotions.isEmpty()) {
				List<PromocionDto> promotionsDto = promocionMapper.toDtoList(promotions);

				promotionsDto.stream().forEach(item -> {
					resp.setPorcentajeDescuento(item.getPorcentajeDescuento());

					double valorDescuento = productoDto.getPrecio().doubleValue()
							* (item.getPorcentajeDescuento().doubleValue() / 100);
					resp.setValorDescuento(new BigDecimal(valorDescuento));

					double precioFinal = productoDto.getPrecio().doubleValue() - valorDescuento;
					resp.setPrecioFinal(new BigDecimal(precioFinal));
				});
			} else {
				resp.setPorcentajeDescuento(new BigDecimal(0));
				resp.setValorDescuento(new BigDecimal(0));
				resp.setPrecioFinal(productoDto.getPrecio());
			}

			return new ResponseEntity<>(resp, HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
