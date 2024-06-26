package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import helpers.*;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.time.Duration;
import java.util.Map;

public class RegisterNewUserStepDefinition extends AgeasDigitalReactPortalHelpers {
    private final long waitDuration = 1000L;
    private String POLICYNUMBER = "PolicyNumber";
    private String EMAIL = "Email";
    private String PASSWORD = "Password";
    private String DATE_OF_BIRTH = "DateOfBirth";
    private String POSTCODE = "Postcode";
    PortalGeneralStepDefinitions portalGeneralStepDefinitions;

    public RegisterNewUserStepDefinition(WebDriver driver,
                                         PageObjects.PortalModel.Root pageObjectOfPortal) {
        super(driver, pageObjectOfPortal);
        portalGeneralStepDefinitions = new PortalGeneralStepDefinitions(driver, pageObjectOfPortal);
    }

  public void registerNewPolicyUser(Map<String, Object> newUserDetails) throws CustomE2eException
      , ParseException {
    clickRegistrationButton();
    enterPolicyNumber((String) newUserDetails.get(POLICYNUMBER));
    enterDateOfBirthDet((String) newUserDetails.get(DATE_OF_BIRTH));
    enterPostcode((String) newUserDetails.get(POSTCODE));
    enterUsername((String) newUserDetails.get(EMAIL));
    enterPassword((String) newUserDetails.get(PASSWORD));
    clickCreateAccountButton();
    waitForPageLoad();
  }

  private void enterDateOfBirthDet(String fullDateOfBirth) throws ParseException, CustomE2eException {
    var formattedDate = Formatting.changeDateFormatIntoExpected(fullDateOfBirth, "dd" + "/mm/yyyy"
        , "d/m/yyyy");
    String[] date = CommonHelper.splitDate(formattedDate);
    try {
      enterDateOfBirthDay(date[0]);
      enterDateOfBirthMonth(date[1]);
      enterDateOfBirthYear(date[2]);
    } catch (Exception e) {
      throw new CustomE2eException("Date of Birth is not valid");
    }
  }

  public boolean registrationStatus(String policyNumber) throws CustomE2eException {
    if (isElementVisible(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().ALREADY_REGISTERED_DAILOG()) && getText(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().ALREADY_REGISTERED_DAILOG()).contains("already " + "registered for your online " + "account")) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().LOGIN_BUTTON(),
          SyncType.CLICKABLE);
      return true;
    } else if (PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(60), () -> waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().EMAIL_SENT_MESSAGE(), SyncType.VISIBLE, waitDuration)))
    {

      confirmRegistrationIsSuccessful(policyNumber);
//      portalGeneralStepDefinitions.signOutApplication(); // Moved to calling method
      return true;
    } else {
      throw new CustomE2eException("Registration is not successful.");
    }
  }

  public void clickRegistrationButton() throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().REGISTER_BUTTON(), SyncType.CLICKABLE, waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().REGISTER_BUTTON(),
          SyncType.CLICKABLE);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Register User button is not clickable");
    }
  }

  public void enterPolicyNumber(String policyNumber) throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICY_ID(),
          SyncType.CLICKABLE, waitDuration);
      typeText(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICY_ID(),
          policyNumber.trim(), SyncType.CLICKABLE);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Policy Id field is not editable");
    }
  }

  public void enterDateOfBirthDay(String day) throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICYHOLDER_DOB_DAY(), SyncType.CLICKABLE, waitDuration);
      selectDropdown(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICYHOLDER_DOB_DAY(), day, SelectOptions.TEXT);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Birth date is not selected");
    }
  }

  public void enterDateOfBirthMonth(String month) throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICYHOLDER_DOB_MONTH(), SyncType.CLICKABLE, waitDuration);
      selectDropdown(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICYHOLDER_DOB_MONTH(), month, SelectOptions.TEXT);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Birth month is not selected");
    }
  }

  public void enterDateOfBirthYear(String year) throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICYHOLDER_DOB_YEAR(), SyncType.CLICKABLE, waitDuration);
      selectDropdown(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POLICYHOLDER_DOB_YEAR(), year, SelectOptions.TEXT);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Birth year is not selected");
    }
  }

  public void enterPostcode(String postcode) throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POSTCODE(),
          SyncType.CLICKABLE, waitDuration);
      typeText(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().POSTCODE(), postcode,
          SyncType.CLICKABLE);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Postcode is not provided");
    }
  }

  public void enterUsername(String username) throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().USERNAME(),
          SyncType.CLICKABLE, waitDuration);
      typeText(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().USERNAME(), username,
          SyncType.CLICKABLE);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Username is not provided");
    }
  }

  public void enterPassword(String password) throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().PASSWORD(),
          SyncType.CLICKABLE, waitDuration);
      typeText(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().PASSWORD(), password,
          SyncType.CLICKABLE);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Password is not provided");
    }
  }

  public void clickCreateAccountButton() throws CustomE2eException {
    waitForPageLoad();
    try {
      waitForElement2(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().CREATEACCOUNT_BUTTON(), SyncType.CLICKABLE, waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().CREATEACCOUNT_BUTTON(), SyncType.CLICKABLE);
    } catch (CustomE2eException e) {
      throw new CustomE2eException("Create Account button is not clickable");
    }
  }

  public void confirmRegistrationIsSuccessful(String policyNumber) throws CustomE2eException {
    waitForPageLoad();
    if (isElementVisible(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().EMAIL_SENT_MESSAGE())) {
      try {
         RetryOnException("confirmRegistrationIsNotSuccessful", CustomE2eException.class, 300L, 10,
            () -> clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPortalRegistrationLocatorModel().CONFIRMATION_BUTTON(), SyncType.CLICKABLE));
      } catch (Exception e) {
        throw new CustomE2eException("Policy not created successfully");
      }
    }
    waitForElement2(this.pageObjectOfPortal.getPortalLoginLocatorModel().TAB_HEADER(),
        SyncType.VISIBLE, waitDuration);
    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(120), ()->
      clickElement(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB(),
          SyncType.CLICKABLE));
//    waitForElement2(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_NUMBER(),
//        SyncType.VISIBLE, waitDuration);

    clickElement(this.pageObjectOfPortal.getPortalLoginLocatorModel().POLICY_DETAILS_TAB(),
            SyncType.CLICKABLE);
//
//    waitForElement(this.pageObjectOfPortal.getPortalLoginLocatorModel().MY_HOME_TAB(),
//            SyncType.CLICKABLE);

    var listOfPolicies = portalGeneralStepDefinitions.getAllPolicyNumber();
    if (!listOfPolicies.contains(policyNumber)) {
      throw new CustomE2eException("Policy number doest not matched. Expected policy number:" +
          " " + policyNumber + " actual policy number: " + getText(this.pageObjectOfPortal.getDashboardLocatorModel().POLICY_NUMBER()));
    }

//    waitForPageLoad();




  }


}
