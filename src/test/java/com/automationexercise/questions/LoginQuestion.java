package com.automationexercise.questions;

import com.automationexercise.ui.account.EditAccountUI;
import com.automationexercise.ui.login.LoginFormUI;
import net.serenitybdd.screenplay.Question;

public class LoginQuestion {
    public static Question<String> isErrorUpdaMessageVisible() {
        return actor -> LoginFormUI.ERROR_MESSAGE.resolveFor(actor).getText().trim();
    }
}
