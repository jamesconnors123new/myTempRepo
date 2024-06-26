package activities;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.EchelonGeneralStepDefinitions;
import UiWrappers.Browser;
import UiWrappers.Echelon.Site.EchelonVer001;
import activities.bases.EchelonLoggedInBase;
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

public class EchelonLogon  extends EchelonLoggedInBase<EchelonVer001> implements ActivityEndpoint {

    @Override
    protected WebDriver ProvideWebDriver() throws CustomE2eException {
        return SeleniumHelper.openBrowser();
    }


    @Override
    protected ActivityExecPeriodReturn performActionLoggedIntoEchelon(PageObjects.EchelonModel.Root pageObjectOfEchelon, Browser<PageObjects.EchelonModel.Root, EchelonGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> controlData, ActivityInterimState activityInterimState, PrintStream printStream) throws CustomE2eException {
        return ActivityExecPeriodReturnImpl.completed(uuid, new HashMap<String,Object>());
    }
}