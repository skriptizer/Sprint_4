package org.Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;

// Кука
    public static By cookieButton = By.className("App_CookieButton__3cvqF");

// Header
    // Верхняя кнопка "Заказать"
    public static By orderTopButton = By.className("Button_Button__ra12g");
    // Кнопка "Статус заказа"
    public static By orderStatus = By.className("Header_Link__1TAG7");
    // Поле "Введите номер заказа"
    public static By inputOrderStatus = By.xpath(".//input[@placeholder='Введите номер заказа']");
    // Кнопка "Go"
    public static By goButton = By.className("Header_Button__28dPO");
    // Лого "Яндекс"
    public static By logoYandex = By.xpath(".//img[@alt='Yandex']");
    // Лого "Самокат"
    public static By logoScooter = By.xpath(".//img[@alt='Scooter']");

// Main
    // Нижняя кнопка заказать
    public static By orderBottomButton = By.className("Button_Middle__1CSJM");
    // Текст "Самокат на пару дней"
    public static By title = By.className("Home_Header__iJKdX");

// вопросы
    // Сколько это стоит? И как оплатить?
    public static By howMuchIsIt = By.id("accordion__heading-0");
    // Хочу сразу несколько самокатов
    public static By iWantSomeScooters = By.id("accordion__heading-1");
    // Как рассчитывается время аренды?
    public static By howIsTheRentalTime = By.id("accordion__heading-2");
    // Можно ли заказать самокат прямо на сегодня?
    public static By orderToday = By.id("accordion__heading-3");
    // Можно ли продлить заказ или вернуть самокат раньше?
    public static By extendTheOrder = By.id("accordion__heading-4");
    // Вы привозите зарядку вместе с самокатом?
    public static By areYouBringingaACharger = By.id("accordion__heading-5");
    // Можно ли отменить заказ?
    public static By isItPossibleToCancelTheOrder = By.id("accordion__heading-6");
    // Я живу за МКАДом, привезёте?
    public static By iLiveAcrossTheMkad = By.id("accordion__heading-7");

// Всплывающие Ответы

    // Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    public static By answerHowMuchIsIt = By.xpath("//*[@id='accordion__panel-0']/p");
    public static String answerHowMuchIsItText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    // Один заказ - один самокат
    public static By answerIWantSomeScooters = By.xpath("//*[@id='accordion__panel-1']/p");
    public static String answerIWantSomeScootersText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    // Допустим, вы оформляете заказ на 8 мая
    public static By answerHowIsTheRentalTime = By.xpath("//*[@id='accordion__panel-2']/p");
    public static String answerHowIsTheRentalTimeText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    // Только начиная с завтрашнего дня. Но скоро станем расторопнее
    public static By answerOrderToday = By.xpath("//*[@id='accordion__panel-3']/p");
    public static String answerOrderTodayText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    // Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010
    public static By answerExtendTheOrder = By.xpath("//*[@id='accordion__panel-4']/p");
    public static String answerExtendTheOrderText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    // Самокат приезжает к вам с полной зарядкой
    public static By answerAreYouBringingaACharger = By.xpath("//*[@id='accordion__panel-5']/p");
    public static String answerAreYouBringingaAChargerText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    // Да, пока самокат не привезли.
    public static By answerIsItPossibleToCancelTheOrder = By.xpath("//*[@id='accordion__panel-6']/p");
    public static String answerIsItPossibleToCancelTheOrderText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    // Да, обязательно. Всем самокатов! И Москве, и Московской области.
    public static By answerILiveAcrossTheMkad = By.xpath("//*[@id='accordion__panel-7']/p");
    public static String answerILiveAcrossTheMkadText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    protected By locator;

    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
    }

    public void clickButton(By locator) {
        this.locator = locator;
        driver.findElement(locator).click();
    }

    public void input(By locator, String name) {
        this.locator = locator;
        driver.findElement(locator).sendKeys(name);
    }
}
