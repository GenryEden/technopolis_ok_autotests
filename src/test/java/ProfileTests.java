import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class ProfileTests {
    private static final String notFriendId = "kernelpunik";
    @BeforeAll
    public static void login(){
        open("https://ok.ru/");
        (new OkLoginPage()).login("botS23AT8", "autotests2023");
    }

    public static ProfilePage getNotFriendProfilePage(){
        return ProfilePage.goByUserName(notFriendId);
    }
    @Test
    public void checkAName(){
        var profilePage = getNotFriendProfilePage();
        String name = profilePage.getName();
        assertEquals("Виталий Емельянов", name);
    }

    @Test
    public void createFriendInvite(){
        var profilePage = getNotFriendProfilePage();
        profilePage.sendFriendRequest();
    }

    @Test
    public void checkProfile(){
        var profilePage = getNotFriendProfilePage();
        assertAll(
                () -> assertEquals("Виталий Емельянов", profilePage.getName()),
                () -> assertEquals(profilePage.getDateOfBirth(), "21 ноября 2003")
        );
    }



}
