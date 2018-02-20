package RigaTask.pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("https://www.ss.com/{ru|lv}/search/")
public class SearchPage extends PageObject {

    @FindBy(xpath = "//input[contains(@onkeyup, 'preload_search')]")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//input[@name='topt[8][min]']")
    private WebElementFacade minPriceInput;

    @FindBy(xpath = "//input[@name='topt[8][max]']")
    private WebElementFacade maxPriceInput;

    @FindBy(name = "search_region")
    private WebElementFacade regionDropdown;

    @FindBy(name = "pr")
    private WebElementFacade periodDropdown;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElementFacade searchButton;


    public void enterPhraseIntoSearchField(final String phrase) {
        searchInput.sendKeys(phrase);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void seletRegion(final String region) {
        regionDropdown.selectByValue(String.format("%s_f", region.toLowerCase()));
    }

    public void seletPeriod(final String period) {
        periodDropdown.selectByValue(period);
    }

    public void setMinPrice(final String min) {
        minPriceInput.sendKeys(min);
    }

    public void setMaxPrice(final String max) {
        maxPriceInput.sendKeys(max);
    }
}
