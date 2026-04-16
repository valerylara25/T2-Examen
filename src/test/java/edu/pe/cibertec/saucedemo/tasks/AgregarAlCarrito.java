package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AgregarAlCarrito {
    public static Performable producto (String nombreProducto){
        return Task.where("{0} agrega el producto" + nombreProducto,
                Click.on(Target.the("Add to cart" + nombreProducto)
                        .locatedBy("[data-test='add-to-cart-" + nombreProducto.toLowerCase().replace(" ", "-") + "']"))


        );
    }
}
