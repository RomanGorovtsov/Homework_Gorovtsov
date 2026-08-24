package org.example.Lesson19;

import org.example.Lesson19.Pages.MainPage;
import org.junit.jupiter.api.Test;

public class heroAppTest {

    private final MainPage mainPage = new MainPage();

    @Test
    public void loginLogoutTest() {
        mainPage.openPage()
                .clickFormAuthentication()
                .checkHeaderIsVisible()
                .enterUsername("tomsmith")
                .enterPassword("SuperSecretPassword!")
                .clickLoginSuccess()
                .checkSuccessMessageIsVisible()
                .checkLogoutButtonIsVisible()
                .clickLogout()
                .checkHeaderIsVisible();
    }

    @Test
    public void checkInvalidUsernameNotification() {
        mainPage.openPage()
                .clickFormAuthentication()
                .checkFooterLinkIsVisible()
                .enterUsername("admin")
                .enterPassword("1234!")
                .clickLoginWithButton()
                .checkErrorMessageIsVisible();
    }
}
