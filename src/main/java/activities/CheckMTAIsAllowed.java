package activities;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.GetMTAListFromPortalStepDefinition;
import StepDefinitions.PortalGeneralStepDefinitions;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
import activities.bases.AgeasPortalLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;

import java.io.PrintStream;
import java.util.Map;
import java.util.UUID;

public class CheckMTAIsAllowed extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {

    @Override
    protected WebDriver ProvideWebDriver() throws CustomE2eException {
        return SeleniumHelper.openBrowser();
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }

    @Override
    public ActivityExecPeriodReturn performActionLoggedIntoPortal(
        PageObjects.PortalModel.Root pageObjectOfPortal,
        Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBrowser,
            SequencerFaceToActivity sequencerFaceToActivity,
            UUID uuid,
            Map<String, Object> controlData,
            ActivityInterimState activityInterimState,
            PrintStream printStream)
    {
        try {
            var mtaListFromPortal = new GetMTAListFromPortalStepDefinition(pBrowser, pageObjectOfPortal);    // Get MTA data
            Map<String, Object> mtaList = mtaListFromPortal.getMTAList(pBrowser.Wd(), (String) controlData.get(CommonControlDataDefns.POLICY_NUMBER),(String) controlData.get(CommonControlDataDefns.MTAEFFECTIVEDATE), (String)((Map<String,Object>) controlData.get(CommonControlDataDefns.CUSTOMER_CREDENTIALS)).get(CommonControlDataDefns.EMAIL));  //Fetching customer details from portal
            return ActivityExecPeriodReturnImpl.completed(uuid, mtaList);
        }catch(IllegalArgumentException illegalArgumentException){
            useActionRecordingService().reportControlDataIssue(getClass().getSimpleName() + "Activity failed; \n\n" + illegalArgumentException.getMessage());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
        catch (Exception customE2eException) {
            useActionRecordingService().reportProblem("Test data issue:",customE2eException.getMessage());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }

}

