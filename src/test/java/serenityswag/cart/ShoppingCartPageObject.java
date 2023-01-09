package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ShoppingCartPageObject extends PageObject {

    public static By icon(){
        return By.cssSelector(".shopping_cart_link");
    }

    public String cartBadgeNumber() {
        return $(".shopping_cart_link").getText();
    }

    public List<String> items(){
        return findAll(".inventory_item_name").texts();
    }
}
