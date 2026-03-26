package com.automationexercise.tasks.login;

import com.automationexercise.ui.login.LoginFormUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterCredentialsTask {
    public static Performable enterIdNumber(String idNumber) {
        return Task.where("{0} ingresa el numero de cedula en el formulario de inicio de sesion",
                WaitUntil.the(LoginFormUI.IDNUMBER, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(idNumber).into(LoginFormUI.IDNUMBER));
    }

    public static Performable enterPassword(String password) {
        return Task.where("{0} ingresa el password en el formulario de inicio de sesion",
                WaitUntil.the(LoginFormUI.PASSWORD, isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(password).into(LoginFormUI.PASSWORD));
    }

    public static Performable clickLogInButton() {
        return Task.where("{0} click en el boton Iniciar sesion",
                WaitUntil.the(LoginFormUI.LOGIN_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(LoginFormUI.LOGIN_BUTTON));
    }
}
