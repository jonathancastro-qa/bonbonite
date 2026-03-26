package com.automationexercise.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class HomePageUI {
    public static final Target ACCEPT_COOKIES_BUTTON = Target.the("Botón aceptar cookies")
            .located(By.id("cookiescript_accept"));

    public static final Target HAMBURGUER_MENU = Target.the("menú de navegación")
            .located(By.id("toggle-desktop-menu"));

    public static final Target ICON_ACCOUNT = Target.the("Icono de Cuentas")
            .located(By.id("toggle-account-menu"));

    public static final Target MI_CUENTA_MENU = Target.the("Opción Mi Cuenta en el menú de navegación")
            .located(By.xpath("//a[contains(text(),'Mi cuenta')]"));


    public static final Target HOME_MENU = Target.the("Opción HOME en el menú de navegación")
            .located(By.xpath("//a[contains(text(),'Home')]"));

    public static final Target LOGOUT_MENU = Target.the("Opción LOGOUT en el menú de navegación")
            .located(By.xpath("(//a[contains(@href,'logout')])[1]"));

    public static final Target CART_MENU = Target.the("Opción CART en el menú de navegación")
            .located(By.xpath("//a[contains(text(),'Cart')]"));

    public static final Target LOGGED_IN_AS_MESSAGE = Target.the("Mensaje Logged in as ")
            .located(By.xpath("//a[contains(text(),'Logged in as')]"));

    public static final Target ADD_TO_CART_PRODUCT_BLUE_TOP = Target.the("Producto Blue Top del inventario")
            .located(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));

    public static final Target ADD_TO_CART_PRODUCT_MEN_TSHIRT = Target.the("Producto Men Tshirt del inventario")
            .located(By.xpath("(//a[contains(text(),'Add to cart')])[3]"));

    public static final Target CONTINUE_SHOPPING_BUTTON = Target.the("Botón Continue Shopping")
            .located(By.xpath("//button[contains(text(),'Continue Shopping')]"));

    public static final Target CONFIRMATION_ADD_TO_CART_MESSAGE = Target.the("Popup con mensaje de confirmación al hacer click en el boton add to cart")
            .located(By.xpath("//p[contains(text(),'Your product has been added to cart.')]"));

    public static final Target CONFIRMATION_VIEW_CART_LINK = Target.the("Link con el texto View Cart en el Popup con mensaje de confirmación")
            .located(By.xpath("//u[contains(text(),'View Cart')]"));
}

