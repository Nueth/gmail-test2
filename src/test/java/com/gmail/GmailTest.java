package com.gmail;

import com.gmail.pages.Gmail;
import com.gmail.pages.Mails;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class GmailTest extends BaseTest {

    private final String email = "testaccasd123@gmail.com";
    private final String password = "testasd123";
    private final String uniqueSubj = "subject " + (new SimpleDateFormat("dd-M-yyyy hh:mm:ss")).format(new Date());

    @Test
    public void testMailCycle() {
        Gmail gmailPage = new Gmail(driver);
        Mails mailsPage = new Mails(driver);
        gmailPage.visit().logIn(email, password);

        mailsPage.sendMail(email, uniqueSubj);
        assertTrue("email wasn't found", mailsPage.inboxMailsContainSubject(uniqueSubj));

    }
}
