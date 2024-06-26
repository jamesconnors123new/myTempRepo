package helpers;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CdlEisHelpers extends CdlHelpers {
    protected final Root pageObjectOfEis;

    public CdlEisHelpers(WebDriver pDriver, Root pageObjectOfEis) {
        super(pDriver);
        this.pageObjectOfEis = pageObjectOfEis;
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
                5,
                Duration.ofMillis(100L),
                pProtectedAction );
    }
}
