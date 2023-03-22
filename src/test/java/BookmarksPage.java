import java.util.LinkedList;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.By;

public class BookmarksPage {
    public static BookmarksPage openPage(){
        open("https://ok.ru/bookmarks");
        return new BookmarksPage();
    }

    public LinkedList<TopicPage> getBookmarksTopics(){
        LinkedList<TopicPage> ans = new LinkedList<>();
        for (var element: $$(By.xpath("//a[@class='media-text_a']"))) {
            ans.add(new TopicPage(element.getAttribute("href")));
        }
        return ans;
    }

}
