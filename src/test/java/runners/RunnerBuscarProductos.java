package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(features = "src/test/resources/features/falabella/BuscarProductos.feature"
	,tags = "@SeleccionarProducto"
	,plugin = {"pretty","html:target/cucumber-reports"}
	,glue = {"com.sophos.falabella.definition"}) 

public class RunnerBuscarProductos {
		
	}

