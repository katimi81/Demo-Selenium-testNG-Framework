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
        Thread.sleep(2000);
        loginPage.login("yoll-student", "Bootcamp5#");
        Thread.sleep(2000);
        HomePage homePage = new HomePage(driver);
        homePage.clickPimTab();
        PimPage pimPage = new PimPage(driver);
        pimPage.clickAddEmployeeTab();
        pimPage.fillEmployeeDetails();
        pimPage.clickCreateLoginDetailsCheckbox();
//        System.out.println("Text: "+pimPage.getPasswordRecommendationText());
        Assert.assertEquals(pimPage.getPasswordRecommendationText(), ExpectedMessages.PASSWORD_RECOMMENDATION);
        Thread.sleep(2000);
        Assert.assertTrue(pimPage.verifyLoginDetailsAreDisplayed());
        Thread.sleep(2000);
        pimPage.clickCreateLoginDetailsCheckbox();
        Thread.sleep(2000);
        Assert.assertFalse(pimPage.verifyLoginDetailsAreDisplayed());
    }

}
