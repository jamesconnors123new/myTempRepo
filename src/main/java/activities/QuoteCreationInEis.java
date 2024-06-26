package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import StepDefinitions.*;
import UiWrappers.Browser;
import UiWrappers.Eis.Site.EisVer001;
import activities.bases.EisLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class QuoteCreationInEis extends EisLoggedInBase<EisVer001> implements ActivityEndpoint {
  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;



  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoEis(Root pageObjectOfEis, Browser<Root, EisGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {

    LinkedHashMap<String, Object> resultsData = new LinkedHashMap<>();
    LinkedHashMap<String, Object> returnYaml = new LinkedHashMap<>();


    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

    try {
      var eisHomePage = new EisHomeStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var eisClientPortfolioPage = new EisClientPortfolioStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);
      var eisQuoteCreationStepDef = new EisHomeQuoteCreationStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);

      var eisLoginSteDef = new EisLoginStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var motorQuoteStepDef = new EisMotorQuoteCreationStepDefinition(pBrowser.Wd(), pageObjectOfEis);

      var homeQuoteStepDef = new EisHomeQuoteCreationStepDefinition(pBrowser.Wd(),
          pageObjectOfEis);

      var commonControlDataDef = new CommonControlDataDefns();
      var salesDetails =
          ((LinkedHashMap<String, Object>) controlData.get(commonControlDataDef.SALES_DETAILS_VAR));
      var quotesDetails =
          (LinkedHashMap<String, Object>) (salesDetails.get(commonControlDataDef.QUOTE_DETAILS));

      LinkedHashMap<String, String> searchCriteriaMap = (LinkedHashMap<String, String>) controlData.get(commonControlDataDef.SEARCH_CRITERIA);
      eisHomePage.searchEisClient(searchCriteriaMap);

      eisClientPortfolioPage.clickOnCreateQuoteButton();
      eisClientPortfolioPage.loginQuotePortal((LinkedHashMap<String, Object>) controlData.get(CORE_USER_CREDENTIALS)); //EIS Core Insurance Software
      eisQuoteCreationStepDef.clickOnAddNewQuote();

      // Condition to Switch..
      if(((String) quotesDetails.get(eisQuoteCreationStepDef.PRODUCT_TYPE_VAR)).equalsIgnoreCase(commonControlDataDef.HOME_QUOTE)) {
        homeQuoteStepDef.homeQuoteCreation(salesDetails);
      } else if(((String) quotesDetails.get(eisQuoteCreationStepDef.PRODUCT_TYPE_VAR)).equalsIgnoreCase(commonControlDataDef.MOTOR_QUOTE)){
        motorQuoteStepDef.motorQuoteCreation(salesDetails);
      }

      eisQuoteCreationStepDef.saveAndExitButton();

      // Need to recheck with motor/van quote creation after defect is close
      returnYaml.put(commonControlDataDef.QUOTE_VALUE, String.valueOf(eisQuoteCreationStepDef.getQuoteValue()));
      returnYaml.put(commonControlDataDef.QUOTE_REF, eisQuoteCreationStepDef.getQuoteReference());
      returnYaml.put(commonControlDataDef.CUSTOMER_NUMBER, eisQuoteCreationStepDef.getCustomerNumber());
      returnYaml.put(commonControlDataDef.EFFECTIVE_DATE, eisQuoteCreationStepDef.getEffectiveDate());
      returnYaml.put(commonControlDataDef.DECLINES, String.valueOf(eisQuoteCreationStepDef.declinesApplied()));
      returnYaml.put(commonControlDataDef.REFERRALS, String.valueOf(eisQuoteCreationStepDef.referralsApplied()));

      returnYaml.put(commonControlDataDef.SALES_DETAILS_VAR, salesDetails);


      this.useActionRecordingService()
              .storeDataInTestCaseInstanceRecord(
                      "EisQuoteDetails_PremiumCalculated",
                      "png",
                      ((TakesScreenshot) pBrowser.Wd()).getScreenshotAs(OutputType.BYTES)
              );

      eisLoginSteDef.signOutEisApplication();
      resultsData.put(commonControlDataDef.QUOTE_DETAILS, returnYaml);
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}
