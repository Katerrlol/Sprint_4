package yandex.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import yandex.page_object.*;

public class ScooterOrderTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // автоматически качает нужную версию браузера, без необходимости скачивать exe
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }


    @Test
    public void orderScooterTest() {
        ScooterMainPage scooterMainPage = new ScooterMainPage(driver);
        ClientDataFormPage clientDataFormPage = new ClientDataFormPage(driver);
        RentFormPage rentFormPage = new RentFormPage(driver);
        NotificationConfirmOrder notificationConfirmOrder = new NotificationConfirmOrder(driver);
        NotificationReadyOrder notificationReadyOrder = new NotificationReadyOrder(driver);

        scooterMainPage.clickOnHeaderOrderButton();

        clientDataFormPage.setValueForField("Имя", "Коля");
        clientDataFormPage.setValueForField("Фамилия", "Васильков");
        clientDataFormPage.setValueForField("Адрес", "Москва");
        clientDataFormPage.setValueForFieldStation("Станция метро", "Черкизовская");
        clientDataFormPage.setValueForField("Телефон", "12345678901");
        clientDataFormPage.acceptCookiesButton();
        clientDataFormPage.clickOnNextButton();

        rentFormPage.setValueForCalendarInput("22.09.2023");
        rentFormPage.clickRentPeriod();
        rentFormPage.selectRentPeriod("сутки");
        rentFormPage.clickOrderButton();

        notificationConfirmOrder.clickYesButton();

        Assert.assertTrue(notificationReadyOrder.getHeaderStatusOrder().contains("Заказ оформлен"));
    }
}
