package yandex.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ScooterMainPage {

    private final WebDriver driver;

    public ScooterMainPage(WebDriver driver) {
        this.driver = driver;
    }


    //локатор для полей
    private final By headerOrderButton = By.xpath("//div[contains(@class, 'Header_Nav')]//button[contains(@class, 'Button_Button')]");


    public void clickOnElementWithDropDownByIndex(int index) {
        By locator = By.xpath("//*[@id='accordion__heading-" + index + "']//..//..");
        scrollToElement(locator);
        checkElementVisibility(locator).click();
    }

    public String getExpandedDropDownElementTextByIndex(int index) {
        By locator = By.xpath("//*[@id='accordion__panel-" + index + "']/p");
        scrollToElement(locator);
        return checkElementVisibility(locator).getText();
    }

    public void clickOnHeaderOrderButton() {
        checkElementVisibility(headerOrderButton).click();
    }

    private WebElement checkElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    private void scrollToElement(By locator) {
        //  scrolltobottom
//        new Actions(driver)
//                .moveToElement(driver.findElement(locator))
//                .perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
//Scroll to top
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));

    }


}
