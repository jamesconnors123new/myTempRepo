package UiWrappers.Echelon.Site;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.EchelonLoginStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Portal.Recognisers.TechnicalErrorPage;
import UiWrappers.SiteWrapper;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.util.Map;

public class EchelonVer001 extends SiteWrapper {
    private final PageObjects.EchelonModel.Root echelonModelRoot;
    public EchelonVer001(PageObjects.EchelonModel.Root echelonModelRoot,
                         StandardReportingPatterns pReporting) {
        super(pReporting);
        this.echelonModelRoot = echelonModelRoot;
    }

    @Override
    protected String SiteIdentifier() {
        return this.getClass().getName();
    }

    @Override
    protected void PreFirstVisitActions(Browser pBrowser) {
        // Load any cookies that are needed to influence site behaviour
        pBrowser.Wd().manage().deleteAllCookies();
    }

    @Override
    protected void PostFirstVisitActions(Browser pBrowser) throws CustomE2eException {

 //      28-Aug-2023 - Cookie banner is not appearing when running Selenium, though it is when running manually

//        var vCookieWindowWrapper = new PortalAcceptCookieWindow(pBrowser);
//        if(vCookieWindowWrapper.TryWaitForWindowToBePresent()) {
//            pBrowser.Cs().acceptCookieBtn();
//        } else {
//            throw new CustomE2eException("Navigating to portal timed out waiting for Accept Cookie Window");
//        }
    }

    @Override
    protected boolean WaitForSettledInSomeFinalState(Browser pBrowser) throws CustomE2eException {
        //TODO: Add waiting for final state wait, can be after initial load or after cookie clear
        return true;
    }


    @Override
    protected boolean FinalStateCheck(Browser pBrowser) throws CustomE2eException {
        //TODO: Add check that the system is now in its final state
        return true;
    }

    public boolean GoToEchelonAndLogin(Browser pBrowser, String rootUrl,
                                 Map<String, Object> pCredentials) {
        try {
            mReporting.recordStartOfAnActivityInCaseInstRecord("GoToEchelonAndLogin");
            // Goto site
            try {
                mReporting.recordStartOfAnActivityInCaseInstRecord("GoToSite");
                if (!this.GoToSite(pBrowser, rootUrl, (b) -> b.Sh().tryWaitForPageLoad())) {
                    mReporting.reportRuntimeFaultIssue("Goto portal sequence did not execute as expected");
                    return false;
                }
            } finally {
                mReporting.recordEndOfAnActivityInCaseInstRecord();
            }
            try {
                mReporting.recordStartOfAnActivityInCaseInstRecord("Login");
                // Login to portal
                var echelonLoginPage = new EchelonLoginStepDefinition(pBrowser.Wd(),
                        this.echelonModelRoot);
                return echelonLoginPage.loginToEchelon(pCredentials, rootUrl,
                        // Check anomaly estate and decide whether to retry
                        () -> {
                            try {
                                mReporting.recordStartOfAnActivityInCaseInstRecord("Check if should retry");
                                var vTechnicalErrorPageHandler = new TechnicalErrorPage(pBrowser.Sh());
                                if (vTechnicalErrorPageHandler.PassiveRecogniser()) {
                                    mReporting.writeToTestCaseInstanceRecord("Portal responded with technical error page");
                                }
                                return true;
                            } finally {
                                mReporting.recordEndOfAnActivityInCaseInstRecord();
                            }
                        },
                        // Prepare for retry action
                        () ->
                        {
                            try {
                                mReporting.recordStartOfAnActivityInCaseInstRecord("Prepare for retry");
                                mReporting.reportUseOfWorkaround("Retry of login to portal");
                                pBrowser.Wd().manage().deleteCookieNamed("token");
                                return this.GoToSite(pBrowser, rootUrl, (b) -> b.Sh().tryWaitForPageLoad());
                            } finally {
                                mReporting.recordEndOfAnActivityInCaseInstRecord();
                            }
                        });
            } finally {
                mReporting.recordEndOfAnActivityInCaseInstRecord();
            }
        }catch(CustomE2eException pEx) {
            return false;
        }finally{
            mReporting.recordEndOfAnActivityInCaseInstRecord();
        }
    }
}
