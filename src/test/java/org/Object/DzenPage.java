package org.Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DzenPage {
    private WebDriver driver;

    // Поле "Поиск Яндекса"
    public static By dzenSearch = By.className("dzen-search-arrow-common");

    public DzenPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadDzenPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.className("dzen-search-arrow-common")));
    }
}
