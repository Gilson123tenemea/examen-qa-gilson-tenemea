package com.demoblaze.questions;

import com.demoblaze.userinterfaces.CartPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ProductosEnCarrito {

    public static Question<List<String>> nombres() {
        return Question.about("los productos en el carrito").answeredBy(actor ->
                CartPage.NOMBRES_PRODUCTOS.resolveAllFor(actor).stream()
                        .map(WebElementFacade::getText)
                        .toList());
    }

    private ProductosEnCarrito() {
    }
}