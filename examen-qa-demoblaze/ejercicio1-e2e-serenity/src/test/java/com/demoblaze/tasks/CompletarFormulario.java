package com.demoblaze.tasks;

import com.demoblaze.models.DatosCompra;
import com.demoblaze.userinterfaces.CartPage;
import com.demoblaze.userinterfaces.OrderModal;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CompletarFormulario {

    public static Performable con(DatosCompra datos) {
        return Task.where("{0} completa el formulario de compra",
                Click.on(CartPage.BOTON_PLACE_ORDER),
                Enter.theValue(datos.nombre()).into(OrderModal.CAMPO_NOMBRE),
                Enter.theValue(datos.pais()).into(OrderModal.CAMPO_PAIS),
                Enter.theValue(datos.ciudad()).into(OrderModal.CAMPO_CIUDAD),
                Enter.theValue(datos.tarjeta()).into(OrderModal.CAMPO_TARJETA),
                Enter.theValue(datos.mes()).into(OrderModal.CAMPO_MES),
                Enter.theValue(datos.anio()).into(OrderModal.CAMPO_ANIO));
    }

    private CompletarFormulario() {
    }
}