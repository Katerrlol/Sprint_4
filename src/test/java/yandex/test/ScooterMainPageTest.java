package yandex.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import yandex.page_object.ScooterMainPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScooterMainPageTest {
    private WebDriver driver;
    private final int index;
    private final String expectedText;
    private static String page = "https://qa-scooter.praktikum-services.ru/";
    private static int arrowone = 0;
    private static int arrowtwo = 1;
    private static int arrowthree = 2;
    private static int arrowfour = 3;
    private static int arrowfive = 4;
    private static int arrowsix = 5;
    private static int arrowseven = 6;
    private static int arroweight = 7;
    private static String textone = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static String texttwo = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static String textthree = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static  String textfour = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static String textfive = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static String textsix = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static String textseven = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static String texteight = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    public ScooterMainPageTest(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-blink-features=AutomationControlled", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(page);

    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> provideIndexAndExpected() {
        return Arrays.asList(new Object[][]{
                {arrowone, textone},
                {arrowtwo, texttwo},
                        {arrowthree, textthree},
                        {arrowfour, textfour},
                        {arrowfive, textfive},
                        {arrowsix, textsix},
                        {arrowseven, textseven},
                        {arroweight, texteight}
                });
    }




    @Test
    public void dropDownTest() {
        ScooterMainPage scooterMainPage = new ScooterMainPage(driver);
        scooterMainPage.clickOnElementWithDropDownByIndex(index);
        String actualText = scooterMainPage.getExpandedDropDownElementTextByIndex(index);
        Assert.assertEquals(expectedText, actualText);
    }



}
