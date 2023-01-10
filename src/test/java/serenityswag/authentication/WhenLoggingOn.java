package serenityswag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.inventory.pageObjects.InventoryPageObject;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn {

    @Steps
    LoginActions login;

    @BeforeEach
    public void login(){
        login.as(STANDARD_USER);
        Serenity.recordReportData().withTitle("Login Credentials")
                .andContents("User: " + STANDARD_USER.username() +
                        "\nPassword: " + STANDARD_USER.password() +
                        "\nDescription: " + STANDARD_USER.description());
    }

    InventoryPageObject inventoryPage;

    @Test
    public void loginViaHomePage() {
        Serenity.reportThat("The inventory should be displayed with the correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualTo("PRODUCTS")
        );
    }
}
