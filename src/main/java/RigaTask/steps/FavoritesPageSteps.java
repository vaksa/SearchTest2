package RigaTask.steps;

import RigaTask.pages.FavoritesPage;
import net.thucydides.core.Thucydides;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FavoritesPageSteps extends ScenarioSteps {

    private FavoritesPage favoritesPage;

    @Step
    public void check_list_of_favorites() {
        List<String> expected = cutStringInList((List<String>) Thucydides.getCurrentSession().get("Expected"));
        List<String> actual = cutStringInList(favoritesPage.getActualFavoritesItems());
        assertThat(expected)
                .as("Ads on the page do not match the previously selected")
                .containsAll(actual);
    }

    private List<String> cutStringInList(final List<String> list) {
        return list.stream().map(s -> s.substring(0, 50)).collect(Collectors.toList());
    }
}
