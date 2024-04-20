package org.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

// Кнопки заказать
    // Нижняя кнопка "Заказать"
    public static By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");
    // Кнопка "Да"
    public static By yesButton = By.xpath(".//button[text()='Да']");

// Форма заказа
    // Поле "* Имя"
    public static By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // Ошибка "Введите корректное имя"
    public static By inputNameError = By.xpath(".//div[text()='Введите корректное имя']");
    // Поле "* Фамилия"
    public static By inputSurName = By.xpath(".//input[@placeholder='* Фамилия']");
    // Ошибка "Введите корректную фамилию"
    public static By inputSurNameError = By.xpath(".//div[text()='Введите корректную фамилию']");
    // Поле "* Адрес: куда привезти"
    public static By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Ошибка "Введите корректный адрес"
    public static By inputAddressError = By.xpath(".//div[text()='Введите корректный адрес']");
    // Поле "* Станция метро"
    public static By inputMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    // Бульвар Рокоссовского
    public static By rokossovskogo = By.xpath(".//div[text()='Бульвар Рокоссовского']");
    // Бульвар Рокоссовского
    public static By lihobory = By.xpath(".//div[text()='Лихоборы']");
    // Ошибка "Выберите станцию"
    public static By inputMetroError = By.xpath(".//div[text()='Выберите станцию']");
    // Поле "* Телефон: на него позвонит курьер"
    public static By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Ошибка "Введите корректный номер"
    public static By inputPhoneError = By.xpath(".//div[text()='Введите корректный номер']");
    // Поле "* Когда привезти самокат
    public static By inputOrderDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Choose пятница, 5-е апреля 2024 г.
    public static By april052024 = By.xpath(".//div[@aria-label='Choose пятница, 5-е апреля 2024 г.']");
    // Choose пятница, 5-е апреля 2024 г.
    public static By april112024 = By.xpath(".//div[@aria-label='Choose четверг, 11-е апреля 2024 г.']");
    // Поле "* Срок аренды
    public static By inputRentalPeriod = By.className("Dropdown-control");
    // Сутки
    public static By day = By.xpath(".//div[text()='сутки']");
    // Двое суток
    public static By twoDays = By.xpath(".//div[text()='двое суток']");
    // Чёрный жемчуг
    public static By black = By.id("black");
    // Серая безысходность
    public static By grey = By.id("grey");
    // Комментарий для курьера
    public static By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка далее
    public static By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    // Заказ оформлен
    public static By success = By.className("Order_NextButton__1_rCA");

    protected By locator;

    public void waitForLoadOrderPage() {

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(inputName));

    }

    public OrderPage(WebDriver driver){
        this.driver = driver;
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
