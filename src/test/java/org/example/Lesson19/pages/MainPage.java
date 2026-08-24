package org.example.Lesson19.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {


    private final SelenideElement formAuthenticationLink = $(By.xpath("//a[text()='Form Authentication']"));

    public MainPage openPage() {
        open("https://the-internet.herokuapp.com/");
        return this;
    }

    public LoginPage clickFormAuthentication() {
        formAuthenticationLink.click();
        return new LoginPage();
    }
}
