package co.com.jikkosoft.tasks;

import co.com.jikkosoft.userinterfaces.LoginUI;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

import java.security.SecureRandom;
import java.util.Locale;

public class Loguearse implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		Faker faker = Faker.instance(new Locale("en", "US"), new SecureRandom());
		String username = faker.name().firstName() + faker.number().numberBetween(1000,9999);
		actor.attemptsTo(SendKeys.of(username).into(LoginUI.INPUT_USUARIO));
		actor.attemptsTo(SendKeys.of("Password12345").into(LoginUI.INPUT_PASSWORD));
		actor.attemptsTo(Click.on(LoginUI.BUTTON_INGRESAR));
	}

	public static Loguearse conLosDatos() {
		return Tasks.instrumented(Loguearse.class);
	}
}
