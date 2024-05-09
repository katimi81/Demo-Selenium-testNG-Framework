package com.orange_hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="welcome")
    private WebElement welcomeElement;

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminTab;

    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement pimTab;

    public void clickAdminTab(){
        adminTab.click();
    }

    public String getWelcomeMessage(){
        return welcomeElement.getText();
    }

    public void clickPimTab(){
        pimTab.click();
    }

}

