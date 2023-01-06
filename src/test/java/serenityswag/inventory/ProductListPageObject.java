package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> getTitles() {
        return findAll(".inventory_item_name").textContents();
    }

    public void openProductDetailsFor(String ItemName) {
        find(By.linkText(ItemName)).click();
    }
}
