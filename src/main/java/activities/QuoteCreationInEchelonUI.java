package activities;


import Generic.customExceptions.CustomE2eException;
import PageObjects.EchelonModel.Root;
import StepDefinitions.EchelonClientDetailsStepDefinition;
import StepDefinitions.EchelonGeneralStepDefinitions;
import StepDefinitions.EchelonHomeStepDefinition;
import StepDefinitions.EchelonQuoteCreationsStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Echelon.Site.EchelonVer001;
import activities.bases.EchelonLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sqc.bstof.operationhelp.interactive.RobustnessHelp;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Creation of home policy on Echelon UI.
 */
public class QuoteCreationInEchelonUI extends EchelonLoggedInBase<EchelonVer001> implements ActivityEndpoint {

  public static final String POLICY_NUMBER = "PolicyNumber";
  public static final String HOUSE_HOLD = "Household";
  public static final String QUOTE_VAL = "QuoteValue";
  public static final String QUOTE_REF = "QuoteReference";
  public static final String QUOTE_DET = "QuoteDetails";
  public static final String QUOTE_WEB_REFERENCE = "WebReference";
  public static final String CLIENT_NUMBER = "ClientNumber";
  public static final String NUMBER_DAYS_QUOTE_STORE = "NumberOfDaysQuoteStore";
  public static final String QUOTE_STORE_UNTIL_DATE = "QuoteStoreUntilDate";

  StandardReportingPatterns actionRecordingService = null;
  ActivityExecPeriodReturn executionResult;


  @Override
  protected WebDriver ProvideWebDriver() throws CustomE2eException {
    return SeleniumHelper.openBrowser();
  }

  @Override
  protected ActivityExecPeriodReturn performActionLoggedIntoEchelon(Root pageObjectOfEchelon, Browser<Root, EchelonGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {
    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> returnYaml = new HashMap<>();
    actionRecordingService = new StandardReportingPatterns(sequencerFaceToActivity);
    String strLogLine = getClass().getSimpleName() + " Activity.execute";
    actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);
    try {
      var echelonHomePage = new EchelonHomeStepDefinition(pBrowser.Wd(), pageObjectOfEchelon);
      var echelonClientDetailsPage = new EchelonClientDetailsStepDefinition(pBrowser.Wd(),
          pageObjectOfEchelon);
      var echelonQuoteCreationPage = new EchelonQuoteCreationsStepDefinition(pBrowser.Wd(),
          pageObjectOfEchelon);
      var salesDetails = ((Map<String, Object>) controlData.get("SalesDetails"));
      //Search for client using policy number
      echelonHomePage.searchForClientPolicy((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
      echelonClientDetailsPage.isItNewCustomer();
      echelonQuoteCreationPage.newHouseHoldQuotesDetails(((Map<String, Object>) salesDetails.get(
          "QuotesDetails")));
      echelonQuoteCreationPage.selectTypeOfHouseholdCover((Map<String, Object>) ((Map<String,
          Object>) salesDetails.get("InsuranceDetails")).get("TypeOfHouseHoldCover"));
      echelonQuoteCreationPage.redirectToNextPage();
      echelonQuoteCreationPage.proposerPersonalDetails((Map<String, Object>) salesDetails.get(
          "ProposerPersonalDetails"));
      echelonQuoteCreationPage.contactAddress((Map<String, Object>) salesDetails.get(
          "ProposerContactDetails"), (String) salesDetails.get("PreferredDeliveryMethod"));
      echelonQuoteCreationPage.employmentDetails((Map<String, Object>) salesDetails.get("ProposerPersonalDetails"));

      //Sarah changed this is not hte legal relationship to the risk... it is Property owned
      //echelonQuoteCreationPage.mainBuildingDetails(((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("BuildingDetails")), (String) ((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("ProposerRelationshipToRisk")).get("LegalRelationship"));
      echelonQuoteCreationPage.mainBuildingDetails(((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("BuildingDetails")), (String) ((Map<String, Object>) salesDetails.get("DynamicUnderwriterQuestions")).get("PropertyOwned"));
      echelonQuoteCreationPage.structuralDetails((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("BuildingDetails"));

      echelonQuoteCreationPage.usageDetails((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("Usage"));
      echelonQuoteCreationPage.securityDetails((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("Security"));

      echelonQuoteCreationPage.riskAddress(((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("BuildingDetails")), ((Map<String, Object>) ((Map<String, Object>) salesDetails.get("ProposerContactDetails")).get("CorrespondenceAddress")));
      //echelonQuoteCreationPage.selectJointPolicyHolderDropdown(Boolean.parseBoolean((String) salesDetails.get("JointPolicyHolderDetails")));

      // I replaced with this and removed line 96 which was creating an exception
      if (Boolean.parseBoolean(salesDetails.get( "JointPolicyHolderDetails").toString())){
        echelonQuoteCreationPage.selectJointPolicyHolderDropdown(true);
        echelonQuoteCreationPage.jointPolicyHolder((Map<String, Object>) salesDetails.get("JointPolicyHolder"));
      }else {
        echelonQuoteCreationPage.selectJointPolicyHolderDropdown(false);
      }
      //end



      if (((Boolean) ((Map<String, Object>) ((Map<String, Object>) salesDetails.get(
          "InsuranceDetails")).get("TypeOfHouseHoldCover")).get("Buildings")).equals(true)) {
        echelonQuoteCreationPage.BuildingCover((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("InsuredAmount"), (Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("TypeOfHouseHoldCover"));
        echelonQuoteCreationPage.interestedParties();
      }
      if (((Boolean) ((Map<String, Object>) ((Map<String, Object>) salesDetails.get(
          "InsuranceDetails")).get("TypeOfHouseHoldCover")).get("Contents")).equals(true)) {
        echelonQuoteCreationPage.contentCover((Map<String, Object>) salesDetails.get(
            "InsuranceDetails"));
        echelonQuoteCreationPage.specifiedContentInHome();
        echelonQuoteCreationPage.personalBelonginAwayFromHomeCover((Map<String, Object>) ((Map<String, Object>) salesDetails.get("InsuranceDetails")).get("InsuredAmount"));
//        echelonQuoteCreationPage.specifiedContentAwayFromHome();
      }
      echelonQuoteCreationPage.convictionDetails();

      //echelonQuoteCreationPage.riskAddress((Map<String, Object>)  salesDetails.get
      // ("ProposerContactDetails"));

      //PreviousInsurance - Need to add
      //ClaimDetails - Need to add
      //ConvictionDetails - Need to add

      //SLC Need to talk to Vishal as how is Yes or No selected
//      if (Boolean.parseBoolean((String) salesDetails.get("JointPolicyHolderDetails"))) {
//        echelonQuoteCreationPage.jointPolicyHolder((Map<String, Object>) salesDetails.get(
//            "JointPolicyHolder"));
//      }

      echelonQuoteCreationPage.marketingChoices((Map<String, Object>) salesDetails.get(
          "MarketingChoice"));
      echelonQuoteCreationPage.policyUserField((Map<String, Object>) salesDetails.get(
          "OtherDetails"));
      echelonQuoteCreationPage.navigateToNextPage();

      // Retryable block if get timeout waiting for premium

      /*

      PerformWithRetries(

    Duration pFixedActionSpacing, RobustnessHelp.PrimaryOpWithoutReturn
      pPrimaryOperation, RobustnessHelp.PrecursorOp... pPrecursorOps) {
      */

      var quoteValue = new AtomicReference<Double>(0.0);
      var vQuotedObtained = new AtomicReference<Boolean>(false);
      var currentUrl = pBrowser.Wd().getCurrentUrl();

      RobustnessHelp.PerformWithRetries(3, Duration.ZERO, 1.0, Duration.ZERO, (x)->{ return x.getMessage().equals("Retry limit exceeded in getQuotePremium()")||x.getMessage().startsWith("Failed to select")||x.getMessage().contains("Element not interactable");
    }, () -> true, () -> {
        pBrowser.Wd().navigate().to(currentUrl);
        pBrowser.Sh().RetryOnExceptionFailSilenly("Clear alert", NoAlertPresentException.class,
            500L, 4, () -> pBrowser.Wd().switchTo().alert().dismiss());
        pBrowser.Sh().waitForPageLoad();
        return true;
      }, Duration.ZERO, () -> {
        try {
          this.useActionRecordingService().recordStartOfAnActivityInCaseInstRecord("Process DUQs");
          echelonQuoteCreationPage.dynamicsUnderwriterQuestions((Map<String, Object>) salesDetails.get("DynamicUnderwriterQuestions"), this.useActionRecordingService());
          var vPremium = echelonQuoteCreationPage.getQuotePremium();
          if (vPremium >= 0.0) {
            quoteValue.set(vPremium);
            vQuotedObtained.set(true);
          } else {
            quoteValue.set(-1.0);
          }
        } finally {
          this.useActionRecordingService().recordEndOfAnActivityInCaseInstRecord();
        }
        return true;
      });

      var vNoValueForString = "!NO-VALUE!";
      var quoteReference = vNoValueForString;
      var clientNumber = vNoValueForString;
      var webReference = vNoValueForString;

      if (vQuotedObtained.get()) {
        echelonQuoteCreationPage.clickOnStoreQuote();
        quoteReference = echelonQuoteCreationPage.getQuoteReference();
        clientNumber = echelonQuoteCreationPage.getClientId(quoteReference);
        webReference = echelonQuoteCreationPage.getWebReference();
      }
      returnYaml.put(CLIENT_NUMBER, clientNumber);
      returnYaml.put(QUOTE_WEB_REFERENCE, webReference);
      returnYaml.put(QUOTE_REF, quoteReference);
      returnYaml.put(QUOTE_VAL, quoteValue.get());
      resultsData.put(QUOTE_DET, returnYaml);
      try {
        var vScreenShot = ((TakesScreenshot) pBrowser.Wd()).getScreenshotAs(OutputType.BYTES);
        this.useActionRecordingService().storeDataInTestCaseInstanceRecord("QuoteSummary", "png",
            vScreenShot);
      } catch (Exception pEx) {
        this.useActionRecordingService().storeDataInTestCaseInstanceRecord("QuoteSummary-FAILED",
            "txt", new byte[]{});
      }
      echelonHomePage.signOutEchelonApplication();
      return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
    } catch (Exception customE2eException) {
      useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
      return ActivityExecPeriodReturnImpl.faulted(uuid);
    }
  }
}
