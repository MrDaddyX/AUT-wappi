package co.com.jikkosoft.tasks;

import co.com.jikkosoft.userinterfaces.HomeUI;
import co.com.jikkosoft.userinterfaces.InformacionPersonalUI;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.File;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ActualizarLosDatos implements Task {

	static final Logger LOGGER =  Logger.getLogger(ActualizarLosDatos.class.getName());
	String tipoPrueba;
	File file = new File("src/test/resources/data/ImgParaPrueba.jpg");
	String path = file.getAbsolutePath();
	Faker faker = Faker.instance(new Locale("en", "US"), new SecureRandom());

	public ActualizarLosDatos(String tipoPrueba){
		this.tipoPrueba = tipoPrueba;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(WaitUntil.the(HomeUI.NAV_MENU_INFO_PERSONAL, isVisible()).forNoMoreThan(7).seconds());
		actor.attemptsTo(Click.on(HomeUI.NAV_MENU_INFO_PERSONAL));
		actor.attemptsTo(WaitUntil.the(InformacionPersonalUI.BUTTON_SELECT_IMAGE_UPLOAD, isVisible()).forNoMoreThan(7).seconds());

		switch (tipoPrueba){
			case "de manera correcta":
				actor.attemptsTo(SendKeys.of(path).into(InformacionPersonalUI.BUTTON_SELECT_IMAGE_UPLOAD));
				actor.attemptsTo(Clear.field(InformacionPersonalUI.INPUT_NOMBRE));
				actor.attemptsTo(SendKeys.of(faker.name().firstName()).into(InformacionPersonalUI.INPUT_NOMBRE));
				actor.attemptsTo(Clear.field(InformacionPersonalUI.INPUT_APELLIDO));
				actor.attemptsTo(SendKeys.of(faker.pokemon().name()).into(InformacionPersonalUI.INPUT_APELLIDO));
				actor.attemptsTo(Clear.field(InformacionPersonalUI.INPUT_FECHA_NACIMIENTO));
				actor.attemptsTo(SendKeys.of("08/10/2000").into(InformacionPersonalUI.INPUT_FECHA_NACIMIENTO));
				actor.attemptsTo(Click.on(InformacionPersonalUI.SELECT_COUNTRY));
				actor.attemptsTo(Click.on(InformacionPersonalUI.SELECT_COLOMBIA));
				actor.attemptsTo(Click.on(InformacionPersonalUI.BUTTON_GUARDAR));
				break;
			case "validando que los campos sean obligatorios":
				actor.attemptsTo(Clear.field(InformacionPersonalUI.INPUT_NOMBRE));
				actor.attemptsTo(Clear.field(InformacionPersonalUI.INPUT_APELLIDO));
				actor.attemptsTo(Clear.field(InformacionPersonalUI.INPUT_FECHA_NACIMIENTO));
				actor.attemptsTo(Click.on(InformacionPersonalUI.SELECT_COUNTRY));
				actor.attemptsTo(Click.on(InformacionPersonalUI.SELECT_SELECCIONAR));
				actor.attemptsTo(Click.on(InformacionPersonalUI.BUTTON_GUARDAR));
				break;
			default:
				LOGGER.log(Level.SEVERE, "No se encontro tipo de prueba la cual seguir");
		}
	}

	public static ActualizarLosDatos conLosDatos(String tipoPrueba) {
		return Tasks.instrumented(ActualizarLosDatos.class,tipoPrueba);
	}
}
