package helpers;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EchelonModel.Root;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CdlEchelonHelpers extends CdlHelpers {
  protected final Root pageObjectOfEchelon;

  public CdlEchelonHelpers(WebDriver pDriver, Root pageObjectOfEchelon) {
    super(pDriver);
    this.pageObjectOfEchelon = pageObjectOfEchelon;
  }
  public Boolean RecogniseBusySpinnerInException(ElementClickInterceptedException pException) {
    return pException.getMessage().contains("busyIndicator");
  }

  public void PerformActionThatMightBeBlockedByBusySpinner(
          Duration pBusyIndicationTimelimit,
          helpers.SeleniumHelper.I_Action pProtectedAction ) throws CustomE2eException {
    RetryOnClickInterceptedException(
            pBusyIndicationTimelimit,
            this::RecogniseBusySpinnerInException,
            Duration.ofSeconds(1),
            5,
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
