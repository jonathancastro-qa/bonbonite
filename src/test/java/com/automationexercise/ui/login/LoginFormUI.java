package com.automationexercise.ui.login;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginFormUI {
    public static final Target IDNUMBER = Target.the("Campo para ingresar el numero de cedula")
            .located(By.xpath("//input[@id='username']"));

    public static final Target PASSWORD = Target.the("Campo para ingresar el password")
            .located(By.xpath("//input[@id='password']"));

    public static final Target LOGIN_BUTTON = Target.the("Boton Iniciar sesion")
            .located(By.xpath("//button[@type='submit' and @name='login']"));

    public static final Target ERROR_MESSAGE = Target.the("Mensaje de error por credenciales incorrectas")
            .located(By.xpath("//ul[contains(@class,'woocommerce-error')]//li"));
}


