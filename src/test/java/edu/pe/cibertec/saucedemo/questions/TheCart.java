package edu.pe.cibertec.saucedemo.questions;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class TheCart {
    public static Question<String> contador(){
        return Text.of(Target.the("Cart badge")
                .locatedBy(CarritoPage.Cart_Badge));
    }
    public static Question<Boolean> productoVisible(String nombreProducto){
        return Visibility.of(Target.the(nombreProducto)
                .locatedBy(CarritoPage.Product_in_Cart(nombreProducto)));
    }
}
