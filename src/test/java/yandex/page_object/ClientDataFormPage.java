package yandex.page_object;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientDataFormPage {
    private final WebDriver driver;

    public ClientDataFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nextButton = By.xpath("//div[contains(@class, 'Order_NextButton')]/button");
    private final By acceptCookiesButton = By.xpath("//button[@id='rcc-confirm-button']");


    public void setValueForField(String placeholderName, String value) {
        By locator = By.xpath("//input[contains(@placeholder, '" + placeholderName + "')]");
        scrollToElement(locator);
        checkElementVisibility(locator)
                .sendKeys(value);
    }

    public void setValueForFieldStation(String placeholderName, String value) {
        By locator = By.xpath("//input[contains(@placeholder, '" + placeholderName + "')]");
        checkElementVisibility(locator)
                .sendKeys(value);
        driver.findElement(locator).sendKeys(Keys.DOWN);
        driver.findElement(locator).sendKeys(Keys.RETURN);


    }

    public void clickOnNextButton() {
        scrollToElement(nextButton);
        checkElementVisibility(nextButton)
                .click();
    }

    public void acceptCookiesButton() {
        checkElementVisibility(acceptCookiesButton)
                .click();
    }

    private WebElement checkElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    private void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//Scroll to top
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));

    }

}
