package serenityswag.heroku;

import org.junit.jupiter.api.Test;

public class WhenHoveringTheCursor {

    HoverPage hoverPage;

    @Test
    public void hover() {
        hoverPage.open();

        hoverPage.hoverOverFigure(2);
        hoverPage.captionForFigure(2).shouldBeVisible();
        hoverPage.captionForFigure(2).shouldContainText("name: user2");

        hoverPage.hoverOverFigure(1);
        hoverPage.captionForFigure(1).shouldBeVisible();
        hoverPage.captionForFigure(1).shouldContainText("name: user1");
    }
}
