package com.automationexercise.tasks.account;

import com.automationexercise.ui.account.EditAccountUI;
import com.automationexercise.utils.RandomDataGenerator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditAccountTask {
    public static Performable editProfileInformation() {
        // Generación de nuevos datos aleatorios
        String newFirstName = RandomDataGenerator.generarFirstName();
        String newLastName = RandomDataGenerator.generateLastName();
        String newPhone=RandomDataGenerator.generatePhoneNumber();

        return Task.where("{0} actualiza su información de perfil",
                // Guardar los nuevos datos en la memoria del actor
                rememberUserEditData(newFirstName, newLastName,newPhone),
                WaitUntil.the(EditAccountUI.ICON_PROFILE,isClickable()).forNoMoreThan(10).seconds(),
                Scroll.to(EditAccountUI.ICON_PROFILE),
                Click.on(EditAccountUI.ICON_PROFILE),
                WaitUntil.the(EditAccountUI.EDIT_PERSONAL_INFO_MENU ,isClickable()).forNoMoreThan(10).seconds(),
                Click.on(EditAccountUI.EDIT_PERSONAL_INFO_MENU ),
                WaitUntil.the(EditAccountUI.BUTTON_EDIT ,isClickable()).forNoMoreThan(10).seconds(),
                Click.on(EditAccountUI.BUTTON_EDIT),
                WaitUntil.the(EditAccountUI.INPUT_FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(newFirstName).into(EditAccountUI.INPUT_FIRST_NAME),
                WaitUntil.the(EditAccountUI.INPUT_LAST_NAME, isClickable()),
                Enter.theValue(newLastName).into(EditAccountUI.INPUT_LAST_NAME),
                WaitUntil.the(EditAccountUI.INPUT_PHONE,isClickable()).forNoMoreThan(20).seconds(),
                Enter.theValue(newPhone).into(EditAccountUI.INPUT_PHONE),
                Click.on(EditAccountUI.BUTTON_SAVE_CHANGES)
        );
    }

    private static Performable rememberUserEditData(String firstName, String lastName, String phoneNumber) {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                actor.remember("newFirstName", firstName);
                actor.remember("newLastName", lastName);
                actor.remember("newPhoneNumber",phoneNumber);
            }
        };
    }
}