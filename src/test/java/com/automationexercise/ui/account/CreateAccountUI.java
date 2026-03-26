package com.automationexercise.ui.account;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAccountUI {
    public static final Target SHOW_REGISTER_LINK=Target.the("Link Registrate")
            .located(By.xpath("//p[contains(text(), '¿Eres nuevo?')]//span[@id='show_register']"));

    public static final Target ID_NUMBER=Target.the("Numero de cedula")
            .located(By.xpath("//input[@id='reg_username']"));

    public static final Target FIRST_NAME_INPUT=Target.the("Campo nombres")
            .located(By.id("first_name"));

    public static final Target LAST_NAME_INPUT=Target.the("Campo apellidos")
            .located(By.id("last_name"));

    public static final Target REG_EMAIL_INPUT=Target.the("Campo Dirección de correo electrónico")
            .located(By.xpath("//*[@id=\"reg_email\"]"));

    public static final Target REG_PASSWORD_INPUT=Target.the("Campo contraseña")
            .located(By.xpath("//*[@id=\"reg_password\"]"));

    public static final Target REG_PASSWORD_INPUT2=Target.the("Campo contraseña")
            .located(By.xpath("//*[@id=\"reg_password2\"]"));

    public static final Target PRIVACY_POLICY_CHECKBOX=Target.the("Checkbox tratamiento de datos personales")
            .located(By.xpath("//*[@id=\"privacy_policy_reg\"]"));

    public static final Target REGISTER_BUTTON=Target.the("Botón REGISTRARME")
            .located(By.xpath("//button[contains(text(), 'Registrarme')]"));
}