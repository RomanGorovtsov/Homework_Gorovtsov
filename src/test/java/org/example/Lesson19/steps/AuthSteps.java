package org.example.Lesson19.steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.ru.И;
import org.example.Lesson19.pages.MainPage;
import org.example.Lesson19.pages.LoginPage;
import org.example.Lesson19.pages.SecureAreaPage;

public class AuthSteps {

    private final MainPage mainPage = new MainPage();
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;

    @Допустим("Пользователь открывает главную страницу сайта")
    public void openMainPage() {
        mainPage.openPage();
    }

    @Когда("Пользователь кликает по ссылке {string}")
    public void clickFormAuthLink(String linkName) {
        loginPage = mainPage.clickFormAuthentication();
    }

    @Тогда("Заголовок страницы содержит текст {string}")
    public void verifyHeader(String expectedHeaderText) {
        loginPage.checkHeaderIsVisible();
    }

    @Когда("Пользователь вводит логин {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @И("Пользователь вводит пароль {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @И("Нажимает кнопку Login")
    public void clickLogin() {
        loginPage.clickLoginWithButton();
        secureAreaPage = new SecureAreaPage();
    }

    @Тогда("Отображается сообщение {string}")
    public void verifySuccessMessage(String msg) {
        secureAreaPage.checkSuccessMessageIsVisible();
    }

    @И("На экране присутствует кнопка Logout")
    public void verifyLogoutButton() {
        secureAreaPage.checkLogoutButtonIsVisible();
    }

    @Когда("Пользователь нажимает на кнопку Logout")
    public void clickLogout() {
        loginPage = secureAreaPage.clickLogout();
    }

    @Тогда("Внизу страницы присутствует ссылка {string}")
    public void verifyFooterLink(String linkText) {
        loginPage.checkFooterLinkIsVisible();
    }

    @Тогда("Отображается сообщение об ошибке {string}")
    public void verifyErrorMessage(String errorMsg) {
        loginPage.checkErrorMessageIsVisible();
    }
}

