package com.sophos.falabella.steps;



import com.sophos.falabella.pageObjects.BuscarProductosPageObjects;
import utilidades.Utilidades;


public class BuscarProductosSteps {
	
	BuscarProductosPageObjects pageObjectsBuscarProductos;
	Utilidades utilidades;

	
	public void ingresar_pagina_web_falabella(String strUrl) {
		try {
			pageObjectsBuscarProductos.openAt(strUrl);
			utilidades.esperaCargarPagina();
			pageObjectsBuscarProductos.borrarcache();
			cerrarPopUpSuscribete();
		}catch (Exception e) {
				pageObjectsBuscarProductos.openAt(strUrl);
			}
		
	}

	public void cerrarPopUpSuscribete() {
		if(BuscarProductosPageObjects.getbtnCerrarPopUpSuscribete().isPresent()) {
		utilidades.posicionarElementoScroll(BuscarProductosPageObjects.getbtnCerrarPopUpSuscribete());
		utilidades.bordearElemento(BuscarProductosPageObjects.getbtnCerrarPopUpSuscribete());
		utilidades.clickEnBoton(BuscarProductosPageObjects.getbtnCerrarPopUpSuscribete());
		}
	}
	
	public void buscarProducto(String strProducto) {
		utilidades.bordearElemento(BuscarProductosPageObjects.gettxtBuscador(), "gray");
		utilidades.escribirTexto(BuscarProductosPageObjects.gettxtBuscador(),strProducto);
		utilidades.tomarEvidencia();
		utilidades.bordearElemento(BuscarProductosPageObjects.getbtnBuscarProducto());
		utilidades.clickEnBoton(BuscarProductosPageObjects.getbtnBuscarProducto());
	}

	public void seleccionarProducto(String strstrProdSeleccionar) {
		utilidades.posicionarElementoScrollBy(BuscarProductosPageObjects.getbtnSeleccionararProducto(strstrProdSeleccionar));
		utilidades.bordearElementoBy(BuscarProductosPageObjects.getbtnSeleccionararProducto(strstrProdSeleccionar));
		utilidades.tomarEvidencia();
		utilidades.clickEnBotonBy(BuscarProductosPageObjects.getbtnSeleccionProducto(strstrProdSeleccionar));
		utilidades.tomarEvidencia();
	}

	public void agregarProductoALaBolsa() {
		utilidades.bordearElemento(BuscarProductosPageObjects.getbtnAgregarABolsa());
		utilidades.tomarEvidencia();
		cerrarPopUpCMRPuntos();
		utilidades.clickEnBoton(BuscarProductosPageObjects.getbtnAgregarABolsa());
		
	}
	
	public void cerrarPopUpCMRPuntos() {
		if(BuscarProductosPageObjects.getbtnCerrarPopUpCMRPuntos().isDisplayed()) {
		utilidades.bordearElemento(BuscarProductosPageObjects.getbtnCerrarPopUpCMRPuntos());
		utilidades.clickEnBoton(BuscarProductosPageObjects.getbtnCerrarPopUpCMRPuntos());
		}
	}
	public void seleccionarSeguroParaElProducto() {
		utilidades.bordearElemento(BuscarProductosPageObjects.gettxtSeguroProducto());
		utilidades.tomarEvidencia();
		utilidades.clickEnBoton(BuscarProductosPageObjects.gettxtSeguroProducto());
	}

	public void verBolsaDeCompras() {
		utilidades.bordearElemento(BuscarProductosPageObjects.getbtnVerBolsaCompras());
		utilidades.tomarEvidencia();
		utilidades.clickEnBoton(BuscarProductosPageObjects.getbtnVerBolsaCompras());
	}

	public void verificarResumenDeLaOrden() {
		utilidades.bordearElemento(BuscarProductosPageObjects.getlblResumenOC());
		utilidades.bordearElemento(BuscarProductosPageObjects.getlblSubTotalProd());
		utilidades.tomarEvidencia();
	}

	public void salirDeLaPagina() {
		utilidades.cerrarPagina();
	}
	
	
}
