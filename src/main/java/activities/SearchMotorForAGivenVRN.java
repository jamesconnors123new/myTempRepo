package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import StepDefinitions.*;
import UiWrappers.Browser;
import UiWrappers.Eis.Site.EisVer001;
import activities.bases.EisLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.LocalActionRecordingServices;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SearchMotorForAGivenVRN extends EisLoggedInBase<EisVer001> implements ActivityEndpoint {
    LocalActionRecordingServices actionRecordingService = null;



    @Override
    protected WebDriver ProvideWebDriver() throws CustomE2eException {
        return SeleniumHelper.openBrowser();
    }

    @Override
    public ActivityExecPeriodReturn performActionLoggedIntoEis(Root pageObjectOfEis, Browser<Root, EisGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) {

        Map<String, Object> resultsData = new HashMap<>();
        Map<String, Object> returnYaml = new HashMap<>();


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
            var searchVehicleStepDef = new EisSearchMotorStepDefinition(pBrowser.Wd(), pageObjectOfEis);

            var homeQuoteStepDef = new EisHomeQuoteCreationStepDefinition(pBrowser.Wd(),
                    pageObjectOfEis);

            var commonControlDataDef = new CommonControlDataDefns();
            var salesDetails =
                    ((Map<String, Object>) controlData.get(CommonControlDataDefns.SALES_DETAILS_VAR));

            eisHomePage.searchEisClient((Map<String, String>) controlData.get(CommonControlDataDefns.SEARCH_CRITERIA));
            eisClientPortfolioPage.clickOnCreateQuoteButton();
            eisClientPortfolioPage.loginQuotePortal((Map<String, Object>) controlData.get(CORE_USER_CREDENTIALS)); //EIS Core Insurance Software
            eisQuoteCreationStepDef.clickOnAddNewQuote();

                var VehicleDetails = searchVehicleStepDef.vehicleDetails(salesDetails);

            resultsData.put(commonControlDataDef.EIS_VEHICLE_DETAILS, VehicleDetails);
            return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
        } catch (Exception customE2eException) {
            useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }
}
