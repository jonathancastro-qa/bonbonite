package com.automationexercise.tasks.account;

import com.automationexercise.ui.account.CreateAccountUI;
import com.automationexercise.ui.HomePageUI;
import com.automationexercise.utils.RandomDataGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class CreateAccountTask {

    public static Performable goToRegisterForm() {
        return Task.where("{0} se dirige al formulario de registro",
                WaitUntil.the(HomePageUI.ICON_ACCOUNT, isClickable()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.ICON_ACCOUNT),
                Click.on(HomePageUI.ICON_ACCOUNT),
                WaitUntil.the(CreateAccountUI.SHOW_REGISTER_LINK, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(CreateAccountUI.SHOW_REGISTER_LINK));
    }

    public static Performable fillRegistrationFormwithValidRandomData() {
        String idNumber = RandomDataGenerator.generateID();
        String firstName = RandomDataGenerator.generarFirstName();
        String lastName = RandomDataGenerator.generateLastName();
        String email = RandomDataGenerator.generateEmail();
        String password = RandomDataGenerator.generatePassword();

        return Task.where("{0} llena los campos requeridos",
                rememberUserData(idNumber,firstName, email, password),
                WaitUntil.the(CreateAccountUI.ID_NUMBER, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(idNumber).into(CreateAccountUI.ID_NUMBER),
                WaitUntil.the(CreateAccountUI.FIRST_NAME_INPUT, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(firstName).into(CreateAccountUI.FIRST_NAME_INPUT),
                WaitUntil.the(CreateAccountUI.LAST_NAME_INPUT, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(lastName).into(CreateAccountUI.LAST_NAME_INPUT),
                WaitUntil.the(CreateAccountUI.REG_EMAIL_INPUT, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(email).into(CreateAccountUI.REG_EMAIL_INPUT),
                WaitUntil.the(CreateAccountUI.REG_PASSWORD_INPUT, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(password).into(CreateAccountUI.REG_PASSWORD_INPUT),
                WaitUntil.the(CreateAccountUI.REG_PASSWORD_INPUT2, isClickable()).forNoMoreThan(20).seconds(),
                Scroll.to(CreateAccountUI.REG_PASSWORD_INPUT2).andAlignToTop(),
                Enter.theValue(password).into(CreateAccountUI.REG_PASSWORD_INPUT2),
                selectCheckBoxPersonalData(),
                clickRegisterButton()
        );
    }

    private static Performable rememberUserData(String idNumber,String firstName, String email, String password) {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                actor.remember("idNumber", idNumber);
                actor.remember("firstName", firstName);
                actor.remember("email", email);
                actor.remember("password", password);
            }
        };
    }

    public static Performable selectCheckBoxPersonalData() {
        return Task.where("{0} hace click en el checkbox Tratamiento de datos personales",
                WaitUntil.the(CreateAccountUI.PRIVACY_POLICY_CHECKBOX, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(CreateAccountUI.PRIVACY_POLICY_CHECKBOX));
    }

    public static Performable clickRegisterButton() {
        return Task.where("{0} hace click en el boton REGISTRARME",
                WaitUntil.the(CreateAccountUI.REGISTER_BUTTON, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(CreateAccountUI.REGISTER_BUTTON));
    }
}