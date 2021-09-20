package co.com.jikkosoft.questions;

import co.com.jikkosoft.userinterfaces.InformacionPersonalUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Boolean.FALSE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarLaActualizacion implements Question<Boolean>{

	static final Logger LOGGER =  Logger.getLogger(ValidarLaActualizacion.class.getName());
	String tipoDeValidacion;
	Boolean validacion = FALSE;

	public ValidarLaActualizacion(String tipoDeValidacion) {
		this.tipoDeValidacion=tipoDeValidacion;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		switch(tipoDeValidacion){
			case "el mensaje Tu información se guardó correctamente":
				actor.attemptsTo(WaitUntil.the(InformacionPersonalUI.LABEL_GUARDADO_INFORMACION_EXITOSA, isVisible()).forNoMoreThan(7).seconds());
				String mensaje = tipoDeValidacion.replace("el mensaje ", "");
				return InformacionPersonalUI.LABEL_GUARDADO_INFORMACION_EXITOSA.resolveFor(actor).getText().equals(mensaje);
			case "que los campos estan inicializados correctamente":
				if(!InformacionPersonalUI.INPUT_NOMBRE.resolveFor(actor).getValue().isEmpty()){
  					if(!InformacionPersonalUI.INPUT_APELLIDO.resolveFor(actor).getValue().isEmpty()){
						if(!InformacionPersonalUI.INPUT_FECHA_NACIMIENTO.resolveFor(actor).getValue().isEmpty()){
							validacion=true;
						}
					}
				}
				return validacion;
			case "los mensajes de error de los campos obligatorios":
				if(InformacionPersonalUI.LABEL_ERROR_IMG_REQUERIDA.resolveFor(actor).getText().trim().equals("La imagen es requerida")){
					if(InformacionPersonalUI.LABEL_ERROR_NOMBRE_REQUERIDA.resolveFor(actor).getText().trim().equals("El nombre es requerido")){
						if(InformacionPersonalUI.LABEL_ERROR_APELLIDO_REQUERIDA.resolveFor(actor).getText().trim().equals("El apellido es requerido")){
							if(InformacionPersonalUI.LABEL_ERROR_FECHA_NACIMIENTO_REQUERIDA.resolveFor(actor).getText().trim().equals("La fecha de nacimiento es requerida")){
								if(InformacionPersonalUI.LABEL_ERROR_PAIS_REQUERIDA.resolveFor(actor).getText().trim().equals("El país es requerido")){
									validacion=true;
								}
							}
						}
					}
				}
				return validacion;
			default:
				LOGGER.log(Level.SEVERE, "No se encontro tipo de prueba la cual seguir");
				return FALSE;
		}

	}

	public static ValidarLaActualizacion deInformacionPersonal(String tipoDeValidacion) {
		return new ValidarLaActualizacion(tipoDeValidacion);
	}
}
