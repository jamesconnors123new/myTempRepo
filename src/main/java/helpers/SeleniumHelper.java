package helpers;

import Generic.customExceptions.CustomE2eException;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

//import javax.swing.text.html.Option;
//import java.sql.Time;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class SeleniumHelper {

  protected WebDriver driver;

  public SeleniumHelper(WebDriver pDriver) {
    driver = pDriver;
  }

  private static final String HEADLESS_BROWSER = "HEADLESS_BROWSER";
  private static final String CHROMIUM_HEADLESS_ARG = "--headless=new";
  private static final String FIREFOX_HEADLESS_ARG = "-headless";
  private static final String EDGE_DISABLE_POPUP_ARG = "--guest";
  private static final String BROWSER_NAME = "BROWSER_NAME";
  private static final String WAIT_FOR_PAGE_LOAD_MILLISECONDS = "WAIT_FOR_PAGE_LOAD_MILLISECONDS";
  private static final String WAIT_FOR_ELEMENT_CLICKABLE_MILLISECONDS =
          "WAIT_FOR_ELEMENT_CLICKABLE_MILLISECONDS";
  private static final String REMOTE_ALLOW_ORIGIN = "--remote-allow-origins=*";
  private static final String FIREFOX = "firefox";
  private static final String CHROME = "chrome";
  private static final String EDGE = "edge";

  private static WebDriverWait wait;

  public static Select selectFromDropDown(WebElement element) {
    return new Select(element);
  }


  enum BrowserTypes {Edge, Chrome, Firefox}

  private static BrowserTypes ParseBrowserType(String pBrowserTypeText) throws CustomE2eException {
    var vBrowserName = (!StringUtils.isAllBlank(pBrowserTypeText)) ? pBrowserTypeText.trim() : null;
    if (vBrowserName == null) {
      throw new CustomE2eException("Malformed browser identifier provided");
    }
    var vBrowserType = switch (vBrowserName) {
      case FIREFOX -> BrowserTypes.Firefox;
      case EDGE -> BrowserTypes.Edge;
      case CHROME -> BrowserTypes.Chrome;
      default -> throw new CustomE2eException("Unrecognised browser identifier: " + vBrowserName);
    };
    return vBrowserType;
  }

  private static FirefoxOptions SetFirefoxBrowserOptions(FirefoxOptions pOptionSet,
                                                         Boolean pHeadless) {
    pOptionSet.addArguments(REMOTE_ALLOW_ORIGIN);
    if (pHeadless) {
      pOptionSet.addArguments(FIREFOX_HEADLESS_ARG);
    }
    return pOptionSet;
  }

  private static ChromiumOptions<?> SetChromiumBrowserOptions(ChromiumOptions<?> pOptionSet,
                                                              Boolean pHeadless) {
    pOptionSet.addArguments(REMOTE_ALLOW_ORIGIN);
    if (pHeadless) {
      pOptionSet.addArguments(CHROMIUM_HEADLESS_ARG);
    }
    return pOptionSet;
  }

  private static void EnsureWebDriverSetupForUse(BrowserTypes pBroswerType) throws CustomE2eException {
    var vWebDriverManager = switch (pBroswerType) {
      case Firefox -> WebDriverManager.firefoxdriver();
      case Edge -> WebDriverManager.edgedriver();
      case Chrome -> WebDriverManager.chromedriver();
    };
    var vNumberOfFurtherAttempts = 5;
    var vSetupCompleted = false;
    while (--vNumberOfFurtherAttempts > 0) {
      try {
        vWebDriverManager.setup();
        vSetupCompleted = true;
      } catch (Throwable pThrown) {
        try {
          Thread.sleep(100L);
        } catch (InterruptedException vIntExcep) {
        }
      }
    }
    if (!vSetupCompleted) {
      throw new CustomE2eException("Failed to setup WebDriver using WebDriverManager for " + pBroswerType.name());
    }
  }

  public static WebDriver openBrowser1(String pBrowserName, Boolean pHeadless) throws CustomE2eException {
    var vBrowserType = ParseBrowserType(pBrowserName);
    EnsureWebDriverSetupForUse(vBrowserType);
    try {
      var vWebDriver = switch (vBrowserType) {
        case Firefox ->
                new FirefoxDriver(SetFirefoxBrowserOptions(new FirefoxOptions(), pHeadless));
        case Edge ->
                new EdgeDriver((EdgeOptions) SetChromiumBrowserOptions(new EdgeOptions(), pHeadless));
        case Chrome ->
                new ChromeDriver((ChromeOptions) SetChromiumBrowserOptions(new ChromeOptions(),
                        pHeadless));
      };
      return vWebDriver;
    } catch (Throwable pThrown) {
      throw new CustomE2eException("Failed to create WebDriver for browser " + vBrowserType.name());
    }
  }

  public static WebDriver openBrowser(String applicationUrl) throws CustomE2eException {
    String browserName = Utils.getProperty(BROWSER_NAME);
    boolean isHeadlessBrowser = Boolean.parseBoolean(Utils.getProperty(HEADLESS_BROWSER));
    var driver = openBrowser1(browserName, isHeadlessBrowser);
    driver.get(applicationUrl);
    new SeleniumHelper(driver).waitForPageLoad();
    return driver;
  }

  public static WebDriver openBrowser() throws CustomE2eException {
    try {
      WebDriver driver;
      String browserName = Utils.getProperty(BROWSER_NAME);
      boolean isHeadlessBrowser = Boolean.parseBoolean(Utils.getProperty(HEADLESS_BROWSER));
      switch (browserName.toLowerCase()) {
        case FIREFOX:
          //WebDriverManager.firefoxdriver().setup(); // Not able to test it. Fixrefox is not
          // installed.
          FirefoxOptions ffOptions = new FirefoxOptions();
          ffOptions.addArguments(REMOTE_ALLOW_ORIGIN);
          if (isHeadlessBrowser) {
            ffOptions.addArguments("-headless");
          }
          driver = new FirefoxDriver(ffOptions); //Browser is not installed
          break;
        case EDGE:
          // WebDriverManager.edgedriver().setup();
          EdgeOptions edgeOptions = new EdgeOptions();
          if (isHeadlessBrowser) {
            edgeOptions.addArguments(CHROMIUM_HEADLESS_ARG);
          }
          edgeOptions.addArguments(REMOTE_ALLOW_ORIGIN);
          edgeOptions.addArguments(EDGE_DISABLE_POPUP_ARG);
          driver = new EdgeDriver(edgeOptions);
          break;
        case CHROME:
          //chrome
          try {
            // WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(REMOTE_ALLOW_ORIGIN);
            if (isHeadlessBrowser) {
              chromeOptions.addArguments(CHROMIUM_HEADLESS_ARG);
            }
            driver = new ChromeDriver(chromeOptions);
          } catch (Throwable pThrown) {
            throw pThrown;
          }
          break;
        default:
          throw new CustomE2eException("Unknown browser name");
      }
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
      return driver;
    } catch (CustomE2eException pCe) {
      throw pCe;
    } catch (Throwable pThrown) {
      throw new CustomE2eException("Issue creating browser: " + pThrown.getMessage());
    }
  }

  public WebDriver getCurrentWebDriverInstance() {
    return driver;
  }

  public static void returnWebDriverToBase(WebDriver currentWebDriverInstance) {
    //driver = currentWebDriverInstance;
  }

  public static By xpathBuilder(By xpathBase, String value) {
    String replacedVar = xpathBase.toString().replace("<variable>", value);
    String cutByType = replacedVar.substring(10);
    return By.xpath(cutByType);
  }

  /**
   * This function, keep clicking on current locator on interval of time
   * and wait for visibility of next expected locator.
   *
   * @param currentByLocator element to be clicked
   * @param nextByLocator    new element to be visible
   */
  public void smartClickElement(By currentByLocator, By nextByLocator, String problemMessage) {
    int retryCount = 0;
    do {
      try {
        WebDriverWait wait = new WebDriverWait(getCurrentWebDriverInstance(),
                Duration.ofMillis(Long.parseLong(Utils.getProperty(WAIT_FOR_ELEMENT_CLICKABLE_MILLISECONDS))));
        clickElement(currentByLocator, SyncType.CLICKABLE, problemMessage);
        elementSyncTime(SyncType.PRESENT, nextByLocator, wait);
        if (findElement(nextByLocator, SyncType.CLICKABLE, problemMessage).isDisplayed() && findElement(nextByLocator, SyncType.CLICKABLE, problemMessage).isEnabled()) {
          break;
        }
      } catch (CustomE2eException e) {

      }
      retryCount++;
    } while (retryCount <= 5);
  }


  public WebElement clickElementRetryX3onClickIntExAlt(By byLocator, SyncType syncType) throws CustomE2eException {
    return clickElement(byLocator, syncType, String.format("clickElement failed %s", byLocator.toString()));
  }

  public WebElement clickElementRetryX3onClickIntEx(By byLocator, SyncType syncType) throws CustomE2eException {

    final var returnObject = new Object() {
      WebElement webElement = null;
    };

    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      returnObject.webElement = clickElementRetryX3onClickIntExAlt(byLocator, syncType);
    } else {

      RetryOnClickInterceptedException(3, () -> returnObject.webElement = clickElement(byLocator, syncType, String.format(
              "clickElement failed %s", byLocator.toString())));

    }

    return returnObject.webElement;

  }

  public WebElement clickElement(By byLocator, SyncType syncType) throws CustomE2eException {
    return clickElement(byLocator, syncType, String.format("clickElement failed %s",
            byLocator.toString()));
  }




  public WebElement clickElement(By byLocator, SyncType syncType, String problemMessage) throws CustomE2eException {


    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      return clickElementAlt(byLocator, syncType, problemMessage);
    } else {

      final WebElement[] element = {null};

      synchronized (WebElement.class) {
        try {
          RetryOnStaleElementException(2, () -> {
            element[0] = findElement(byLocator, syncType, problemMessage);
            if (element[0] != null && element[0].isDisplayed()) {
              waitForElement(byLocator, SyncType.CLICKABLE);
              scrollIntoView(byLocator);
              element[0].click();
            } else {
              scrollIntoView(byLocator);
              try {
                element[0].wait(800);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            }
          }, problemMessage);
        } catch (NullPointerException exception) {
          throw new NoSuchElementException("Element Not found");
        } catch (ElementClickInterceptedException interceptedException) {
          scrollElementIntoCenterOfScreen(byLocator);
          throw new ElementClickInterceptedException(interceptedException.getMessage());
        }
        return element[0];
      }
    }
  }


  public WebElement clickElementAlt(By byLocator, SyncType syncType, String problemMessage)
          throws CustomE2eException, TimeoutException, NullPointerException {

    int numberOfStaleExceptionRetries = 0;
    int numberOfClickInterceptRetries = 0;

    WebElement tempWebElement = null;

    Exception e = null;

    do {

      try {

        // tempWebElement = driver.findElement(byLocator);
        tempWebElement = findElement(byLocator, syncType, problemMessage);
        tempWebElement.click();

        return tempWebElement;

      } catch (StaleElementReferenceException staleElementReferenceException) {

        numberOfStaleExceptionRetries++;
        if (numberOfStaleExceptionRetries > 10) {
          e = staleElementReferenceException;
        }

        // drop out of try block to loop and refresh WebElement and retry click()

      } catch (ElementClickInterceptedException elementClickInterceptedException) {

        numberOfClickInterceptRetries++;
        if (numberOfClickInterceptRetries > 10) {
          e = elementClickInterceptedException;
        }

        // element is present on page but click is not getting to it
        // a number of different methods will be attempted in turn to
        // reveal the element to enable WebDriver.click()

//        // Method 1 - attempt to use JavascriptExecutor click() method
//        try {
//          JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//          javascriptExecutor.executeScript
//                  ("arguments[0].click()", tempWebElement);
//          return tempWebElement;
//        } catch (ElementClickInterceptedException elementClickInterceptedExceptionTwo) {
//          // drop out of try to allow alternative methods to click element
//        } catch (Exception exception) {
//          // any other exception throw
//          e = exception;
//        }


        // Method 2 - Attempt scrolling browser to reveal element to
        // enable successful WebElement click()
        try {

          // Attempt scrolling down first - could scroll to top of page before scroll?
          browserScrollToElementUpOrDown(tempWebElement, false);

          // refresh element
          // tempWebElement = driver.findElement(byLocator);

          // attempt click
          tempWebElement.click();

          return tempWebElement;

        } catch (ElementClickInterceptedException elementClickInterceptedExceptionTwo) {


          // Attempt scrolling up this time - could scroll to bottom of page before scroll?
          browserScrollToElementUpOrDown(tempWebElement, true);

          // refresh element
          // tempWebElement = driver.findElement(byLocator);

          // attempt click
          tempWebElement.click();
          return tempWebElement;

        } catch (Exception ex) {
          // any other exception throw
          e = ex;
        }

      }
      // return tempWebElement;
    } while(e == null);

    if (e != null) {
      throw new CustomE2eException(
              "Click element failed due to repeated exceptions caught of type: " + e.getMessage()
      );
    }

    return tempWebElement;

  }



//
//
//
//    tempWebElement.click();
//
//
//    int exceptionCaughtCount = 0;
//    boolean success = false;
//    boolean scrollIntoViewPerformed = false;
//    do {
//
//      try {
////        scrollIntoView(byLocator);
////        scrollElementIntoCenterOfScreen(byLocator);
//
//        element = findElement(byLocator, syncType, problemMessage);
//
//
//        element.click();
//
//        success = true;
//        return element;
////
////        element = findElement(byLocator, syncType, problemMessage);
////        if (element != null && element.isDisplayed()) {
//////          waitForElement(byLocator, SyncType.CLICKABLE);
//////          scrollIntoView(byLocator);
////          element.click();
////          success = true;
////          return element;
////        }
////        }, problemMessage);
////      } catch (NullPointerException | TimeoutException exception) {
//
//
//      } catch (TimeoutException | NullPointerException exception) {
//        throw exception;
////      }
////      } catch (TimeoutException exception) {
////        exceptionCaughtCount++;
////        throw exception;
////        if (exceptionCaughtCount == 100) {
////          throw new NoSuchElementException("Element Not found - TimeoutException");
//////          throw exception;
////        }
//////        NoThrowSleep(Duration.ofMillis(100));
////
////
//////        throw new NoSuchElementException("Element Not found - NullPointerException");
////      } catch (NullPointerException exception) {
////        exceptionCaughtCount++;
////        if (exceptionCaughtCount == 100) {
////          throw new NoSuchElementException("Element Not found - NullPointerException");
////        }
////      }
//
//      } catch (ElementClickInterceptedException interceptedException) {
//
////        JavascriptExecutor ex=(JavascriptExecutor)driver;
////        ex.executeScript("arguments[0].click()", element);
////
////        return element;
//
//        // TODO: maybe move NullPointerException here?
////        scrollElementIntoCenterOfScreen(byLocator);
//        if (!scrollIntoViewPerformed) {
//          scrollIntoViewAlt(byLocator, false);
////          scrollIntoViewPerformed = true;
//        } else {
//          scrollIntoViewAlt(byLocator, true);
//        }
////
////        scrollIntoViewPerformed = !scrollIntoViewPerformed;
//
//
//        // TODO: Alternative solution not tried yet
////        JavascriptExecutor ex=(JavascriptExecutor)driver;
////        ex.executeScript("arguments[0].click()", element);
//
////        throw new ElementClickInterceptedException(interceptedException.getMessage());
//      } catch (Exception exception) {
//        exceptionCaughtCount++;
//        if (exceptionCaughtCount == 100) {
//          throw new CustomE2eException(problemMessage + ";\n\nException message;\n\n" + exception.getMessage());
//        }
////        NoThrowSleep(Duration.ofMillis(100));
//      }
//
//      // Maybe move scroll call here?
//
//      NoThrowSleep(Duration.ofMillis(100));
//    } while(!success);
//
//    return element;
//
//  }

  public interface I_FuncReturning<T> {
    T Act() throws CustomE2eException;
  }

  public interface I_Action {
    void Act() throws CustomE2eException;
  }


  public class RetryLimitExceeded extends RuntimeException {
    public RetryLimitExceeded(Class<?> pExceptionType, String pAction) {
      super(String.format("Exceeded retry attempts. Ex type: %s. Action: %s",
              pExceptionType.getName(), pAction));
    }

    public RetryLimitExceeded() {
    }
  }


  public <T> T RetryOnException(String pAction, Class<?> pExceptionType, long pSpacing,
                                int pAttempts, I_FuncReturning<T> pProtectedFunction) throws CustomE2eException {
    return Private_RetryOnException(null, pAction, pExceptionType, pSpacing, pAttempts,
            pProtectedFunction, null);
  }

  public <T> T RetryOnExceptionFailSilently(String pAction, Class<?> pExceptionType,
                                            long pSpacing, int pAttempts,
                                            I_FuncReturning<T> pProtectedFunction,
                                            I_FuncReturning<T> pSilentFailureValueGenerator) throws CustomE2eException {
    return Private_RetryOnException(pSilentFailureValueGenerator, pAction, pExceptionType,
            pSpacing, pAttempts, pProtectedFunction, null);
  }

  public <T> T RetryOnException(String pAction, Class<?> pExceptionType, long pSpacing,
                                int pAttempts, I_FuncReturning<T> pProtectedFunction,
                                Function<Exception, Boolean> pRetryGuard) throws CustomE2eException {
    return Private_RetryOnException(null, pAction, pExceptionType, pSpacing, pAttempts,
            pProtectedFunction, pRetryGuard);
  }

  public <T> T RetryOnExceptionFailSilenly(String pAction, Class<?> pExceptionType, long pSpacing
          , int pAttempts, I_FuncReturning<T> pProtectedFunction,
                                           Function<Exception, Boolean> pRetryGuard,
                                           I_FuncReturning<T> pSilentFailureValueGenerator) throws CustomE2eException {
    return Private_RetryOnException(pSilentFailureValueGenerator, pAction, pExceptionType,
            pSpacing, pAttempts, pProtectedFunction, pRetryGuard);
  }

  private <T> T Private_RetryOnException(I_FuncReturning<T> pSilentFailureValueGenerator,
                                         String pAction, Class<?> pExceptionType, long pSpacing,
                                         int pAttempts, I_FuncReturning<T> pProtectedFunction,
                                         Function<Exception, Boolean> pRetryGurad) throws CustomE2eException {
    var vAttemptsLeft = Math.max(1, pAttempts);
    while (vAttemptsLeft > 0) {
      vAttemptsLeft--;
      try {
        var vResult = pProtectedFunction.Act();
        vResult.getClass();
        return vResult;
      } catch (Exception pExcep) {
        if (!(pExceptionType.isAssignableFrom(pExcep.getClass()))) {
          throw pExcep;
        } else if (pRetryGurad != null && !pRetryGurad.apply(pExcep)) {
          throw pExcep;
        }
        try {
          Thread.sleep(pSpacing);
        } catch (InterruptedException pInterruptEx) {
        }
      }
    }
    if (pSilentFailureValueGenerator == null) {
      throw new RetryLimitExceeded(pExceptionType, pAction);
    } else {
      return pSilentFailureValueGenerator.Act();
    }

  }

  public void RetryOnException(String pAction, Class<?> pExceptionType, long pSpacing,
                               int pAttempts, I_Action pProtectedFunction) throws CustomE2eException {
    Private_RetryOnException(false, pAction, pExceptionType, pSpacing, pAttempts,
            pProtectedFunction, null);
  }

  public void RetryOnExceptionFailSilenly(String pAction, Class<?> pExceptionType, long pSpacing,
                                          int pAttempts, I_Action pProtectedFunction) throws CustomE2eException {
    Private_RetryOnException(true, pAction, pExceptionType, pSpacing, pAttempts,
            pProtectedFunction, null);
  }

  public void RetryOnException(String pAction, Class<?> pExceptionType, long pSpacing,
                               int pAttempts, I_Action pProtectedFunction, Function<Exception,
          Boolean> pRetryGuard) throws CustomE2eException {
    Private_RetryOnException(false, pAction, pExceptionType, pSpacing, pAttempts,
            pProtectedFunction, pRetryGuard);
  }

  public void RetryOnExceptionFailSilenly(String pAction, Class<?> pExceptionType, long pSpacing,
                                          int pAttempts, I_Action pProtectedFunction,
                                          Function<Exception, Boolean> pRetryGuard) throws CustomE2eException {
    Private_RetryOnException(true, pAction, pExceptionType, pSpacing, pAttempts,
            pProtectedFunction, pRetryGuard);
  }


  private void Private_RetryOnException(Boolean pFailSilently, String pAction,
                                        Class<?> pExceptionType, long pSpacing, int pAttempts,
                                        I_Action pProtectedFunction,
                                        Function<Exception, Boolean> pRetryGuard) throws CustomE2eException {
    var vAttemptsLeft = Math.max(1, pAttempts);
    while (vAttemptsLeft > 0) {
      vAttemptsLeft--;
      try {
        pProtectedFunction.Act();
        return;
      } catch (Exception pExcep) {
        if (!(pExceptionType.isAssignableFrom(pExcep.getClass()))) {
          throw pExcep;
        } else if (pRetryGuard != null && !pRetryGuard.apply(pExcep)) {
          throw pExcep;
        }
        try {
          Thread.sleep(pSpacing);
        } catch (InterruptedException pInterruptEx) {
        }
      }
    }
    if (!pFailSilently) {
      throw new RetryLimitExceeded(pExceptionType, pAction);
    }
  }


  public <T> T RetryOnStaleElementException(int pAttempts, I_FuncReturning<T> pProtectedFunction,
                                            String pActionDesc) throws CustomE2eException {
    var vAttemptsLeft = Math.max(1, pAttempts);
    while (vAttemptsLeft > 0) {
      vAttemptsLeft--;
      try {
        var vResult = pProtectedFunction.Act();
        return vResult;
      } catch (StaleElementReferenceException pSere) {
        try {
          Thread.sleep(100L);
        } catch (InterruptedException pInterruptEx) {
        }
        NoThrowSleep(Duration.ofMillis(100));
      }
    }
    throw new RuntimeException(String.format("Exceeded retry attempts for " +
            "StaleElementReferenceException, action: %s", pActionDesc));
  }

  public void RetryOnStaleElementException(int pAttempts, I_Action pProtectedFunction,
                                           String pActionDesc) throws CustomE2eException {
    var vAttemptsLeft = Math.max(1, pAttempts);
    while (vAttemptsLeft > 0) {
      vAttemptsLeft--;
      try {
        pProtectedFunction.Act();
        return;
      } catch (StaleElementReferenceException pSere) {
        try {
          Thread.sleep(100L);
        } catch (InterruptedException pInterruptEx) {
        }
      }
    }
    throw new RuntimeException(String.format("Exceeded retry attempts for " +
            "StaleElementReferenceException, action: %s", pActionDesc));
  }


//    public <T> T RetryOnClickInterceptedException(int pAttempts, I_FuncReturning<T>
//    pProtectedFunction)  throws CustomE2eException{
//        var vAttemptsLeft = Math.max(1,pAttempts);
//        while(vAttemptsLeft>0) {
//            vAttemptsLeft--;
//            try {
//                var vResult = pProtectedFunction.Act();
//                return vResult;
//            } catch(ElementClickInterceptedException pSere) {
//                try {
//                    Thread.sleep(100L);
//                } catch(InterruptedException pInterruptEx) {
//                }
//            }
//        }
//        throw new RuntimeException("Exceeded retry attempts for
//        ElementClickInterceptedException");
//    }

  public WebElement RetryOnClickInterceptedException(int pAttempts, I_Action pProtectedFunction) throws CustomE2eException {


    int pAttemptsRefactored = pAttempts * 100;

    var vAttemptsLeft = Math.max(1, pAttemptsRefactored);
    while (vAttemptsLeft > 0) {
      vAttemptsLeft--;
      try {
        pProtectedFunction.Act();
        return null;
      } catch (ElementClickInterceptedException pSere) {
//        try {
//          Thread.sleep(100L);
//        } catch (InterruptedException pInterruptEx) {
//        }

        NoThrowSleep(Duration.ofMillis(100));
      }
    }
    throw new RuntimeException("Exceeded retry attempts for ElementClickInterceptedException");
  }

  public Boolean NoThrowSleep(Duration pDuration) {
    try {
      Thread.sleep(pDuration.toMillis());
      return true;
    } catch (InterruptedException e) {
      return false;
    }
  }

  public void NoExplicitThrowSleep(Duration pDuration) {
    try {
      Thread.sleep(pDuration.toMillis());
    } catch (InterruptedException e) {
      throw new RuntimeException("Sleep interrupted: " + e.getMessage());
    }
  }


  public void RetryOnClickInterceptedException(Duration pBusyIndicationLimit,
                                               Function<ElementClickInterceptedException,
                                                       Boolean> pCauseIsBusyIndicatorDetector,
                                               Duration pRetryDelayIfBusyPresent,
                                               int pAttemptsOutsideBusy,
                                               Duration pRetryDelayOutsideBusy,
                                               I_Action pProtectedAction) throws CustomE2eException {
    RetryOnClickInterceptedException(pBusyIndicationLimit, pCauseIsBusyIndicatorDetector,
            pRetryDelayIfBusyPresent, pAttemptsOutsideBusy, pRetryDelayOutsideBusy, () -> {
              pProtectedAction.Act();
              return true;
            });
  }

  public <T> T RetryOnClickInterceptedException(Duration pBusyIndicationLimit,
                                                Function<ElementClickInterceptedException,
                                                        Boolean> pCauseIsBusyIndicatorDetector,
                                                Duration pRetryDelayIfBusyPresent,
                                                int pAttemptsOutsideBusy,
                                                Duration pRetryDelayOutsideBusy,
                                                I_FuncReturning<T> pProtectedFunction) throws CustomE2eException {
    var vFirstDetectionOfBusyIndicator = (LocalDateTime) null;
    var vLatestDetectionOfBusyIndicator = (LocalDateTime) null;
    var vAttemptsLeft = Math.max(1, pAttemptsOutsideBusy);
    while (vAttemptsLeft > 0) {
      vAttemptsLeft--;
      try {
        var vResult = pProtectedFunction.Act();
        return vResult;
      } catch (ElementClickInterceptedException pElementClickInterceptedException) {
        var vRetryDelay = (Duration) null;
        var vCauseIsBusy = pCauseIsBusyIndicatorDetector.apply(pElementClickInterceptedException);
        if (vCauseIsBusy) {
          var vNow = LocalDateTime.now(ZoneId.of("UTC"));
          if (vFirstDetectionOfBusyIndicator == null) {
            vFirstDetectionOfBusyIndicator = vNow;
          }
          vLatestDetectionOfBusyIndicator = vNow;
          var vDurationWeHaveBeenSeeingBusy = Duration.between(vFirstDetectionOfBusyIndicator,
                  vLatestDetectionOfBusyIndicator);
          if (vDurationWeHaveBeenSeeingBusy.compareTo(pBusyIndicationLimit) > 0) {
            // Busy indication has been there too long
            throw new RuntimeException("Could not click because busy indication has been there " + "for too long");
          }
          vAttemptsLeft = pAttemptsOutsideBusy;
          vRetryDelay = pRetryDelayIfBusyPresent;
        } else {
          vRetryDelay = pRetryDelayOutsideBusy;
        }
        NoExplicitThrowSleep(vRetryDelay);
      }
    }
    throw new RuntimeException("Exceeded retry attempts for ElementClickInterceptedException");
  }


  public WebElement elementSyncTime(SyncType syncType, By byLocator, WebDriverWait wait) throws CustomE2eException {
    var vProblemMsg = String.format("Sync %s on %s", syncType.toString(), byLocator.toString());
    switch (syncType) {
      case PRESENT:
        return RetryOnStaleElementException(2,
                () -> wait.until(ExpectedConditions.presenceOfElementLocated(byLocator)), vProblemMsg);
      case VISIBLE:
        return RetryOnStaleElementException(2,
                () -> wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator)),
                vProblemMsg);
      case CLICKABLE:
        return RetryOnStaleElementException(2,
                () -> wait.until(ExpectedConditions.elementToBeClickable(byLocator)), vProblemMsg);
      case INVISIBILITY:
        if (RetryOnStaleElementException(2,
                () -> wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator)),
                vProblemMsg)) {
          return null;
        } else {
          throw new CustomE2eException("Element did not become invisible");
        }
      default:
        throw new RuntimeException("Unknown operation in call to elementSyncTime");
    }
  }

  public static String addCause(String problem, String cause) {
    return problem + " caused by " + cause;
  }

  public WebElement findElement(By byLocator, SyncType syncType, String problemMessage) throws CustomE2eException {
    WebElement element = null;
    int retryCount = 0;
    try {
      for (retryCount = 0; retryCount < 3; retryCount++) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        element = elementSyncTime(syncType, byLocator, wait);
      }
    } catch (ElementNotInteractableException elementNotInteractableException) {
      throw new CustomE2eException(addCause(problemMessage,
              elementNotInteractableException.getMessage()));
    } catch (TimeoutException timeoutException) {
      //throw new CustomE2eException(addCause(problemMessage, timeoutException.getMessage()));
      throw new TimeoutException(addCause(problemMessage, timeoutException.getMessage()));
    } catch (NullPointerException exception) {
      throw new NullPointerException(addCause(problemMessage, exception.getMessage()));
    }
    return element;
  }

  public WebElement getElementAtPosition(By webElement, int position) {
    List<WebElement> elements = driver.findElements(webElement);
    return elements.get(position);
  }

  public List<WebElement> getElementsMatchingToLocator(By webElement) {
    return driver.findElements(webElement);
  }

  public int getCountOfElementsMatchingToLocator(By webElement) {
    return driver.findElements(webElement).size();
  }

  public void typeText(By byLocator, Object text, SyncType syncType) throws CustomE2eException {
    typeText(byLocator, text, syncType, false, false, "typeText failed");
  }

  public void typeText(By byLocator, Object text, SyncType syncType, boolean pTabOutAtEnd) throws CustomE2eException {
    typeText(byLocator, text, syncType, pTabOutAtEnd, false, "typeText failed");
  }

  public void typeText(By byLocator, Object text, SyncType syncType, String problemMessage) throws CustomE2eException {
    typeText(byLocator, text, syncType, false, false, problemMessage);
  }

  public void typeText(By byLocator, Object stringObject, SyncType syncType, boolean pTabOutAtEnd, boolean sendEnterAfter,
                       String problemMessage) throws CustomE2eException {

    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      typeTextAlt(byLocator, stringObject, syncType, pTabOutAtEnd, sendEnterAfter, problemMessage);
    } else {

      try {
        RetryOnStaleElementException(3, () -> {
          WebElement element = findElement(byLocator, syncType, problemMessage);
          clearText(byLocator);
          NoThrowSleep(Duration.ofMillis(20L));
          element.sendKeys(String.valueOf(stringObject));
          if (pTabOutAtEnd) {
            element.sendKeys(Keys.TAB);
          }
          NoThrowSleep(Duration.ofMillis(20L));
        }, problemMessage);
      } catch (ElementNotInteractableException exception) {
        throw new CustomE2eException(byLocator + "Element not interactable");
      }

    }

  }

  public void typeTextAlt(By byLocator, Object stringObject, SyncType syncType, boolean pTabOutAtEnd, boolean sendEnterAfter,
                          String problemMessage) throws CustomE2eException {

    clickElementAlt(byLocator, syncType, problemMessage);

    if (byLocator == null) {
      var actions = new Actions(driver);
      actions.sendKeys((CharSequence) stringObject);
      if (pTabOutAtEnd) {
        actions.sendKeys(Keys.TAB);
      }
      if (sendEnterAfter) {
        actions.sendKeys(Keys.ENTER);
      }
      actions.perform();
      return;
    }


    int exceptionCaughtCount = 0;
    boolean success = false;
    do {

      clickElementAlt(byLocator, syncType, problemMessage);

      try {

        if (!waitForElement(byLocator, syncType)) {
          throw new CustomE2eException(problemMessage
                  + "waitForElement method could not find element using the provided By locator: "
                  + byLocator);

        }

        WebElement element = driver.findElement(byLocator);
        element.click();
        element.clear();

        element.sendKeys(String.valueOf(stringObject));

        if (pTabOutAtEnd) {
          element.sendKeys(Keys.TAB);
        }
        if (sendEnterAfter) {
          element.sendKeys(Keys.ENTER);
        }

        // success
        return;
//        break;
        // HERE
      } catch (NullPointerException exception) {
        throw new NoSuchElementException("Element Not found - NullPointerException");
      } catch (TimeoutException exception) {
        throw new NoSuchElementException("Element Not found - TimeoutException");
      } catch (ElementClickInterceptedException interceptedException) {
        scrollElementIntoCenterOfScreen(byLocator);
//        throw new ElementClickInterceptedException(interceptedException.getMessage());
      } catch (Exception exception) {
        if (exceptionCaughtCount == 100) {
          throw new CustomE2eException(problemMessage + ";\n\nException message;\n\n" + exception.getMessage());
        }
      }

      exceptionCaughtCount++;
      NoThrowSleep(Duration.ofMillis(100));

    } while(true);

//    throw new CustomE2eException(problemMessage + ";\n\nException message;\n\n" + exception.getMessage());

  }


  //Use this function for Sort code.
  public void typeTextWithoutClearField(By byLocator, Object text, boolean pTabOutAtEnd,
                                        SyncType syncType, String problemMessage) throws CustomE2eException {
    try {
      RetryOnStaleElementException(3, () -> {
        WebElement element = findElement(byLocator, syncType, problemMessage);
        NoThrowSleep(Duration.ofMillis(60L));
        element.sendKeys(String.valueOf(text));
        NoThrowSleep(Duration.ofMillis(60L));
        if (pTabOutAtEnd) {
          element.sendKeys(Keys.TAB);
        }
        NoThrowSleep(Duration.ofMillis(60L));
      }, problemMessage);
    } catch (ElementNotInteractableException exception) {
      throw new CustomE2eException(byLocator + "Element not interactable");
    }
  }


  public void clearText(By byLocator) throws CustomE2eException {
    WebElement element = null;
    int retryAttempt = 0;
    try {
      do {
        var beforeClearTextField = getAttribute(byLocator, "value", "value not found.");
        element = findElement(byLocator, SyncType.VISIBLE, "failed  clear text");
        element.clear();
        if (!getAttribute(byLocator, "value", "value not found.").equalsIgnoreCase(beforeClearTextField) || beforeClearTextField.isEmpty()) {
          break;
        }
        retryAttempt++;
      } while (retryAttempt < 3);
      if (retryAttempt == 3) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
      }
    } catch (ElementNotInteractableException exception) {
      throw new CustomE2eException(element + "Element not intractable");
    }
  }

  public void clearText(WebElement element) throws CustomE2eException {
    try {
      element.clear();
    } catch (ElementNotInteractableException exception) {
      throw new CustomE2eException(element + "Element not intractable");
    }
  }

  public boolean isElementVisible(By byLocator) {


    try {

      WebElement tempWebElement = driver.findElement(byLocator);

      if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
        browserScrollToElementUpOrDown(tempWebElement, false);
      }

      return tempWebElement.isDisplayed();
    } catch (CustomE2eException | NullPointerException | NoSuchElementException | TimeoutException |
             ElementNotInteractableException e) {
      return false;
    }
  }

  public boolean isElementEnabled(By byLocator) {
    boolean elementEnabled = true;
    try {
      elementEnabled = driver.findElement(byLocator).isEnabled();
    } catch (NullPointerException | NoSuchElementException | TimeoutException |
             ElementNotInteractableException e) {
      elementEnabled = false;
    }
    return elementEnabled;
  }

  public boolean isElementSelected(By byLocator) {
    boolean elementSelected = true;
    try {
      elementSelected = driver.findElement(byLocator).isSelected();
    } catch (NullPointerException | NoSuchElementException | TimeoutException |
             ElementNotInteractableException e) {
      elementSelected = false;
    }
    return elementSelected;
  }

  public boolean waitForElement(By byLocator, SyncType syncType) throws CustomE2eException {
    boolean elementVisible = false;
    wait = new WebDriverWait(driver,
            Duration.ofMillis(Long.parseLong(Utils.getProperty(WAIT_FOR_ELEMENT_CLICKABLE_MILLISECONDS))));
    var ele = elementSyncTime(syncType, byLocator, wait);
    if (ele != null) {
      elementVisible = true;
    }
    return elementVisible;
  }

  public boolean waitForElement2(By byLocator, SyncType syncType, Long waitForElement) {
    var waitForElementToBeVisible = new WebDriverWait(driver, Duration.ofMillis(waitForElement));
    try {
      elementSyncTime(syncType, byLocator, waitForElementToBeVisible);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void CheckedWaitForElement2(By byLocator, SyncType syncType, Long waitForElement,
                                     String pAfter, String pCondition) throws CustomE2eException {
    var waitForElementToBeVisible = new WebDriverWait(driver, Duration.ofMillis(waitForElement));
    try {
      elementSyncTime(syncType, byLocator, waitForElementToBeVisible);
    } catch (Exception e) {
      throw new CustomE2eException(String.format("Exception %s, waiting for %s to signal %s, " +
              "after %s", e.getMessage(), byLocator.toString(), pCondition, pAfter));
    }
  }

  public boolean isAttributePresent(WebElement element, String attribute) throws CustomE2eException {
    Boolean result = false;
    try {
      String value = element.getAttribute(attribute);
      if (value != null) {
        result = true;
      }
    } catch (Exception e) {
      throw new CustomE2eException("Attribute not found");
    }
    return result;
  }

  public void waitForElementToInvisible(By byLocator) throws CustomE2eException {
    wait = new WebDriverWait(driver,
            Duration.ofMillis(Long.parseLong(Utils.getProperty(WAIT_FOR_ELEMENT_CLICKABLE_MILLISECONDS))));
    elementSyncTime(SyncType.INVISIBILITY, byLocator, wait);
  }

  public Boolean tryWaitForPageLoad() {
    try {
      waitForPageLoad();
      return true;
    } catch (TimeoutException pToEx) {
      return false;
    }
  }

  public void CheckedWaitForPageLoad(String pTrigger, String pWaitingFor) throws CustomE2eException {
    try {
      waitForPageLoad();
    } catch (TimeoutException pToEx) {
      throw new CustomE2eException(String.format("Timeout waiting for %s in response to %s",
              pWaitingFor, pTrigger));
    }
  }

  public void waitForPageLoad() {
    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals(
                "complete");
      }
    };
    WebDriverWait waitForPageLoad = new WebDriverWait(driver,
            Duration.ofMillis(Long.parseLong(Utils.getProperty(WAIT_FOR_PAGE_LOAD_MILLISECONDS))));
    waitForPageLoad.until(pageLoadCondition);
  }

  //Echelon
  public void quitBrowser() {
    getCurrentWebDriverInstance().quit();
  }

  public void selectDropdown(By byLocator, Object dropdownVal, SelectOptions selectOptions) throws CustomE2eException {
    selectDropdown(byLocator, dropdownVal, selectOptions,
            String.format("selectDropdown failed " + "on: %s", byLocator.toString()));
  }

  public void selectDropdown(By byLocator, Object dropdownVal, SelectOptions selectOptions,
                             String problemMessage) throws CustomE2eException {

    if (!waitForElement2(byLocator, SyncType.CLICKABLE, 60000L)) {
      new CustomE2eException(String.format("In selectDropdown element %s did not become " +
              "clickable, causing: %s", byLocator.toString(), problemMessage));
    }
    RetryOnException(String.format("Select dropdown->%s", problemMessage), Exception.class, 50, 3
            , () -> {
              Select selectOption = new Select(findElement(byLocator, SyncType.VISIBLE, problemMessage));
              if (selectOptions.equals(SelectOptions.TEXT)) {
                selectOption.selectByVisibleText((String) dropdownVal);
              } else if (selectOptions.equals(SelectOptions.INDEX)) {
                selectOption.selectByIndex(Integer.parseInt(String.valueOf(dropdownVal)));
              } else if (selectOptions.equals(SelectOptions.VALUE)) {
                selectOption.selectByValue(String.valueOf(dropdownVal));
              }
            }, (pEx) -> pEx.getClass().equals(StaleElementReferenceException.class) || pEx.getClass().equals(NoSuchElementException.class));

//    RetryOnStaleElementException(2, () -> {
//      var selectOption = new Select(findElement(byLocator, SyncType.VISIBLE, problemMessage));
//      var vSelected = selectOption.getAllSelectedOptions();
//      if (vSelected.size() != 1) {
//        throw new CustomE2eException(String.format("Select dropdown on %s does not have a
//        single " +
//            "selection, the number selected is %d", byLocator.toString(), vSelected.size()));
//      }
//      if (selectOptions.equals(SelectOptions.TEXT)) {
//        if (!vSelected.get(0).getText().equals((String) dropdownVal)) {
//          throw new CustomE2eException(String.format("Failed to select %s on %s", dropdownVal,
//              byLocator.toString()));
//        }
//      } else if (selectOptions.equals(SelectOptions.INDEX)) {
//      } else if (selectOptions.equals(SelectOptions.VALUE)) {
//      }
//    }, "SelectDropdownConfirm");
  }

  public String formatDropDownAmount(String amount) {
    DecimalFormat formatter = new DecimalFormat("#,###");
    return String.format("£%S", formatter.format(Integer.valueOf(amount)));
  }

  public List<WebElement> getAllValuesFromDropDown(By byLocator, String problemMessage) throws CustomE2eException {
    return new Select(findElement(byLocator, SyncType.VISIBLE, problemMessage)).getOptions();
  }

  public String getSelectedValueFromDropDown(By byLocator, String problemMessage) throws CustomE2eException {
    return new Select(findElement(byLocator, SyncType.VISIBLE, problemMessage)).getFirstSelectedOption().getText();
  }

  public String getText(By element) throws CustomE2eException {
    return getText(element, "getText failed").trim();
  }


  public int getIndex(By byLocator, String elementValue, String problemMessage) throws CustomE2eException {
    List<WebElement> dropdownList = new Select(findElement(byLocator, SyncType.VISIBLE,
            problemMessage)).getOptions();
    int index = 0;

    for (int i = 0; i < dropdownList.size(); i++) {
      if (dropdownList.get(i).getText().contains(getSelectedValueFromDropDown(byLocator,
              problemMessage))) {
        index = i;
      }
    }
    return index;
  }

  public int getListSize(By byLocator) throws CustomE2eException {
    List<WebElement> dropdownList =
            new Select(findElement(byLocator, SyncType.VISIBLE, "")).getOptions();
    int listSize = dropdownList.size();

    return listSize;
  }

  public void scrollIntoView(By byLocator) throws CustomE2eException {

//    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
//      scrollElementIntoView(byLocator, false);
//    } else {


    RetryOnStaleElementException(3, () -> {
      var element = findElement(byLocator, SyncType.VISIBLE, "Failed to find element to be " +
              "scroll into view");
      new Actions(driver).scrollToElement(element).build().perform();
    }, String.format("Scroll into view %s", byLocator.toString()));


//    }


  }

  public void browserScrollToElementUpOrDown(WebElement tempWebElement, boolean scrollUpDirection) throws CustomE2eException {

    // try scrolling down first - maybe scroll to top of page first?
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Default javascript will scroll down to find element
    String scriptString = "arguments[0].scrollIntoView();";

    // If scrollUpDirection parameter true then amend the default javascript statement
    if (scrollUpDirection) {
      scriptString = "arguments[0].scrollIntoView(false);";
    }

    js.executeScript(scriptString, tempWebElement);

  }
//
//    WebElement tempWebElement;
//
//
//    int exceptionCaughtCount = 0;
//    boolean success = false;
//    do {
//
//      try {
//
//        tempWebElement = driver.findElement(byLocator);
//
//
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//
//
//        if (attemptReverseScroll) {
//          js.executeScript("arguments[0].scrollIntoView(false);", tempWebElement);
//        } else {
//          js.executeScript("arguments[0].scrollIntoView(true);", tempWebElement);
//        }
//
//
////        var element = findElement(byLocator, SyncType.VISIBLE, "Failed to find element to be " +
////                "scroll into view");
////        new Actions(driver).scrollToElement(element).build().perform();
////        success = true;
//
//        tempWebElement = driver.findElement(byLocator);
////
////        new Actions(driver)
//////                .scrollToElement(element)
////                .moveToElement(tempWebElement)
////                .click()
////                .build()
////                .perform();
////
////        boolean one = isElementVisible(byLocator);
////        boolean two = driver.findElement(byLocator).isDisplayed();
////        boolean three = driver.findElement(byLocator).isEnabled();
////
////
//////
//////        if (!isElementVisible(byLocator)) {
////////          var element = findElement(byLocator, SyncType.VISIBLE,
////////                  "Failed to find element to be scroll " + "into view");
//////          JavascriptExecutor js = (JavascriptExecutor) driver;
//////          js.executeScript("arguments[0].scrollIntoView(true);", tempWebElement);
//////        }
//////
//////        if (!isElementVisible(byLocator)) {
////////          var element = findElement(byLocator, SyncType.VISIBLE,
////////                  "Failed to find element to be scroll " + "into view");
//////          JavascriptExecutor js = (JavascriptExecutor) driver;
//////          js.executeScript("arguments[0].scrollIntoView(false);", tempWebElement);
//////        }
//////
//////        if (!isElementVisible(byLocator)) {
////////          var element = findElement(byLocator, SyncType.VISIBLE,
////////                  "Failed to find element to be scroll " + "into view");
//////          JavascriptExecutor js = (JavascriptExecutor) driver;
//////          js.executeScript("arguments[0].scrollIntoView(true);", tempWebElement);
//////        }
//
//        return;
//
//
//      } catch (Exception exception) {
//
//        exceptionCaughtCount++;
//        if (exceptionCaughtCount == 100) {
//          throw new CustomE2eException(byLocator + " - Exception caught;\n" + exception.getMessage());
//        }
////        NoThrowSleep(Duration.ofMillis(100));
//      }
//
//    } while (!success);
//
//
//  }

  //This one is for EIS because scrollIntoView doesn't work for EIS.
  public void scrollElementIntoCenterOfScreen(By byLocator) throws CustomE2eException {
    var element = findElement(byLocator, SyncType.VISIBLE,
            "Failed to find element to be scroll " + "into view");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
  }

  private String getAttribute_Internal(Boolean treatNotFoundAsEmpty, By element,
                                       String attributeName, String problemMessage) throws CustomE2eException {
    return RetryOnStaleElementException(3, () -> {
      try {
        var webElement = findElement(element, SyncType.VISIBLE, problemMessage);
        return webElement.getAttribute(attributeName);
      } catch (TimeoutException exception) {
        if (treatNotFoundAsEmpty) {
          return "NoValue";
        }
        throw exception;
      }
    }, problemMessage);
  }

  private String getAttribute_InternalNotEmpty(Boolean treatNotFoundAsEmpty, By element,
                                               String attributeName, String problemMessage) throws CustomE2eException {
    return RetryOnStaleElementException(3, () -> {
      try {
        var webElement = findElement(element, SyncType.VISIBLE, problemMessage);
        var vValue = webElement.getAttribute(attributeName);
        if (vValue.isEmpty()){
          //retry once
          webElement = findElement(element, SyncType.VISIBLE, problemMessage);
          vValue = webElement.getAttribute(attributeName);
        }
        return vValue;
      } catch (TimeoutException exception) {
        if (treatNotFoundAsEmpty) {
          return "NoValue";
        }
        throw exception;
      }
    }, problemMessage);
  }


  public String getAttribute(By byLocator, String attributeName, String problemMessage) throws CustomE2eException {
    return getAttribute_Internal(false, byLocator, attributeName, problemMessage);
  }

  public String getAttributeNotEmpty(By byLocator, String attributeName, String problemMessage) throws CustomE2eException {
    return getAttribute_InternalNotEmpty(false, byLocator, attributeName, problemMessage);
  }

  public String getAttributeNotPresetBecomesEmpty(By element, String attributeName,
                                                  String problemMessage) throws CustomE2eException {
    return getAttribute_Internal(true, element, attributeName, problemMessage);
  }

  public String getText(By byLocator, String problemMessage) throws CustomE2eException {
    return getText_Internal(false, byLocator, problemMessage);
  }

  public String getTextNotPresetBecomesEmpty(By element, String problemMessage) throws CustomE2eException {
    return getText_Internal(true, element, problemMessage);
  }


  private String getText_Internal(Boolean treatNotFoundAsEmpty, By element,
                                  String problemMessage) throws CustomE2eException {


    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      return getText_InternalAlt(treatNotFoundAsEmpty, element, problemMessage);
    } else {

      return RetryOnStaleElementException(3, () -> {
        try {
          var webElement = findElement(element, SyncType.VISIBLE, problemMessage);
          return webElement.getText().trim();
        } catch (TimeoutException exception) {
          if (treatNotFoundAsEmpty) {
            return "";
          }
          throw exception;
        }
      }, problemMessage);

    }

  }

  private String getText_InternalAlt(Boolean treatNotFoundAsEmpty, By byLocator,
                                     String problemMessage) throws CustomE2eException {

    WebElement webElement = null;

    int exceptionCaughtCount = 0;
    boolean success = false;
    do {

      try {
        webElement = findElement(byLocator, SyncType.VISIBLE, problemMessage);
        success = true;
      } catch (TimeoutException exception) {
        if (treatNotFoundAsEmpty) {
          return "";
        }
        throw exception;
      } catch (Exception exception) {

        exceptionCaughtCount++;
        if (exceptionCaughtCount == 100) {
          throw new CustomE2eException(problemMessage + ";\n\nException message;\n\n" + exception.getMessage());
        }
        NoThrowSleep(Duration.ofMillis(100));
      }
    } while(!success);



    return webElement.getText().trim();

  }

  public String tryGetText(By element) {
    try {
      return getText(element, "").trim();
    } catch (CustomE2eException e) {
      return null;
    }
  }


//  public String getAttribute(WebElement webElement, String attributeName) {
//    return webElement.getAttribute(attributeName);
//  }

  public void refreshPage() {
    driver.navigate().refresh();
  }

  public void navigateTo(String url) {
    driver.navigate().to(url);
  }

  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  public ArrayList<String> getTextAllWebElementMatchingLocator(By byLocator) throws CustomE2eException {
    List<WebElement> listOfElement = new ArrayList<>();
    ArrayList<String> listOfValues = new ArrayList<>();
    try {
//      waitForPageLoad();
//      NoThrowSleep(Duration.ofSeconds(10));
//      waitForElement2(byLocator, SyncType.VISIBLE, 40000L);
      waitForElement2(byLocator, SyncType.VISIBLE, 10000L);
      listOfElement = getElementsMatchingToLocator(byLocator);
      for (var value : listOfElement) {
        listOfValues.add(value.getText().trim());
      }
    } catch (Exception e){
      throw new CustomE2eException("Failed to get text of all matching locator. Error message ".concat(e.getMessage()));
    }
    return listOfValues;
  }
}
