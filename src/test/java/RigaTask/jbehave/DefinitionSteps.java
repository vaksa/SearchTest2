package RigaTask.jbehave;

import RigaTask.steps.FavoritesPageSteps;
import RigaTask.steps.HomePageSteps;
import RigaTask.steps.SearchPageSteps;
import RigaTask.steps.SearchResultPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

public class DefinitionSteps {

    @Steps
    private HomePageSteps homePageSteps;

    @Steps
    private SearchPageSteps searchPageSteps;

    @Steps
    private SearchResultPageSteps searchResultPageSteps;

    @Steps
    private FavoritesPageSteps favoritesPageSteps;

    @Given("open the browser and maximize it")
    public void givenOpenTheBrowserAndMaximizeIt() {
        homePageSteps.openAndMaximize();
    }

    @Given("switch to '$language' language")
    public void givenSwitchToRussianLanguage(final String language) {
        homePageSteps.switch_language(language);
    }

    @When("go to the section '$section'")
    public void whenGoToTheSection(final String section) {
        homePageSteps.go_to_the_section(section);
    }

    @When("open search and in Search enter the search phrase '$phrase'")
    public void whenOpenSearchAndInSearchEnterTheSearchPhrase(final String phrase) {
        homePageSteps.open_search_page();
        searchPageSteps.enter_phrase_into_search_field(phrase);

    }

    @When("select a different search parameters and click Search button")
    public void whenSelectADifferentSearchParametersAndClickSearchButton() {
        searchPageSteps.select_region("Riga");  // Could be set in .story file
        searchPageSteps.select_period("30");    // Could be set in .story file
        searchPageSteps.click_search_button();
    }

    @When("Sort the results by price")
    public void whenSortTheResultsByPrice() {
        searchResultPageSteps.sort_by_price();
    }

    @When("select option '$option' in 'Operation' dropdown")
    public void whenSelectOptionInOperationDropdown(final String option) {
        searchResultPageSteps.select_operation(option);
    }

    @When("open advanced search")
    public void whenOpenAdvancedSearch() {
        searchResultPageSteps.open_advanced_search();
    }

    @When("enter search option price between '$min' and '$max'")
    public void whenEnterSearchOptionPriceBetween(final String min, final String max) {
        searchPageSteps.set_min_price(min);
        searchPageSteps.set_max_price(max);
        searchPageSteps.click_search_button();
    }

    @When("choose at least '$amount' random ads")
    public void whenChooseAtLeastRandomAds(final int amount) {
        searchResultPageSteps.select_random_items(amount);
    }

    @When("press add to memo")
    public void whenPressAddToMemo() {
        searchResultPageSteps.add_to_memo();
        searchResultPageSteps.close_confirm_popup();
    }

    @When("open favorites")
    public void whenOpenFavorites() {
        searchResultPageSteps.open_favorites();
    }

    @Then("check that the ads on the page match the previously selected")
    public void thenCheckThatTheAdsOnThePageMatchThePreviouslySelected() {
        favoritesPageSteps.check_list_of_favorites();
    }
}
