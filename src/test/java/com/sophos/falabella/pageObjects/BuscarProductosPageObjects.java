package com.sophos.falabella.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utilidades.Utilidades;




public class BuscarProductosPageObjects extends PageObject{
	
	private static By txtProductoASeleccionar = By.xpath("");

	
	@FindBy(xpath="//input[contains(@class,'SearchBar-module_searchBar__Input')]")
	static WebElementFacade txtBuscador;
	
	@FindBy(xpath="//button[contains(@class,'SearchBar-module_searchBtnIcon')]")
	static WebElementFacade btnBuscarProducto;
	
	@FindBy(xpath="//div[@id='acc-alert-container']//a[@id='acc-alert-close']")
	static WebElementFacade btnCerrarPopUpSuscribete;
	
	@FindBy(xpath="//button[text()='Agregar a la Bolsa']")
	static WebElementFacade btnAgregarABolsa;
	
	@FindBy(xpath="//div[@class='dy-modal-contents']//div[@class='dy-lb-close']")
	static WebElementFacade btnCerrarPopUpCMRPuntos;
	
	@FindBy(xpath="//div[contains(@class,'jsx-3514808864 cart-services')]//button[@type='button']//span[@class='jsx-136194434 label   ' and contains(text(),'Protegido $')]")
	static WebElementFacade txtSeguroProducto;
	
	@FindBy(xpath="//a[@id='linkButton' and contains(text(),'Ver Bolsa')]")
	static WebElementFacade btnVerBolsaCompras;
	
	@FindBy(xpath="//form[@class='fb-order-status__form']//h4[text()='Resumen de tu orden']")
	static WebElementFacade lblResumenOC;
	
	@FindBy(xpath="//form[@class='fb-order-status__form']//div[@class='fb-order-status__sub-totals']")
	static WebElementFacade lblSubTotalProd;
			
	Utilidades utilidades;
	
	
	public void abrirpagina(String strUrl) {
		getDriver().get(strUrl);
	
	}
	
	public static WebElementFacade gettxtBuscador() {
		return txtBuscador;
	}
	
	public static WebElementFacade getbtnBuscarProducto() {
		return btnBuscarProducto;
	}
	
	public static WebElementFacade getbtnCerrarPopUpSuscribete() {
		return btnCerrarPopUpSuscribete;
	}
	
	public static By getbtnSeleccionararProducto(String strstrProdSeleccionar) {
		txtProductoASeleccionar = By.xpath("//b[contains(@id,'testId-pod-displaySubTitle-prod') and contains(text(),'*')]".replace("*", strstrProdSeleccionar));
		return txtProductoASeleccionar;
	}
	
	
	public static void  setbtnSeleccionararProducto(String strProductoSeleccionar) {
		txtProductoASeleccionar = By.xpath("/b[contains(@id,'testId-pod-displaySubTitle-prod') and contains(text(),'*')]".replace("*", strProductoSeleccionar));
	}

	public static  String getbtnSeleccionProducto(String strstrProdSeleccionar) {
		String txtProductoASeleccion = ("//b[contains(@id,'testId-pod-displaySubTitle-prod') and contains(text(),'*')]".replace("*", strstrProdSeleccionar));
		return txtProductoASeleccion;
	}
	
	public static WebElement getbtnAgregarABolsa() {
		return btnAgregarABolsa;
	}
	
	public static WebElement getbtnCerrarPopUpCMRPuntos() {
		return btnCerrarPopUpCMRPuntos;
	}
	
	public static WebElement gettxtSeguroProducto() {
		return txtSeguroProducto;
	}

	public static WebElement getbtnVerBolsaCompras() {
		return btnVerBolsaCompras;
	}

	public static WebElement getlblResumenOC() {
		return lblResumenOC;
	}
	
	public static WebElement getlblSubTotalProd() {
		return lblSubTotalProd;
	}



	public void borrarcache() {
		getDriver().manage().deleteAllCookies();
		
	}
	

public void evidencia( String strDescrip) {
		String strTxtgloboinfo = "";

		//LOGGER.error(strDescrip);
		  Serenity.takeScreenshot();
        Serenity.recordReportData().withTitle("Tener En cuenta Eror sin dañar el Flujo").andContents(strDescrip + ".  "+ strTxtgloboinfo);
       
	}


}
