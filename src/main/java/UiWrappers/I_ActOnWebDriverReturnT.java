package UiWrappers;

import Generic.customExceptions.CustomE2eException;
import org.openqa.selenium.WebDriver;

public interface I_ActOnWebDriverReturnT<T> {
    T Action(WebDriver pWebDriver)  throws CustomE2eException;
}
