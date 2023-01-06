package serenityswag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.pageObjects.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn {

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void loginViaHomePage() {

        login.as(STANDARD_USER);

        Serenity.reportThat("The inventory should be displayed with the correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualTo("PRODUCTS")
        );
    }
}
