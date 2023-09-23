package yandex.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationReadyOrder {
    private final WebDriver driver;

    public NotificationReadyOrder(WebDriver driver) {
        this.driver = driver;
    }

    private final By header = By.xpath("//div[contains(@class, 'Order_ModalHeader')]");


    public String getHeaderStatusOrder() {
        return checkElementVisibility(header).getText();
    }

    private WebElement checkElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

}
