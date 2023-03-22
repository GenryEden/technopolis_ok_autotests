import java.util.LinkedList;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import org.openqa.selenium.By;

public class GroupPage {
    private static final String TOPIC_MORE_LOCATOR = "//a[@class='media_more_a']";
    private final String url;
    public static GroupPage getByUsername(String username) {
        return new GroupPage("https://ok.ru/" + username);
    }

    private GroupPage(String url) {
        this.url = url;
    }

    public GroupPage openURL() {
        open(url);
        return this;
    }

    public LinkedList<TopicPage> getTopics() {
        LinkedList<TopicPage> ans = new LinkedList<>();
        for (var element: $$(By.xpath(TOPIC_MORE_LOCATOR))) {
            ans.add(new TopicPage(element.getAttribute("href")));
        }
        return ans;
    }
}
