package com.automationexercise.stepdefinitions.account;

import com.automationexercise.tasks.account.CreateAccountTask;
import com.automationexercise.tasks.homepage.HomePageTask;
import com.automationexercise.ui.account.MyAccountPageUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateSteps {

    @Given("que el usuario ingresa al sitio web de Bon Bonite")
    public void visitHome() {
        theActorCalled("User").attemptsTo(
                HomePageTask.openPage()
        );
    }

    @When("el usuario se registra con datos válidos")
    public void selectRegisterOption() {
        theActorInTheSpotlight().attemptsTo(HomePageTask.acceptingCookiesIfPresent());
        theActorInTheSpotlight().attemptsTo(CreateAccountTask.goToRegisterForm());
        theActorInTheSpotlight().attemptsTo(CreateAccountTask.fillRegistrationFormwithValidRandomData());
    }

    @Then("el sistema debe mostrar un mensaje de bienvenida")
    public void completeRegisterForm() {
        String expectedName = theActorInTheSpotlight().recall("firstName");

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(MyAccountPageUI.WELCOME_MESSAGE).textContent().contains("Hola, " + expectedName)
        );
    }
}
