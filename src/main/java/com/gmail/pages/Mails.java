package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Mails {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "T-I-KE")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement emailTo;

    @FindBy(name = "subjectbox")
    private WebElement subject;

    @FindBy(css = ".T-I.J-J5-Ji.aoO.T-I-atl.L3")
    private WebElement sendButton;

    @FindBy(css = "[role='main'] .zA")
    private List<WebElement> mails;

    public Mails(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 5);
        this.driver = driver;
    }

    public void sendMail(String email, String subj) {
        wait.until(ExpectedConditions.visibilityOf(composeButton));
        composeButton.click();
        emailTo.sendKeys(email);
        subject.sendKeys(subj);
        sendButton.click();
    }

    public boolean inboxMailsContainSubject(String subj) {
        for (WebElement m : mails) {
            if (m.getText().contains(subj))
                return true;
        }
        return false;
    }

}
