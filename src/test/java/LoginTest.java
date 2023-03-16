import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    @BeforeAll
    public static void instant() {
    }

    @Test
    public void canLogin(){
        open("https://ok.ru/");
        OkLoginPage okLoginPage = new OkLoginPage();
        var okMainPage = okLoginPage.login("your-login-here", "your-password here");
        assertEquals(okMainPage.getName(), "your-name-here");
    }
}
