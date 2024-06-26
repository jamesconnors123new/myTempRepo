package helpers;

import Generic.customExceptions.CustomE2eException;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

public class EisHelpers extends SeleniumHelper {
  PageObjects.EisModel.Root pageObjectOfEis;

  public EisHelpers(WebDriver pDriver, PageObjects.EisModel.Root pageObjectOfEis) {
    super(pDriver);
    this.pageObjectOfEis = pageObjectOfEis;
  }

  private final long waitDuration = 60000L;

  public void datePickerAlt(String dateOfBirth) throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().DATE_OF_BIRTH(), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEis.getEisClientCreationLocatorModel().DATE_OF_BIRTH_INPUT(), dateOfBirth, SyncType.PRESENT, false, true, "enter dob text failed");
  }


  public void datePicker(String dateOfBirth) throws CustomE2eException, ParseException {

    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      datePickerAlt(dateOfBirth);
    } else {

      var fullDateOfBirth = Formatting.changeDateFormatIntoExpected(dateOfBirth, "dd/MM/yyyy",
              "d " + "MMMM yyyy");
      var yearOfBirth = dateOfBirth.split("/")[2];
      var monthOfBirth = Formatting.covertNumberIntoMonths(Integer.parseInt(dateOfBirth.split("/")[1]));
      waitForElement2(this.pageObjectOfEis.getEisClientCreationLocatorModel().DATE_OF_BIRTH(),
              SyncType.CLICKABLE, waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().DATE_OF_BIRTH(), SyncType.CLICKABLE);
      waitForElement2(this.pageObjectOfEis.getEisClientCreationLocatorModel().DATE_OF_BIRTH_INPUT(),
              SyncType.CLICKABLE,
              waitDuration);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().DOB_YEAR(),
              SyncType.VISIBLE);
      int prevYears = 0;
      do {
        var listOfYear =
                getTextAllWebElementMatchingLocator(this.pageObjectOfEis.getEisClientCreationLocatorModel().LIST_OF_YEARS_TO_SELECT());
        if (listOfYear.contains(yearOfBirth)) {
          waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel().CHOOSE_YEAR(),
                          String.valueOf(yearOfBirth)),
                  SyncType.CLICKABLE, waitDuration);
          clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel().CHOOSE_YEAR(),
                  String.valueOf(yearOfBirth)), SyncType.CLICKABLE);
          waitForElement2(this.pageObjectOfEis.getEisClientCreationLocatorModel().CHOOSE_MONTH(),
                  SyncType.CLICKABLE, waitDuration);
          if (!getText(this.pageObjectOfEis.getEisClientCreationLocatorModel().CHOOSE_MONTH()).equalsIgnoreCase(monthOfBirth)) {
            RetryOnClickInterceptedException(3,
                    () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().CHOOSE_MONTH(),
                            SyncType.CLICKABLE));
            waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel().SELECT_MONTH(), monthOfBirth), SyncType.CLICKABLE, waitDuration);
            RetryOnClickInterceptedException(3,
                    () -> clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel().SELECT_MONTH(), monthOfBirth),
                            SyncType.CLICKABLE));
          }
          waitForElement2(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel().DATE_SELECTION(),
                  fullDateOfBirth), SyncType.CLICKABLE, waitDuration);
          clickElementRetryX3onClickIntEx(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel().DATE_SELECTION(),
                  fullDateOfBirth), SyncType.CLICKABLE);
          break;
        } else {
          waitForElement2(this.pageObjectOfEis.getEisClientCreationLocatorModel().PREV_YEARS(),
                  SyncType.VISIBLE, waitDuration);
          clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().PREV_YEARS(),
                  SyncType.VISIBLE);
          prevYears++;
        }
      } while (prevYears <= 10);
    }
  }
}
