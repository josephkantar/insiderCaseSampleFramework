package com.pages;

import static com.utils.JSUtils.*;

import com.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;


public class QualityAssurancePage extends BasePage{

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='See all QA jobs']") private WebElement seeAllJobsButton;
    @FindBy(id = "select2-filter-by-location-result-p5pv-Istanbul, Turkey") private WebElement istanbulTurkey;
    @FindBy(xpath = "//select[@id='filter-by-location']") private WebElement dropDownLocation;
    @FindBy(id = "jobs-list") private WebElement jobsList;
    @FindBy(xpath = "//a[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']") private WebElement viewRole;
    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']") private List<WebElement> qualityAssuranceList;
    @FindBy(xpath = "//div[@class='position-location text-large']") private List<WebElement> istanbulTurkeyList;

    public QualityAssurancePage clickSeeAllQAJobsAndSelectLocationAndDepartment(){
        Allure.step("The user clicks on seeAllQaJobs and filter Istanbul, Turkey");
        click(seeAllJobsButton);
        Select selectLocation = new Select(dropDownLocation);
        selectLocation.selectByVisibleText("Istanbul, Turkey");
        return this;
    }

    public QualityAssurancePage verifyJobsList(){
        Allure.step("The user verifies the visibility of the jobs list");
        Assert.assertTrue(jobsList.isDisplayed());
        scrollByAmountJS(0,450);
        waitFor(3);
        return this;
    }

    public QualityAssurancePage verifyJobsLocationContainsIstanbulTurkey(){
        Allure.step("The user confirms that it contains Istanbul, Turkey.");
        for(WebElement each:istanbulTurkeyList){
            Assert.assertEquals(each.getText(),"Istanbul, Turkey");
        }
        return this;
    }

    public QualityAssurancePage verifyJobsDepartmentContainsQualityAssurance(){
        Allure.step("The user confirms that it contains Quality Assurance.");
        for(WebElement each:qualityAssuranceList){
            Assert.assertEquals(each.getText(),"Quality Assurance");
        }
        return this;
    }

    public QualityAssurancePage clickViewRoleNewWindowsAndVerifyLeverApplication(){
        Allure.step("The user opens a new window and verifies that it is the Lever page.");
        hoverOver(istanbulTurkeyList.get(0));
        String windowHandle = DriverManager.getDriver().getWindowHandle();
        click(viewRole);
        switchToNewWindow(windowHandle);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("jobs.lever.co"));
        Assert.assertEquals(DriverManager.getDriver().getTitle(),"Insider. - Senior Software Quality Assurance Engineer");
        return this;
    }
}