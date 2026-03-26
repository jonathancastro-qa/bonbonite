package com.automationexercise.questions;

import com.automationexercise.ui.account.EditAccountUI;
import net.serenitybdd.screenplay.Question;

public class EditUserQuestion {
    public static Question<String> isSuccessUpdaMessageVisible() {
        return actor -> EditAccountUI.DATA_UPDATED_MESSAGE.resolveFor(actor).getText().trim();
    }
}
