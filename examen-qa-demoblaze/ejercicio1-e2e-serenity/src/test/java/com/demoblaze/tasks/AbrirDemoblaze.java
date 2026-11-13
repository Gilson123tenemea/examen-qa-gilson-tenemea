package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirDemoblaze {

    private static final String URL =
            System.getProperty("demoblaze.url", "https://www.demoblaze.com/");

    public static Performable paginaPrincipal() {
        return Task.where("{0} abre la página principal de Demoblaze",
                Open.url(URL));
    }

    private AbrirDemoblaze() {
    }
}