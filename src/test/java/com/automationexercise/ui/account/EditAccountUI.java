package com.automationexercise.ui.account;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditAccountUI {
    public static final Target ICON_PROFILE = Target.the("icono de perfil")
            .located(By.id("toggle-account-menu"));

    public static final Target EDIT_PERSONAL_INFO_MENU = Target.the("opcion de submenu  DATOS")
            .located(By.xpath("(//li[contains(@class,'edit-account')]//a[normalize-space()='Datos'])[1]"));

    public static final Target INPUT_FIRST_NAME = Target.the("campo nombre")
            .located(By.xpath("//input[@name='first_name']"));

    public static final Target INPUT_LAST_NAME = Target.the("campo nombre")
            .located(By.xpath("//input[@name='last_name']"));

    public static final Target INPUT_PHONE = Target.the("campo numero de telefono")
            .located(By.xpath("//input[@name='billing_phone']"));

    public static final Target BUTTON_EDIT = Target.the("botón actualizar información")
            .located(By.xpath("//form[@id='profile-update-form']/div[1]/div[2]/button[1]"));

    public static final Target BUTTON_SAVE_CHANGES = Target.the("botón guardar cambios")
            .located(By.xpath("(//button[@type='button' and contains(text(),'Guardar')])[1]"));

    public static final Target DATA_UPDATED_MESSAGE=Target.the("mensaje de confirmación de datos actualizados")
            .located(By.xpath("//span[contains(.,'Datos personales actualizados correctamente')]"));

    //Campos de texto despues de la edicion y hacer click en Guardar
    public static final Target TXT_FIRST_NAME = Target.the("Nombre editado mostrado")
            .located(By.xpath("//div[@data-field='first_name']"));

    public static final Target TXT_LAST_NAME = Target.the("Apellido editado mostrado")
            .located(By.xpath("//div[@data-field='last_name']"));

    public static final Target TXT_PHONE = Target.the("Teléfono editado mostrado")
            .located(By.xpath("//div[@data-field='billing_phone']"));
}
