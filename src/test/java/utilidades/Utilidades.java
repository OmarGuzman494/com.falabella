package utilidades;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;


public class Utilidades extends PageObject{

	
	private static final Logger LOGGER = LoggerFactory.getLogger("Registro");
	private EnvironmentVariables environmentVariables; 
	private static final String WEBDRIVERTIMEOUT = "webdriver.timeouts.implicitlywait";
		
	
	WebElementFacade lblTransaccionError;
	
		

	public void esperaCargarPagina() {		
		int intTimer = 15;
		try {
			new WebDriverWait(getDriver(), intTimer).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
					.executeScript("return document.readyState").equals("complete"));			
		}catch (Exception e) {
			LOGGER.error("en la clase AccionesWeb en el metodo esperaCargarPagina " + e);
			}		
	}
	
	public void escribirTexto(WebElementFacade webElementFacade, String strTexto) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), obtenerTiempoSerenity());
			//wait.until(ExpectedConditions.visibilityOfElementLocated(webElementFacade));
			WebElementFacade input = element(webElementFacade);
			waitFor(input).isEnabled();
			input.clear();
			input.type(strTexto);
		}catch (Exception e) {
			LOGGER.error("en la clase AccionesWeb en el metodo escribirTexto" + e);
		}
	}

	public void tomarEvidencia() {
		try {
			Serenity.takeScreenshot();
		}catch(Exception e) {
			LOGGER.error("en la clase AccionesWeb en el metodo tomarEvidencia " + e);
		}
	}
	public void tomarCapturaPantallaDesdeElemento(WebElementFacade strWebElement) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", strWebElement);
		Serenity.takeScreenshot();
	}
	
	public void posicionarElemento(WebElement txtProductoASeleccionar) {
		Actions actions=new Actions(getDriver());
		actions.moveToElement(txtProductoASeleccionar).perform();
		if(elementoExite(find(By.id("js-cookie-notification")), 1))
		{			
			System.out.println("MENSAJE");
					find(By.xpath("//*[@id='js-cookie-notification']//div[contains(@class,'button')]")).click();
					
		
		}	
	}

	public void bajaroSubirScroll (String x, String y) {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy("+x+","+y+")");
	}

		
	public void posicionarElementoScroll(WebElement strWebElement) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", strWebElement);
	}

	public void posicionarElementoString(String strElement) {
		((JavascriptExecutor) getDriver()).executeScript(
				"arguments[0].scrollIntoView(true); arguments[0].style.border='1px dashed blue';",
				getDriver().findElements(By.xpath(strElement)).get(0));
	}

	
	public boolean elementoExite(WebElementFacade webElemento, int iespera ) {
		try { 
			int contador=0;
				
				do {
					contador++;	
						System.out.println("Elemnto existe"+iespera);		
						if (webElemento.isCurrentlyVisible()) {
							//el contador =iespera+1;
							return true;
						}
				waitFor(300).milliseconds();
				}while (contador<iespera);
				return false;
			} catch (Exception e) {
				 return false;
			 }
	}
	

	public void evidencia( String strDescrip) {
		String strTxtgloboinfo = "";

		LOGGER.error(strDescrip);
		  Serenity.takeScreenshot();
        Serenity.recordReportData().withTitle("Tener En cuenta Error sin dañar el Flujo").andContents(strDescrip + ".  "+ strTxtgloboinfo);
       
	}
		

	public void borrarcache() {
		getDriver().manage().deleteAllCookies();
		
	}
	
	
	public static void actualizarDriverNavegadores() {
		switch (SystemEnvironmentVariables.createEnvironmentVariables().getProperty("webdriver.driver")) {
		case "chrome":			
			    WebDriverManager.chromedriver().setup(); 
			   break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			break;
		default:
			
			WebDriverManager.chromedriver().setup();
			
			
			break;
		}
	}
	
		public void clickEnBoton(WebElement boton) {
		
		try {
			
				WebDriverWait wait = new WebDriverWait(getDriver(), 15);
				wait.until(ExpectedConditions.elementToBeClickable(boton));
				boton.click();
	
		} catch (Exception e) {
			System.out.println(boton + " error: " + e.getMessage());
			evidencia("ERROR: en la clase UtilidadesWeb en el método clickEnBoton: " + e);
		}
	}
	
	public void clickEnBotonEspecial(WebElement by) {
			try {
				waitFor(1).second();
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
				wait.until(ExpectedConditions.elementToBeClickable(by));
			
				withAction().moveToElement(by).click().build().perform();

		} catch (Exception e) {
			System.out.println(by + " error: " + e.getMessage());
			evidencia("ERROR: en la clase UtilidadesWeb en el método clickEnBotonEspecial: " + e);
		}
	}
	
	public void clickEnBoton(String boton) {
		try {
			
				WebDriverWait wait = new WebDriverWait(getDriver(), 15);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(boton)));
				find(By.xpath(boton)).click();

		} catch (Exception e) {
			evidencia("ERROR: en la clase UtilidadesWeb en el método clickEnBoton: " + e);
		}
	}
	
	public void click(String xpath) {
		
		try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 15);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				find(By.xpath(xpath)).click();
		} catch (Exception e) {
			evidencia("ERROR: en la clase UtilidadesWeb en el método click: " + e);
		}
	}
	
		
	public int obtenerTiempoSerenity() {
		return (Integer.parseInt(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEBDRIVERTIMEOUT)))/1000;
	}
	
	public void bordearElemento(WebElement txtProductoASeleccionar) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'",
					element(txtProductoASeleccionar));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background='#cc8f94'", element(txtProductoASeleccionar)); 
		}catch(Exception e) {
			LOGGER.error("en la clase AccionesWeb en el metodo bordearElemento " + e);
		}
	}
	
	public void bordearElemento(WebElementFacade gettxtBuscador, String colorFondo) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'", element(gettxtBuscador));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background= '"+colorFondo+"'", element(gettxtBuscador)); 
		}catch(Exception e) {
			LOGGER.error("en la clase AccionesWeb en el metodo bordearElemento " + e);
		}
		
	}

	public void bordearElementoBy(org.openqa.selenium.By by) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px dashed red'",
					element(by));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.background='#cc8f94'", element(by)); 
		}catch(Exception e) {
			LOGGER.error("en la clase AccionesWeb en el metodo bordearElemento " + e);
			
		
		}
	
	}

	
	public void posicionarElementoScrollBy(org.openqa.selenium.By by) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);",
					element(by));
		}catch(Exception e) {
			LOGGER.error("en la clase AccionesWeb en el metodo posicionarElementoScroll " + e);
		}
	
	}

	public void clickEnBotonBy(String string) {
		try {
			
			WebDriverWait wait = new WebDriverWait(getDriver(), 15);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(string)));
			find(By.xpath(string)).click();

		} catch (Exception e) {
			evidencia("ERROR: en la clase UtilidadesWeb en el método clickEnBoton: " + e);
		}
			
	}
	
	public void cerrarPagina() {
		getDriver().close();
		
	}

}