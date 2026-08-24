package org.example.Lesson19.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement pageHeader = $(By.xpath("//h2[text()='Login Page']"));
    private final SelenideElement usernameInput = $(By.xpath("//input[@name='username']"));
    private final SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private final SelenideElement loginButton = $(By.xpath("//*[text()=' Login']"));
    private final SelenideElement errorMessage = $(By.xpath("//*[contains(text(), 'Your username is invalid!')]"));
    private final SelenideElement elementalSeleniumLink = $(By.xpath("//*[@href='http://elementalselenium.com/']"));

    public LoginPage checkHeaderIsVisible() {
        pageHeader.shouldBe(visible);
        return this;
    }

    public LoginPage checkFooterLinkIsVisible() {
        elementalSeleniumLink.shouldBe(visible);
        return this;
    }

    public LoginPage checkErrorMessageIsVisible() {
        errorMessage.shouldBe(visible);
        return this;
    }

    public LoginPage enterUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public SecureAreaPage clickLoginSuccess() {
        loginButton.click();
        return new SecureAreaPage(); // При успешном входе возвращаем защищенную страницу
    }

    public LoginPage clickLoginWithButton() {
        loginButton.click();
        return this; // При ошибке остаемся на этой же странице
    }
}
