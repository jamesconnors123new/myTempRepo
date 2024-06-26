package helpers;

import Generic.customExceptions.CustomE2eException;
import PageObjects.PortalModel.Root;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class AgeasDigitalReactPortalHelpers extends AgeasDigitalReactHelpers {
  protected final long waitDuration = 10000L;
  protected final Root pageObjectOfPortal;

  public AgeasDigitalReactPortalHelpers(WebDriver pDriver, Root pageObjectOfPortal) {
    super(pDriver);
    this.pageObjectOfPortal = pageObjectOfPortal;
  }


  public void signOutApplication() throws CustomE2eException {
    try {
      //waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON(), SyncType.CLICKABLE, waitDuration);
      //if (isElementVisible(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON())) {
      PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().SIGN_OUT_BUTTON(),
              SyncType.CLICKABLE));

      //waitForElement2(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_SIGNOUT(), SyncType.CLICKABLE, waitDuration);
      PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> clickElement(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_SIGNOUT(),
              SyncType.CLICKABLE));
      //clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalSharedLocatorModel().ACCEPT_SIGNOUT(),SyncType.CLICKABLE);
      //}
      PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), () -> waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().LOG_IN_BTN(), SyncType.CLICKABLE, waitDuration));

    } catch (Exception e) {
      throw new CustomE2eException(e.getMessage());

    }

  }



  public Object getAnswerSelected(List<WebElement> getChildNodes) {
    String selectedChoice = "NoValueSelected";
    for (var element : getChildNodes) {
      if (element.isSelected()) {
        selectedChoice = element.getAttribute("value");
        break;
      }
    }
    if (selectedChoice.equalsIgnoreCase("Yes")) {
      return true;
    } else if (selectedChoice.equalsIgnoreCase("No")) {
      return false;
    }
    return selectedChoice;
  }

  public void editPersonalDetailsInHomeTab() throws CustomE2eException {
    waitForPageLoad();
//    waitForElement2(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_PERSONAL_DETAILS(), SyncType.CLICKABLE,
//        waitDuration);
    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120),
        () -> clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().EDIT_PERSONAL_DETAILS(),
            SyncType.CLICKABLE));
    waitForPageLoad();
  }

    public void importantInformationPage() throws CustomE2eException {
        //waitForElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONFIRM_CONTINUE_BTN(), SyncType.VISIBLE);
      PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300),
              () -> clickElement(this.pageObjectOfPortal.getPerformMTALocatorModel().CONFIRM_CONTINUE_BTN(), SyncType.CLICKABLE));

    }

    public void redirectToHomeTab() throws CustomE2eException {
    //waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB(), SyncType.PRESENT, waitDuration);
      PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300),
              () -> waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB(), SyncType.VISIBLE, waitDuration));
      if (isElementVisible(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB()) && !getCurrentUrl().endsWith(
        "/my_home")) {
      PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300),
          () -> clickElement(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB(), SyncType.CLICKABLE));
      //TO ensure spinner not present after clicking the home tab
      //Make sure that an accordian is clickable
      PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300),
              () -> waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER(), SyncType.VISIBLE, waitDuration));

      var tabHeader = PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300),()->
              getText(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER()));


      //var tabHeader = RetryOnException("redirectToHomeTab", CustomE2eException.class, 500L, 50,
          //() -> getText(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER()));

      if(!tabHeader.equalsIgnoreCase("My Home Policy")) {
                waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER(),
                    SyncType.VISIBLE, waitDuration);
            }
        }
        waitForPageLoad();
    }

    public void redirectToCarTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_MOTOR_TAB(), SyncType.PRESENT, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_MOTOR_TAB(), SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER(), SyncType.VISIBLE, waitDuration);
    var tabHeader = RetryOnException("redirectToCarTab", CustomE2eException.class, 500L, 50,
        () -> getText(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER()));
        if(!tabHeader.equalsIgnoreCase("My Car Policy")){
            waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER(),
                SyncType.VISIBLE, waitDuration);
        }
    }
    public void redirectToRetrieveQuotePage() throws CustomE2eException {
      waitForPageLoad();
      waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().RETRIEVE_QUOTE(), SyncType.PRESENT, waitDuration);
      clickElement(this.pageObjectOfPortal.getPortalLoginLocatorModel().RETRIEVE_QUOTE(), SyncType.CLICKABLE);
    }

  public void redirectToHomePageTab() throws CustomE2eException {
    if(!getCurrentUrl().endsWith("/dashboard")) {
      waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().DASHBOARD_TAB(), SyncType.PRESENT, waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalLoginLocatorModel().DASHBOARD_TAB(), SyncType.CLICKABLE);
    }
  }

    public void redirectToVanTab() throws CustomE2eException {
    waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_VAN_TAB(), SyncType.PRESENT, waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_VAN_TAB(), SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER(), SyncType.VISIBLE, waitDuration);
    var tabHeader = RetryOnException("redirectToVanTab",CustomE2eException.class, 500L, 50,
        () -> getText(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER()));
        if(!tabHeader.equalsIgnoreCase("My Van Policy")){
            waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER(),
                SyncType.VISIBLE, waitDuration);
        }
    }

    public void selectEffectiveDateFromList(int indexInList) throws CustomE2eException {
        waitForElement(this.pageObjectOfPortal.getPerformMTALocatorModel().EFFECTIVE_DATE_SELECTION(), SyncType.VISIBLE);
        selectDropdown(this.pageObjectOfPortal.getPerformMTALocatorModel().EFFECTIVE_DATE_SELECTION(), indexInList, SelectOptions.INDEX);
    }


}
