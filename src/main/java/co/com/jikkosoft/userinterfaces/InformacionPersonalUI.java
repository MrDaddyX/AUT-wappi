package co.com.jikkosoft.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InformacionPersonalUI {

    private InformacionPersonalUI(){}

    public static final Target BUTTON_SELECT_IMAGE_UPLOAD = Target.the("Boton para seleccionar la imagen a subir")
            .locatedBy("//input[@id='image']");

    public static final Target INPUT_NOMBRE  = Target.the("Campo de ingreso del nombre")
            .located(By.id("name"));

    public static final Target INPUT_APELLIDO  = Target.the("Campo de ingreso del apellido")
            .located(By.id("lastName"));

    public static final Target INPUT_FECHA_NACIMIENTO  = Target.the("Campo de ingreso para la fecha de nacimiento")
            .located(By.id("bornDate"));

    public static final Target SELECT_COUNTRY  = Target.the("Seleccion de el pais")
            .located(By.id("country"));

    public static final Target SELECT_COLOMBIA  = Target.the("Seleccion de la opcion Colombia")
            .locatedBy("//select[@id='country']/option[3]");

    public static final Target SELECT_SELECCIONAR  = Target.the("Seleccion la opcion Selecionar")
            .locatedBy("//select[@id='country']/option[1]");

    public static final Target BUTTON_GUARDAR  = Target.the("Boton el cual guarda la actualizacion de los datos")
            .located(By.id("save-profile"));

    public static final Target LABEL_GUARDADO_INFORMACION_EXITOSA  = Target.the("Label el cual dice que se actualizaron los datos correctamente")
            .locatedBy("//div[@id='confirmation-modal']//p");

    public static final Target LABEL_ERROR_IMG_REQUERIDA  = Target.the("Label de error para el campo requerido IMAGEN")
            .located(By.id("e-image"));

    public static final Target LABEL_ERROR_NOMBRE_REQUERIDA  = Target.the("Label de error para el campo requerido NOMBRE")
            .located(By.id("e-name"));

    public static final Target LABEL_ERROR_APELLIDO_REQUERIDA  = Target.the("Label de error para el campo requerido APELLIDO")
            .located(By.id("e-lastName"));

    public static final Target LABEL_ERROR_FECHA_NACIMIENTO_REQUERIDA  = Target.the("Label de error para el campo requerido FECHA NACIMIENTO")
            .located(By.id("e-bornDate"));

    public static final Target LABEL_ERROR_PAIS_REQUERIDA  = Target.the("Label de error para el campo requerido PAIS")
            .located(By.id("e-country"));
}