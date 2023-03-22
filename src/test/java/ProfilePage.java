import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.By;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {

    private static final String nameLocator = "//h1[@class='__user-profile-name-decorator']";
    private static final String friendInviteLocator = "//li[@data-l='outlandertarget,invite,t,invite']";
    private static final String cancelInviteLocator = "//a[@class='u-menu_a']";

    private static final String ageLocator = "//span[@data-type='AGE']";

    private static final String lastVisitTime = "//div[@class='main-content-header_title']//span";
    // здесь локатор большой и неочевидный, поскольку у этого span класс какой-то очень странный, не уверен, что он надолго
    public static ProfilePage goById(long id) {
        String url = "https://ok.ru/profile/" + id;
        open(url);
        return new ProfilePage();
    }

    public static ProfilePage goByUserName(String userName) {
        String url = "https://ok.ru/" + userName;
        open(url);
        return new ProfilePage();
    }

    public void sendFriendRequest(){
        $(By.xpath(friendInviteLocator)).click();
    }

    public void cancelFriendRequest() {
        $(By.xpath(friendInviteLocator)).click();
        $(By.xpath(cancelInviteLocator)).click();
    }

    public String getName() {
        return $(By.xpath(nameLocator)).text();
    }

    public String getDateOfBirth() {
        String[] words = $(By.xpath(ageLocator)).text().split(" ");
        String[] usefulWords = Arrays.copyOfRange(words, 0, words.length - 2);
        return String.join(" ", usefulWords);
    }

    public String getLastVisitTime() {
        String[] words = $(By.xpath(lastVisitTime)).text().split(" ");
        String[] usefulWords = Arrays.copyOfRange(words, 2, words.length);
        return String.join(" ", usefulWords);
    }

    public ProfileInfo getProfileInfo(){
        return new ProfileInfo()
                .setName(getName())
                .setDateOfBirth(getDateOfBirth())
                .setLastVisit(getLastVisitTime());
    }
}
