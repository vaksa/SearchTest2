package RigaTask.jbehave;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.jbehave.ThucydidesJUnitStories;
import org.jbehave.core.annotations.AfterScenario;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {

    @Steps
    private ScenarioSteps scenarioSteps;

    public AcceptanceTestSuite() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        getSystemConfiguration().setIfUndefined("webdriver.driver", "chrome");
        getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_STORE_HTML_SOURCE.getPropertyName(), "true");
        getSystemConfiguration().setIfUndefined(ThucydidesSystemProperty.THUCYDIDES_TAKE_SCREENSHOTS.getPropertyName(), "FOR_FAILURES");
    }

    @AfterScenario
    public void AfterScenario() {
        scenarioSteps.getDriver().quit();
    }
}
