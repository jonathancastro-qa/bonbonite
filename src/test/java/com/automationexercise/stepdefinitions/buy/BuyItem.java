package com.automationexercise.stepdefinitions.buy;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyItem {
    @Given("que el usuario tiene productos en el carrito")
    public void productOnCart(){

    }

    @And("se encuentra logueado en la plataforma")
    public void userLogged(){

    }

    @When("procede a realizar la compra")
    public void buyItem(){

    }

    @Then("el sistema debe confirmar que la compra fue exitosa")
    public void confirm(){

    }
}
