package UiWrappers;

import Generic.customExceptions.CustomE2eException;

public interface I_ActionReturnT<T> {
    T Action()  throws CustomE2eException;
}
