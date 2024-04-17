package org.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotFoundPage {
    private WebDriver driver;

    // Окно "Такого заказа нет"
    public static By orderNotFound = By.className("Track_NotFound__6oaoY");

    public NotFoundPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadNotFoundPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='Посмотреть']")));
    }
}
