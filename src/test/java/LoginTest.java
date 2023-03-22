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
        var okMainPage = okLoginPage.login("botS23AT8", "autotests2023");
        assertEquals(okMainPage.getName(), "botS23AT8 botS23AT8");
    }
}
