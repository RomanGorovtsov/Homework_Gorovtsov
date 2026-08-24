package org.example.Lesson19.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SecureAreaPage {

    private final SelenideElement successMessage = $(By.xpath("//*[contains(text(), 'You logged into a secure area!')]"));
    private final SelenideElement logoutButton = $(By.xpath("//*[text()=' Logout']"));

    public SecureAreaPage checkSuccessMessageIsVisible() {
        successMessage.shouldBe(visible);
        return this;
    }

    public SecureAreaPage checkLogoutButtonIsVisible() {
        logoutButton.shouldBe(visible);
        return this;
    }

    public LoginPage clickLogout() {
        logoutButton.click();
        return new LoginPage();
    }
}

