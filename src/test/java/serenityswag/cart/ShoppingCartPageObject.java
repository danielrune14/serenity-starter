package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class ShoppingCartPageObject extends PageObject {

    private static By CART_ITEMS = By.cssSelector(".cart_item");

    public static By icon(){
        return By.cssSelector(".shopping_cart_link");
    }

    public String cartBadgeNumber() {
        return $(".shopping_cart_link").getText();
    }

    public List<String> itemNames(){
        return findAll(".inventory_item_name").texts();
    }

    public List<CartItem> items() {
        //inRadioButtonGroup("btn_secondary").selectByValue("Male");
        //$(".checkbox").isSelected();


        return findAll(CART_ITEMS).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceFrom(item.findBy(".inventory_item_price"))
                )
        );
    }

    private Double priceFrom(String textValue) {
        return Double.parseDouble(textValue.replace("$",""));
    }
}
