package com.demoblaze.stepdefinitions;

import com.demoblaze.models.DatosCompra;
import com.demoblaze.questions.ConfirmacionDeCompra;
import com.demoblaze.questions.ProductosEnCarrito;
import com.demoblaze.tasks.AbrirDemoblaze;
import com.demoblaze.tasks.AgregarProducto;
import com.demoblaze.tasks.CompletarFormulario;
import com.demoblaze.tasks.FinalizarCompra;
import com.demoblaze.tasks.VisualizarCarrito;
import com.demoblaze.utils.LectorCsv;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class CompraStepDefinitions {

    @Dado("que {actor} abre la tienda Demoblaze")
    public void abreLaTienda(Actor actor) {
        actor.attemptsTo(AbrirDemoblaze.paginaPrincipal());
    }

    @Cuando("agrega al carrito los productos {string} y {string}")
    public void agregaLosProductos(String producto1, String producto2) {
        theActorInTheSpotlight().attemptsTo(
                AgregarProducto.alCarrito(producto1),
                AgregarProducto.alCarrito(producto2));
    }

    @Y("visualiza el carrito de compras con {int} productos")
    public void visualizaElCarrito(int cantidad) {
        theActorInTheSpotlight().attemptsTo(VisualizarCarrito.con(cantidad));
    }

    @Entonces("el carrito muestra los productos {string} y {string}")
    public void elCarritoMuestraLosProductos(String producto1, String producto2) {
        theActorInTheSpotlight().should(
                seeThat(ProductosEnCarrito.nombres(), hasItems(producto1, producto2)));
    }

    @Cuando("completa el formulario de compra con los datos del comprador {string}")
    public void completaElFormulario(String caso) {
        DatosCompra datos = LectorCsv.compradorPorCaso(caso);
        theActorInTheSpotlight().attemptsTo(CompletarFormulario.con(datos));
    }

    @Y("finaliza la compra")
    public void finalizaLaCompra() {
        theActorInTheSpotlight().attemptsTo(FinalizarCompra.conPurchase());
    }

    @Entonces("la compra se confirma con el mensaje {string}")
    public void laCompraSeConfirma(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat(ConfirmacionDeCompra.mensaje(), equalTo(mensaje)));
    }
}