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

import static org.junit.Assert.assertTrue;

public class GmailTest {

    private static WebDriver driver;
    private final String email = "testaccasd123@gmail.com";
    private final String password = "testasd123";
    private final String uniqueSubj = "subject " + (new SimpleDateFormat("dd-M-yyyy hh:mm:ss")).format(new Date());

    @Before
    public void setup() {
        Configuration.loadProperties();
        System.setProperty(Configuration.NAME_DRIVER, Configuration.PATH_DRIVER);
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testMailCycle() {
        Gmail gmailPage = new Gmail(driver);
        Mails mailsPage = new Mails(driver);
        gmailPage.visit();
        gmailPage.logIn(email, password);

        mailsPage.sendMail(email, uniqueSubj);
        assertTrue("email wasn't found", mailsPage.inboxMailsContainSubject(uniqueSubj));

    }
}
