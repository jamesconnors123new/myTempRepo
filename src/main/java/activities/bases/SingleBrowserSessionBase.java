package activities.bases;

import Generic.customExceptions.CustomE2eException;
import UiWrappers.Browser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sqc.bstof.operationhelp.CommonOpWrap;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;

import java.io.PrintStream;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public abstract class SingleBrowserSessionBase<PomType, CommonStepType> extends CommonOpWrap {

    protected abstract WebDriver ProvideWebDriver() throws CustomE2eException;
    protected abstract PomType ProvidePom();
    protected abstract Function<WebDriver,CommonStepType> ProvideCommonStep();

    protected abstract ActivityExecPeriodReturn executeUsingBrowser (Browser<PomType, CommonStepType> pBrowser,
        SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> map, ActivityInterimState activityInterimState, PrintStream printStream);

    @Override
    protected final ActivityExecPeriodReturn executeImpl(SequencerFaceToActivity sequencerFaceToActivity, UUID uuid, Map<String, Object> map, ActivityInterimState activityInterimState, PrintStream printStream) {

        var vWebDriver = (WebDriver)null;

        Browser<PomType, CommonStepType> vBrowser = null;

        try {
            vWebDriver = ProvideWebDriver();
            vBrowser = new Browser<>(vWebDriver, ProvidePom(),
                    ProvideCommonStep());
            return executeUsingBrowser(vBrowser, sequencerFaceToActivity, uuid, map, activityInterimState, printStream);
        } catch(CustomE2eException pException) {
            useActionRecordingService().reportRuntimeFaultIssue("Issue opening browser" + pException.getMessage());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        } finally {
            if (vWebDriver != null && !(vWebDriver.toString().contains("null"))) {
                try {
                    var vScreenShot = ((TakesScreenshot) vWebDriver).getScreenshotAs(OutputType.BYTES);
                    this.useActionRecordingService().storeDataInTestCaseInstanceRecord("SingleBrowserSessionBase-FinalScreenShot", "png", vScreenShot);
                } catch(Exception pEx) {
                    this.useActionRecordingService().storeDataInTestCaseInstanceRecord("SingleBrowserSessionBase-FinalScreenShot-FAILED", "txt", new byte[]{});
                }

                if (vBrowser.Wd() != null && !(vBrowser.Wd().toString().contains("null"))) {
                    vBrowser.Sh().quitBrowser();
                }
                vWebDriver.quit();

            }
        }
    }
}
