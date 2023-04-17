import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    public static void login() {
        open("https://ok.ru/");
        new OkLoginPage().login("botS23AT8", "autotests2023");
    }
}
