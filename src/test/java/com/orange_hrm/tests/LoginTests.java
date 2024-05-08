package com.orange_hrm.tests;

import com.orange_hrm.base.TestBase;
import com.orange_hrm.pages.HomePage;
import com.orange_hrm.pages.LoginPage;
import com.orange_hrm.test_data.DataProviders;
import com.orange_hrm.test_data.ExpectedMessages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends TestBase {



    @Test
    public void testSuccessfulLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("yoll-student", "Bootcamp5#");
        HomePage homePage = new HomePage(driver);
        String actualWelcomeMessage = homePage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMessage, ExpectedMessages.WELCOME_MESSAGE, "the Login verification Failed!");
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "invalidLoginCredentials")
    public void testErrorMessagesWithInvalidCredentials(String username, String password, String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message verification failed!");
    }
}