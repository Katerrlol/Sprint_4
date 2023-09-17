package yandex.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationConfirmOrder {
    private final WebDriver driver;

    public NotificationConfirmOrder(WebDriver driver) {
        this.driver = driver;
    }

    private final By yesButton = By.xpath("//button[text()='Да']");


    public void clickYesButton() {
        checkElementVisibility(yesButton).click();
    }

    private WebElement checkElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
}
