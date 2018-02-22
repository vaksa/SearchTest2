package RigaTask.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends PageObject {

    AbstractPage(final WebDriver driver) {
        super(driver);
        getDriver().manage().window().maximize();
    }

    public void waitForAjaxToComplete() {
        final String script = "return window.jQuery != undefined && jQuery.active == 0;";
        final Object result = getJavascriptExecutorFacade().executeScript(script);
        waitFor(condition -> result);
    }

    public void waitForReadyStateToComplete() {
        final String script = "return document.readyState";
        final Object result = getJavascriptExecutorFacade().executeScript(script);
        waitFor(condition -> result.equals("complete"));
    }
}