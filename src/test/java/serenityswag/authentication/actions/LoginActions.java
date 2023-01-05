package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {

    @Step("Login as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com");

        $("css:input[data-test='username']").sendKeys(user.getUsername());
        $("css:input[data-test='password']").sendKeys(user.getPassword());
        $("css:input[data-test='login-button']").click();
        
    }
}
