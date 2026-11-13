package com.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {

    public static final Target BOTON_AGREGAR_AL_CARRITO =
            Target.the("botón Add to cart").locatedBy("//a[text()='Add to cart']");

    private ProductPage() {
    }
}