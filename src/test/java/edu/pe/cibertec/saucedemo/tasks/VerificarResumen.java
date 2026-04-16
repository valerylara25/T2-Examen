package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarResumen {

   public static Performable itemTotalVisible() {

      return Task.where("{0} verifica item total visible",

              actor -> actor.should(
                      seeThat(
                              WebElementQuestion.the(CheckoutPage.Item_Total),
                              isVisible()
                      )
              )
      );
   }
}
