package edu.pe.cibertec.saucedemo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class TestHooks {

    @Before
    public void setTheStage(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        System.out.println("Stating Scenarios +"+ scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finished Scenarios +"+ scenario.getName() + " | Status: " + scenario.getStatus());
        OnStage.drawTheCurtain();
    }
}
