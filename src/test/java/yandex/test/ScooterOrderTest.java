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
    private static String name ="Коля";
    private static String lastname = "Васильков";
    private static String city = "Москва";
    private static String metro = "Черкизовская";
    private static String phone = "12345678901";
    private static String fieldname = "Имя";
    private static String fieldlastname= "Фамилия";
    private static String fieldaddress = "Адрес";
    private static String fieldmetro = "Станция метро";
    private static String fieldphone  = "Телефон";
    private static String fielddate  = "22.09.2023";
    private static String fieldamount = "сутки";
    private static String fieldorder = "Заказ оформлен";
    private static String nametwo ="Катя";
    private static String lastnametwo = "Пупкина";
    private static String citytwo = "Санкт-Петербург";
    private static String metrotwo = "Бабушкинская";
    private static String phonetwo = "00362871928";
    private static String fielddatetwo  = "27.10.2023";
    private static String fieldamounttwo  = "двое суток";


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
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
        scooterMainPage.clickOnHeaderOrderButton();
        clientDataFormPage.setValueForField(fieldname , name);
        clientDataFormPage.setValueForField(fieldlastname, lastname);
        clientDataFormPage.setValueForField(fieldaddress, city);
        clientDataFormPage.setValueForFieldStation(fieldmetro, metro);
        clientDataFormPage.setValueForField(fieldphone, phone);
        clientDataFormPage.acceptCookiesButton();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
        clientDataFormPage.clickOnNextButton();
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
        rentFormPage.setValueForCalendarInput(fielddate);
        rentFormPage.clickRentPeriod();
        rentFormPage.selectRentPeriod(fieldamount);
        rentFormPage.clickOrderButton();
        notificationConfirmOrder.clickYesButton();
        Assert.assertTrue(notificationReadyOrder.getHeaderStatusOrder().contains(fieldorder));
    }
  @Test
    public void orderScooterTestTwo() {
        ScooterMainPage scooterMainPage = new ScooterMainPage(driver);
        ClientDataFormPage clientDataFormPage = new ClientDataFormPage(driver);
        RentFormPage rentFormPage = new RentFormPage(driver);
        NotificationConfirmOrder notificationConfirmOrder = new NotificationConfirmOrder(driver);
        NotificationReadyOrder notificationReadyOrder = new NotificationReadyOrder(driver);
        scooterMainPage.scrollToOrderButton();
        scooterMainPage.clickOnAnotherOrderButton();
        clientDataFormPage.setValueForField(fieldname, nametwo);
        clientDataFormPage.setValueForField(fieldlastname, lastnametwo);
        clientDataFormPage.setValueForField(fieldaddress, citytwo);
        clientDataFormPage.setValueForFieldStation(fieldmetro, metrotwo);
        clientDataFormPage.setValueForField(fieldphone, phonetwo);
        clientDataFormPage.acceptCookiesButton();
        clientDataFormPage.clickOnNextButton();
        rentFormPage.setValueForCalendarInput(fielddatetwo);
        rentFormPage.clickRentPeriod();
        rentFormPage.selectRentPeriod(fieldamounttwo);
        rentFormPage.clickOrderButton();
        notificationConfirmOrder.clickYesButton();
        Assert.assertTrue(notificationReadyOrder.getHeaderStatusOrder().contains(fieldorder));
    }

}
