package ru.mpavlov.test.n;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.text.html.CSS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class OpenSiteTest {

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\source\\tn\\chromedriver.exe");

    }

    @Test
    public void testSiteNatlex() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //   driver.manage().timeouts().implicitlyWait( 2, TimeUnit.SECONDS);

        //open site
        driver.get("http://natlex.ru/");
        sleep(1000);

        //goto jobs
        driver.findElement(By.cssSelector("#top-navigation > div.nav-box > div.ui.large.secondary.inverted.text.menu.menu-list > a:nth-child(5)")).click();
        sleep(1000);

        //goto backend
        driver.findElement(By.linkText("Бэкенд-разработчик")).click();
        sleep(1000);

        //pick send CV
        driver.findElement(By.cssSelector("#feedback > div > div > a:nth-child(2)")).click();
        sleep(1000);

        //write name
        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div:nth-child(1) > div > input[type=text]")).sendKeys("Михаил");
        sleep(1000);

        //pick backend dev
        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div.position.required.field > div")).click();
        // sleep(1000);
        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div.position.required.field > div > div.menu.transition > div:nth-child(2)")).click();
        sleep(1000);

        //write phone
        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div:nth-child(3) > div > input[type=tel]")).sendKeys("+79214573127");
        sleep(1000);

        //write email
        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div:nth-child(4) > div > input[type=email]")).sendKeys("mail@mpavlov.ru");
        sleep(1000);

        //write message
        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div:nth-child(5) > textarea")).sendKeys("/////");
        sleep(1000);

        //pick file
        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div:nth-child(6) > div > input[type=file]:nth-child(3)")).sendKeys("C:\\source\\tn\\cv.txt");
        sleep(1000);

        //checkbox
        driver.findElement(By.cssSelector(" #agreement-checkbox")).click();
        sleep(1000);
        //        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        String winHanaleBefore = driver.getWindowHandle();
        driver.switchTo().frame(0);
        driver.findElement(By.id("recaptcha-anchor")).click();
        driver.switchTo().window(winHanaleBefore);
        sleep(1000);


        WebElement explicitWait2 = (new WebDriverWait(driver, 1000)).until(ExpectedConditions.visibilityOfElementLocated(By.className("toast-text")));

        //Send
//        driver.findElement(By.cssSelector("#feedback > div > section > div:nth-child(2) > form > div.field.agreement-check > div.send-button-box > button")).click();
//        sleep(1000);
        Assert.assertEquals("Success", explicitWait2.getText());
        driver.quit();


    }


}