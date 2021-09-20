package co.com.jikkosoft.stepdefinitions;

import co.com.jikkosoft.questions.ValidarElPedido;
import co.com.jikkosoft.tasks.HacerPedido;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PedidoDeProductosTestDefinitions {

    @Cuando("hace un pedido del producto '(.*)' y '(.*)'")
    public void haceUnPedidoDelProductoY(String numProducto, String tipoPrueba) {
        theActorInTheSpotlight().attemptsTo(HacerPedido.delProductoYdeManera(numProducto,tipoPrueba));
    }

    @Cuando("hace un pedido de 3 productos con el cupon de bienvenida")
    public void haceUnPedidoDe3ProductosConElCuponDeBienvenida() {
        theActorInTheSpotlight().attemptsTo(HacerPedido.delProductoYdeManera("1","3 productos"));
    }

    @Entonces("podra ver que '(.*)'")
    public void podraVer(String tipoValidacion) {
        theActorInTheSpotlight().should(seeThat(ValidarElPedido.realizadoDeManera(tipoValidacion), equalTo(true)));
    }
}
