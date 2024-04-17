import org.Object.MainPage;
import org.Object.NotFoundPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class NotFoundOrderTest {
    private final WebDriver driver = new ChromeDriver();
    //private final WebDriver driver = new FirefoxDriver();

    @Test
    public void NotFoundPageTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();
        objMainPage.clickButton(MainPage.cookieButton);
        objMainPage.clickButton(MainPage.orderStatus);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(MainPage.inputOrderStatus));
        objMainPage.input(MainPage.inputOrderStatus, "adb");
        objMainPage.clickButton(MainPage.goButton);

        NotFoundPage objNotFoundPage = new NotFoundPage(driver);
        objNotFoundPage.waitForLoadNotFoundPage();

        Boolean isNotFoundDisplayed = driver.findElement(NotFoundPage.orderNotFound).isDisplayed();
        assertEquals(true, isNotFoundDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
