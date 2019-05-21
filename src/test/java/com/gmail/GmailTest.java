package com.gmail;

import com.gmail.pages.Gmail;
import com.gmail.pages.Mails;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GmailTest {

    private final String email = "testaccasd123@gmail.com";
    private final String password = "testasd123";
    private final String uniqueSubj = "subject " + (new SimpleDateFormat("dd-M-yyyy hh:mm:ss")).format(new Date());
    WebDriver driver;
    private Gmail gmailPage = new Gmail(driver);
    private Mails mailsPage = new Mails(driver);

    @Before
    public void setup() {
        WebDriver driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
    }


    @Test
    public void testMailCycle() {
        gmailPage.visit();
        gmailPage.logIn(email, password);

        mailsPage.sendMail(email, uniqueSubj);
    }
}
