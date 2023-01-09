package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.pageObjects.ProductListPageObject;

public class ViewProductDetailsActions extends UIInteractionSteps {

    @Step("View product details for product '{0}'")
    public void ForProductWithName(String itemName) {
        $(ProductListPageObject.productDetailsLinkFor(itemName)).click();
    }
}
