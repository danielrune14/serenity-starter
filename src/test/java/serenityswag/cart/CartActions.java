package serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.pageObjects.ProductListPageObject;

import java.util.List;

public class CartActions extends UIInteractionSteps {

    ShoppingCartPageObject shoppingCartPage;

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductListPageObject.addToCartBtnFor(itemName)).click();
    }

    @Step("Add {0} to the cart")
    public void addItems(List<String> items) {
        for(String itemName : items){
            addItem(itemName);
        }
    }

    @Step
    public void openCart(){
        $(ShoppingCartPageObject.icon()).click();
    }

    @Step
    public List<String> displayedItems(){
        return shoppingCartPage.items();
    }
}
