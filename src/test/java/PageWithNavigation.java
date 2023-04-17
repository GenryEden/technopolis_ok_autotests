import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface PageWithNavigation {
    static final String bookMarkButtonLocator = "//a[@hrefattrs=\"st.cmd=bookmarks\"]";

    public static BookmarksPage openBookmarks() {
        $(By.xpath(bookMarkButtonLocator)).click();
        return new BookmarksPage();
    }
}
