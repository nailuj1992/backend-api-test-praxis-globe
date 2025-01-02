package com.example.praxis.infrastructure.rest.spring.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.praxis.application.service.ProductoService;
import com.example.praxis.application.service.PromocionService;
import com.example.praxis.domain.Producto;
import com.example.praxis.domain.Promocion;
import com.example.praxis.infrastructure.rest.spring.dto.ProductInfoDto;
import com.example.praxis.infrastructure.rest.spring.dto.ProductoDto;
import com.example.praxis.infrastructure.rest.spring.dto.PromocionDto;
import com.example.praxis.infrastructure.rest.spring.mapper.ProductoMapper;
import com.example.praxis.infrastructure.rest.spring.mapper.PromocionMapper;

public class ResourcesTest {

	@Mock
	private ProductoService productoService;

	@Mock
	private ProductoMapper productoMapper;

	@Mock
	private PromocionService promocionService;

	@Mock
	private PromocionMapper promocionMapper;

	@InjectMocks
	private Resources resources;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetProductById_ProductWithPromotions() {
		// Arrange
		Long productId = 1L;

		Producto mockProducto = new Producto();
		mockProducto.setNombre("Producto 1");
		mockProducto.setPrecio(new BigDecimal(100.00));
		ProductoDto mockProductoDto = new ProductoDto();
		mockProductoDto.setNombre(mockProducto.getNombre());
		mockProductoDto.setPrecio(mockProducto.getPrecio());
		when(productoService.getProducto(productId)).thenReturn(mockProducto);
		when(productoMapper.toDto(mockProducto)).thenReturn(mockProductoDto);

		Promocion mockPromocion = new Promocion();
		mockPromocion.setPorcentajeDescuento(new BigDecimal(10));
		List<Promocion> mockPromotions = Arrays.asList(mockPromocion);
		when(promocionService.findActualPromotionsForProduct(productId)).thenReturn(mockPromotions);

		PromocionDto mockPromocionDto = new PromocionDto();
		mockPromocionDto.setPorcentajeDescuento(new BigDecimal(10));
		when(promocionMapper.toDtoList(mockPromotions)).thenReturn(Arrays.asList(mockPromocionDto));

		// Act
		ResponseEntity<ProductInfoDto> response = resources.getProductById(productId);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Producto 1", response.getBody().getNombre());
		assertEquals(new BigDecimal(100.00), response.getBody().getPrecioOriginal());
		assertEquals(new BigDecimal(10), response.getBody().getPorcentajeDescuento());
		assertEquals(new BigDecimal(10.00), response.getBody().getValorDescuento());
		assertEquals(new BigDecimal(90.00), response.getBody().getPrecioFinal());
	}

	@Test
	void testGetProductById_ProductWithoutPromotions() {
		// Arrange
		Long productId = 1L;

		Producto mockProducto = new Producto();
		mockProducto.setNombre("Producto 1");
		mockProducto.setPrecio(new BigDecimal(100.00));
		ProductoDto mockProductoDto = new ProductoDto();
		mockProductoDto.setNombre(mockProducto.getNombre());
		mockProductoDto.setPrecio(mockProducto.getPrecio());
		when(productoService.getProducto(productId)).thenReturn(mockProducto);
		when(productoMapper.toDto(mockProducto)).thenReturn(mockProductoDto);

		when(promocionService.findActualPromotionsForProduct(productId)).thenReturn(Collections.emptyList());

		// Act
		ResponseEntity<ProductInfoDto> response = resources.getProductById(productId);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Producto 1", response.getBody().getNombre());
		assertEquals(new BigDecimal(100.00), response.getBody().getPrecioOriginal());
		assertEquals(new BigDecimal(0), response.getBody().getPorcentajeDescuento());
		assertEquals(new BigDecimal(0), response.getBody().getValorDescuento());
		assertEquals(new BigDecimal(100.00), response.getBody().getPrecioFinal());
	}

	@Test
	void testGetProductById_ProductNotFound() {
		// Arrange
		Long productId = 1L;
		when(productoService.getProducto(productId)).thenThrow(new NoSuchElementException());

		// Act
		ResponseEntity<ProductInfoDto> response = resources.getProductById(productId);

		// Assert
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNull(response.getBody());
	}

	@Test
	void testGetProductById_InternalServerError() {
		// Arrange
		Long productId = 1L;
		when(productoService.getProducto(productId)).thenThrow(new RuntimeException());

		// Act
		ResponseEntity<ProductInfoDto> response = resources.getProductById(productId);

		// Assert
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertNull(response.getBody());
	}

}
