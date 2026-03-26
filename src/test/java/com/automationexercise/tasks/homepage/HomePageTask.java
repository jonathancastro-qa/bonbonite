package com.automationexercise.tasks.homepage;

import com.automationexercise.ui.HomePageUI;
import com.automationexercise.ui.account.EditAccountUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automationexercise.questions.HomePage.isContinueShoppingButtonVisible;
import static com.automationexercise.ui.HomePageUI.ACCEPT_COOKIES_BUTTON;
import static net.serenitybdd.screenplay.Task.where;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class HomePageTask {
    private static final String URL = "https://www.bon-bonite.com/";

    public static Performable openPage() {
        return Task.where("{0} abre la página www.bon-bonite.com",
                Open.url(URL)
        );
    }

    public static Performable acceptingCookiesIfPresent() {
        return Task.where("{0} acepta cookies si están presentes",
                Check.whether(
                        WebElementQuestion.the(ACCEPT_COOKIES_BUTTON),
                        isCurrentlyVisible()
                ).andIfSo(
                        WaitUntil.the(ACCEPT_COOKIES_BUTTON, isClickable())
                                .forNoMoreThan(15).seconds(),
                        Scroll.to(ACCEPT_COOKIES_BUTTON),
                        Click.on(ACCEPT_COOKIES_BUTTON)
                )
        );
    }

    public static Performable clickUserProfile() {
        return where("{0} hace click en el boton User",
                WaitUntil.the(HomePageUI.ICON_ACCOUNT, isClickable()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.ICON_ACCOUNT),
                Click.on(HomePageUI.ICON_ACCOUNT));
    }

    public static Performable clickContinueShopping() {
        return where("{0} hace click en el boton Continue Shopping",
                WaitUntil.the(HomePageUI.CONTINUE_SHOPPING_BUTTON, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.CONTINUE_SHOPPING_BUTTON),
                Click.on(HomePageUI.CONTINUE_SHOPPING_BUTTON));
    }

    public static Performable clickHomeMenu() {
        return where("{0} hace click en menu Home",
                WaitUntil.the(HomePageUI.HOME_MENU, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.HOME_MENU),
                Click.on(HomePageUI.HOME_MENU)
        );
    }

    public static Performable clickCartMenu() {
        return where("{0} hace click en menu Cart",
                WaitUntil.the(HomePageUI.CART_MENU, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.CART_MENU),
                Click.on(HomePageUI.CART_MENU)
        );
    }

    public static Performable clickLogoutMenu() {
        return where("{0} hace click en la opcion del menu Logout",
                WaitUntil.the(EditAccountUI.ICON_PROFILE,isClickable()).forNoMoreThan(10).seconds(),
                Scroll.to(EditAccountUI.ICON_PROFILE),
                Click.on(EditAccountUI.ICON_PROFILE),
                WaitUntil.the(HomePageUI.LOGOUT_MENU, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(HomePageUI.LOGOUT_MENU),
                Click.on(HomePageUI.LOGOUT_MENU));
    }

    public static Performable clickContinueShoppingIfVisible() {
        return where("{0} hace click en el botón 'Continue Shopping' si es visible",
                actor -> {
                    boolean isVisible = isContinueShoppingButtonVisible().answeredBy(actor);

                    if (isVisible) {
                        actor.attemptsTo(
                                Click.on(HomePageUI.CONTINUE_SHOPPING_BUTTON)
                        );
                    } else {
                        System.out.println("El botón 'Continue Shopping' no está visible.");
                    }
                }
        );
    }
}


