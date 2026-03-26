package com.automationexercise.stepdefinitions.login;

import com.automationexercise.tasks.homepage.HomePageTask;
import com.automationexercise.tasks.login.EnterCredentialsTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginWithValidCredentialsSteps {
    @When("cierra sesion")
    public void loggedout(){
        theActorInTheSpotlight().attemptsTo(HomePageTask.clickLogoutMenu());
    }

    @And("vuelve a iniciar sesion")
    public void login(){
        String expecteidNumber = theActorInTheSpotlight().recall("idNumber");
        String expectedPassword = theActorInTheSpotlight().recall("password");
        theActorInTheSpotlight().attemptsTo(HomePageTask.clickUserProfile());
        theActorInTheSpotlight().attemptsTo(EnterCredentialsTask.enterIdNumber(expecteidNumber));
        theActorInTheSpotlight().attemptsTo(EnterCredentialsTask.enterPassword(expectedPassword));
        theActorInTheSpotlight().attemptsTo(EnterCredentialsTask.clickLogInButton());
    }

    @Then("el sistema debe permitir el acceso a su cuenta")
    public void goToAccount(){

    }
}
