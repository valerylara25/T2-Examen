package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import static org.hamcrest.Matchers.greaterThan;
public class LoginStepDefinitions {
    private long startTime;

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo("Products"))
        );
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

    }

    @When("she starts login timer")
    public void startLoginTimer() {
        startTime = System.currentTimeMillis();
    }
    @Then("the page load time should be greater than {long} milliseconds")
    public void pageLoadTime(long expected) {

        long duration = System.currentTimeMillis() - startTime;

        OnStage.theActorInTheSpotlight().should(
                seeThat("page load time", actor -> duration, greaterThan(expected))
        );
    }
    @When("she navigates to the cart page")
    public void navigateToCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on("#shopping_cart_container")
        );
    }
    @When("she navigates back to the inventory page")
    public void backToInventoryPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on("#back-to-products")

        );
    }
    @Then("she should still be logged in")
    public void shouldStillBeLoggedIn() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        WebElementQuestion.the(By.cssSelector(".app_logo")),
                        WebElementStateMatchers.isVisible()
                )
        );
    }

    @Then("she verifies session persistence")
    public void verifySession() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.validate()
        );
    }



}
