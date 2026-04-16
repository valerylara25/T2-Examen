package edu.pe.cibertec.saucedemo.stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Enter.theValue;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.Text.of;
import static org.hamcrest.Matchers.containsString;

public class CheckoutStepDefinitions {

    @When("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void checkout(String first, String last, String zip) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                on("#shopping_cart_container"),
                on("#checkout"),

                theValue(first).into("#first-name"),
                theValue(last).into("#last-name"),
                theValue(zip).into("#postal-code"),

                on("#continue")
        );
    }

    @When("she completes the order")
    public void finish() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                on("#finish")
        );
    }

    @Then("she should see the confirmation message {string}")
    public void confirmation(String msg) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(the(By.className("complete-header")), isVisible())
        );
    }

    @Then("she verifies the order summary shows item total {string}")
    public void verifyItemTotal(String expectedTotal) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        of(By.className("summary_subtotal_label")),
                        containsString(expectedTotal)
                )
        );
    }

    @Then("the checkout form should remain visible")
    public void checkoutFormStillVisible() {

        OnStage.theActorInTheSpotlight().should(
                seeThat(the(By.id("first-name")), isVisible())
        );
    }
}
