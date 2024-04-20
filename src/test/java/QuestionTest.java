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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class QuestionTest {
    private final WebDriver driver = new ChromeDriver();
    private final  By buttonLocator;
    private final  By textLocator;
    private final String answerText;

    public QuestionTest(By buttonLocator, By textLocator, String answerText){
        this.buttonLocator = buttonLocator;
        this.textLocator = textLocator;
        this.answerText = answerText;

    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {MainPage.howMuchIsIt, MainPage.answerHowMuchIsIt, MainPage.answerHowMuchIsItText},
                {MainPage.iWantSomeScooters, MainPage.answerIWantSomeScooters, MainPage.answerIWantSomeScootersText},
                {MainPage.howIsTheRentalTime, MainPage.answerHowIsTheRentalTime, MainPage.answerHowIsTheRentalTimeText},
                {MainPage.orderToday, MainPage.answerOrderToday, MainPage.answerOrderTodayText},
                {MainPage.extendTheOrder, MainPage.answerExtendTheOrder, MainPage.answerExtendTheOrderText},
                {MainPage.areYouBringingaACharger, MainPage.answerAreYouBringingaACharger, MainPage.answerAreYouBringingaAChargerText},
                {MainPage.isItPossibleToCancelTheOrder, MainPage.answerIsItPossibleToCancelTheOrder, MainPage.answerIsItPossibleToCancelTheOrderText},
                {MainPage.iLiveAcrossTheMkad, MainPage.answerILiveAcrossTheMkad, MainPage.answerILiveAcrossTheMkadText},
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
        String isAnswerCorrect = driver.findElement(textLocator).getText();
        assertTrue(isTextDisplayed);
        assertEquals(answerText, isAnswerCorrect);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}