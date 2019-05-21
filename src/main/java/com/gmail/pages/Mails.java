package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Mails {

    private WebDriver driver;

    @FindBy(linkText = "Compose")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement emailTo;

    @FindBy(name = "subjectbox")
    private WebElement subject;

    @FindBy(linkText = "Send")
    private WebElement sendButton;

    @FindBy(css = "[role='main'] .zA")
    private List<WebElement> mails;


    public Mails(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void sendMail(String email, String subj) {
        composeButton.click();
        emailTo.sendKeys(email);
        subject.sendKeys(subj);
        sendButton.click();
    }

}
