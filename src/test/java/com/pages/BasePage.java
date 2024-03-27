package com.pages;

import com.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public abstract class BasePage extends BrowserUtils {

    public static WebDriver driver;
    public static Wait<WebDriver> wait;
    public static SoftAssert softAssert;
    public static Actions actions;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
        softAssert = new SoftAssert();
        PageFactory.initElements(driver,this);
        actions=new Actions(driver);
    }
}
