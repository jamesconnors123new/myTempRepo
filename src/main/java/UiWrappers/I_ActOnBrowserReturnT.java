package UiWrappers;

import Generic.customExceptions.CustomE2eException;

public interface I_ActOnBrowserReturnT<T> {
    T Action(Browser pWebDriver) throws CustomE2eException;
}
