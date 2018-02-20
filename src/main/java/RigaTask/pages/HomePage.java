package RigaTask.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("https://www.ss.com")
public class HomePage extends PageObject {

    private final static String SECTION_TO_SELECT = "//h2/a[contains(@href, '%s')]";

    @FindBy(xpath = "//a[contains(@href, '/search/')]")
    private WebElementFacade searchLink;

    @FindBy(xpath = "//span[@class='menu_lang']/a")
    private WebElementFacade languageMenuLink;

    public void maximazeWindow() {
        getDriver().manage().window().maximize();
    }

    public void switchLanguage(final String lang) {
        if (lang.equals(languageMenuLink.getText())) {
            languageMenuLink.click();
        }
    }

    public void openSearchPage() {
        searchLink.click();
    }

    public void selectSection(final String section) {
        findBy(String.format(SECTION_TO_SELECT, section)).click();
    }
}