package RigaTask.steps;

import RigaTask.pages.SearchPage;
import net.thucydides.core.annotations.Step;

public class SearchPageSteps {

    private SearchPage searchPage;

    @Step
    public void enter_phrase_into_search_field(final String phrase) {
        searchPage.enterPhraseIntoSearchField(phrase);
    }

    @Step
    public void click_search_button() {
        searchPage.clickSearchButton();
    }

    @Step
    public void select_region(final String region) {
        searchPage.seletRegion(region);
    }

    @Step
    public void select_period(final String period) {
        searchPage.seletPeriod(period);
    }

    @Step
    public void set_min_price(final String min) {
        searchPage.setMinPrice(min);
    }

    @Step
    public void set_max_price(final String max) {
        searchPage.setMaxPrice(max);
    }
}
