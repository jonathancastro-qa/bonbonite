package com.automationexercise.stepdefinitions.login;

import com.automationexercise.questions.LoginQuestion;
import com.automationexercise.tasks.homepage.HomePageTask;
import com.automationexercise.tasks.login.EnterCredentialsTask;
import com.automationexercise.utils.RandomDataGenerator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginWithInvalidCredentialsSteps {
    @When("el usuario ingresa credenciales incorrectas")
    public void invalidCredentials() {
        String idNumber = RandomDataGenerator.generateID();
        String password = RandomDataGenerator.generatePassword();
        theActorInTheSpotlight().attemptsTo(HomePageTask.acceptingCookiesIfPresent());
        theActorInTheSpotlight().attemptsTo(HomePageTask.clickUserProfile());
        theActorInTheSpotlight().attemptsTo(EnterCredentialsTask.enterIdNumber(idNumber));
        theActorInTheSpotlight().attemptsTo(EnterCredentialsTask.enterPassword(password));
        theActorInTheSpotlight().attemptsTo(EnterCredentialsTask.clickLogInButton());
    }

    @Then("el sistema debe mostrar un mensaje de error de autenticación")
    public void displayErrorMessage(List<String> expectedMessage) {
        String expected = expectedMessage.get(0);

        theActorInTheSpotlight().should(
                seeThat("Nombre de usuario o contraseña inválidos. Recuperar contraseña", LoginQuestion.isErrorUpdaMessageVisible(), equalTo(expected)
                )
        );
    }
}
