package UiWrappers.Eis.Site;

import Generic.customExceptions.CustomE2eException;
import StepDefinitions.EisLoginStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Portal.Recognisers.TechnicalErrorPage;
import UiWrappers.SiteWrapper;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

import java.util.Map;

public class EisVer001 extends SiteWrapper {
    private final PageObjects.EisModel.Root eisModelRoot;
    public EisVer001(PageObjects.EisModel.Root eisModelRoot,
                     StandardReportingPatterns pReporting) {
        super(pReporting);
        this.eisModelRoot = eisModelRoot;
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

    public boolean GoToEisAndLogin(Browser pBrowser, String rootUrl,
                                 Map<String, Object> pCredentials) {
        try {
            // Goto site
            if (!this.GoToSite(pBrowser, rootUrl, (b) -> b.Sh().tryWaitForPageLoad())) {
                mReporting.reportRuntimeFaultIssue("Goto portal sequence did not execute as expected");
                return false;
            }

            pBrowser.Sh().waitForPageLoad();



            // Login to portal
            var eisLoginPage = new EisLoginStepDefinition(pBrowser.Wd(), this.eisModelRoot);
            return eisLoginPage.loginToEis(pCredentials, rootUrl,
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
}
