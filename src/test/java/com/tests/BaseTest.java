package com.tests;

import com.driver.DriverManager;
import com.pages.CareersPage;
import com.pages.HomePage;
import com.pages.QualityAssurancePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.driver.Driver.initDriver;
import static com.driver.Driver.quitDriver;

public class BaseTest {

   HomePage homePage;
   CareersPage careersPage;
   QualityAssurancePage qualityAssurancePage;

    @BeforeMethod
    public void setUp() {
        initDriver();
        homePage=new HomePage(DriverManager.getDriver());
        careersPage=new CareersPage(DriverManager.getDriver());
        qualityAssurancePage=new QualityAssurancePage(DriverManager.getDriver());
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
