package UiWrappers;

import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Browser<PomType, CommonStepType> {
    private final WebDriver mWebDriver;
    public WebDriver Wd() {
        return mWebDriver;
    }

    private final SeleniumHelper mSeleniumHelper;
    public SeleniumHelper Sh() {
        return mSeleniumHelper;
    }

    private final CommonStepType mCommonSteps;
    public CommonStepType Cs() {
        return mCommonSteps;
    }

    public Browser(WebDriver pWebDriver, PomType pageObjectOfPortal,
                   Function<WebDriver,CommonStepType> pCommonSteps) {
        mWebDriver = pWebDriver;
        mSeleniumHelper = new SeleniumHelper(mWebDriver);
       //mCommonSteps = new PortalGeneralStepDefinitions(mWebDriver, pageObjectOfPortal);
        this.mCommonSteps = pCommonSteps.apply(mWebDriver);
    }

    private Set<String> mSitesVisitedBefore = new HashSet<String>();

    public boolean RecordVisit(String pSiteIdentifier) {
        var vIdentifier = pSiteIdentifier.trim();
        var vVisitedBefore = mSitesVisitedBefore.contains(vIdentifier);
        mSitesVisitedBefore.add(pSiteIdentifier.trim());
        return vVisitedBefore;
    }

}
