package org.example.Lesson19;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class heroAppTest {

    @Test
    public void loginLogoutTest() {
        open("https://the-internet.herokuapp.com/");
        $(By.xpath("//a[text()='Form Authentication']")).click();
        $(By.xpath("//h2[text()='Login Page']")).shouldBe(visible);
        $(By.xpath("//input[@name ='username']")).setValue("tomsmith");
        $(By.xpath("//input[@name ='password']")).setValue("SuperSecretPassword!");
        $(By.xpath("//*[text() =' Login']")).click();
        $(By.xpath("//*[contains(text(), 'You logged into a secure area!')]")).shouldBe(visible);
        $(By.xpath("//*[text() = ' Logout']")).shouldBe(visible);
        $(By.xpath("//*[text() = ' Logout']")).click();
        $(By.xpath("//h2[text()='Login Page']")).shouldBe(visible);
    }

    @Test
    public void checkInvalidUsernameNotification() {
        open("https://the-internet.herokuapp.com/");
        $(By.xpath("//a[text()='Form Authentication']")).click();
        $(By.xpath("//*[@href='http://elementalselenium.com/']")).shouldBe(visible);
        $(By.xpath("//input[@name ='username']")).setValue("admin");
        $(By.xpath("//input[@name ='password']")).setValue("1234!");
        $(By.xpath("//*[text() =' Login']")).click();
        $(By.xpath("//*[contains(text(), 'Your username is invalid!')]")).shouldBe(visible);
    }
}
