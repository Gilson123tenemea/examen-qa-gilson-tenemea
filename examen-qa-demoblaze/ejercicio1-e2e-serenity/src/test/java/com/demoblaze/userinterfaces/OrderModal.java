package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class OrderModal {

    public static final Target CAMPO_NOMBRE = Target.the("campo Name").locatedBy("#name");
    public static final Target CAMPO_PAIS = Target.the("campo Country").locatedBy("#country");
    public static final Target CAMPO_CIUDAD = Target.the("campo City").locatedBy("#city");
    public static final Target CAMPO_TARJETA = Target.the("campo Credit card").locatedBy("#card");
    public static final Target CAMPO_MES = Target.the("campo Month").locatedBy("#month");
    public static final Target CAMPO_ANIO = Target.the("campo Year").locatedBy("#year");

    public static final Target BOTON_PURCHASE =
            Target.the("botón Purchase").locatedBy("//button[text()='Purchase']");

    public static final String MENSAJE_CONFIRMACION_CSS = ".sweet-alert h2";

    public static final Target MENSAJE_CONFIRMACION =
            Target.the("mensaje de confirmación").locatedBy(MENSAJE_CONFIRMACION_CSS);

    public static final Target DETALLE_COMPRA =
            Target.the("detalle de la compra").locatedBy(".sweet-alert p.lead");

    public static final Target BOTON_OK =
            Target.the("botón OK").locatedBy("button.confirm");

    private OrderModal() {
    }
}