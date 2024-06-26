package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.PortalModel.Root;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PortalLogon  extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {

    @Override
    protected WebDriver ProvideWebDriver() throws CustomE2eException {
        return SeleniumHelper.openBrowser();
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }

    @Override
    protected ActivityExecPeriodReturn performActionLoggedIntoPortal(Root pageObjectOfPortal, Browser<Root, PortalGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) throws CustomE2eException {
        return ActivityExecPeriodReturnImpl.completed(uuid, new HashMap<String,Object>());
    }
}
