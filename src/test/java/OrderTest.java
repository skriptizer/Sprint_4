import org.Object.OrderPage;
import org.Object.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

public class OrderTest {

    //private final WebDriver driver = new ChromeDriver();
    private final WebDriver driver = new FirefoxDriver();

    @Test
    public void orderSuccessTopButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();
        objMainPage.clickButton(MainPage.cookieButton);
        objMainPage.clickButton(MainPage.orderTopButton);

        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.waitForLoadOrderPage();
        objOrderPage.input(OrderPage.inputName, "Иван");
        objOrderPage.input(OrderPage.inputSurName, "Воронов");
        objOrderPage.input(OrderPage.inputAddress, "Ул. Пушкина");
        objOrderPage.clickButton(OrderPage.inputMetro);
        objOrderPage.clickButton(OrderPage.rokossovskogo);
        objOrderPage.input(OrderPage.inputPhone, "+79999999999");
        objOrderPage.clickButton(OrderPage.nextButton);
        objOrderPage.clickButton(OrderPage.inputOrderDate);
        objOrderPage.clickButton(OrderPage.april052024);
        objOrderPage.clickButton(OrderPage.inputRentalPeriod);
        objOrderPage.clickButton(OrderPage.day);
        objOrderPage.clickButton(OrderPage.black);
        objOrderPage.input(OrderPage.inputComment, "Побыстрее, пожалуйста!");
        objOrderPage.clickButton(OrderPage.orderButton);
        objOrderPage.clickButton(OrderPage.yesButton);

        Boolean isSuccsessDisplayed = driver.findElement(OrderPage.success).isDisplayed();
        assertEquals(true, isSuccsessDisplayed);
    }

    @Test
    public void orderSuccessBottomButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();

        WebElement element = driver.findElement(MainPage.orderBottomButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        objMainPage.clickButton(MainPage.cookieButton);
        objMainPage.clickButton(MainPage.orderBottomButton);
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.waitForLoadOrderPage();
        objOrderPage.input(OrderPage.inputName, "Алексей");
        objOrderPage.input(OrderPage.inputSurName, "Ледяев");
        objOrderPage.input(OrderPage.inputAddress, "Кошурникова");
        objOrderPage.clickButton(OrderPage.inputMetro);
        objOrderPage.clickButton(OrderPage.lihobory);
        objOrderPage.input(OrderPage.inputPhone, "+79888888888");
        objOrderPage.clickButton(OrderPage.nextButton);
        objOrderPage.clickButton(OrderPage.inputOrderDate);
        objOrderPage.clickButton(OrderPage.april112024);
        objOrderPage.clickButton(OrderPage.inputRentalPeriod);
        objOrderPage.clickButton(OrderPage.twoDays);
        objOrderPage.clickButton(OrderPage.grey);
        objOrderPage.input(OrderPage.inputComment, "Позвоните!");
        objOrderPage.clickButton(OrderPage.orderButton);
        objOrderPage.clickButton(OrderPage.yesButton);

        Boolean isSuccsessDisplayed = driver.findElement(OrderPage.success).isDisplayed();
        assertEquals(true, isSuccsessDisplayed);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}