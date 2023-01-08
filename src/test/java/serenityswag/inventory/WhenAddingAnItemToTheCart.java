package serenityswag.inventory;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.authentication.LoginActions;
import serenityswag.inventory.pageObjects.ProductListPageObject;

import static serenityswag.authentication.User.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart {

    LoginActions login;
    ProductListPageObject productList;

    @Test
    public void theCorrectItemCountShouldBeShown(){
        login.as(STANDARD_USER);
    }

    @Test
    public void allTheItemsShouldAppearInTheCart(){

    }
}
