package co.com.jikkosoft.questions;

import co.com.jikkosoft.userinterfaces.InicioUI;
import co.com.jikkosoft.utils.Convertir;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Boolean.FALSE;

public class ValidarElPedido implements Question<Boolean>{

	static final Logger LOGGER =  Logger.getLogger(ValidarElPedido.class.getName());
	String tipoDeValidacion;
	Boolean validacion = FALSE;
	List<String> datosInicio;
	List<String> datos;
	String numProducto;

	public ValidarElPedido(String tipoDeValidacion) {
		this.tipoDeValidacion=tipoDeValidacion;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		datosInicio = actor.recall("datosInicio");
		switch(tipoDeValidacion){
			case "los datos son correctos":
				numProducto = actor.recall("numProducto");
				if(InicioUI.LABEL_DESCRIPCION_PRODUCTO.resolveFor(actor).getText().trim().equals(datosInicio.get(1).trim())){
					if(InicioUI.LABEL_PRECIO_PRODUCTO.resolveFor(actor).getText().trim().equals(datosInicio.get(2).trim())){
						if(InicioUI.LABEL_FECHA_PRODUCTO.resolveFor(actor).getText().replace("date_range","").trim().equals(datosInicio.get(0).trim())){
							if(InicioUI.LABEL_VALOR_ENVIO.resolveFor(actor).getText().replace("local_shipping","").trim().equals(datosInicio.get(3).trim())){
								if(InicioUI.LABEL_NOMBRE_COMERCIO.resolveFor(actor).getText().replace("business","").trim().equals(datosInicio.get(4).trim())){
									if(InicioUI.LABEL_DIRECCION_COMERCIO.resolveFor(actor).getText().replace("location_on","").trim().equals(datosInicio.get(5).trim())){
										validacion=true;
									}
								}
							}
						}
					}
				}
				return validacion;
			case "los datos en mis pedidos son correctos":
				datos = Convertir.DataTable(BrowseTheWeb.as(actor).getDriver()).get(0);
				System.out.println("La data1 es="+datos.get(0));
				System.out.println("La data1 es="+datosInicio.get(0));
				if(datos.get(0).trim().equals(datosInicio.get(0).trim())){
					System.out.println("La data1 es="+datos.get(1));
					System.out.println("La data1 es="+datosInicio.get(1));
					if(datos.get(1).trim().equals(datosInicio.get(1).trim())){
						System.out.println("La data1 es="+datos.get(2));
						System.out.println("La data1 es="+datosInicio.get(2));
						if(datos.get(2).trim().equals(datosInicio.get(2).trim())){
							System.out.println("La data1 es="+datos.get(3));
							System.out.println("La data1 es="+datosInicio.get(3));
							if(datos.get(3).trim().equals(datosInicio.get(3).trim())){
								System.out.println("La data1 es="+datos.get(4));
								System.out.println("La data1 es="+datosInicio.get(4));
								if(datos.get(4).trim().equals(datosInicio.get(4).trim())){
									System.out.println("La data1 es="+datos.get(5));
									System.out.println("La data1 es="+datosInicio.get(5));
									if(datos.get(5).trim().equals(datosInicio.get(5).trim())){
										validacion=true;
									}
								}
							}
						}
					}
				}
				return validacion;
			case "al momento de hacer el 3er pedido saldra el mensaje de error informando que el cupon no esta disponible":
				return InicioUI.CUPON_ERROR_CODE.resolveFor(actor).isVisible();
			default:
				LOGGER.log(Level.SEVERE, "No se encontro tipo de prueba la cual seguir");
				return FALSE;
		}

	}

	public static ValidarElPedido realizadoDeManera(String tipoDeValidacion) {
		return new ValidarElPedido(tipoDeValidacion);
	}
}
