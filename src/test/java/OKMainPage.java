import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class OKMainPage {
    private static final String ownPageButtonXPath = "//a[@data-l=\"t,userPage\"]";
    private static final String postingFormLocator = "//div[@id=\"hook_Block_PostingForm\"]";
    private static final String feedHeaderLocator = "//div[@data-l=\"t,filter\"]";
    private static final String feedLocator = "//div[@id=\"hook_Block_MainFeedsContent\"]";
    public OKMainPage() {
        check();
    }
    public void check() {
        $(By.xpath(ownPageButtonXPath)).should(Condition.exist);
        $(By.xpath(postingFormLocator)).should(Condition.exist);
        $(By.xpath(feedHeaderLocator)).should(Condition.exist);
        $(By.xpath(feedLocator)).should(Condition.exist);
    }
    public String getName(){
        return $(By.xpath(ownPageButtonXPath)).getText();
    }

}
