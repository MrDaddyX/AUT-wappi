package co.com.jikkosoft.tasks;

import co.com.jikkosoft.userinterfaces.HomeUI;
import co.com.jikkosoft.userinterfaces.InicioUI;
import co.com.jikkosoft.utils.Convertir;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HacerPedido implements Task {

	static final Logger LOGGER =  Logger.getLogger(HacerPedido.class.getName());
	String numProducto;
	String tipoPrueba;
	List<String> datos;
	String cuponID;


	public HacerPedido(String numProducto, String tipoPrueba){
		this.numProducto = numProducto;
		this.tipoPrueba = tipoPrueba;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(WaitUntil.the(InicioUI.BUTTON_GET_CUPON, isVisible()).forNoMoreThan(7).seconds());
		actor.attemptsTo(Click.on(InicioUI.BUTTON_GET_CUPON));
		actor.attemptsTo(WaitUntil.the(InicioUI.CUPON_CODE, isVisible()).forNoMoreThan(7).seconds());
		cuponID = InicioUI.CUPON_CODE.resolveFor(actor).getText().trim();
		actor.attemptsTo(Click.on(InicioUI.EXIT_GET_CUPON));
		actor.attemptsTo(WaitUntil.the(HomeUI.NAV_MENU_INICIO, isVisible()).forNoMoreThan(7).seconds());
		actor.attemptsTo(Click.on(HomeUI.NAV_MENU_INICIO));
		datos = Convertir.DataTable(BrowseTheWeb.as(actor).getDriver()).get(Integer.parseInt(numProducto)-1);
		actor.remember("datosInicio",datos);

		switch (tipoPrueba){
			case "valida el resumen":
				actor.attemptsTo(Click.on(InicioUI.BUTTON_PEDIR.of(numProducto)));
				actor.remember("numProducto",numProducto);
				actor.attemptsTo(WaitUntil.the(InicioUI.BUTTON_CONFIRMAR_PEDIDO, isVisible()).forNoMoreThan(7).seconds());
				break;
			case "lo completa exitosamente":
				actor.attemptsTo(Click.on(InicioUI.BUTTON_PEDIR.of(numProducto)));
				actor.attemptsTo(WaitUntil.the(InicioUI.BUTTON_CONFIRMAR_PEDIDO, isVisible()).forNoMoreThan(7).seconds());
				actor.attemptsTo(Click.on(InicioUI.BUTTON_CONFIRMAR_PEDIDO));
				actor.attemptsTo(Click.on(InicioUI.EXIT_CONFIRMACION_COMPRA));
				actor.attemptsTo(Click.on(HomeUI.NAV_MENU_MIS_PEDIDOS));
				break;
			case "3 productos":
				actor.attemptsTo(Click.on(InicioUI.BUTTON_PEDIR.of("1")));
				actor.attemptsTo(WaitUntil.the(InicioUI.BUTTON_CONFIRMAR_PEDIDO, isVisible()).forNoMoreThan(7).seconds());
				actor.attemptsTo(SendKeys.of(cuponID).into(InicioUI.INPUT_CUPON_DESCUENTO));
				actor.attemptsTo(Click.on(InicioUI.BUTTON_CONFIRMAR_PEDIDO));
				actor.attemptsTo(WaitUntil.the(InicioUI.EXIT_CONFIRMACION_COMPRA, isVisible()).forNoMoreThan(7).seconds());
				actor.attemptsTo(Click.on(InicioUI.EXIT_CONFIRMACION_COMPRA));
				//------------------------------------------------------
				actor.attemptsTo(Click.on(InicioUI.BUTTON_PEDIR.of("2")));
				actor.attemptsTo(WaitUntil.the(InicioUI.BUTTON_CONFIRMAR_PEDIDO, isVisible()).forNoMoreThan(7).seconds());
				actor.attemptsTo(SendKeys.of(cuponID).into(InicioUI.INPUT_CUPON_DESCUENTO));
				actor.attemptsTo(Click.on(InicioUI.BUTTON_CONFIRMAR_PEDIDO));
				actor.attemptsTo(WaitUntil.the(InicioUI.EXIT_CONFIRMACION_COMPRA, isVisible()).forNoMoreThan(7).seconds());
				actor.attemptsTo(Click.on(InicioUI.EXIT_CONFIRMACION_COMPRA));
				//---------------------------------
				actor.attemptsTo(Click.on(InicioUI.BUTTON_PEDIR.of("3")));
				actor.attemptsTo(WaitUntil.the(InicioUI.BUTTON_CONFIRMAR_PEDIDO, isVisible()).forNoMoreThan(7).seconds());
				actor.attemptsTo(SendKeys.of(cuponID).into(InicioUI.INPUT_CUPON_DESCUENTO));
				actor.attemptsTo(Click.on(InicioUI.BUTTON_CONFIRMAR_PEDIDO));
				break;
			default:
				LOGGER.log(Level.SEVERE, "No se encontro tipo de prueba la cual seguir");
		}
	}

	public static HacerPedido delProductoYdeManera(String numProducto, String tipoPrueba) {
		return Tasks.instrumented(HacerPedido.class,numProducto,tipoPrueba);
	}
}
