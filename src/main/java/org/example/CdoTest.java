package org.example;

import org.example.ui.CdoPage;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CdoTest {

    @Test
    public void Test() {

        WebDriver driver = new ChromeDriver();

        driver.get("http://moodle-cdo.kemsu.ru/login/index.php");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        CdoPage cdoPage = new CdoPage(driver);

        cdoPage.waitForElement("//*[@name='username']");
        cdoPage.typeLogin("//*[@name='username']");
        cdoPage.waitForElement("//*[@name='password']");
        cdoPage.typePassword("//*[@name='password']");
        cdoPage.waitForElement("//*[@class='btn btn-primary btn-block mt-3']");
        cdoPage.waitForElement("//*[@class='card-img dashboard-card-img']");

        try {
            TimeUnit.HOURS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}