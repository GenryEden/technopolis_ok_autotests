import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

public class Bookmark {
    private SelenideElement element;

    public Bookmark(SelenideElement element) {
        this.element = element;
    }

    public String getUrl() {
        return this.element.$(By.xpath(".//a[@class=\"media_more_a\"]")).getAttribute("href");
    }

    public TopicPage open() {
        var ans = new TopicPage(getUrl());
        this.element.$(By.xpath(".//a[@class=\"media_more_a\"]")).click();
        return ans;
    }
}