package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.LoginActions;
import serenityswag.cart.CartActions;
import serenityswag.cart.ShoppingCartPageObject;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    @Steps
    LoginActions login;

    @Steps
    CartActions cart;

    ShoppingCartPageObject shoppingCartPage;

    @BeforeEach
    public void login(){
        login.as(STANDARD_USER);
    }

    @Test
    public void theCorrectItemCountShouldBeShown(){
        Serenity.reportThat("The shopping cart badge should be empty",
                () -> assertThat(shoppingCartPage.cartBadgeNumber()).isEmpty());

        cart.addItem("Sauce Labs Backpack");

        Serenity.reportThat("The shopping cart badge should now be '1'",
                () -> assertThat(shoppingCartPage.cartBadgeNumber()).isEqualTo("1"));
    }

    @Test
    public void allTheItemsShouldAppearInTheCart() throws InterruptedException {
        List<String> addedProducts = new ArrayList<String>(){
            {add("Sauce Labs Backpack"); add("Sauce Labs Bolt T-Shirt"); add("Sauce Labs Onesie");}};

        cart.addItems(addedProducts);
        cart.openCart();

        Serenity.reportThat("Should see all of the items listed in the shooping cart page",
                () ->assertThat(cart.displayedItems()).containsExactlyElementsOf(addedProducts));

    }
}
