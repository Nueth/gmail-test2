package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "identifierId")
    private WebElement email;

    @FindBy(id = "identifierNext")
    private WebElement loginNextButton;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    public Gmail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }


    public void visit() {
        driver.get("http://gmail.com");
    }

    public void logIn(String login, String pass) {
        email.sendKeys(login);
        loginNextButton.click();
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
        passwordNextButton.click();
    }
}
