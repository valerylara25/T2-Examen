package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.actions.Click.on;
import org.openqa.selenium.By;

public class VerificarSesion implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                on(By.id("shopping_cart_container"))
        );
    }

    public static VerificarSesion validate() {
        return new VerificarSesion();
    }
}
