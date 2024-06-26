package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import helpers.CdlEchelonHelpers;
import helpers.SeleniumHelper;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;

public class EchelonGeneralStepDefinitions extends CdlEchelonHelpers  {

  public static final String BROKER_CLAIM_REF = "BrokerClaimReference";
  public static final String SETTLED_DATE = "SettledDtae";
  public static final String TYPE_OF_CLAIM = "TypeOfClaim";
  public static final String COVERED_IN_SAME_CLAIM = "CoveredInSameClaim";

  private final WebDriver driver;
  private final SeleniumHelper SeleniumHelper;
  private final long waitDuration = 60000L;

  public static final String HOME_INSURANCE_VAR = "HomeInsurance";

  PageObjects.EchelonModel.Root pageObjectOfEchelon;

  public EchelonGeneralStepDefinitions(WebDriver driver,
                                       PageObjects.EchelonModel.Root pageObjectOfEchelon) {

    super(driver, pageObjectOfEchelon);
    this.driver = driver;
    this.SeleniumHelper = new SeleniumHelper(this.driver);
    this.pageObjectOfEchelon = pageObjectOfEchelon;
  }


  //Echelon
  public void selectClient() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonHomeLocatorModel().CLIENT_SELECT_BTN(), SyncType.CLICKABLE);
  }
}
