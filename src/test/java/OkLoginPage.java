import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class OkLoginPage {
    private static final String loginFieldID = "field_email";
    private static final String passwordFieldID = "field_password";

    private static final String loginButtonXPath = "//input[@data-l='t,sign_in']";
    private static final String loginQRButtonLocator = "//a[@data-l=\"t,get_qr\"]";
    private static final String accountRestoreBtnLocator = "//a[@data-l=\"t,restore\"]";
    private static final String registerBtnLocator = "//a[@data-l=\"t,register\"]";

    public OkLoginPage(){
        check();
    }
    public OKMainPage login(String login, String pass) {
        $(By.id(loginFieldID)).clear();
        $(By.id(loginFieldID)).sendKeys(login);
        $(By.id(passwordFieldID)).clear();
        $(By.id(passwordFieldID)).sendKeys(pass);
        $(By.xpath(loginButtonXPath)).click();
        return new OKMainPage();
    }

    public void check() {
        $(By.id(loginFieldID)).should(Condition.exist);
        $(By.id(passwordFieldID)).should(Condition.exist);
        $(By.xpath(loginButtonXPath)).should(Condition.exist);
        $(By.xpath(loginQRButtonLocator)).should(Condition.exist);
        $(By.xpath(accountRestoreBtnLocator)).should(Condition.exist);
        $(By.xpath(registerBtnLocator)).should(Condition.exist);
    }
}
