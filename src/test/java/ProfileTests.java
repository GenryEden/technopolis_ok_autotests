import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ProfileTests {
    private static final String notFriendId = "kernelpunik";
    @BeforeAll
    public static void login(){
        open("https://ok.ru/");
        (new OkLoginPage()).login("botS23AT8", "autotests2023");
    }

    private static ProfilePage getNotFriendProfilePage(){
        return ProfilePage.goByUserName(notFriendId);
    }
    @Test
//    @Disabled("отключено до перепроверки под линуксом, под виндой приколы c кодировкой")
    public void checkAName(){
        var profilePage = getNotFriendProfilePage();
        String name = profilePage.getName();
        assertThat(name, equalToIgnoringCase("Виталий Емельянов"));
    }

    @Test
    public void createFriendInvite(){
        var profilePage = getNotFriendProfilePage();
        profilePage.sendFriendRequest();
    }

    @Test
    @Disabled("не разобрался, как навестись и нажать")
    public void createFriendInviteAndCancel(){
        var profilePage = getNotFriendProfilePage();
        profilePage.sendFriendRequest();
        profilePage.cancelFriendRequest();
    }

    @Test
//    @Disabled("отключено до перепроверки под линуксом, под виндой приколы c кодировкой")
    public void checkProfile(){
        var profilePage = getNotFriendProfilePage();
        assertThat(profilePage.getProfileInfo(),
                SimilarProfileMatcher.isSimilarTo(
                        new ProfileInfo()
                                .setDateOfBirth("21 ноября 2003")
                                .setName("Виталий Емельянов")
                )
        );
    }



}
