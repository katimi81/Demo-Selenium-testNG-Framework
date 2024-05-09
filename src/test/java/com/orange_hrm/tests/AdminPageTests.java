package com.orange_hrm.tests;

import com.orange_hrm.base.TestBase;
import com.orange_hrm.pages.AdminPage;
import com.orange_hrm.pages.HomePage;
import com.orange_hrm.pages.LoginPage;
import com.orange_hrm.test_data.ExpectedMessages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminPageTests extends TestBase {



        @Test
        public void verifyAdminPageHeader () {
            LoginPage loginpage = new LoginPage(driver);
            loginpage.login("yoll-student", "Bootcamp5#");
            HomePage homePage = new HomePage(driver);
            homePage.clickAdminTab();
            AdminPage adminPage = new AdminPage(driver);
            String actualHeader = adminPage.getUserManagementHeader();
            Assert.assertEquals(actualHeader, ExpectedMessages.USER_MANAGEMENT_HEADER, "Admin header verification failed!");


        }
    }
