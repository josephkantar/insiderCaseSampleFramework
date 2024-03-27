package com.pages;

import com.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import static com.constants.FrameworkConstants.getUrl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(text(),'Company')]") private WebElement companyButton; // locator lar baska yerde degistirilmesin diye private ile olusturuk
    @FindBy(xpath = "//a[contains(text(),'Careers')]") private WebElement careersButton;
    @FindBy(id = "wt-cli-accept-all-btn") private WebElement acceptAllCookiesButton;

    public HomePage loadPage(){
        Allure.step("The user navigates to the " +getUrl()); //raporlama adimlari
        navigateTo_URL(getUrl());
        click(acceptAllCookiesButton);
        return  this; // bana load page in degerlerini gonder
    }

    public HomePage verifyHomePage(){
        Allure.step("Check that the user is on the homepage.");
        assertThat(DriverManager.getDriver().getTitle(),equalTo("#1 Leader in Individualized, Cross-Channel CX — Insider"));
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),"https://useinsider.com/");
        return this;
    }

    // goToCareersPageViaCompany burada zincereleme methodu kullaniyor , boylece homepage case leri run edildikten sonra browser kapanmadan diger
    // test leri run ediyor.

    public CareersPage goToCareersPageViaCompany(){
        Allure.step("The user navigates to the career page");
        click(companyButton);
        click(careersButton);
        return new CareersPage(driver);
    }
}
