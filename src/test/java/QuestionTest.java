import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.Object.MainPage;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionTest {
    private final WebDriver driver = new ChromeDriver();
    private final  By buttonLocator;
    private final  By textLocator;

    public QuestionTest(By buttonLocator, By textLocator){
        this.buttonLocator = buttonLocator;
        this.textLocator = textLocator;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {MainPage.howMuchIsIt, MainPage.answerHowMuchIsIt},
                {MainPage.iWantSomeScooters, MainPage.answerIWantSomeScooters},
                {MainPage.howIsTheRentalTime, MainPage.answerHowIsTheRentalTime},
                {MainPage.orderToday, MainPage.answerOrderToday},
                {MainPage.extendTheOrder, MainPage.answerExtendTheOrder},
                {MainPage.areYouBringingaACharger, MainPage.areYouBringingaACharger},
                {MainPage.isItPossibleToCanсelTheOrder, MainPage.answerIsItPossibleToCanсelTheOrder},
                {MainPage.iLiveAcrossTheMkad, MainPage.answerILiveAcrossTheMkad},
        };
    }

    @Test
    public void ClickQuestionTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();

        WebElement element = driver.findElement(MainPage.iLiveAcrossTheMkad);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objMainPage.clickButton(buttonLocator);

        boolean isTextDisplayed = driver.findElement(textLocator).isDisplayed();
        assertEquals(true, isTextDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}