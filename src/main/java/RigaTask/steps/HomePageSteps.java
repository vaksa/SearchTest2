package RigaTask.steps;

import RigaTask.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomePageSteps extends ScenarioSteps {

    private HomePage homePage;

    @Step
    public void openAndMaximize() {
        homePage.maximazeWindow();
        homePage.open();
    }

    @Step
    public void switch_language(final String language) {
        homePage.switchLanguage(language);
    }

    @Step
    public void go_to_the_section(final String section) {
        homePage.selectSection(section);
    }

    @Step
    public void open_search_page() {
        homePage.openSearchPage();
    }
}