package com.orange_hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {

    public PimPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu_pim_addEmployee")
    private WebElement addEmployeeTab;

    @FindBy(id = "firstName")
    private WebElement firstNameInputBox;

    @FindBy(id = "middleName")
    private WebElement middleNameInputBox;

    @FindBy(id = "lastName")
    private WebElement lastNameInputBox;

    @FindBy(xpath = "//input[@id ='chkLogin']")
    private WebElement createLoginDetailsCheckbox;

    @FindBy(id = "user_name")
    private WebElement usernameInputBox;

    @FindBy(id = "user_password")
    private WebElement passwordInputBox;

    @FindBy(id = "re_password")
    private WebElement confirmPasswordInputBox;

    @FindBy(id = "status")
    private WebElement statusDropdown;

    @FindBy(xpath = "//span[contains(text(),'hard to guess')]")
    private WebElement passwordRecommendation;

    public boolean verifyLoginDetailsAreDisplayed(){
      return usernameInputBox.isDisplayed() && passwordInputBox.isDisplayed()
              && confirmPasswordInputBox.isDisplayed() && statusDropdown.isDisplayed();


    }

    public String getPasswordRecommendationText(){
        System.out.println(passwordRecommendation.getText());
        return passwordRecommendation.getText();

    }

    public void fillEmployeeDetails(){
        firstNameInputBox.sendKeys("Michel");
        middleNameInputBox.sendKeys("Ibrahim");
        lastNameInputBox.sendKeys("Katimi");
    }


    public void clickAddEmployeeTab(){
        addEmployeeTab.click();
    }

    public void clickCreateLoginDetailsCheckbox(){
        createLoginDetailsCheckbox.click();
    }

}
