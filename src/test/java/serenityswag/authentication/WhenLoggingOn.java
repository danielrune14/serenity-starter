package serenityswag.authentication;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn {

    @Managed
    WebDriver driver;

    @Test
    public void loginViaHomePage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[data-test='login-button']")).click();
        Thread.sleep(2000);

    }
}
