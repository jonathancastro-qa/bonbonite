package com.automationexercise.stepdefinitions.account;

import com.automationexercise.questions.EditUserQuestion;
import com.automationexercise.tasks.account.CreateAccountTask;
import com.automationexercise.tasks.account.EditAccountTask;
import com.automationexercise.tasks.homepage.HomePageTask;
import com.automationexercise.ui.account.EditAccountUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class EditSteps {
    @And("se registra en la plataforma")
    public void visitHome() {
        theActorCalled("User").attemptsTo(
                HomePageTask.acceptingCookiesIfPresent(),
                CreateAccountTask.goToRegisterForm(),
                CreateAccountTask.fillRegistrationFormwithValidRandomData()
        );
    }

    @When("actualiza su información personal")
    public void selectRegisterOption() {
        theActorInTheSpotlight().attemptsTo(EditAccountTask.editProfileInformation());
    }

    @Then("el sistema debe guardar los cambios correctamente")
    public void completeRegisterForm() {
        String expectedName = theActorInTheSpotlight().recall("newFirstName");
        String expectedLastName = theActorInTheSpotlight().recall("newLastName");
        String expectedPhoneNumber = theActorInTheSpotlight().recall("newPhoneNumber");

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(EditAccountUI.TXT_FIRST_NAME).text().isEqualTo(expectedName),
                Ensure.that(EditAccountUI.TXT_LAST_NAME).text().isEqualTo(expectedLastName),
                Ensure.that(EditAccountUI.TXT_PHONE).text().isEqualTo(expectedPhoneNumber)
        );
    }

    @And("se muestra el mensaje de exito")
    public void displaySuccessMessage(List<String> expectedMessage) {
        String expected = expectedMessage.get(0);

        theActorInTheSpotlight().should(
                seeThat("Datos personales actualizados correctamente", EditUserQuestion.isSuccessUpdaMessageVisible(), equalTo(expected)
                )
        );
    }
}
