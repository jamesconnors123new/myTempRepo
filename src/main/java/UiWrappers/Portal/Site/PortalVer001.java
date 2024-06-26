package UiWrappers.Portal.Site;

import Generic.customExceptions.CustomE2eException;
import PageObjects.PortalModel.Root;
import StepDefinitions.PortalLoginStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Portal.Recognisers.TechnicalErrorPage;
import UiWrappers.SiteWrapper;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.util.Map;

public class PortalVer001 extends SiteWrapper {
    private final Root portalModelRoot;
    public PortalVer001(Root portalModelRoot,
                        StandardReportingPatterns pReporting) {
        super(pReporting);
        this.portalModelRoot = portalModelRoot;
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

    public boolean GoToPortalAndLogin(Browser pBrowser, String rootUrl, Map<String, Object> pCredentials) {
        try {
            // Goto site
            if (!this.GoToSite(pBrowser, rootUrl, (b) -> b.Sh().tryWaitForPageLoad())) {
                mReporting.reportRuntimeFaultIssue("Goto portal sequence did not execute as expected");
                return false;
            }
            // Login to portal
  //          Root pageObjectOfPortal = null;
            var portalLoginPage = new PortalLoginStepDefinition(pBrowser.Wd(), this.portalModelRoot);
            return portalLoginPage.loginPortal2(pCredentials, rootUrl,
                    // Check anomally estate and decide whether to retry
                    ()-> {
                        var vTechnicalErrorPageHandler = new TechnicalErrorPage(pBrowser.Sh());
                        if(vTechnicalErrorPageHandler.PassiveRecogniser()) {
                            mReporting.writeToTestCaseInstanceRecord("Portal responded with technical error page");
                        }
                        return true;
                    },
                    // Prepare for retry action
                    () ->
                    {
                        mReporting.reportUseOfWorkaround("Retry of login to portal");
                        pBrowser.Wd().manage().deleteCookieNamed("token");
                        return this.GoToSite(pBrowser, rootUrl, (b) -> b.Sh().tryWaitForPageLoad());
                    });
        }catch(CustomE2eException pEx) {
            return false;
        }
    }

    public boolean GoToPortal(Browser pBrowser, String rootUrl) {
        try {
            // Goto site
            if (!this.GoToSite(pBrowser, rootUrl, (b) -> b.Sh().tryWaitForPageLoad())) {
                mReporting.reportRuntimeFaultIssue("Goto portal sequence did not execute as expected");
                return false;
            }else  {
                return true;
            }
            // Login to portal
            /*Root pageObjectOfPortal = null;
            var portalLoginPage = new PortalLoginStepDefinition(pBrowser.Wd(), pageObjectOfPortal);
            return portalLoginPage.loginPortal2(pCredentials, rootUrl,
                    // Check anomally estate and decide whether to retry
                    ()-> {
                        var vTechnicalErrorPageHandler = new TechnicalErrorPage(pBrowser.Sh());
                        if(vTechnicalErrorPageHandler.PassiveRecogniser()) {
                            mReporting.writeToTestCaseInstanceRecord("Portal responded with technical error page");
                        }
                        return true;
                    },
                    // Prepare for retry action
                    () ->
                    {
                        mReporting.reportUseOfWorkaround("Retry of login to portal");
                        pBrowser.Wd().manage().deleteCookieNamed("token");
                        return this.GoToSite(pBrowser, rootUrl, (b) -> b.Sh().tryWaitForPageLoad());
                    });*/
        }catch(CustomE2eException pEx) {
            return false;
        }
    }
}
