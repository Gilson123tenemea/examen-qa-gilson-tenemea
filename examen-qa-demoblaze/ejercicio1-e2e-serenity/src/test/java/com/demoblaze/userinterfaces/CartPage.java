package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static final String FILAS_CARRITO_CSS = "#tbodyid tr";

    public static final Target NOMBRES_PRODUCTOS =
            Target.the("nombres de productos en el carrito").locatedBy("#tbodyid tr td:nth-child(2)");

    public static final Target BOTON_PLACE_ORDER =
            Target.the("botón Place Order").locatedBy("//button[text()='Place Order']");

    private CartPage() {
    }
}