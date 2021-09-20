package co.com.jikkosoft.stepdefinitions;

import co.com.jikkosoft.questions.ValidarLaActualizacion;
import co.com.jikkosoft.tasks.ActualizarLosDatos;
import co.com.jikkosoft.tasks.Loguearse;
import co.com.jikkosoft.utils.WebDriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ActualizarInformacionTestDefinitions {

    @Before
    public void antesDelTest() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Analista").whoCan(BrowseTheWeb.with(WebDriverFactory.web().onPage("https://automation-wappi.vercel.app/login")));
    }

    @Dado("que el analista accede al aplicativo web")
    public void queElAnalistaAccedeAlAplicativoWeb() {
        theActorInTheSpotlight().attemptsTo(Loguearse.conLosDatos());
    }

    @Cuando("desea hacer el actualizado de informacion '(.*)'")
    public void deseaHacerElActualizadoDeInformacion(String tipoPrueba) {
        theActorInTheSpotlight().attemptsTo(ActualizarLosDatos.conLosDatos(tipoPrueba));
    }

    @Entonces("podra ver '(.*)'")
    public void podraVer(String tipoValidacion) {
        theActorInTheSpotlight().should(seeThat(ValidarLaActualizacion.deInformacionPersonal(tipoValidacion), equalTo(true)));
    }
}
