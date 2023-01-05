package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> getTitles() {
        return findAll(".inventory_item_name").textContents();
    }
}
