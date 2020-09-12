package com.trainline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//*[@id='header-btn-1']")
    private WebElement register;

    @FindBy(id = "TextBox-SelectBox-register-titleSelectBox")
    private WebElement title;

    @FindBy(id="TextBox-register-fullNameTextBox")
    private WebElement firstName;

    @FindBy(id="TextBox-register-emailTextBox")
    private WebElement email;

    @FindBy(id="TextBox-register-passwordTextBox")
    private WebElement password;

    @FindBy(id="modelRegisterBtn")
    private WebElement registerBtn;




    public  SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTO(){
        this.driver.get("https://www.thetrainline.com/season-tickets");
        this.wait.until(ExpectedConditions.visibilityOf(this.register));
    }

    public  void register(){
        this.register.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));

        Select select=new Select(this.title);
        select.selectByValue("Miss");

        this.firstName.sendKeys("Test Auto");
        this.email.sendKeys("Automation@test.com");
        this.password.sendKeys("Apr@2020");
        this.registerBtn.click();
    }


}
