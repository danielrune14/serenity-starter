package serenityswag.heroku;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://the-internet.herokuapp.com/hovers")
public class HoverPage extends PageObject {

    public static final String VISIBLE_FIGURE = "css:div.figure:nth-of-type({0})";

    public void hoverOverFigure(int figureNbr) {
        WebElementFacade figure = $(VISIBLE_FIGURE, figureNbr);

        withAction().moveToElement(figure).perform();
    }

    public WebElementState captionForFigure(int figureNbr) {
        return $(VISIBLE_FIGURE + ">div", figureNbr);
    }
}
