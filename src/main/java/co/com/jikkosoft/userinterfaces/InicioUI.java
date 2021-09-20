package co.com.jikkosoft.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioUI {

    private InicioUI(){}

    public static final Target BUTTON_GET_CUPON = Target.the("Boton con el cual podemos pedir el cupon")
            .located(By.id("welcome-coupon"));

    public static final Target CUPON_CODE = Target.the("Label en el cual nos dan el cupon")
            .located(By.id("coupon-code"));

    public static final Target EXIT_GET_CUPON = Target.the("Label con el cual se sale del cupon de bienvenida")
            .locatedBy("//*[@id='coupon-modal']//span[@class='close']");

    public static final Target CUPON_ERROR_CODE = Target.the("Mensaje de error del cupon invalido")
            .located(By.id("e-coupon"));

    public static final Target BUTTON_PEDIR = Target.the("Boton con el cual ser hace el pedido de los productos")
            .locatedBy("//table/tbody/tr[{0}]/td/button");

    public static final Target LABEL_DESCRIPCION_PRODUCTO = Target.the("Label de descripcion del producto")
            .locatedBy("//span[@class='offer-description']");

    public static final Target LABEL_PRECIO_PRODUCTO = Target.the("Label precio del producto")
            .locatedBy("//span[@class='offer-price']");

    public static final Target LABEL_FECHA_PRODUCTO = Target.the("Label fecha del producto")
            .locatedBy("(//span[@class='info'])[1]");

    public static final Target LABEL_VALOR_ENVIO = Target.the("Label valor del envio")
            .locatedBy("(//span[@class='info'])[2]");

    public static final Target LABEL_NOMBRE_COMERCIO = Target.the("label nombre del comercio")
            .locatedBy("(//span[@class='info'])[3]");

    public static final Target LABEL_DIRECCION_COMERCIO = Target.the("Label direccion del comercio")
            .locatedBy("(//span[@class='info'])[4]");

    public static final Target INPUT_CUPON_DESCUENTO = Target.the("Campo de ingreso de el cupon de descuento")
            .located(By.id("coupon"));

    public static final Target BUTTON_CONFIRMAR_PEDIDO = Target.the("Boton para confirmar pedido")
            .located(By.id("order-confirm"));

    public static final Target EXIT_CONFIRMACION_COMPRA = Target.the("Span donde se puede salir del label que confirma la compra")
            .locatedBy("//div[@id='confirmation-modal']//span");
}
