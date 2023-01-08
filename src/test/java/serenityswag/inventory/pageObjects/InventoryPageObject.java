package serenityswag.inventory.pageObjects;

import net.serenitybdd.core.pages.PageObject;

public class InventoryPageObject extends PageObject {

    public String getHeading() {
        return $(".title").getText();
    }
}
