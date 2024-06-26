package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import activities.CreateClientOnEis;
import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.Map;

import static activities.CommonControlDataDefns.*;


public class EisClientCreationStepDefinition extends CdlEisHelpers {
  public static final String MAIN_TELEPHONE_NUMBER = "MainTelephoneNumber";

  EisHelpers eisHelpers;
  EisGeneralStepDefinitions eisGeneralStepDefinitions;

  public EisClientCreationStepDefinition(WebDriver pDriver,
                                         PageObjects.EisModel.Root pageObjectOfEis) {
    super(pDriver, pageObjectOfEis);
    eisHelpers = new EisHelpers(pDriver, pageObjectOfEis);
    eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pDriver, pageObjectOfEis);
  }

  public void saveAndExitClientPage() throws CustomE2eException {
    RetryOnClickInterceptedException(10,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().SAVE_AND_EXIT(), SyncType.CLICKABLE));
  }

  public void cancelClientPage() throws CustomE2eException {
    RetryOnClickInterceptedException(10,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().CANCEL(),
            SyncType.CLICKABLE));
    waitForElement2(this.pageObjectOfEis.getEisClientCreationLocatorModel().LOST_DATA_POP_UP_YES(), SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);
    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().LOST_DATA_POP_UP_YES(),
        SyncType.CLICKABLE);
  }

  public String getClientNumberAlt()  {

    try {

      return getText(this.pageObjectOfEis.getEisClientCreationLocatorModel().CLIENT_NUMBER()).replace("#", "");

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public String getClientNumber() throws CustomE2eException {

    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      return getClientNumberAlt();
    } else {

      if (isElementVisible(this.pageObjectOfEis.getEisClientCreationLocatorModel().DUPLICATE_CLIENT_MESSAGE())
              && getText(this.pageObjectOfEis.getEisClientCreationLocatorModel().DUPLICATE_CLIENT_MESSAGE())
                  .equalsIgnoreCase("We've identified potential duplicate customers shown below.")
      ) {
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().CLOSE_CONFIRMATION_MESSAGE(), SyncType.CLICKABLE);
        RetryOnClickInterceptedException(10,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().CANCEL_MERGE_CLIENT(), SyncType.CLICKABLE));
        clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().ACCEPT_CANCEL_MERGE(),
                SyncType.CLICKABLE);
//      ##DO NOT DELETE
//      var numberOfClientNumber =
//          getTextAllWebElementMatchingLocator(this.pageObjectOfEis
//          .getEisClientCreationLocatorModel().POTENTIAL_DUPLICATE_CLIENT_NUMBERS());
//      for (var clientNumber : numberOfClientNumber) {
//        clickElement(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel()
//        .SELECT_CLIENT(), clientNumber),
//            SyncType.CLICKABLE);
//        clickElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().NEXT_PAGE(),
//        SyncType.CLICKABLE);
//      }
//      throw new CustomE2eException("Cclient already existed.");
      }
      waitForElement2(this.pageObjectOfEis.getEisClientCreationLocatorModel().CLIENT_NUMBER(),
              SyncType.VISIBLE, eisGeneralStepDefinitions.waitDuration);
      return getText(this.pageObjectOfEis.getEisClientCreationLocatorModel().CLIENT_NUMBER()).replace("#", "");
    }
  }

  public void enterDetails(Map<String, Object> salesDetails) throws CustomE2eException,
      ParseException {
    selectGeneralInformation((Map<String, Object>) salesDetails.get(CreateClientOnEis.PROPOSER_PERSONAL_DET), (String) ((Map<String, Object>) salesDetails.get(CreateClientOnEis.QUOTE_DETAILS)).get(CreateClientOnEis.BRAND));
    enterContactDetails((Map<String, Object>) salesDetails.get(CreateClientOnEis.PROPOSER_CONTACT_DET));
    enterMarketingDetails((Map<String, Object>) salesDetails.get(MARKETING_CHOICE_VAR));
  }

  private void enterMarketingDetails(Map<String, Object> marketingDetails) throws CustomE2eException {
    var smsMarketingChoice =
        marketingDetails.get(MARKETING_CHOICE_SMS_VAR);
    var emailMarketingChoice =
        marketingDetails.get(MARKETING_CHOICE_EMAIL_VAR);
    var postalMarketingChoice =
        marketingDetails.get(MARKETING_CHOICE_POSTAL_VAR);
    var telephoneMarketingChoice =
        marketingDetails.get(MARKETING_CHOICE_TELEPHONE_VAR);

    if (smsMarketingChoice instanceof String) {
      smsMarketingChoice = Boolean.parseBoolean((String) smsMarketingChoice);
    }
    if (emailMarketingChoice instanceof String) {
      emailMarketingChoice = Boolean.parseBoolean((String) emailMarketingChoice);
    }
    if (postalMarketingChoice instanceof String) {
      postalMarketingChoice = Boolean.parseBoolean((String) postalMarketingChoice);
    }
    if (telephoneMarketingChoice instanceof String) {
      telephoneMarketingChoice = Boolean.parseBoolean((String) telephoneMarketingChoice);
    }


////    scrollElementIntoCenterOfScreen(this.pageObjectOfEis.getEisClientCreationLocatorModel().ADD_NEW_EMAIL());
//    smsMarketingChoices((Boolean) smsMarketingChoice);
//    emailMarketingChoice((Boolean) emailMarketingChoice);
//    postalMarketingChoice((Boolean) postalMarketingChoice);
//    telephoneMarketingChoice((Boolean) telephoneMarketingChoice);

    clickElementThenTypeTextInInput(CommonHelper.convertBooleanIntoString(smsMarketingChoice), this.pageObjectOfEis.getEisClientCreationLocatorModel().SMS_MARKETING_CHOICE());
    clickElementThenTypeTextInInput(CommonHelper.convertBooleanIntoString(emailMarketingChoice), this.pageObjectOfEis.getEisClientCreationLocatorModel().EMAIL_MARKETING_CHOICE());
    clickElementThenTypeTextInInput(CommonHelper.convertBooleanIntoString(postalMarketingChoice), this.pageObjectOfEis.getEisClientCreationLocatorModel().POST_MARKETING_CHOICE());
    clickElementThenTypeTextInInput(CommonHelper.convertBooleanIntoString(telephoneMarketingChoice), this.pageObjectOfEis.getEisClientCreationLocatorModel().TELEPHONE_MARKETING_CHOICE());


  }


  private void clickElementThenTypeTextInInput(String textToType, By byLocator) throws CustomE2eException {

      WebElement tempWebElement =
              clickElement(byLocator, SyncType.CLICKABLE);

      var elementXpathStringArray = tempWebElement.toString().split(" -> xpath: ");
      var byLocatorXpathString = elementXpathStringArray[1].substring(0, elementXpathStringArray[1].length() - 1);

      typeText(
              By.xpath(byLocatorXpathString.concat("//input")),
              textToType,
              SyncType.CLICKABLE,
              false,
              true,
              "typeText in method clickElementThenTypeTextInInput failed"
      );
  }


  private void enterContactDetails(Map<String, Object> proposerPersonalDetails) throws CustomE2eException {
    Map<String, String> correspondenceAddress =
            (Map<String, String>) proposerPersonalDetails.get(CORRESPONDENCE_ADDRESS);

    String postcode = correspondenceAddress.get(POST_CODE_VAR);
    String houseIdentifier = correspondenceAddress.get(HOUSE_IDENTIFIER);

    clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().ADD_NEW_ADDRESS(),
        SyncType.CLICKABLE);


    // Loop?

    typeText(this.pageObjectOfEis.getEisClientCreationLocatorModel().POST_CODE(), postcode,
        SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEis.getEisClientCreationLocatorModel().LIST_POST_CODE(),
        SyncType.CLICKABLE, eisGeneralStepDefinitions.waitDuration);



    By tempBy = By.xpath("//span[contains(@id, 'auto-complete-container')]//li[starts-with(text(), '"
                    + houseIdentifier
                    + " ')]"
    );

    clickElement(tempBy, SyncType.CLICKABLE);

    clickElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().CONFIRM_BUTTON(),
            SyncType.CLICKABLE);

    if (Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().ADD_NEW_PHONE(), SyncType.CLICKABLE);
    } else {
      RetryOnClickInterceptedException(50,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().ADD_NEW_PHONE(), SyncType.CLICKABLE));
    }


      if (!Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      RetryOnClickInterceptedException(50,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().ADD_NEW_PHONE(), SyncType.CLICKABLE));
      }

    typeText(this.pageObjectOfEis.getEisClientCreationLocatorModel().PHONE_NUMBER(),
        proposerPersonalDetails.get(EisClientCreationStepDefinition.MAIN_TELEPHONE_NUMBER),
        SyncType.CLICKABLE);
    clickElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().CONFIRM_BUTTON(),
            SyncType.CLICKABLE);


    if (!Boolean.valueOf(Utils.getProperty("SKIP_DEEP_SYNC_MEASURES", "false"))) {
      RetryOnClickInterceptedException(10,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisClientCreationLocatorModel().ADD_NEW_EMAIL(), SyncType.CLICKABLE));
    } else {
      clickElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().ADD_NEW_EMAIL(), SyncType.CLICKABLE);
    }

    typeText(this.pageObjectOfEis.getEisClientCreationLocatorModel().EMAIL(),
        proposerPersonalDetails.get(EMAIL_ADDRESS),
        SyncType.CLICKABLE);
    clickElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().CONFIRM_BUTTON(),
            SyncType.CLICKABLE);

  }

  private void selectGeneralInformation(Map<String, Object> clientDetails, String brandDet) throws CustomE2eException, ParseException {
    brandDet = Formatting.addSpacesAfterCapital(brandDet);

    if (brandDet.equalsIgnoreCase(CreateClientOnEis.AGEAS)) {
      // TODO James 01/05/2024 - Had to remove this as brand in ui is AGEAS
      // brandDet = Formatting.addSpacesAfterCapital(CreateClientOnEis.AGEAS_DIRECT);
    } else if (brandDet.equalsIgnoreCase(CreateClientOnEis.RIAS)) {
      brandDet = Formatting.addSpacesAfterCapital(CreateClientOnEis.RIAS);
    }

    clickElementThenTypeTextInInput(
            brandDet,
            this.pageObjectOfEis.getEisClientCreationLocatorModel().BRAND_DROP_DOWN()
    );


    clickElementThenTypeTextInInput(
            String.valueOf(clientDetails.get(TITLE)),
            this.pageObjectOfEis.getEisClientCreationLocatorModel().TITLE_TEXT_FIELD()
    );


//    driver.findElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().FIRST_NAME())
//            .sendKeys((CharSequence) clientDetails.get(FIRST_NAME_VAR));
//    driver.findElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().LAST_NAME())
//            .sendKeys((CharSequence) clientDetails.get(LAST_NAME_VAR));

    typeText(this.pageObjectOfEis.getEisClientCreationLocatorModel().FIRST_NAME(),
            clientDetails.get(FIRST_NAME_VAR),
            SyncType.CLICKABLE
    );

    typeText(this.pageObjectOfEis.getEisClientCreationLocatorModel().LAST_NAME(),
            clientDetails.get(LAST_NAME_VAR),
            SyncType.CLICKABLE
    );

    selectDateOfBirth((String) clientDetails.get(CommonControlDataDefns.DATE_OF_BIRTH));

    clickElement(this.pageObjectOfEis.getEisClientCreationLocatorModel().GENDER(), SyncType.PRESENT);

    clickElement(xpathBuilder(this.pageObjectOfEis.getEisClientCreationLocatorModel().GENDER_SELECTION(),
            Formatting.addSpacesAfterCapital((String) clientDetails.get(GENDER))),
            SyncType.PRESENT
    );


    clickElementThenTypeTextInInput(
            Formatting.addSpacesAfterCapital((String) clientDetails.get(MARITAL_STATUS_VAR)),
            this.pageObjectOfEis.getEisClientCreationLocatorModel().MARTIAL()
    );
  }

  private void selectDateOfBirth(String dateOfBirth) throws CustomE2eException, ParseException {
    eisHelpers.datePicker(dateOfBirth);
  }
}
