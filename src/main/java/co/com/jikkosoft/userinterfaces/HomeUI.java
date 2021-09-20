package co.com.jikkosoft.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {

    private HomeUI(){}

    //NAV con el cual se puede navegar por las diferentes ssecciones de la pagina
    public static final Target NAV_MENU_INICIO  = Target.the("Campo INICIO en la barra del nav")
            .locatedBy("//nav/ul[1]/li[1]");

    public static final Target NAV_MENU_CUPONES  = Target.the("Campo CUPONES en la barra del nav")
            .locatedBy("//nav/ul[1]/li[2]");

    public static final Target NAV_MENU_MIS_PEDIDOS  = Target.the("Campo PEDIDOS en la barra del nav")
            .locatedBy("//nav/ul[1]/li[3]");

    public static final Target NAV_MENU_INFO_PERSONAL  = Target.the("Campo PERSONAL en la barra del nav")
            .locatedBy("//nav/ul[1]/li[4]");

    public static final Target NAV_ACCOUNT_USUARIO  = Target.the("Campo en el cual se muestra el nombre del usuario que se logueo")
            .locatedBy("//nav/ul[2]/li[1]");

    public static final Target NAV_ACCOUNT_CERRAR_SESION = Target.the("Label Cerrar SSesion de la lista del nav")
            .locatedBy("//nav/ul[2]/li[2]");
}
