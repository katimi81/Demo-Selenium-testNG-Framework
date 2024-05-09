package com.orange_hrm.tests;

import com.orange_hrm.base.TestBase;
import com.orange_hrm.pages.HomePage;
import com.orange_hrm.pages.LoginPage;
import com.orange_hrm.pages.PimPage;
import com.orange_hrm.test_data.ExpectedMessages;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest extends TestBase {

    @Test
    public void addEmployee() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("yoll-student", "Bootcamp5#");
        HomePage homePage = new HomePage(driver);
        homePage.clickPimTab();
        PimPage pimPage = new PimPage(driver);
        pimPage.clickAddEmployeeTab();
        pimPage.fillEmployeeDetails();
        pimPage.clickCreateLoginDetailsCheckbox();
        Assert.assertEquals(pimPage.getPasswordRecommendationText(), ExpectedMessages.PASSWORD_RECOMMENDATION);
        Assert.assertTrue(pimPage.verifyLoginDetailsAreDisplayed());
        pimPage.clickCreateLoginDetailsCheckbox();
        Assert.assertFalse(pimPage.verifyLoginDetailsAreDisplayed());
    }

}
