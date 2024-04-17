import org.Object.MainPage;
import org.Object.OrderPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;

public class ErrorInputTest {
    private final WebDriver driver = new ChromeDriver();
    //private final WebDriver driver = new FirefoxDriver();
    private final OrderPage objOrderPage;

    public ErrorInputTest(){
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();
        objMainPage.clickButton(MainPage.cookieButton);
        objMainPage.clickButton(MainPage.orderTopButton);
        objOrderPage = new OrderPage(driver);
        objOrderPage.waitForLoadOrderPage();
    }

    @Test
    public void inputNameErrorTest() {
        objOrderPage.input(OrderPage.inputName, "Alex");
        objOrderPage.clickButton(OrderPage.inputSurName);
        boolean isErrorDisplayed = driver.findElement(OrderPage.inputNameError).isDisplayed();
        assertEquals(true, isErrorDisplayed);
    }

    @Test
    public void inputSurNameErrorTest(){
        objOrderPage.input(OrderPage.inputSurName, "Alex");
        objOrderPage.clickButton(OrderPage.inputName);
        boolean isErrorDisplayed = driver.findElement(OrderPage.inputSurNameError).isDisplayed();
        assertEquals(true, isErrorDisplayed);
    }

    @Test
    public void inputAddressErrorTest(){
        objOrderPage.input(OrderPage.inputAddress, "Alex");
        objOrderPage.clickButton(OrderPage.inputName);
        boolean isErrorDisplayed = driver.findElement(OrderPage.inputAddressError).isDisplayed();
        assertEquals(true, isErrorDisplayed);
    }

    @Test
    public void inputMetroErrorTest(){
        objOrderPage.clickButton(OrderPage.nextButton);
        boolean isErrorDisplayed = driver.findElement(OrderPage.inputMetroError).isDisplayed();
        assertEquals(true, isErrorDisplayed);
    }

    @Test
    public void inputPhoneErrorTest(){
        objOrderPage.input(OrderPage.inputPhone, "899");
        objOrderPage.clickButton(OrderPage.inputName);
        boolean isErrorDisplayed = driver.findElement(OrderPage.inputPhoneError).isDisplayed();
        assertEquals(true, isErrorDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
