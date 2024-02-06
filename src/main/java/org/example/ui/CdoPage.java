package org.example.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CdoPage {

    protected WebDriver driver;
    String login = null;
    String password = null;

    public CdoPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickOnElement(String string) {
        driver.findElement(By.xpath(string)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void waitForElement(String string) {
        clickOnElement(string);
    }

    private void insertData(String string, String name) {
        driver.findElement(By.xpath(name)).clear();
        driver.findElement(By.xpath(name)).sendKeys(string);
    }

    public void switchFrame(String string) {
        WebElement frame = driver.findElement(By.xpath(string));
        driver.switchTo().frame(frame);
    }

    public void typeLogin(String string) {
        insertData(login, string);
    }

    public void typePassword(String string) {
        insertData(password, string);
    }

}
