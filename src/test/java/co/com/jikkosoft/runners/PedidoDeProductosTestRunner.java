package co.com.jikkosoft.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features/pedido-de-productos.feature",
		glue = "co.com.jikkosoft.stepdefinitions",
		tags = {""},snippets = SnippetType.CAMELCASE)

public class PedidoDeProductosTestRunner {

}
