package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheCart;
import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @When("she adds the product {string} to the cart")
    public void agregarProducto(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.producto(product)
        );
    }

    @Then("the cart icon should display {string}")
    public void validarContador(String cantidad) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.contador(), equalTo(cantidad))
        );
    }

    @And("the cart should contain {string} and {string}")
    public void validarDosProductos(String p1, String p2) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.productoVisible(p1), is(true)),
                seeThat(TheCart.productoVisible(p2), is(true))
        );
    }

    @And("she removes the product {string} from the cart")
    public void eliminarProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.producto(producto)
        );
    }

    @And("the cart should only contain {string}")
    public void validarUnProducto(String producto) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCart.productoVisible(producto), is(true))
        );
    }
}
