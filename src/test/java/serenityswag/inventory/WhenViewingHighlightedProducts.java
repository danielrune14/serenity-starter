package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.pageObjects.ProductDetailsPageObject;
import serenityswag.inventory.pageObjects.ProductListPageObject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightedProducts {

    @Steps
    LoginActions login;

    ProductListPageObject productList;
    ProductDetailsPageObject productDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){
        login.as(STANDARD_USER);

        List<String> productsOnDisplay = productList.getTitles();
        Serenity.reportThat("Product List should contain 6 items",
                () -> assertThat(productsOnDisplay).hasSize(6));
        Serenity.reportThat("Product List should contain Sauce Labs Backpack",
                () -> assertThat(productsOnDisplay).contains("Sauce Labs Backpack"));
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(STANDARD_USER);

        String firstItemName = productList.getTitles().get(0);
        productList.openProductDetailsFor(firstItemName);

        Serenity.reportThat("The product Name is correct",
                () -> assertThat(productDetails.productName()).isEqualTo(firstItemName));

        productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible();

    }
}
