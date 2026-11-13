package com.demoblaze.tasks;

import com.demoblaze.interactions.EsperarHasta;
import com.demoblaze.userinterfaces.OrderModal;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinalizarCompra {

    public static Performable conPurchase() {
        return Task.where("{0} finaliza la compra",
                Click.on(OrderModal.BOTON_PURCHASE),
                EsperarHasta.que(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(OrderModal.MENSAJE_CONFIRMACION_CSS))));
    }

    private FinalizarCompra() {
    }
}