package RigaTask.steps;

import RigaTask.pages.SearchResultPage;
import net.thucydides.core.Thucydides;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchResultPageSteps extends ScenarioSteps {

    private SearchResultPage searchResultPage;

    @Step
    public void sort_by_price() {
        searchResultPage.sortByPrice();
    }

    @Step
    public void select_operation(final String option) {
        searchResultPage.selectOperation(option);
    }

    @Step
    public void open_advanced_search() {
        searchResultPage.openAdvancedSearch();
    }

    @Step
    public void select_random_items(final int amount) {
        Thucydides.getCurrentSession().put("Expected", searchResultPage.selectRandomItems(amount));
    }

    @Step
    public void add_to_memo() {
        searchResultPage.click_add_to_memo();
    }

    @Step
    public void close_confirm_popup() {
        searchResultPage.closeConfirmPopup();
    }

    @Step
    public void open_favorites() {
        searchResultPage.openFavorites();
    }
}
