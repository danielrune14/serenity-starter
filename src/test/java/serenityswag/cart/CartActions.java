package serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.pageObjects.ProductListPageObject;

import java.util.ArrayList;
import java.util.List;

public class CartActions extends UIInteractionSteps {

    ShoppingCartPageObject shoppingCartPage;

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductListPageObject.addToCartBtnFor(itemName)).click();
    }

    @Step("Add {0} to the cart")
    public List<String> addThreeItems(String product1, String product2, String product3) {
        List<String> items = new ArrayList<String>(){
            {add(product1); add(product2); add(product3);}};

        for(String itemName : items){
            addItem(itemName);
        }

        return items;
    }

    @Step
    public void openCart(){
        $(ShoppingCartPageObject.icon()).click();
    }

    @Step
    public List<String> displayedItems(){
        return shoppingCartPage.itemNames();
    }
}
