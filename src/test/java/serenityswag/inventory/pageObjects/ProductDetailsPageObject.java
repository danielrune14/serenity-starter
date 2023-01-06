package serenityswag.inventory.pageObjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class ProductDetailsPageObject extends PageObject {

    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltValueOf(String ItemName) {
        return $(".inventory_details_container img[alt='" + ItemName + "']");
    }
}
