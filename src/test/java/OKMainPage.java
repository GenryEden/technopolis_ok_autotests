import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OKMainPage {
    private static final String ownPageButtonXPath = "//div[@id='hook_Block_Navigation']/div/div/div/a/div";
    public String getName(){
        return $(By.xpath(ownPageButtonXPath)).getOwnText();
    }

}
