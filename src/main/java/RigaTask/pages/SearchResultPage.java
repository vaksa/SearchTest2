package RigaTask.pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@DefaultUrl("https://www.ss.com/{ru|lv}/*/search-result/*")
public class SearchResultPage extends PageObject {

    private final static String SEARCHED_ITEMS = "//table//tr[@id='head_line']/following-sibling::tr[@style!='display:none;']";
    private final static String ITEM_CHECKBOX = ".//input[@type='checkbox']";
    private final static String ITEM_TEXT = ".//div[@class='d1']//a";

    @FindBy(xpath = "//table[@id='page_main']//a[@href='/ru/electronics/search/']")
    private WebElementFacade advancedSearchLink;

    @FindBy(xpath = "//td[@class='msg_column_td']//a")
    private WebElementFacade priceSortingLink;

    @FindBy(xpath = "//div[@class='filter_second_line_dv']/span[1]/select")
    private WebElementFacade modeDropdown;

    @FindBy(xpath = "//div[@class='filter_second_line_dv']/span[2]/select")
    private WebElementFacade regionDropdown;

    @FindBy(xpath = "//div[@class='filter_second_line_dv']/span[3]/select")
    private WebElementFacade operationDropdown;

    @FindBy(xpath = "//div[@class='alert_dv']//a[@onclick='_alert_close();']")
    private WebElementFacade confirmPopupCloseButton;

    @FindBy(xpath = "//a[@href='/ru/favorites/']")
    private WebElementFacade favoritesButton;

    @FindBy(xpath = "//a[contains(@onclick, 'af')]")
    private WebElementFacade addToBookmarks;

    public void click_add_to_memo() {
        addToBookmarks.click();
    }

    public void closeConfirmPopup() {
        confirmPopupCloseButton.click();
    }

    public void sortByPrice() {
        priceSortingLink.click();
    }

    public void selectOperation(final String option) {
        String[] url = getDriver().getCurrentUrl().split("/");
        String value = String.format("/%s/%s/%s/%s/%s", url[3], url[4], url[5], option, url[6]);
        operationDropdown.selectByValue(value);
    }

    public void openAdvancedSearch() {
        advancedSearchLink.click();
    }

    public List<String> selectRandomItems(final int amount) {
        List<String> result = new ArrayList<>();
        List<WebElementFacade> items = findAll(SEARCHED_ITEMS);
        for (int i = 0; i < amount; i++) {
            int r = new Random().nextInt(items.size());
            selectCheckbox(items, r);
            result.add(items.get(r).then(ITEM_TEXT).getText());
        }
        return result;
    }

    private void selectCheckbox(final List<WebElementFacade> items, int r) {
        if (items.get(r).then(ITEM_CHECKBOX).isSelected()) {
            r = new Random().nextInt(items.size());
            selectCheckbox(items, r);
        } else {
            items.get(r).then(ITEM_CHECKBOX).click();
        }
    }

    public void openFavorites() {
        favoritesButton.click();
    }
}
