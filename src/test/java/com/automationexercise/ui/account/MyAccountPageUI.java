package com.automationexercise.ui.account;

import net.serenitybdd.screenplay.targets.Target;

public class MyAccountPageUI {
    public static final Target WELCOME_MESSAGE = Target.the("mensaje de bienvenida")
            .locatedBy("//h3[contains(., 'Hola,')]");
}

