package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.LoginActions;
import serenityswag.inventory.pageObjects.ProductDetailsPageObject;
import serenityswag.inventory.pageObjects.ProductListPageObject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightedProducts {

    @Steps
    LoginActions login;

    @Steps
    ViewProductDetailsActions viewProductDetails;

    @BeforeEach
    public void login(){
        login.as(STANDARD_USER);
    }

    ProductListPageObject productList;
    ProductDetailsPageObject productDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){
        List<String> productsOnDisplay = productList.titles();
        Serenity.reportThat("Product List should contain 6 items",
                () -> assertThat(productsOnDisplay).hasSize(6));
        Serenity.reportThat("Product List should contain Sauce Labs Backpack",
                () -> assertThat(productsOnDisplay).contains("Sauce Labs Backpack"));
    }

    @Test
    public void highlightedProductsShouldDisplayTheCorrespondingImages(){
        List<String> productsOnDisplay = productList.titles();

        SoftAssertions softly = new SoftAssertions();
        productsOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll();
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        String firstItemName = productList.titles().get(0);
        viewProductDetails.ForProductWithName(firstItemName);

        Serenity.reportThat("The product name should be correctly displayed",
                () -> assertThat(productDetails.productName()).isEqualTo(firstItemName));

        Serenity.reportThat("The product image should have the correct 'alt' value",
                () -> productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible());

    }
}
