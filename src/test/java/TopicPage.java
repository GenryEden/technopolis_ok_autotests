import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.open;


public class TopicPage {
    private static final String addBookmarksButtonLocator = "//a[@class='mall-widget_item mt-2x']";
    private static final String removeBookmarksButtonLocator = "//a[@class='mall-widget_item mt-2x  __active']";
    private static final String closeButtonLocator = "//div[@class=\"ic media-layer_close_ico\"]";
    private final String url;
    public static TopicPage getByUsernameAndID(String username, long id) {
        String url = "https://ok.ru/" + username + "/topic/" + id;
        return new TopicPage(url);
    }

    public TopicPage(String url) {
        this.url = url;
    }

    public TopicPage openURL() {
        open(this.url);
        return this;
    }

    public void addToBookmarks() {
        $(By.xpath(addBookmarksButtonLocator)).click();
    }

    public void removeFromBookmarks() {
        $(By.xpath(removeBookmarksButtonLocator)).click();
    }

    public String getUrl() {
        return url;
    }

    public boolean isMarked() {
        return !$(By.xpath(addBookmarksButtonLocator)).exists();
    }

    public void ensureMark() {
        if (!isMarked()) {
            addToBookmarks();
        }
    }

    public void ensureUnmark() {
        if (isMarked()) {
            removeFromBookmarks();
        }
    }

    public void close() {
        $(By.xpath(closeButtonLocator)).click();
    }
}
