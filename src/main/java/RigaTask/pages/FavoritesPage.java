package RigaTask.pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.ss.com/{ru|lv}/{1}/search-result/*")
public class FavoritesPage extends AbstractPage {

    private final static String FAVORITES_ITEMS = "//table//tr[@id='head_line']/following-sibling::tr[@style!='display:none;']";
    private final static String ITEM_TEXT = ".//div[@class='d1']//a";

    public FavoritesPage(final WebDriver driver) {
        super(driver);
    }

    public List<String> getActualFavoritesItems() {
        List<WebElementFacade> items = findAll(FAVORITES_ITEMS);
        return items.stream().map(i -> i.then(ITEM_TEXT).getText()).collect(Collectors.toList());
    }
}