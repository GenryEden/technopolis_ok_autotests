import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage {
    private static final String loginFieldID = "field_email";
    private static final String passwordFieldID = "field_password";

    private static final String loginButtonXPath = "//input[@value='Log in to OK']";
    public OKMainPage login(String login, String pass) {
        $(By.id(loginFieldID)).clear();
        $(By.id(loginFieldID)).sendKeys(login);
        $(By.id(passwordFieldID)).clear();
        $(By.id(passwordFieldID)).sendKeys(pass);
        $(By.xpath(loginButtonXPath)).click();
        return new OKMainPage();
    }
}
