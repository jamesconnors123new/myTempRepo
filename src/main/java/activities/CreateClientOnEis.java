package activities;


import Generic.customExceptions.CustomE2eException;
import StepDefinitions.EisClientCreationStepDefinition;
import StepDefinitions.EisGeneralStepDefinitions;
import StepDefinitions.EisHomeStepDefinition;
import StepDefinitions.EisLoginStepDefinition;
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


public class CreateClientOnEis extends EisLoggedInBase<EisVer001> implements ActivityEndpoint {
  public static final String CLIENT_NUMBER = "ClientNumber";
  public static final String EIS_CLIENT_DETAILS = "EisClientDetails";
  public static final String PROPOSER_PERSONAL_DET = "ProposerPersonalDetails";
  public static final String QUOTE_DETAILS = "QuotesDetails";
  public static final String BRAND ="Brand";
  public static final String PROPOSER_CONTACT_DET = "ProposerContactDetails";
  public static final String AGEAS_DIRECT = "AgeasDirect";
  public static final String AGEAS = "Ageas";
  public static final String RIAS = "Rias";
  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;
  public static final long waitDuration = 60000L;


  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }



  @Override
  public ActivityExecPeriodReturn performActionLoggedIntoEis(PageObjects.EisModel.Root pageObjectOfEis,
                                                             Browser<PageObjects.EisModel.Root,
                                                                 EisGeneralStepDefinitions> pBrowser,
                                                             SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) throws CustomE2eException {

    LinkedHashMap<String, Object> resultsData = new LinkedHashMap<>();
    LinkedHashMap<String, Object> returnYaml = new LinkedHashMap<>();

    actionRecordingService =  new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);



    try {
      var eisLoginPage = new EisLoginStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var eisHomePage = new EisHomeStepDefinition(pBrowser.Wd(), pageObjectOfEis);
      var eisClientCreationPage = new EisClientCreationStepDefinition(pBrowser.Wd(), pageObjectOfEis);

      eisHomePage.clickOnAddNewCustomerButton();
      
      LinkedHashMap<String, Object> salesDetailsMap = (LinkedHashMap<String, Object>) controlData.get(CommonControlDataDefns.SALES_DETAILS_VAR);
      eisClientCreationPage.enterDetails(salesDetailsMap);

      eisClientCreationPage.saveAndExitClientPage();
      var clientNumber = eisClientCreationPage.getClientNumber();

      returnYaml.put(CLIENT_NUMBER, clientNumber);
      returnYaml.put(CommonControlDataDefns.SALES_DETAILS_VAR, salesDetailsMap);

      this.useActionRecordingService()
              .storeDataInTestCaseInstanceRecord(
                      "EisClientDetails_CustomerSaved",
                      "png",
                      ((TakesScreenshot) pBrowser.Wd()).getScreenshotAs(OutputType.BYTES)
              );

      eisLoginPage.signOutEisApplication();

      actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + " " +
          "Activity completed");
      resultsData.put(EIS_CLIENT_DETAILS, returnYaml);
      executionResult = ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      actionRecordingService.reportRuntimeFaultIssue(customE2eException);
      executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
    } finally {
      actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
    }
    return executionResult;
  }

}
