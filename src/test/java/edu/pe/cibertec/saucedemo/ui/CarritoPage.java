package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {
    public static final String Cart_Badge = "[data-test='shopping-cart-badge']";
    public static final String Cart_Link = "[data-test='shopping-cart-link']";
    public static String Product_in_Cart(String nombreProducto){
        return "text=" +nombreProducto;
    }
}
