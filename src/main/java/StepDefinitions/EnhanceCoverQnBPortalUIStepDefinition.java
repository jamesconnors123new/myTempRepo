package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import helpers.AgeasDigitalReactPortalHelpers;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;


public class EnhanceCoverQnBPortalUIStepDefinition extends AgeasDigitalReactPortalHelpers {

  public EnhanceCoverQnBPortalUIStepDefinition(WebDriver driver,
                                               PageObjects.PortalModel.Root pageObjectOfPortal) {
    super(driver, pageObjectOfPortal);
  }


  public void setEnhancePolicyCoverToNo() throws CustomE2eException {
    waitForPageLoad();
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST(), "N"), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EMERGENCY(), "N"), SyncType.CLICKABLE);
    //clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXCESS_PROTECTION(), "N"), SyncType.CLICKABLE);
  }

  public void setEnhancePolicyCoverToYesAndUpdate() throws CustomE2eException {
    waitForPageLoad();
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST(), "Y"), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().LEGAL_COST_ADD_BTN(), SyncType.CLICKABLE);
    waitForElementToInvisible(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().RECALCULATE_SCREEN_MSG());
    clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EMERGENCY(), "Y"), SyncType.CLICKABLE);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().HOME_EMERGENCY_ADD_BTN(), SyncType.CLICKABLE);
    waitForElementToInvisible(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().RECALCULATE_SCREEN_MSG());
    //clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfPortal.getPortalQuoteCreationLocatorModel().EXCESS_PROTECTION(), "Y"), SyncType.CLICKABLE);
  }
}
