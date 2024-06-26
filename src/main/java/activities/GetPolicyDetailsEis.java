package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;

import StepDefinitions.*;

import UiWrappers.Browser;
import UiWrappers.Eis.Site.EisVer001;
import activities.bases.EisLoggedInBase;
import helpers.DataNormalisationHelper;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;

import java.io.PrintStream;
import java.util.*;

public class GetPolicyDetailsEis extends EisLoggedInBase<EisVer001> implements ActivityEndpoint {

  public static final String WEBSITE_ROOT = "EISLoginURL";
  public static final String USER_CREDENTIALS = "UserCredentials";
  public static final String CLIENT_NUMBER = "ClientNumber";

  public static final String EIS_CLIENT_DETAILS = "EisClientDetails";
  public static final String CONVICTION_MONTHS_SUSPENDED = "MonthSuspended";
  public static final String CUSTOMER_POLICY_DETAILS = "CustomerPolicyDetailOnEis";
  ActivityExecPeriodReturn executionResult;

  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  public ActivityExecPeriodReturn performActionLoggedIntoEis(Root pageObjectOfEis, Browser<Root, EisGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {

    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();
    var eisHomePage = new EisHomeStepDefinition(pBrowser.Wd(), pageObjectOfEis);
    var eisClientPortfolioPage = new EisClientPortfolioStepDefinition(pBrowser.Wd(),
            pageObjectOfEis);

    var eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pBrowser.Wd(), pageObjectOfEis);
    var dataNorm = new DataNormalisationHelper();
    try {

      eisHomePage.searchEisClient((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      eisGeneralStepDefinitions.selectEisPolicy((Map<String, Object>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      eisClientPortfolioPage.loginQuotePortal((Map<String, Object>) controlData.get(USER_CREDENTIALS));
      var customerDetails = eisGeneralStepDefinitions.getEisPolicyData(null,
              (Map<String, Object>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      returnYaml.put(CommonControlDataDefns.RAW_DATA, customerDetails);
      var normalizedEisData = dataNorm.dataNormalisation(customerDetails);
      returnYaml.put(CommonControlDataDefns.NORMALIZED_DATA, normalizedEisData);
      resultsData.put(CommonControlDataDefns.CUSTOMER_POLICY_DETAILS, returnYaml);
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName() + " " + "Activity completed");
//      resultsData.put(CommonControlDataDefns.HOME_INSURANCE_INFORMATION, returnYaml);
      resultsData.put(CUSTOMER_POLICY_DETAILS, returnYaml);
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (CustomE2eException customE2eException) {
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName() +
              "Activity" + " failed; \n\n" + customE2eException);
      executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
    } catch (Exception e) {
      useActionRecordingService().writeToTestCaseInstanceRecord(getClass().getSimpleName() +
              "Activity" + " failed; \n\n" + e);
      executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
    } finally {
      useActionRecordingService().recordEndOfAnActivityInCaseInstRecord();

    }
    return executionResult;
  }
}

