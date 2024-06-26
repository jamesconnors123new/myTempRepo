package activities;

import Generic.customExceptions.CustomE2eException;
import PageObjects.PortalModel.Root;
import StepDefinitions.PortalGeneralStepDefinitions;
import StepDefinitions.RegisterNewUserStepDefinition;
import UiWrappers.Browser;
import activities.bases.SingleBrowserSessionBase;
import helpers.CommonHelper;
import helpers.ControlDataHelpers;
import helpers.SeleniumHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public class RegisterNewUser extends SingleBrowserSessionBase<Root,
    PortalGeneralStepDefinitions>  implements ActivityEndpoint {
    private static final String NEW_USER_REGISTRATION = "NewRegistrationDetails";
    public static final String REGISTRATION_STATUS = "RegistrationStatus";
    StandardReportingPatterns actionRecordingService = null;
    ActivityExecPeriodReturn executionResult;
    private WebDriver webDriver;


    @Override
    protected WebDriver ProvideWebDriver() throws CustomE2eException {
        webDriver = SeleniumHelper.openBrowser();

        return webDriver;
    }

    private final Root PORTAL_PAGE_OBJECT_ROOT =
        new PageObjects.PortalVersion.V01.Root();

    @Override
    protected Root ProvidePom(){
        return PORTAL_PAGE_OBJECT_ROOT;
    }

    @Override
    protected Function<WebDriver, PortalGeneralStepDefinitions> ProvideCommonStep() {
        return (WebDriver pDriver)-> new PortalGeneralStepDefinitions(pDriver, ProvidePom());
    }

    private static String FormPortalUrlMessage(CommonControlDataDefns.E_ControlDataSource pSource, String pUrl) {
        return "Using portal url from "+pSource.name()+" value: " + pUrl;
    }

    @Override
    protected ActivityExecPeriodReturn executeUsingBrowser(Browser<Root,
        PortalGeneralStepDefinitions> pBrowser, SequencerFaceToActivity sequencerFaceToActivity,
                                                           UUID uuid, Map<String, Object> map,
                                                           ActivityInterimState activityInterimState, PrintStream printStream) {
        Map<String, Object> resultsData = new HashMap<>();

        actionRecordingService =  new StandardReportingPatterns(sequencerFaceToActivity);
        String strLogLine = getClass().getSimpleName() + " Activity.execute";
        actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

        Root pageObjectOfPortal = PORTAL_PAGE_OBJECT_ROOT;

        Map<String, Object> newRegistrationDetails = (Map<String, Object>) map.get(NEW_USER_REGISTRATION);
        String brand = (String) newRegistrationDetails.get(CommonControlDataDefns.BRAND);

        // If Brand not defined in yaml ControlData set to Ageas as default
        if (brand == null) {
            brand = "Ageas";
        }

        try {
            var vFaulted = false;
            var rootUrl = (String)null;

            if(ControlDataHelpers.ValidateMapContainsFieldWithNonEmptyStringValue(map,
                CommonControlDataDefns.WEBSITE_ROOT)) {
                rootUrl = ((String)map.get(CommonControlDataDefns.WEBSITE_ROOT)).trim();
                useActionRecordingService().writeToTestCaseInstanceRecord(FormPortalUrlMessage(CommonControlDataDefns.E_ControlDataSource.ControlData, rootUrl));
            } else {

//                var rootUrlAsObject = useSettingsAndVariableAccess().getRuntimeValue(CommonControlDataDefns.WEBSITE_ROOT);

//                Object rootUrlAsObject = null;
//                var rootUrlAsObject = (String) null;
                String rootUrlAsObject;

                switch(brand) {

                    case "Ageas":
                        rootUrlAsObject = (String) useSettingsAndVariableAccess().getRuntimeValue(CommonControlDataDefns.PORTAL_URL_AGEAS);

                        if (rootUrlAsObject == null) {
                            rootUrlAsObject = (String) useSettingsAndVariableAccess().getRuntimeValue(CommonControlDataDefns.WEBSITE_ROOT);
                        }

                        break;
                    case "Rias":
                        rootUrlAsObject = (String) useSettingsAndVariableAccess().getRuntimeValue(CommonControlDataDefns.PORTAL_URL_RIAS);
                        break;
                    default:
                        throw new CustomE2eException("Unrecognised brand: " + brand);

                }


                if(rootUrlAsObject!=null && rootUrlAsObject instanceof String && !StringUtils.isBlank((String)rootUrlAsObject)) {
                    rootUrl = ((String)rootUrlAsObject).trim();
                    useActionRecordingService().writeToTestCaseInstanceRecord(FormPortalUrlMessage(CommonControlDataDefns.E_ControlDataSource.TestInstanceDataStore, rootUrl));
                } else {
                    vFaulted = true;
                    useActionRecordingService().reportControlDataIssue(ControlDataHelpers.MissingValueErrorMessage(CommonControlDataDefns.WEBSITE_ROOT));
                }
            }
            if(vFaulted) {
                return ActivityExecPeriodReturnImpl.faulted(uuid);
            }

//            var newRegistrationDetails = map.get(NEW_USER_REGISTRATION);
            var registerNewUserOnPortal = new RegisterNewUserStepDefinition(pBrowser.Wd(),
                pageObjectOfPortal);

            pBrowser.Wd().navigate().to(rootUrl);
            registerNewUserOnPortal.registerNewPolicyUser((Map<String, Object>) newRegistrationDetails);

            var registrationStatus =
                registerNewUserOnPortal.registrationStatus((String) ((Map<String, Object>) newRegistrationDetails).get(CommonControlDataDefns.POLICY_NUMBER));
            resultsData.put(REGISTRATION_STATUS, registrationStatus);

            executionResult = ActivityExecPeriodReturnImpl.completed(uuid, resultsData);

            this.useActionRecordingService().storeDataInTestCaseInstanceRecord
                    ("RegistrationOfNewUser_Success", "png",
                            new CommonHelper(webDriver).getScreenshotAsByteArray());



            registerNewUserOnPortal.signOutApplication();

        } catch (Exception customE2eException) {
            actionRecordingService.reportRuntimeFaultIssue(customE2eException);
            executionResult = ActivityExecPeriodReturnImpl.faulted(uuid);
        } finally {
            actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
        }
        return executionResult;
    }
}

