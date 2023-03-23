import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BookmarksTest {
    private static final TopicPage MARKED_TOPIC = TopicPage.getByUsernameAndID("vprokru", 155180743826786L);
    private static final TopicPage UNMARKED_TOPIC = TopicPage.getByUsernameAndID("vprokru", 155180984081762L);
    private static final String TEST_GROUP_USERNAME = "vprokru";
    @BeforeAll
    public static void login(){
        open("https://ok.ru/");
        new OkLoginPage().login("botS23AT8", "autotests2023");
    }

    @BeforeEach
    public void setUpBookmarks() {
        UNMARKED_TOPIC.openURL().ensureUnmark();
        MARKED_TOPIC.openURL().ensureMark();
    }

    @Test
    public void checkAddAndRemoveBookmark(){
        var topicPage = UNMARKED_TOPIC.openURL();
        topicPage.addToBookmarks();
        String topicUrl = topicPage.getUrl();
        var bookmarksPage = BookmarksPage.openPage();
        var firstBookMark = bookmarksPage.getBookmarksTopics().getFirst();
        assertEquals(topicUrl, firstBookMark.getUrl());

        topicPage.openURL();
        topicPage.removeFromBookmarks();
        BookmarksPage.openPage();
        var bookmarks = bookmarksPage.getBookmarksTopics();
        if (bookmarks.size() > 0) {
//            assertNotEquals(bookmarks.getFirst(), firstBookMark);
            assertThat(bookmarks.getFirst(), Matchers.not(Matchers.equalTo(firstBookMark)));
        }
    }

    @Test
    public void checkALotOfBookmarks() {
        var bookmarksPage = BookmarksPage.openPage();
        var bookmarks = bookmarksPage.getBookmarksTopics();

        for (var bookmark: bookmarks) {
            new TopicPage(bookmark.getUrl()).openURL().removeFromBookmarks();
        }

        var topicsList = GroupPage.getByUsername(TEST_GROUP_USERNAME).getTopics();

        for (var topic: topicsList) {
            topic.openURL().ensureMark();
        }

        var topicsUrlsList = topicsList.stream().map(TopicPage::getUrl).toList();
        for (var element: BookmarksPage.openPage().getBookmarksTopics().stream().map(TopicPage::getUrl).toList()) {
            assertTrue(topicsUrlsList.contains(element));
        }
    }

    @AfterAll
    public static void removeAllBookmarks() {
        for (var bookmark: BookmarksPage.openPage().getBookmarksTopics()) {
            bookmark.openURL().removeFromBookmarks();
        }
    }
}
