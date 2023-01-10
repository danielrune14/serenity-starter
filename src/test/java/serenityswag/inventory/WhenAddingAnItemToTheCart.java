package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.LoginActions;
import serenityswag.cart.CartActions;
import serenityswag.cart.CartItem;
import serenityswag.cart.ShoppingCartPageObject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    @Steps
    LoginActions login;

    @Steps
    CartActions cart;

    ShoppingCartPageObject cartPage;

    @BeforeEach
    public void login(){
        login.as(STANDARD_USER);
    }

    @Test
    public void theCorrectItemCountShouldBeShown(){
        Serenity.reportThat("The shopping cart badge should be empty",
                () -> assertThat(cartPage.cartBadgeNumber()).isEmpty());

        cart.addItem("Sauce Labs Backpack");

        Serenity.reportThat("The shopping cart badge should now be '1'",
                () -> assertThat(cartPage.cartBadgeNumber()).isEqualTo("1"));
    }

    @Test
    public void allTheItemsShouldAppearInTheCart(){
        List<String> addedProducts = cart.addThreeItems
                ("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Onesie");

        cart.openCart();

        Serenity.reportThat("Should see all of the items listed in the shooping cart page",
                () ->assertThat(cart.displayedItems()).containsExactlyElementsOf(addedProducts));
    }

    @Test
    public void pricesForEachItemShouldBeShownInTheCart(){
        List<String> addedProducts = cart.addThreeItems
                ("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt","Sauce Labs Onesie");

        cartPage.open();

        List<CartItem> items = cartPage.items();
        assertThat(items).hasSize(3)
                .allMatch(item -> item.getItemPrice() > 0.0);
    }

    //inRadioButton
}
