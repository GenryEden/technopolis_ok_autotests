import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class BookmarksTest extends BaseTest {
    private static final TopicPage MARKED_TOPIC = TopicPage.getByUsernameAndID("vprokru", 155180743826786L);
    private static final TopicPage UNMARKED_TOPIC = TopicPage.getByUsernameAndID("vprokru", 155180984081762L);

    @BeforeEach
    public void setUpBookmarks() {
        UNMARKED_TOPIC.openURL().ensureUnmark();
        MARKED_TOPIC.openURL().ensureMark();
    }

    @Test
    public void checkAddBookmark(){
        var topicPage = UNMARKED_TOPIC.openURL();
        topicPage.addToBookmarks();
        String topicUrl = topicPage.getUrl();
        topicPage.close();
        var bookmarksPage = PageWithNavigation.openBookmarks();
        var firstBookMark = bookmarksPage.getBookmarks().getFirst();
        var firstBookMarkUrl = firstBookMark.getUrl();
        assertEquals(topicUrl, firstBookMarkUrl);

    }

    @Test
    public void removeBookmark() {
        var bookmarksPage = BookmarksPage.openPage();
        var firstBookMark = bookmarksPage.getBookmarks().getFirst();
        var firstBookMarkUrl = firstBookMark.getUrl();
        var topicPage = firstBookMark.open();
        topicPage.removeFromBookmarks();
        topicPage.close();
        bookmarksPage.update();
        var bookmarks = bookmarksPage.getBookmarksTopics();
        if (bookmarks.size() > 0) {
            assertNotEquals(bookmarks.getFirst().getUrl(), firstBookMarkUrl);
        }
    }

    @AfterEach
    public void removeAllBookmarks() {
        for (var bookmark: BookmarksPage.openPage().getBookmarksTopics()) {
            bookmark.openURL().removeFromBookmarks();
        }
    }
}
