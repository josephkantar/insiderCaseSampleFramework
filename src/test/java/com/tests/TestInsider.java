package com.tests;

import com.utils.RetryAnalyzer;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class TestInsider extends BaseTest{

    @Severity(SeverityLevel.CRITICAL)
    @Step("Insider Case")
    @Test(testName = "Insider Case",retryAnalyzer = RetryAnalyzer.class)
    public void testInsiderTask() {
        homePage
                .loadPage()
                .verifyHomePage()
                .goToCareersPageViaCompany();
        careersPage
                .verifyCareersPage()
                .verifyLocationSessionVisible()
                .verifyTeamsClickAble()
                .verifyLifeInsiderSessionVisible()
                .goToQualityAssurance();
        qualityAssurancePage
                .clickSeeAllQAJobsAndSelectLocationAndDepartment()
                .verifyJobsList()
                .verifyJobsDepartmentContainsQualityAssurance()
                .verifyJobsLocationContainsIstanbulTurkey()
                .clickViewRoleNewWindowsAndVerifyLeverApplication();
    }
}
//updated