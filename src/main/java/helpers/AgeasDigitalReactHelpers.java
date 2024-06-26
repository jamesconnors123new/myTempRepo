package helpers;

import Generic.customExceptions.CustomE2eException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AgeasDigitalReactHelpers extends AgeasDigitalHelpers {
    public AgeasDigitalReactHelpers(WebDriver pDriver) {
        super(pDriver);
    }

    public Boolean RecogniseBusySpinnerInException(ElementClickInterceptedException pException) {
        return pException.getMessage().contains("LoadingSpinner__PageOverlay");
    }
    public void PerformActionThatMightBeBlockedByBusySpinner(
            Duration pBusyIndicationTimelimit,
            I_Action pProtectedAction ) throws CustomE2eException {
        RetryOnClickInterceptedException(
                pBusyIndicationTimelimit,
                this::RecogniseBusySpinnerInException,
                Duration.ofSeconds(1),
                100,
                Duration.ofMillis(100L),
                pProtectedAction );
    }
    public <T> T PerformActionThatMightBeBlockedByBusySpinner(
            Duration pBusyIndicationTimelimit,
            I_FuncReturning<T> pProtectedAction ) throws CustomE2eException {
        return RetryOnClickInterceptedException(
                pBusyIndicationTimelimit,
                this::RecogniseBusySpinnerInException,
                Duration.ofSeconds(1),
                5,
                Duration.ofMillis(1000L),
                pProtectedAction );

    }
}
