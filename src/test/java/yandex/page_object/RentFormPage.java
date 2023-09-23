package yandex.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentFormPage {
    private final WebDriver driver;

    public RentFormPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By calendarInput = By.xpath("//input[contains(@placeholder, 'Когда привезти самокат')]");
    private final By rentPeriodDropDownButton = By.cssSelector(".Dropdown-placeholder");
    private final By orderButton = By.xpath("//div[contains(@class, 'Order_Buttons')]/button[string()='Заказать']");


    public void setValueForCalendarInput(String value) {
        checkElementVisibility(calendarInput).sendKeys(value);
        driver.findElement(calendarInput).sendKeys(Keys.RETURN);
    }

    public void clickRentPeriod() {
        checkElementVisibility(rentPeriodDropDownButton).click();
    }

    public void selectRentPeriod(String period) {
        By locator = By.xpath("//div[contains(@class, 'Dropdown-option') and text()='" + period + "']");
        checkElementVisibility(locator)
                .click();
    }

    public void clickOrderButton() {
        checkElementVisibility(orderButton).click();
    }


    private WebElement checkElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

}
