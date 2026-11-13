package com.demoblaze.questions;

import com.demoblaze.userinterfaces.OrderModal;
import net.serenitybdd.screenplay.Question;

public class ConfirmacionDeCompra {

    public static Question<String> mensaje() {
        return Question.about("el mensaje de confirmación").answeredBy(actor ->
                OrderModal.MENSAJE_CONFIRMACION.resolveFor(actor).getText());
    }

    public static Question<String> detalle() {
        return Question.about("el detalle de la compra").answeredBy(actor ->
                OrderModal.DETALLE_COMPRA.resolveFor(actor).getText());
    }

    private ConfirmacionDeCompra() {
    }
}