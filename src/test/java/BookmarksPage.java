import java.util.LinkedList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

public class BookmarksPage {

    public static final String topicUrlLocator = "//a[@class='media-text_a']";
    public static final String bookmarkLocator = "//div[@tsid=\"feedGroupTopicCard\"]";
    public static final String sideNavMenusLocator = "//div[@class=\"nav-side \"]";
    public static final String bookmarksHeaderLocator = "//div[@class=\"portlet_h bookmarks-menu-header\"]";

    public BookmarksPage() {
        check();
    }

    public static BookmarksPage openPage(){
        open("https://ok.ru/bookmarks");
        return new BookmarksPage();
    }


    public LinkedList<TopicPage> getBookmarksTopics(){
        LinkedList<TopicPage> ans = new LinkedList<>();
        for (var element: $$(By.xpath(topicUrlLocator))) {
            ans.add(new TopicPage(element.getAttribute("href")));
        }
        return ans;
    }

    public LinkedList<Bookmark> getBookmarks(){
        var ans = new LinkedList<Bookmark>();
        Selenide.Wait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bookmarkLocator))); // TODO: так можно?
        for (var element: $$(By.xpath(bookmarkLocator))) {
            ans.add(new Bookmark(element));
        }
        return ans;
    }

    public void check() {
//        Selenide.screenshot("test");
//        Selenide.screenshot("test");
        $(By.xpath(sideNavMenusLocator)).should(Condition.exist);
        $(By.xpath(bookmarksHeaderLocator)).should(Condition.exist);
    }

    public void update() {
        Selenide.refresh(); // TODO: так можно?
    }
}
