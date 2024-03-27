package com.pages;

import com.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;
import static com.constants.FrameworkConstants.getQAUrl;
import static com.utils.JSUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".location-info") private List<WebElement> locationInfo;
    @FindBy(css = "[class='icon-arrow-right location-slider-next ml-4 text-xsmall text-dark'") private WebElement swipeButton;
    @FindBy(xpath = "//h3[text()='Customer Success']") private WebElement customerSuccess;
    @FindBy(xpath = "//h3[text()='Sales']") private WebElement sales;
    @FindBy(xpath = "//h3[text()='Product & Engineering']") private WebElement productEngineering;
    @FindBy(xpath = "//div[@class='elementor-swiper']") private WebElement lifeInsider;

    public CareersPage verifyCareersPage(){
        Allure.step("Check that the user is on the Careers Page.");
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),"https://useinsider.com/careers/");
        assertThat(DriverManager.getDriver().getTitle(),containsString("Careers"));
        return this;
    }

    public  CareersPage verifyTeamsClickAble(){
        Allure.step("The user verifies the clickability of the 'Teams' element.");
        jsScrollClick(customerSuccess);
        assertThat(DriverManager.getDriver().getCurrentUrl(),containsString("customer-success"));
        DriverManager.getDriver().navigate().back();
        jsScrollClick(sales);
        assertThat(DriverManager.getDriver().getCurrentUrl(),containsString("sales"));
        DriverManager.getDriver().navigate().back();
        jsScrollClick(productEngineering);
        assertThat(DriverManager.getDriver().getCurrentUrl(),containsString("product-and-engineering"));
        DriverManager.getDriver().navigate().back();
        return this;
    }

    public CareersPage verifyLocationSessionVisible(){
        Allure.step("The user verifies the visibility of the locations.");
        scrollIntoViewJS(locationInfo.get(0));
        waitFor(2);
        for (WebElement each:locationInfo){
            each.isDisplayed();
            jsScrollClick(swipeButton);
            swipeByJS();
        }
        return this;
    }

    public CareersPage verifyLifeInsiderSessionVisible(){
        Allure.step("The user verifies the visibility of the Life Insider.");
        clickElementByJS(lifeInsider);
        Assert.assertTrue(lifeInsider.isDisplayed());
        return this;
    }

    public QualityAssurancePage goToQualityAssurance(){
        Allure.step("The user navigates to the Quality Assurance page");
        DriverManager.getDriver().get(getQAUrl());
        assertThat(DriverManager.getDriver().getCurrentUrl(),containsString("quality-assurance"));
        return new QualityAssurancePage(driver);
    }
}
