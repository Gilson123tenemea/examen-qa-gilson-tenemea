package com.demoblaze.tasks;

import com.demoblaze.interactions.AceptarAlerta;
import com.demoblaze.userinterfaces.HomePage;
import com.demoblaze.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AgregarProducto {

    public static Performable alCarrito(String nombreProducto) {
        return Task.where("{0} agrega al carrito el producto " + nombreProducto,
                Click.on(HomePage.PRODUCTO.of(nombreProducto)),
                Click.on(ProductPage.BOTON_AGREGAR_AL_CARRITO),
                AceptarAlerta.enPantalla(),
                Click.on(HomePage.MENU_HOME));
    }

    private AgregarProducto() {
    }
}