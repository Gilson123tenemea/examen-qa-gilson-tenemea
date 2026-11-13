package com.demoblaze.tasks;

import com.demoblaze.interactions.EsperarHasta;
import com.demoblaze.userinterfaces.CartPage;
import com.demoblaze.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisualizarCarrito {

    public static Performable con(int cantidadEsperada) {
        return Task.where("{0} visualiza el carrito de compras",
                Click.on(HomePage.MENU_CARRITO),
                EsperarHasta.que(ExpectedConditions.numberOfElementsToBe(
                        By.cssSelector(CartPage.FILAS_CARRITO_CSS), cantidadEsperada)));
    }

    private VisualizarCarrito() {
    }
}