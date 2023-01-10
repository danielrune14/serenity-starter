package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractionSteps {

    @Step("Login as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com");

        $(LoginPageObject.USER_NAME).sendKeys(user.username());
        $(LoginPageObject.PASSWORD).sendKeys(user.password());
        $(LoginPageObject.LOGIN_BUTTON).click();
        
    }
}
