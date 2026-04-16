package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompletarCheckout {

    public static Task Datos(String firstName, String lastName, String postalCode) {
        return Task.where("{0} completa checkout",

                Click.on(CheckoutPage.Cart_Link),
                Click.on(CheckoutPage.Checkout_Button),

                WaitUntil.the(CheckoutPage.First_Name, isVisible())
                        .forNoMoreThan(10).seconds(),

                Enter.theValue(firstName).into(CheckoutPage.First_Name),
                Enter.theValue(lastName).into(CheckoutPage.Last_Name),
                Enter.theValue(postalCode).into(CheckoutPage.Postal_Code)
        );
    }

    public static Task finalizarCompra() {
        return Task.where("{0} finaliza compra",

                Click.on(CheckoutPage.Continue_Button),
                Click.on(CheckoutPage.Finish_Button)
        );
    }
}
