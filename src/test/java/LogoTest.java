import org.Object.DzenPage;
import org.Object.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LogoTest {
    private final WebDriver driver = new ChromeDriver();
    //private final WebDriver driver = new FirefoxDriver();

    @Test
    public void scooterTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();
        objMainPage.clickButton(MainPage.cookieButton);
        objMainPage.clickButton(MainPage.orderBottomButton);
        objMainPage.clickButton(MainPage.logoScooter);
        objMainPage.waitForLoadMainPage();

        Boolean isSuccsessDisplayed = driver.findElement(MainPage.title).isDisplayed();
        assertEquals(true, isSuccsessDisplayed);
    }

    @Test
    public void yandexTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();
        objMainPage.clickButton(MainPage.logoYandex);

        new WebDriverWait(driver, 3)
                .until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        new WebDriverWait(driver, 3)
                .until(titleIs("Дзен"));

        Boolean isDzenPageDisplayed = driver.findElement(DzenPage.dzenSearch).isDisplayed();
        assertEquals(true, isDzenPageDisplayed);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
