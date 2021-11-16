package com.sophos.falabella.definition;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sophos.falabella.steps.BuscarProductosSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.core.cli.Main;
import io.cucumber.datatable.*;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BuscarProductosDefinition {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BuscarProductosDefinition.class);
	
	@Steps
	BuscarProductosSteps  stepsBuscarProductos;
	
	
	@Given("Ingresar a la pagina web de Falabella {string}")
	public void Ingresar_a_la_pagina_web_de_Falabella(String strUrl) {
		stepsBuscarProductos.ingresar_pagina_web_falabella(strUrl);
	
}

	
	@And("Buscar producto {string}")
	public void buscarProducto(String strProducto) {
		stepsBuscarProductos.buscarProducto(strProducto);
	}
	
	@And("Seleccionar producto {string}")
	public void seleccionarProducto(String strstrProdSeleccionar) {
		stepsBuscarProductos.seleccionarProducto(strstrProdSeleccionar);
	}
	
	@When("Agregar producto a la bolsa")
	public void agregarProductoALaBolsa() {
		stepsBuscarProductos.agregarProductoALaBolsa();
	}
	
	@And("Seleccionar seguro para el producto")
	public void seleccionarSeguroParaElProducto() {
		stepsBuscarProductos.seleccionarSeguroParaElProducto();
	}
	
	@And("Ver bolsa de compras")
	public void verBolsaDeCompras() {
		stepsBuscarProductos.verBolsaDeCompras();
	}
	
	@Then("Verificar resumen de la orden")
	public void verificarResumenDeLaOrden() {
		stepsBuscarProductos.verificarResumenDeLaOrden();
	}
	
	@And("Salir de la pagina")
	public void salirDeLaPagina() {
		stepsBuscarProductos.salirDeLaPagina();
	}
}
