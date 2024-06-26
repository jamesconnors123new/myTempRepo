package UiWrappers;

import Generic.customExceptions.CustomE2eException;
import Generic.customExceptions.OpImplMalfunction_MethodCalledWithInvalidParameters;
import org.apache.commons.lang.StringUtils;
import sqc.bstof.skeletonhelp.StandardReportingPatterns;

public abstract class SiteWrapper {

    protected final StandardReportingPatterns mReporting;

    public SiteWrapper(StandardReportingPatterns pReporting) {
        mReporting = pReporting;
    }

    private String FormErrorText(String pSiteInstanceUrl, Throwable pCause) {
        return String.join("\n","GoTo failed targeting site "+SiteIdentifier()+ " at "+pSiteInstanceUrl, "Caused by: " + pCause.getMessage());
    }

    public Boolean GoToSite(Browser pBrowser, String pSiteInstanceUrl, I_ActOnBrowserReturnT<Boolean> pPageWaiter) throws CustomE2eException {
        if(!pBrowser.RecordVisit(SiteIdentifier())) {
            PreFirstVisitActions(pBrowser);
            var vInitialNavigationCheckResult = NavigateToUrlThenWait(pBrowser,pSiteInstanceUrl,pPageWaiter);
            if(vInitialNavigationCheckResult==false) { return false; }
            PostFirstVisitActions(pBrowser);
            var vWaitForFinalSettleResult = WaitForSettledInSomeFinalState(pBrowser);
            if(vWaitForFinalSettleResult==false) { return false; }
            var vFinalStateCheckResult = FinalStateCheck(pBrowser);
            return vFinalStateCheckResult;
        } else {
            return NavigateToUrlThenWait(pBrowser,pSiteInstanceUrl,pPageWaiter);
        }
    }

    private void NavigateToUrl(Browser pBrowser, String pSiteInstanceUrl) {
        pBrowser.Wd().get(pSiteInstanceUrl);
    }

    private boolean NavigateToUrlThenWait(Browser pBrowser, String pSiteInstanceUrl, I_ActOnBrowserReturnT<Boolean> pPageWaiter) throws CustomE2eException {
        if(pBrowser==null|| StringUtils.isBlank(pSiteInstanceUrl)||pPageWaiter==null) {
            throw new OpImplMalfunction_MethodCalledWithInvalidParameters("NavigateToUrlThenWait",pBrowser,pSiteInstanceUrl,pPageWaiter);
        }
        try {
            NavigateToUrl(pBrowser,pSiteInstanceUrl);
            var vPageConfirmed = pPageWaiter.Action(pBrowser);
            return vPageConfirmed;
        } catch(Throwable pThrown) {
            throw new CustomE2eException(FormErrorText(pSiteInstanceUrl,pThrown ));
        }
    }

    protected abstract String SiteIdentifier();
    protected abstract void PreFirstVisitActions(Browser pBrowser) throws CustomE2eException;
    protected abstract void PostFirstVisitActions(Browser pBrowser) throws CustomE2eException;

    protected abstract boolean WaitForSettledInSomeFinalState(Browser pBrowser) throws CustomE2eException;
    protected abstract boolean FinalStateCheck(Browser pBrowser) throws CustomE2eException;

}
