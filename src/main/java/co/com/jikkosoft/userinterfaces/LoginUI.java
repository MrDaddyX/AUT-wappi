package co.com.jikkosoft.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    private LoginUI (){}

    public static final Target INPUT_USUARIO  = Target.the("Input para del usuario en el logueo")
            .located(By.id("username"));

    public static final Target INPUT_PASSWORD  = Target.the("Input para del usuario en el logueo")
            .located(By.id("password"));

    public static final Target BUTTON_INGRESAR  = Target.the("Boton para inicar el logueo")
            .located(By.id("button-login"));
}
