package StepDefinitions;


import Generic.customExceptions.CustomE2eException;
import helpers.*;
import org.openqa.selenium.*;
import sqc.bstof.skeletonhelp.LocalActionRecordingServices;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

public class EchelonQuoteCreationsStepDefinition extends CdlEchelonHelpers {
  private final long waitDuration = 120000L;
  private final CommonHelper CommonHelper;

  public EchelonQuoteCreationsStepDefinition(WebDriver driver,
                                             PageObjects.EchelonModel.Root echelonModelRoot) {
    super(driver, echelonModelRoot);
    this.CommonHelper = new CommonHelper(driver);
  }

  // ----- HOME SECTION - BEGINNING ----- //
  public void newHouseHoldQuotesDetails(Map<String, Object> houseQuotesDetails) throws CustomE2eException, ParseException {
    selectAffinity((String) houseQuotesDetails.get("Affinity"));
    selectInceptionDate((String) houseQuotesDetails.get("InceptionDate"));
  }

  public String getMatchingValueStartWithFromDropDown(By byLocator, String value) throws CustomE2eException {
    String matchingVal = null;
    var options = getAllValuesFromDropDown(byLocator, "selectDropdown failed");
    for (var currVal : options) {
      if (currVal.getText().toLowerCase().startsWith(value.toLowerCase())) {
        matchingVal = currVal.getText();
        break;
      }
    }
    return matchingVal;
  }

  private void selectAffinity(String affinity) throws CustomE2eException {
    var value =
            getMatchingValueStartWithFromDropDown(this.pageObjectOfEchelon.getNewHouseHoldLocatorModel().AFFINITY(), affinity);
    RetryOnException("selectAffinity", CustomE2eException.class, 500L, 50,
            () -> selectDropdown(this.pageObjectOfEchelon.getNewHouseHoldLocatorModel().AFFINITY(),
                    value, SelectOptions.TEXT));
  }

  public void selectTypeOfHouseholdCover(Map<String, Object> typeOfHouseHoldCover) throws CustomE2eException {
    if (typeOfHouseHoldCover.get("Buildings").equals(true) && typeOfHouseHoldCover.get("Contents").equals(true)) {
      selectDropdown(this.pageObjectOfEchelon.getNewHouseHoldLocatorModel().HOUSE_HOLD_COVER(), 1
              , SelectOptions.INDEX);
    } else if (typeOfHouseHoldCover.get("Buildings").equals(true)) {
      selectDropdown(this.pageObjectOfEchelon.getNewHouseHoldLocatorModel().HOUSE_HOLD_COVER(), 2
              , SelectOptions.INDEX);
    } else {
      selectDropdown(this.pageObjectOfEchelon.getNewHouseHoldLocatorModel().HOUSE_HOLD_COVER(), 3
              , SelectOptions.INDEX);
    }
  }

  public void redirectToNextPage() throws CustomE2eException {
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonSharedLocatorModel().NEXT_PAGE_ECHELON(),
            SyncType.CLICKABLE);
  }

  private void selectInceptionDate(String inceptionDate) throws ParseException, CustomE2eException {
    typeText(this.pageObjectOfEchelon.getNewHouseHoldLocatorModel().INCEPTION_DATE(),
            Formatting.changeDateFormatIntoExpected(inceptionDate, "dd/MM/yyyy", "dd-MMM-yyyy"),
            SyncType.CLICKABLE, true, false,  "");

  }

  public void proposerPersonalDetails(Map<String, Object> personalDetails) throws CustomE2eException, ParseException {
    waitForPageLoad();
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSER_SURNAME(),
            personalDetails.get("LastName"), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSER_FORENAME(),
            personalDetails.get("FirstName"), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSER_GENDER(), personalDetails.get("Gender"), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSE_MARITAL_STATUS(), personalDetails.get("MaritalStatus"), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSE_TITLE()
            , personalDetails.get("Title"), SelectOptions.TEXT);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSE_DATE_OF_BIRTH(), Formatting.changeDateFormatIntoExpected((String) personalDetails.get("DateOfBirth"), "dd/MM/yyyy", "dd-MMM-yyyy"), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSE_UK_RESIDENT_SINCE(), Formatting.changeDateFormatIntoExpected((String) personalDetails.get("UkResidentSince"), "dd/MM/yyyy", "dd-MMM-yyyy"), SyncType.CLICKABLE);

  }

  public void employmentDetails(Map<String, Object> employmentDetails) throws CustomE2eException {
    selectEmploymentStatus((Map<String, Object>) employmentDetails.get("PrimaryEmploymentStatus"));
    selectPartTimeEmploymentStatus((Map<String, Object>) employmentDetails.get(
            "SecondaryEmploymentStatus"));
  }

  public void employmentDetailsMotor(Map<String, Object> employmentDetails) throws CustomE2eException {
    selectEmploymentStatusMotor((Map<String, Object>) employmentDetails.get("PrimaryEmploymentStatus"));
    selectPartTimeEmploymentStatusMotor((Map<String, Object>) employmentDetails.get(
            "SecondaryEmploymentStatus"));
  }

  private void selectEmploymentStatusMotor(Map<String, Object> primaryEmploymentStatus) throws CustomE2eException {
    if (primaryEmploymentStatus.get("Employed").equals(true)) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().EMP_OCCUPATION_DET(), primaryEmploymentStatus.get("Type"), SyncType.CLICKABLE, false);
//      RetryOnException("selectEmploymentStatus-A", WebDriverException.class, 100, 2,
//              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().EMP_EMP_STATUS(), primaryEmploymentStatus.get("Category"), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().EMP_INDUSTRY(),
              primaryEmploymentStatus.get("Industry"), SyncType.CLICKABLE, false);
//      RetryOnException("selectEmploymentStatus-B", WebDriverException.class, 100, 2,
//              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
    }
  }

  private void selectPartTimeEmploymentStatusMotor(Map<String, Object> secondaryEmploymentStatus) throws CustomE2eException {
    if (secondaryEmploymentStatus.get("Employed").equals(true)) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PART_TIME_OCCUPATION(), secondaryEmploymentStatus.get("Type"), SyncType.CLICKABLE, false);
//      RetryOnException("selectPartTimeEmploymentStatus-A", WebDriverException.class, 100, 2,
//              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PART_TIME_EMP_STATUS(), secondaryEmploymentStatus.get("Category"), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PART_TIME_INDUSTRY(), secondaryEmploymentStatus.get("Industry"), SyncType.CLICKABLE, false);
//      RetryOnException("selectPartTimeEmploymentStatus-B", WebDriverException.class, 100, 2,
//              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
    }
  }

  public Boolean Match_NotInteract_NoSuchElm(Exception pEx) {
    return pEx.getClass().equals(ElementNotInteractableException.class) || pEx.getClass().equals(NoSuchElementException.class);
  }

  private void selectPartTimeEmploymentStatus(Map<String, Object> secondaryEmploymentStatus) throws CustomE2eException {
    if (secondaryEmploymentStatus.get("Employed").equals(true)) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PART_TIME_OCCUPATION(), secondaryEmploymentStatus.get("Type"), SyncType.CLICKABLE, false);
      RetryOnException("selectPartTimeEmploymentStatus-A", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PART_TIME_EMP_STATUS(), secondaryEmploymentStatus.get("Category"), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PART_TIME_INDUSTRY(), secondaryEmploymentStatus.get("Industry"), SyncType.CLICKABLE, false);
      RetryOnException("selectPartTimeEmploymentStatus-B", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
    }
  }

  private void selectEmploymentStatus(Map<String, Object> primaryEmploymentStatus) throws CustomE2eException {
    if (primaryEmploymentStatus.get("Employed").equals(true)) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().EMP_OCCUPATION_DET(), primaryEmploymentStatus.get("Type"), SyncType.CLICKABLE, false);
      RetryOnException("selectEmploymentStatus-A", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().EMP_EMP_STATUS(), primaryEmploymentStatus.get("Category"), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().EMP_INDUSTRY(),
          primaryEmploymentStatus.get("Industry"), SyncType.CLICKABLE, false);
      RetryOnException("selectEmploymentStatus-B", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
    }
  }

  private void selectJphPartTimeEmploymentStatus(Map<String, Object> secondaryEmploymentStatus) throws CustomE2eException {
    if (secondaryEmploymentStatus.get("Employed").equals(true)) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_PART_TIME_OCCUPATION(), secondaryEmploymentStatus.get("Type"), SyncType.CLICKABLE, false);
      RetryOnException("selectJphPartTimeEmploymentStatus-A", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_PART_TIME_EMP_STATUS(), secondaryEmploymentStatus.get("Category"), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_PART_TIME_INDUSTRY(), secondaryEmploymentStatus.get("Industry"), SyncType.CLICKABLE, false);
      RetryOnException("selectJphPartTimeEmploymentStatus-B", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
    }
  }

  private void selectJphEmploymentStatus(Map<String, Object> primaryEmploymentStatus) throws CustomE2eException {
    if (primaryEmploymentStatus.get("Employed").equals(true)) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_EMP_OCCUPATION_DET(), primaryEmploymentStatus.get("Type"), SyncType.CLICKABLE, false);
      RetryOnException("selectJphEmploymentStatus-A", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_EMP_EMP_STATUS(), primaryEmploymentStatus.get("Category"), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_EMP_INDUSTRY(),
          primaryEmploymentStatus.get("Industry"), SyncType.CLICKABLE, false);
      RetryOnException("selectJphEmploymentStatus-B", WebDriverException.class, 100, 2,
              () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OPTION(), SyncType.CLICKABLE), (x) -> Match_NotInteract_NoSuchElm(x));
    }
  }

  public void contactAddress(Map<String, Object> proposerContactDetails,
                             String preferredDelivery) throws CustomE2eException {
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().POST_CODE(),
            ((Map<String, Object>) proposerContactDetails.get("CorrespondenceAddress")).get("Postcode"
            ), SyncType.CLICKABLE);
    RetryOnException("contactAddress-A", ElementNotInteractableException.class, 100, 2,
            () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().FIND_ADDRES(), SyncType.CLICKABLE));
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOUSE_INDENTIFIER(),
            ((Map<String, Object>) proposerContactDetails.get("CorrespondenceAddress")).get(
                    "HouseIdentifier"), SyncType.CLICKABLE);
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().UPDATE_RISK_ADDRESS(), SyncType.CLICKABLE, waitDuration);
    RetryOnException("contactAddress-A", ElementNotInteractableException.class, 100, 2,
            () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().UPDATE_RISK_ADDRESS(), SyncType.CLICKABLE));
    enterContactDetails((String) proposerContactDetails.get("MainTelephoneNumber"));
    enterEmailDetails((String) proposerContactDetails.get("EmailAddress"), preferredDelivery);
  }


  public void contactAddressMotor(Map<String, Object> proposerContactDetails,
                                  String preferredDelivery) throws CustomE2eException {
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().POST_CODE(),
            ((Map<String, Object>) proposerContactDetails.get("CorrespondenceAddress")).get("Postcode"
            ), SyncType.CLICKABLE);
    RetryOnException("contactAddress-A", ElementNotInteractableException.class, 100, 2,
            () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().FIND_ADDRES(), SyncType.CLICKABLE));
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOUSE_INDENTIFIER(),
            ((Map<String, Object>) proposerContactDetails.get("CorrespondenceAddress")).get(
                    "HouseIdentifier"), SyncType.CLICKABLE);
//    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().UPDATE_RISK_ADDRESS(), SyncType.CLICKABLE, waitDuration);
//    RetryOnException("contactAddress-A", ElementNotInteractableException.class, 100, 2,
//            () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().UPDATE_RISK_ADDRESS(), SyncType.CLICKABLE));

    enterContactDetails((String) proposerContactDetails.get("MainTelephoneNumber"));
    enterEmailDetails((String) proposerContactDetails.get("EmailAddress"), preferredDelivery);
  }

  public void enterEmailDetails(String emailAddress, String preferredDelivery) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PREFFERED_DELIVERY(), SyncType.CLICKABLE, waitDuration);
    RetryOnClickInterceptedException(10,
            () -> selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PREFFERED_DELIVERY(), preferredDelivery, SelectOptions.TEXT));
    RetryOnException("PROPOSER_EMAIL", StaleElementReferenceException.class, 500L, 50,
            () -> typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSER_EMAIL(), emailAddress, SyncType.VISIBLE));
  }

  public void enterContactDetails(String mainTelephoneNumber) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONTACT_TYPE(), SyncType.CLICKABLE, waitDuration);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONTACT_TYPE(),
            4, SelectOptions.INDEX);
    NoThrowSleep(Duration.ofMillis(300L));
    RetryOnStaleElementException(10,
            () -> typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONTACT_INPUT_FIELD(), mainTelephoneNumber, SyncType.CLICKABLE), "Enter contact details");
//    try {
//      RetryOnStaleElementException(10, () -> typeText(this.pageObjectOfEchelon
//      .getEchelonQuoteCreationLocatorModel().CONTACT_INPUT_FIELD(), mainTelephoneNumber,
//      SyncType.CLICKABLE),"Enter contact details");
//    } catch (CustomE2eException ex) {
//      RetryOnException(CustomE2eException.class, 500L, 50,
//          ()-> typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel()
//          .CONTACT_INPUT_FIELD(),
//              mainTelephoneNumber, SyncType.CLICKABLE));
//    }
  }
//
//  public void mainBuildingDetails(Map<String, Object> mainBuildingDetails, String ownerShip) throws CustomE2eException {
//    //Sarah added logic to align building type and structure type to EIS and Quote and Buy
//    String BuildingType = (String) mainBuildingDetails.get("BuildingType");
//    if (BuildingType.equals("Self Contained Flat")  || BuildingType.equals("Maisonette")) {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//              , "Self Contained Flat", SelectOptions.TEXT);
//    } else if (BuildingType.equals("Town House")) {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//              , "Townhouse", SelectOptions.TEXT);
//    } else {
//      String StructureType = (String) mainBuildingDetails.get("StructureType");
//      if (StructureType.contains("Terraced")) {
//        selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//                , "Terraced", SelectOptions.TEXT);
//      }
//      if (StructureType.equals("Detached")) {
//        switch (BuildingType) {
//          case "Bungalow":
//            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//                    , "Detached Bungalow", SelectOptions.TEXT);
//            break;
//          case "House":
//            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//                    , "Detached", SelectOptions.TEXT);
//            break;
//        }
//      }
//      if (StructureType.equals("Semi-Detached")) {
//        switch (BuildingType) {
//          case "Bungalow":
//            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//                    , "Semi Detached Bungalow", SelectOptions.TEXT);
//            break;
//          case "House":
//            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//                    , "Semi-Detached", SelectOptions.TEXT);
//            break;
//        }
//      }
//    }
//
//
//    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//        , mainBuildingDetails.get("BuildingType"), SelectOptions.TEXT);
//    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONSTRUCTION_TYPE(), mainBuildingDetails.get("ConstructionType"), SelectOptions.TEXT);
//    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().YEAR_BUILT(),
//        mainBuildingDetails.get("YearBuilt"), SyncType.CLICKABLE);
//    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_BEDROOM(),
//        mainBuildingDetails.get("NumberOfBedrooms"), SyncType.CLICKABLE);
//    //Sarah added mapping logic for ownership to align with QnB and EIS
//
//    if (ownerShip.contains("Outright") || ownerShip.contains("Mortage"))
//    {
//      ownerShip = "Owned";
//    }
//    if (ownerShip.contains("Housing") || ownerShip.contains ("Council") || ownerShip.contains ("Private") )
//    {
//      ownerShip = "Rented";
//    }
//
//    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OWNERSHIP(),
//        ownerShip, SelectOptions.TEXT);
//  }

    public void mainBuildingDetails(Map<String, Object> mainBuildingDetails, String ownerShip) throws CustomE2eException {
        //Sarah added logic to align building type and structure type to EIS and Quote and Buy
        String BuildingType = (String) mainBuildingDetails.get("BuildingType");
        if (BuildingType.equals("Self Contained Flat")  || BuildingType.equals("Maisonette")) {
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
                    , "Self Contained Flat", SelectOptions.TEXT);
        } else if (BuildingType.equals("Town House")) {
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
                    , "Townhouse", SelectOptions.TEXT);
        } else {
            String StructureType = (String) mainBuildingDetails.get("StructureType");
            if (StructureType.contains("Terraced")) {
                selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
                        , "Terraced", SelectOptions.TEXT);
            }
            if (StructureType.equals("Detached")) {
                switch (BuildingType) {
                    case "Bungalow":
                        selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
                                , "Detached Bungalow", SelectOptions.TEXT);
                        break;
                    case "House":
                        selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
                                , "Detached", SelectOptions.TEXT);
                        break;
                }
            }
            if (StructureType.equals("Semi-Detached")) {
                switch (BuildingType) {
                    case "Bungalow":
                        selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
                                , "Semi Detached Bungalow", SelectOptions.TEXT);
                        break;
                    case "House":
                        selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
                                , "Semi-Detached", SelectOptions.TEXT);
                        break;
                }
            }
        }


//    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_TYPE()
//        , mainBuildingDetails.get("BuildingType"), SelectOptions.TEXT);
        selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONSTRUCTION_TYPE(), mainBuildingDetails.get("ConstructionType"), SelectOptions.TEXT);
        typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().YEAR_BUILT(),
                mainBuildingDetails.get("YearBuilt"), SyncType.CLICKABLE);
        typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_BEDROOM(),
                mainBuildingDetails.get("NumberOfBedrooms"), SyncType.CLICKABLE);
        //Sarah added mapping logic for ownership to align with QnB and EIS

        if (ownerShip.contains("Outright") || ownerShip.contains("Mortgage"))
        {
            ownerShip = "Owned";
        }
        if (ownerShip.contains("Housing") || ownerShip.contains ("Council") || ownerShip.contains ("Private") )
        {
            ownerShip = "Rented";
        }

        selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OWNERSHIP(),
                ownerShip, SelectOptions.TEXT);
    }

  public void structuralDetails(Map<String, Object> mainBuildingDetails) throws CustomE2eException {
    //Structural Details
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LISTING_STATUS(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) mainBuildingDetails.get("AdditionalInformation")).get("ListingStatus")), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_WORK_STATUS(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) mainBuildingDetails.get("AdditionalInformation")).get("BuildingWorkStatus")), SelectOptions.TEXT);
    selectRepairStatus((Boolean) ((Map<String, Object>) mainBuildingDetails.get(
        "AdditionalInformation")).get("GoodRepairStatus"));
    selectionOfGeologicalThreat((Boolean) ((Map<String, Object>) mainBuildingDetails.get(
        "AdditionalInformation")).get("GeologicalThreats"));
    selectionOfFlood((Boolean) ((Map<String, Object>) mainBuildingDetails.get(
        "AdditionalInformation")).get("FreeFromFloodingThreats"));
  }

  private void selectionOfGeologicalThreat(boolean geologicalThreat) throws CustomE2eException {
    if (geologicalThreat) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GEOLOGICAL_STATUS(), "No", SelectOptions.TEXT);
    } else {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GEOLOGICAL_STATUS(), "Yes", SelectOptions.TEXT);
    }
  }


  private void selectRepairStatus(boolean repairStatus) throws CustomE2eException {
    if (repairStatus) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().REPAIR_STATUS(), "Yes", SelectOptions.TEXT);
    } else {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().REPAIR_STATUS(), "No", SelectOptions.TEXT);
    }
  }

  private void selectionOfFlood(boolean answer) throws CustomE2eException {
    if (answer) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().FLOODING_THREAT(), "Yes", SelectOptions.TEXT);
    } else {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().FLOODING_THREAT(), "No", SelectOptions.TEXT);
    }
  }

  public void BuildingCover(Map<String, Object> insuredAmount,
                            Map<String, Object> typeOfHouseHoldCover) throws CustomE2eException {

    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_REBUILDING_COST(), insuredAmount.get("RebuildingCost"), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_ACCIDENTAL_DAMAGE(), this.CommonHelper.convertBooleanIntoString((Boolean) typeOfHouseHoldCover.get("BuildingAccidentalDamage")), SelectOptions.TEXT);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUILDING_VOLUNTARY_EXCESS(), insuredAmount.get("BuildingVoluntaryExcess"), SyncType.CLICKABLE);
  }

  public void interestedParties() throws CustomE2eException {
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().INTERESTED_PARTY(), this.CommonHelper.convertBooleanIntoString(false), SelectOptions.TEXT);
  }

  public void specifiedContentInHome() throws CustomE2eException {
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SPECIFIED_CONTENT(), this.CommonHelper.convertBooleanIntoString(false), SelectOptions.TEXT);
  }

  public void convictionDetails() throws CustomE2eException {
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().RTA_CONVICTION_DETAILS(), this.CommonHelper.convertBooleanIntoString(false), SelectOptions.TEXT);
  }

  public void allRisk(Boolean personalBelonging) throws CustomE2eException {

  }

  public void contentCover(Map<String, Object> insuranceDet) throws CustomE2eException {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SUM_INSURED(),
          ((Map<String, Object>) insuranceDet.get("InsuredAmount")).get("ContentSum"),
          SyncType.CLICKABLE);
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONTENT_ACCIDENTAL_DAMAGE(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) insuranceDet.get("TypeOfHouseHoldCover")).get("ContentAccidentalDamage")), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CONTENT_VOLUNTARY_EXCESS(), ((Map<String, Object>) insuranceDet.get("InsuredAmount")).get("ContentVoluntaryExcess"), SyncType.CLICKABLE);
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SAFE_INSTALLED(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) insuranceDet.get("ContentDetails")).get("Safe")), SelectOptions.TEXT);
  }

  public void usageDetails(Map<String, Object> usageDetails) throws CustomE2eException {

    //Added Logic for converting any value other than No to Yes
    String nonFamilyLodgers = (String) usageDetails.get("NonFamilyLodger");
    if(! (nonFamilyLodgers.equals("No") )) {
      nonFamilyLodgers = "Yes";
    }


    //replacement for non family lodgeres as string no longer boolean
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NON_FAMILY_LEDGERS(),
            nonFamilyLodgers, SelectOptions.TEXT);
    //selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NON_FAMILY_LEDGERS(), this.CommonHelper.convertBooleanIntoString((Boolean) usageDetails.get("NonFamilyLodger")), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LET_SUB_LET(),
        this.CommonHelper.convertBooleanIntoString((Boolean) usageDetails.get("LetWithSublet")),
        SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().BUSINESS_USE(),
        this.CommonHelper.convertBooleanIntoString((Boolean) usageDetails.get("BusinessUse")),
        SelectOptions.TEXT);
    selectHolidayHomeStatus((Boolean) usageDetails.get("HolidayHomeStatus"));
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().OCCUPANCY(),
        usageDetails.get("Occupancy"), SelectOptions.TEXT);
  }

  private void selectHolidayHomeStatus(Boolean holidayHomeStatus) throws CustomE2eException {
    if (holidayHomeStatus) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOLIDAY_HOME_STATUS(), 3, SelectOptions.INDEX);
    } else {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOLIDAY_HOME_STATUS(), 4, SelectOptions.INDEX);
    }
  }

  public void securityDetails(Map<String, Object> securityDetails) throws CustomE2eException {
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SECURITY_LOCKS(), this.CommonHelper.convertBooleanIntoString((Boolean) securityDetails.get("Locks")), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ALARMS(),
        securityDetails.get("Alarms"), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NEIGHBOURHOOD_WATCH(), this.CommonHelper.convertBooleanIntoString((Boolean) securityDetails.get("NeighbourhoodWatch")), SelectOptions.TEXT);

  }

  public void marketingChoices(Map<String, Object> marketingChoices) throws CustomE2eException {
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_POSTAL(), getMatchingValueStartWithFromDropDown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_POSTAL(), this.CommonHelper.convertBooleanIntoString((Boolean) marketingChoices.get("Postal")).substring(0, 1)), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_EMAIL(), getMatchingValueStartWithFromDropDown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_EMAIL(), this.CommonHelper.convertBooleanIntoString((Boolean) marketingChoices.get("Email")).substring(0, 1)), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_TELEPHONE(), getMatchingValueStartWithFromDropDown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_TELEPHONE(), this.CommonHelper.convertBooleanIntoString((Boolean) marketingChoices.get("Telephone")).substring(0, 1)), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_SMS()
        ,
        getMatchingValueStartWithFromDropDown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MARKETING_SMS(), this.CommonHelper.convertBooleanIntoString((Boolean) marketingChoices.get("SMS")).substring(0, 1)), SelectOptions.TEXT);
  }

  public void policyUserField(Map<String, Object> otherDetails) throws CustomE2eException {
    var value = this.CommonHelper.convertBooleanIntoString((Boolean) otherDetails.get(
        "SufferedLossNotResultedInClaim"));
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SUFFERED_LOSS()
        , value, SelectOptions.TEXT);
    //Where did you hear about us?
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SOURCE_CUSTOMER(), 3, SelectOptions.INDEX);
    waitForPageLoad();
  }

  public void navigateToNextPage() throws CustomE2eException {
    try {
      scrollIntoView(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NEXT_PAGE());
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NEXT_PAGE(),
          SyncType.CLICKABLE);
    } catch (ElementClickInterceptedException exception) {
      NoExplicitThrowSleep(Duration.ofMillis(1000L));
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NEXT_PAGE(),
          SyncType.CLICKABLE);
    }
  }

  public void riskAddress(Map<String, Object> riskAddDet, Map<String, Object> corresAddDet) throws CustomE2eException {
    var riskAddHouseIdentifier = String.valueOf((((Map<String, Object>) riskAddDet.get(
        "RiskAddress")).get("HouseIdentifier")));
    var corresHouseIdentifier = String.valueOf((corresAddDet.get("HouseIdentifier")));

    var riskAddPostcode =
        String.valueOf(((Map<String, Object>) riskAddDet.get("RiskAddress")).get("Postcode"));
    var corresPostcode = String.valueOf((corresAddDet.get("Postcode")));

//    if (riskAddHouseIdentifier.equalsIgnoreCase(corresHouseIdentifier) || riskAddPostcode
//    .equalsIgnoreCase(corresPostcode)) {
    if (!riskAddHouseIdentifier.equalsIgnoreCase(corresHouseIdentifier) && !riskAddPostcode.equalsIgnoreCase(corresPostcode)) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().RISK_POST_CODE(),
          riskAddPostcode, SyncType.CLICKABLE);
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().RISK_FIND_ADDRES(), SyncType.CLICKABLE);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().RISK_HOUSE_INDENTIFIER(), riskAddHouseIdentifier, SyncType.CLICKABLE);
    } else {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().USE_CONTACT_ADDRESS(), SyncType.CLICKABLE);
    }
    // input Map<String, Object> proposerContactDetails
//    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().RISK_POST_CODE(),
//        ((Map<String, Object>) proposerContactDetails.get("AddressSelector")).get("Postcode"),
//        SyncType.CLICKABLE);
//    clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel()
//    .RISK_FIND_ADDRES(), SyncType.CLICKABLE);
//    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel()
//    .RISK_HOUSE_INDENTIFIER(),
//        ((Map<String, Object>) proposerContactDetails.get("AddressSelector")).get(
//            "HouseIdentifier"), SyncType.CLICKABLE);

  }

  public void jointPolicyHolder(Map<String, Object> jPHPersonalDetails) throws CustomE2eException
      , ParseException {
    waitForPageLoad();
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_SURNAME(),
        jPHPersonalDetails.get("LastName"), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_FORENAME(),
        jPHPersonalDetails.get("FirstName"), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_GENDER(),
        jPHPersonalDetails.get("Gender"), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_MARITAL_STATUS(), jPHPersonalDetails.get("MaritalStatus"), SelectOptions.TEXT);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_DATE_OF_BIRTH(),
        Formatting.changeDateFormatIntoExpected((String) jPHPersonalDetails.get("DateOfBirth"),
            "dd" + "/MM/yyyy", "dd-MMM-yyyy"), SyncType.CLICKABLE);
    var ukResidentSince =
        Formatting.changeDateFormatIntoExpected((String) jPHPersonalDetails.get("UkResidentSince"), "dd/MM/yyyy", "dd-MMM-yyyy");
    RetryOnException("JPH_UK_RESIDENT_SINCE", StaleElementReferenceException.class, 500L, 50,
        () -> typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_UK_RESIDENT_SINCE(), ukResidentSince, SyncType.CLICKABLE));

    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_RELATIONSHIP_WITH_POLICY_HOLDER(), jPHPersonalDetails.get("RelationshipWithPolicyholder"), SelectOptions.TEXT);
    selectJphEmploymentStatus((Map<String, Object>) jPHPersonalDetails.get(
        "PrimaryEmploymentStatus"));
    selectJphPartTimeEmploymentStatus((Map<String, Object>) jPHPersonalDetails.get(
        "SecondaryEmploymentStatus"));
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_INSURANCE_REFUSED_PREVIOUSLY(), this.CommonHelper.convertBooleanIntoString((Boolean) ((Map<String, Object>) jPHPersonalDetails.get("InsuranceHistory")).get("InsurancePreviouslyRefused")), SelectOptions.TEXT);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JPH_RTA_CONVICTION_DETAILS(), this.CommonHelper.convertBooleanIntoString(false), SelectOptions.TEXT);
  }

  public void selectJointPolicyHolderDropdown(boolean jphDetailsAvailable) throws CustomE2eException {
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().JOINT_POLICY_HOLDER(), this.CommonHelper.convertBooleanIntoString(jphDetailsAvailable), SelectOptions.TEXT);
  }


  public void dynamicsUnderwriterQuestions(Map<String, Object> dynamicUnderwriterQuestions,
                                           LocalActionRecordingServices pLars) throws CustomE2eException {
    var listOfQueries =
        getTextAllWebElementMatchingLocator(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LIST_OF_QUESTION());
//    if (listOfQueries.size() != 12) {
//      throw new CustomE2eException(String.format("List of queries contains %d",
//          listOfQueries.size()));
//    }
    var vPropertyOwned = dynamicUnderwriterQuestions.get("PropertyOwned");
    if( vPropertyOwned.toString().contains("Outright") ){
      vPropertyOwned = "Owned outright";
    }


    var vIndex = 0;
    for (var que : listOfQueries) {
      try {
        pLars.recordStartOfAnActivityInCaseInstRecord(String.format("DUQ: %s", que));
        switch (que.replace(" *", "")) {
          case "Is the property furnished?":
            break;
          case "Type Of Occupancy?":
            break;
          case "Type of wall construction?":
            break;
          case "Type of roof construction?":
            break;
          case "Is business use solely clerical with no employees or visitors?":
            break;
          case "How long is the property left unoccupied?":
            selectDaysOfLeftOccupied((Integer) dynamicUnderwriterQuestions.get(
                "NumberOfDaysPropertyLeftUnoccupied"));
            break;
          case "Approximately what percentage of the roof is flat?":
            selectionOfRoofPercentage((Integer) dynamicUnderwriterQuestions.get(
                "PercentageOfFlatRoof"));
            break;
          case "Payment Type?":
            waitForElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PAYMENT_TYPE(), SyncType.CLICKABLE);
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PAYMENT_TYPE(), dynamicUnderwriterQuestions.get("PaymentType"), SelectOptions.TEXT);
            break;
          case "How Many Bathrooms/En-Suites Do You Have?":
            waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_BATHROOM(), SyncType.CLICKABLE, waitDuration);
            typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_BATHROOM(), dynamicUnderwriterQuestions.get("NumberOfBathroom"), SyncType.CLICKABLE, true);
            break;
          case "Has the property been extended?":
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().EXTENDED_HOUSE(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicUnderwriterQuestions.get("ExtendedHouse")), SelectOptions.TEXT);
            break;
          case "Has any resident had any unsatisfied County Court Judgements?":
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().COUNTY_COURT_JUDGEMENT(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicUnderwriterQuestions.get("UnsatisfiedCountyCourtJudgements")), SelectOptions.TEXT);
            break;
          case "Has any resident been declared bankrupt?":
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DECLARED_BANKRUPT(), this.CommonHelper.convertBooleanIntoString((Boolean) dynamicUnderwriterQuestions.get("ResidentDeclaredBankrupt")), SelectOptions.TEXT);
            break;
          case "How many children live in the property?":
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_CHILDREN(), ((Map<String, Object>) dynamicUnderwriterQuestions.get("NumberOfPeopleLive")).get("Children"), SelectOptions.VALUE);
            break;
          case "How many adults live in the property?":
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_ADULT(), ((Map<String, Object>) dynamicUnderwriterQuestions.get("NumberOfPeopleLive")).get("Adult"), SelectOptions.VALUE);
            break;
          case "Original policy inception date:":
            break;
          case "What type of terraced property do you have?":
            break;
          case "What type of townhouse do you have?":
            break;
          case "What type of flat do you have?":
            break;
          case "Do you have a pet living at the property?":
            petSelection((Map<String, Object>) ((Map<String, Object>) dynamicUnderwriterQuestions.get("NumberOfPeopleLive")).get("Pet"));
            break;
          case "Who do you rent from?":
            break;
          case "How is your property owned?":

            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPERTY_OWNER(), vPropertyOwned
, SelectOptions.TEXT);
            break;
          case "Add Garden Cover":
            break;
          case "Add Student Cover":
            break;
          case "Add Unspecified Bicycle Cover":
            break;
          case "Do you have Smart Home Device - Cameras?":
            break;
          case "Do you have Smart Home Device - Doorbell?":
            break;
          case "Do you have Smart Home Device - Locks?":
            break;
          case "Do you have Smart Home Device - Motion sensors & alarms?":
            break;
          case "Do you have Smart Home Device - Water Detectors?":
            break;
          case "Original Instalment Scheme Code":
            break;
          case "Original Base Premium":
            break;
          case "Base Premium Plus Commission":
            break;
          case "PRICEMATCH True Opex Price - Legal":
            break;
          case "PRICEMATCH True Opex Price - Home Protect":
            break;
          case "PRICEMATCH NEW Total Selling Price":
            break;
          case "PRICEMATCH NEW IPT Amount":
            break;
          case "PRICEMATCH NEW BASE premium":
            break;
          case "Acc Dam PseudoOpex price":
            break;
          case "Student Belongings PseudoOpex price":
            break;
          case "Garden Cover PseudoOpex price":
            break;
          case "Unspec Bicycle PseudoOpex price":
            break;
          default:
        }
/*      try {
        var vScreenShot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        pLars.storeDataInTestCaseInstanceRecord(String.format("SS%02dA",vIndex), "png",
        vScreenShot);
      } catch(Exception pEx) {
        pLars.storeDataInTestCaseInstanceRecord(String.format("SS%02dA-FAILED",vIndex), "txt",
        new byte[]{});
      }*/
        //NoThrowSleep(Duration.ofMillis(300L));
/*      try {
        var vScreenShot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        pLars.storeDataInTestCaseInstanceRecord(String.format("SS%02dB",vIndex), "png",
        vScreenShot);
      } catch(Exception pEx) {
        pLars.storeDataInTestCaseInstanceRecord(String.format("SS%02dA-FAILED",vIndex), "txt",
        new byte[]{});
      }*/
        vIndex++;
      } finally {
        pLars.recordEndOfAnActivityInCaseInstRecord();
      }
    }
    NoThrowSleep(Duration.ofMillis(300L));
    try {
      var vScreenShot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
      pLars.storeDataInTestCaseInstanceRecord("DuqAnswers", "png", vScreenShot);
    } catch (Exception pEx) {
      pLars.storeDataInTestCaseInstanceRecord("DuqAnswers-FAILED", "txt", new byte[]{});
    }
    scrollIntoView(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES());
    CheckedWaitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES(), SyncType.CLICKABLE, waitDuration, "Scroll into view", "Get quote is clickable");
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES(),
        SyncType.CLICKABLE);
    CheckedWaitForPageLoad("GetQuotes", "QuoteDetailsPage");
  }

  public void dynamicUnderwriterQuestionsMotor(Map<String, Object> dynamicUnderwriterQuestionsCar, LocalActionRecordingServices pLars) throws CustomE2eException, ParseException {
    Map<String, Object> vDynamicUnderwriterQuestions = (Map<String, Object>) dynamicUnderwriterQuestionsCar.get("DynamicUnderwriterQuestions");
    var listOfQueries =
            getTextAllWebElementMatchingLocator(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LIST_OF_QUESTION());
    var vIndex = 0;
    for (var que : listOfQueries) {
      try {
        pLars.recordStartOfAnActivityInCaseInstRecord(String.format("DUQ: %s", que));
        switch (que.replace(" *", "").trim()) {
          case "What is the daytime location of the vehicle?":
            clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHAT_IS_DAY_TIME_LOCATION_OF_VEHICLE(),  SyncType.PRESENT);
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHAT_IS_DAY_TIME_LOCATION_OF_VEHICLE(), vDynamicUnderwriterQuestions.get(
                    "WhatIsTheDaytimeLocationOfTheVehicle"), SelectOptions.TEXT);
            break;
          case "How many children are in the household?":
            typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOW_MANY_CHILDREN_ARE_IN_THE_HOUSEHOLD(),
                    vDynamicUnderwriterQuestions.get("HowManyChildrenAreInTheHousehold"), SyncType.CLICKABLE, true, false, "");
            break;
          case "Is the proposer a member of the IAM or other organisation?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheProposerMemberofIAM")) == "false") {
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_PROPOSER_MEMBER_OF_IAM(), "No", SelectOptions.TEXT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_PROPOSER_MEMBER_OF_IAM(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheProposerMemberofIAM")) == "true"){
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_PROPOSER_MEMBER_OF_IAM(), "Yes", SelectOptions.TEXT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_PROPOSER_MEMBER_OF_IAM(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Are you a Home Owner?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("AreYouAHomeOwner")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ARE_YOU_A_HOMEOWNER(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ARE_YOU_A_HOMEOWNER(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("AreYouAHomeOwner")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ARE_YOU_A_HOMEOWNER(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ARE_YOU_A_HOMEOWNER(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Do you REGULARLY use the car in peak time e.g. rush hour?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("DoYouRegularlyUseTheCarInPeakTime")) == "false") {
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_REGULARLY_USE_THE_CAR_IN_PEAKTIME(), "No", SelectOptions.TEXT, "");
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_REGULARLY_USE_THE_CAR_IN_PEAKTIME(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("DoYouRegularlyUseTheCarInPeakTime")) == "true"){
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_REGULARLY_USE_THE_CAR_IN_PEAKTIME(), "Yes", SelectOptions.TEXT, "");
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_REGULARLY_USE_THE_CAR_IN_PEAKTIME(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "How do you pay for your insurance?":
            clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOW_DO_YOU_PAY_FOR_YOUR_INSURANCE(),  SyncType.PRESENT);
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOW_DO_YOU_PAY_FOR_YOUR_INSURANCE(), vDynamicUnderwriterQuestions.get(
                    "HowDoYouPayForYourInsurance"), SelectOptions.TEXT);
            break;
          case "Is the vehicle imported?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleImported")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_VEHICLE_IMPORTED(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_VEHICLE_IMPORTED(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleImported")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_VEHICLE_IMPORTED(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_VEHICLE_IMPORTED(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Do you have a dashcam fitted to your car?":
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_HAVE_A_DASHCAM_FITTED_TO_YOUR_CAR(), vDynamicUnderwriterQuestions.get(
                    "DoYouHaveADashcamFittedToYourCar"), SelectOptions.TEXT);
            break;
            // Van Specific
          case "What is the annual mileage of the vehicle?":
            typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHAT_IS_ANNUAL_MILEAGE_OF_THE_VEHICLE(),
                    vDynamicUnderwriterQuestions.get("WhatIsTheAnnualMileageOfTheVehicle"), SyncType.CLICKABLE, true, false, "");
            break;
          case "Is the vehicle fitted with racking?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleFittedWithRacking")) == "false") {
               clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_FITTED_WITH_RACKING(),  SyncType.PRESENT);
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_FITTED_WITH_RACKING(),  SyncType.PRESENT);
               selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_FITTED_WITH_RACKING(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleFittedWithRacking")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_FITTED_WITH_RACKING(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_FITTED_WITH_RACKING(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Does the vehicle carry signage?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("DoesTheVehicleCarrySignage")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DOES_VICHICLE_HAVE_SIGNAGE(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DOES_VICHICLE_HAVE_SIGNAGE(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("DoesTheVehicleCarrySignage")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DOES_VICHICLE_HAVE_SIGNAGE(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DOES_VICHICLE_HAVE_SIGNAGE(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Is the proposer a house owner?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheProposerAHouseOwner")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_PROPOSER_A_HOUSE_OWNER(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_PROPOSER_A_HOUSE_OWNER(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheProposerAHouseOwner")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_PROPOSER_A_HOUSE_OWNER(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_PROPOSER_A_HOUSE_OWNER(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Do you have Public Liability in force?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("DoYouHavePublicLiabilityInForce")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PUBLIC_LIABILITY_IN_FORCE(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PUBLIC_LIABILITY_IN_FORCE(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("DoYouHavePublicLiabilityInForce")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PUBLIC_LIABILITY_IN_FORCE(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PUBLIC_LIABILITY_IN_FORCE(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Is this policy solely for social domestic and pleasure use?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("IsThisPolicySolelyForSocialDomesticAndPleasureUse")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_POLICY_SOLELY_FOR_SOCIAL_DOMESTIC_AND_PLEASURE_USE(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_POLICY_SOLELY_FOR_SOCIAL_DOMESTIC_AND_PLEASURE_USE(), "No", SelectOptions.TEXT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_POLICY_SOLELY_FOR_SOCIAL_DOMESTIC_AND_PLEASURE_USE(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsThisPolicySolelyForSocialDomesticAndPleasureUse")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_POLICY_SOLELY_FOR_SOCIAL_DOMESTIC_AND_PLEASURE_USE(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_POLICY_SOLELY_FOR_SOCIAL_DOMESTIC_AND_PLEASURE_USE(), "Yes", SelectOptions.TEXT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_POLICY_SOLELY_FOR_SOCIAL_DOMESTIC_AND_PLEASURE_USE(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Will the vehicle carry any hazardous goods?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("WillTheVehicleCarryAnyHazardousGoods")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(), "No", SelectOptions.TEXT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("WillTheVehicleCarryAnyHazardousGoods")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(), "Yes", SelectOptions.TEXT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WILL_VEHICLE_CARRY_HAZARDOUS_GOODS(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Do you have a dashcam fitted to your vehicle?":
            clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DASHCAM_FITTED_TO_YOUR_VEHICLE(),  SyncType.PRESENT);
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DASHCAM_FITTED_TO_YOUR_VEHICLE(), vDynamicUnderwriterQuestions.get(
                    "DoYouHaveADashcamFittedToYourVehicle"), SelectOptions.TEXT);
            break;
          case "Where is the vehicle kept during the day?":
            clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHERE_IS_VEHICLE_KEPT_DURING_THE_DAY(),  SyncType.PRESENT);
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHERE_IS_VEHICLE_KEPT_DURING_THE_DAY(), vDynamicUnderwriterQuestions.get(
                    "WhereIsTheVehicleKeptDuringTheDay"), SelectOptions.TEXT);
            break;
          case "Where is the vehicle kept overnight?":
            clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHERE_IS_VEHICLE_KEPT_OVERNIGHT(),  SyncType.PRESENT);
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHERE_IS_VEHICLE_KEPT_OVERNIGHT(), vDynamicUnderwriterQuestions.get(
                    "WhereIsTheVehicleKeptOvernight"), SelectOptions.TEXT);
            break;
          case "How many children or dependants under the age of 16?":
            typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOW_MANY_CHILDREN_OR_DEPENDANTS_UNDER_AGE_OF_16(),
                    vDynamicUnderwriterQuestions.get("HowManyChildrenOrDependantsUnderTheAgeOf16"), SyncType.CLICKABLE, true, false, "");
            break;
          case "Is the vehicle driven at peak times?":
            if (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleDrivenAtPeakTimes")) == "false") {
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_DRIVEN_AT_PEAK_TIMES(),  SyncType.PRESENT);
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_DRIVEN_AT_PEAK_TIMES(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_DRIVEN_AT_PEAK_TIMES(), "No", SelectOptions.TEXT);
            } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleDrivenAtPeakTimes")) == "true"){
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_DRIVEN_AT_PEAK_TIMES(),  SyncType.PRESENT);
              clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_DRIVEN_AT_PEAK_TIMES(),  SyncType.PRESENT);
              selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_VEHICLE_DRIVEN_AT_PEAK_TIMES(), "Yes", SelectOptions.TEXT);
            }
            break;
          case "Who owns the Vehicle?":
            clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHO_OWNS_THE_VEHICLE(),  SyncType.PRESENT);
            selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHO_OWNS_THE_VEHICLE(), vDynamicUnderwriterQuestions.get(
                    "WhoOwnsTheVehicle"), SelectOptions.TEXT);
            break;
          default:
        }
        vIndex++;
      } finally {
        pLars.recordEndOfAnActivityInCaseInstRecord();
      }
    }
    NoThrowSleep(Duration.ofMillis(300L));
    try {
      var vScreenShot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
      pLars.storeDataInTestCaseInstanceRecord("DuqAnswers", "png", vScreenShot);
    } catch (Exception pEx) {
      pLars.storeDataInTestCaseInstanceRecord("DuqAnswers-FAILED", "txt", new byte[]{});
    }
    scrollIntoView(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES());
    CheckedWaitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES(), SyncType.CLICKABLE, waitDuration, "Scroll into view", "Get quote is clickable");
    clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES(),
            SyncType.CLICKABLE);
    CheckedWaitForPageLoad("GetQuotes", "QuoteDetailsPage");
  }

  public void publicUnderWriterQuestions(Map<String, Object> dynamicUnderwriterQuestionsCar) throws CustomE2eException, ParseException {
    Map<String, Object> vDynamicUnderwriterQuestions = (Map<String, Object>) dynamicUnderwriterQuestionsCar.get("DynamicUnderwriterQuestions");
    if (String.valueOf(vDynamicUnderwriterQuestions.get("LicenseNoDeclared")) == "false") {
      clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LICENSE_NO_DECLARED(),  SyncType.PRESENT);
     selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LICENSE_NO_DECLARED(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("LicenseNoDeclared")) == "true"){
      clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LICENSE_NO_DECLARED(),  SyncType.PRESENT);
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LICENSE_NO_DECLARED(), "Yes", SelectOptions.TEXT);
    }

  }

    private void petSelection(Map<String, Object> petDetails) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PET_DETAILS(),
        SyncType.VISIBLE, waitDuration);
    boolean cat = (boolean) petDetails.get("Cat");
    boolean dog = (boolean) petDetails.get("Dog");
    boolean otherAnimal = (boolean) petDetails.get("Other");
    if (cat && dog) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PET_DETAILS()
          , 4, SelectOptions.INDEX);
    } else if (cat) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PET_DETAILS()
          , 3, SelectOptions.INDEX);
    } else if (dog) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PET_DETAILS()
          , 5, SelectOptions.INDEX);
    } else {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PET_DETAILS()
          , 1, SelectOptions.INDEX);
    }
  }

  private void selectDaysOfLeftOccupied(int numberOfDaysPropertyLeftUnoccupied) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LEFT_UNOCCUPIED(), SyncType.VISIBLE, waitDuration);
    if (numberOfDaysPropertyLeftUnoccupied <= 60) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LEFT_UNOCCUPIED(), "60 days or less", SelectOptions.TEXT);
    } else {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LEFT_UNOCCUPIED(), "More than 60 days", SelectOptions.TEXT);
    }
  }

  private void selectionOfRoofPercentage(int percentageOfFlatRoof) throws CustomE2eException {
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ROOF_PERCENTAGE(), SyncType.CLICKABLE, waitDuration);
    NoThrowSleep(Duration.ofSeconds(1));
    var vSelectionText = "";
    if (percentageOfFlatRoof <= 33) {
      vSelectionText = "Up to 33%";
    } else if (percentageOfFlatRoof <= 50) {
      vSelectionText = "34% - 50%";
    } else {
      vSelectionText = "Greater than 50%";
    }
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ROOF_PERCENTAGE(), vSelectionText, SelectOptions.TEXT, "selectionOfRoofPercentage");
//    if (percentageOfFlatRoof > 33) {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel()
//      .ROOF_PERCENTAGE(), 3, SelectOptions.INDEX, "selectionOfRoofPercentage");
//    } else if (percentageOfFlatRoof <= 50) {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel()
//      .ROOF_PERCENTAGE(), 1, SelectOptions.INDEX, "selectionOfRoofPercentage");
//    } else {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel()
//      .ROOF_PERCENTAGE(), 2, SelectOptions.INDEX, "selectionOfRoofPercentage");
//    }
  }

  public String getQuoteReference() throws CustomE2eException {
    var value =
        getText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().QUOTE_REFERENCE());
    return value.substring(0, value.lastIndexOf("/"));
  }

  public ArrayList<String> getNumberOfDaysStoreQuote() throws CustomE2eException, ParseException {
    ArrayList<String> listOfDettails = new ArrayList<>();
    var storeQuoteDetails =
        getText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().STORE_QUOTE_DURATION());
    var numberOfDays = Formatting.getTextFromRegex(storeQuoteDetails, "\\d{1,3}");
    var endDateOfQuoteStore =
        Formatting.changeDateFormatIntoExpected(Formatting.getTextFromRegex(storeQuoteDetails,
            "\\d" + "{0,2} (January|February|March|April|May|Jun|Jul|August|Sepetember|October" + "|November" + "|December) " + "\\d{4}$"), "dd MMMM yyyy", "dd/MM/yyyy");
    listOfDettails.add(numberOfDays);
    listOfDettails.add(endDateOfQuoteStore);
    return listOfDettails;
  }

  public String getClientId(String quoteReference) {
    return quoteReference.substring(0, quoteReference.lastIndexOf("/"));
  }

  public String getWebReference() throws CustomE2eException {
    RetryOnException("getWebReference", CustomE2eException.class, 500L, 50,
        () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().VIEW_QUOTE(), SyncType.CLICKABLE));

          waitForPageLoad();
    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WEB_REFERENCE(), SyncType.VISIBLE,
            waitDuration);
         var vText = PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(60),()->
                 getText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WEB_REFERENCE()));
          return vText;
  }

//  public Object getQuotePremium() {
//        Object premiumVal = null;
//        int retry = 0;
//        do {
//          try {
//            premiumVal = RetryOnException(NumberFormatException.class, 500L, 50, () -> getText
//            (this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().QUOTE_VALUE()));
//            if (premiumVal.toString().equalsIgnoreCase("PRICEMATCH NEW IPT Amount")) {
//              throw new CustomE2eException("");
//            } else {
//              break;
//            }
//          } catch (CustomE2eException exception) {
//            retry++;
//            NoThrowSleep(Duration.ofMillis(900L));
//          }
//        }while (retry <=15);
//    if(String.valueOf(Double.parseDouble(((String) premiumVal).replace("£",""))).matches
//    ("^\\d*\\.?\\d*$")) {
//      premiumVal =
//          Double.parseDouble(premiumVal.toString().replace("£"
//          , ""));
//    }
//    return premiumVal;
//  }


  public double getQuotePremium() throws CustomE2eException {
    try {
      var premiumVal = RetryOnException("getQuotePremium", NumberFormatException.class, 500L, 100
          , () -> {
        var vUiValueText =
            getText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().QUOTE_VALUE());
        if (vUiValueText.equalsIgnoreCase("No Quote")) {
          return Double.MIN_NORMAL;
        }
        var vNumericValue = Double.parseDouble(vUiValueText.replace("£", "").replace(",", ""));
        return vNumericValue;
      });
      return premiumVal;
    } catch (RetryLimitExceeded pException) {
      throw new CustomE2eException("Retry limit exceeded in getQuotePremium()");
    }
  }

  public void clickOnStoreQuote() throws CustomE2eException {
    try {
      clickElementRetryX3onClickIntEx(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().STORE_QUOTE(),
          SyncType.CLICKABLE);
    } catch (Exception e) {
      throw new CustomE2eException(e.getCause().toString());
    }
  }

  // ----- HOME SECTION END ----- //
  public void newCarQuotesDetails(Map<String, Object> houseQuotesDetails) throws CustomE2eException, ParseException {
    selectAffinity((String) houseQuotesDetails.get("Affinity"));
    selectInceptionDate((String) houseQuotesDetails.get("InceptionDate"));
  }

  public void contactAddressCar(Map<String, Object> proposerContactDetails,
                                String preferredDelivery) throws CustomE2eException {
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().POST_CODE(),
            ((Map<String, Object>) proposerContactDetails.get("AddressSelector")).get("Postcode"),
            SyncType.CLICKABLE);
    RetryOnException("contactAddress-A", ElementNotInteractableException.class, 100, 2,
            ()->clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().FIND_ADDRES(), SyncType.CLICKABLE));
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOUSE_INDENTIFIER(),
            ((Map<String, Object>) proposerContactDetails.get("AddressSelector")).get(
                    "HouseIdentifier"), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPERTY_TYPE(),
            ((Map<String, Object>) proposerContactDetails.get("AddressSelector")).get("PropertyType"), SelectOptions.TEXT);

//    waitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().UPDATE_RISK_ADDRESS(), SyncType.CLICKABLE,
//        waitDuration);
//    RetryOnException("contactAddress-A", ElementNotInteractableException.class, 100, 2,
//            ()->clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().UPDATE_RISK_ADDRESS(), SyncType.CLICKABLE));
    enterContactDetails((String) proposerContactDetails.get("MainTelephoneNumber"));
    enterEmailDetails((String) proposerContactDetails.get("EmailAddress"), preferredDelivery);
  }

  public void vehicleDetails(Map<String, Object> vehicleDetails, String ProductType) throws CustomE2eException, ParseException {

    //Map<String, Object> vDetails = (Map<String, Object>) ((Map<String, Object>) vehicleDetails.get("LicenseDetails"));
    Map<String, Object> vLicenseDetails = (Map<String, Object>) vehicleDetails.get("LicenseDetails");
    Map<String, Object> vVehicleSearch = (Map<String, Object>) vehicleDetails.get("VehicleSearch");
    Map<String, Object> vVehicleDetails = (Map<String, Object>) vehicleDetails.get("VehicleDetails");
    Map<String, Object> vVehicleSecurityDetails = (Map<String, Object>) vehicleDetails.get("VehicleSecurityDetails");


    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LICENSE_TYPE(), vLicenseDetails.get(
            "LicenceType"), SelectOptions.TEXT);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LICENSE_DATE(),
            Formatting.changeDateFormatIntoExpected((String) vLicenseDetails.get("LicenceDate"),
                    "dd/MM/yyyy", "dd-MMM-yyyy"), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().REGISTRATION(),
            vVehicleSearch.get("Registration"), SyncType.CLICKABLE);
    clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().FIND_VEHICLE(),
            SyncType.CLICKABLE);
    waitForPageLoad();
    if (String.valueOf(vVehicleSearch.get("LeftHandDrive")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LEFT_HAND_DRIVE(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vVehicleSearch.get("LeftHandDrive")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LEFT_HAND_DRIVE(), "Yes", SelectOptions.TEXT);
    }
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_SEATS(),
            vVehicleSearch.get("NumberOfSeats"), SyncType.CLICKABLE);
    //for Van only
//    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_DOORS(),
//            vVehicleSearch.get("NumberOfDoors"), SyncType.CLICKABLE);
    ////////////////////////////////

    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PURCHASE_DATE(),
            Formatting.changeDateFormatIntoExpected((String) vVehicleDetails.get("PurchaseDate"),
                    "dd/MM/yyyy", "dd-MMM-yyyy"), SyncType.CLICKABLE);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CURRENT_MARKET_VALUE(),
            vVehicleDetails.get("CurrentMarketValue"), SyncType.CLICKABLE);

    // For Van
    if (ProductType.trim().equalsIgnoreCase("Van")){
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PRICE_PAID(),
              vVehicleDetails.get("PricePaid"), SyncType.CLICKABLE);
    }
    //////////////////////////////
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().VEHICLE_OWNER(), vVehicleDetails.get("VehicleOwner"), SelectOptions.TEXT);
    if (String.valueOf(vVehicleDetails.get("ProposerRegisteredKeeper")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSER_REGISTERED_KEEPER(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vVehicleDetails.get("ProposerRegisteredKeeper")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROPOSER_REGISTERED_KEEPER(), "Yes", SelectOptions.TEXT);
    }
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHERE_KEPT_OVERNIGHT(), vVehicleDetails.get("WhereKeptOvernight"), SelectOptions.TEXT);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHERE_KEPT_POSTCODE(),
            vVehicleDetails.get("WhereKeptPostcode"), SyncType.CLICKABLE);
    if (String.valueOf(vVehicleDetails.get("Modifications")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MODIFICATIONS(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vVehicleDetails.get("Modifications")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().MODIFICATIONS(), "Yes", SelectOptions.TEXT);
    }
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ALARM(), vVehicleSecurityDetails.get(
            "Alarm"), SelectOptions.TEXT);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IMMOBILISER(), vVehicleSecurityDetails.get("Immobiliser"), SyncType.CLICKABLE);
    //typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().TRACKER(), vVehicleSecurityDetails.get("Tracker"), SyncType.CLICKABLE);
    //for van
    if (ProductType.trim().equalsIgnoreCase("Van")){
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().TRACKER(), vVehicleSecurityDetails.get("Tracker"), SyncType.CLICKABLE, true, false, "");
    }
  }


  public void motoringDetails(Map<String, Object> motoringDetails, String ProductType) throws CustomE2eException, ParseException {
  //  public void motoringDetails(Map<String, Object> motoringDetails) throws CustomE2eException, ParseException {

    Map<String, Object> vCoverDetails = (Map<String, Object>) motoringDetails.get("CoverDetails");
    Map<String, Object> vMotoringDetails = (Map<String, Object>) motoringDetails.get("MotoringDetails");

    //for Van
    if (ProductType.trim().equalsIgnoreCase("Van")) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().TYPE_OF_COVER(), vCoverDetails.get(
              "TypeOfCover"), SelectOptions.TEXT);
    }
    ////////////

    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().CLASS_OF_USE(), vCoverDetails.get(
            "ClassOfUse"), SelectOptions.TEXT);
   //Motor only
    if (ProductType.trim().equalsIgnoreCase("Motor")) {
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ANNUAL_MILEAGE(),
            vCoverDetails.get("AnnualMileage"), SyncType.CLICKABLE);
    }
    //Motor only - End
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().LEVEL_OF_VOLUNTARY_EXCESS(),
            vCoverDetails.get("LevelOfVoluntaryExcess"), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().USE_OF_VEHICLE_BY_PROPOSER(), vMotoringDetails.get(
            "UseOfVehicleByProposer"), SelectOptions.TEXT);
    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_OTHER_VEHICLES_IN_HOUSEHOLD(),
            vMotoringDetails.get("NumberOfOtherVehiclesInHousehold"), SyncType.CLICKABLE);
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ACCESS_TO_OTHER_VEHICLES(), vMotoringDetails.get("AccessToOtherVehicles"), SelectOptions.TEXT);
  }


  public void previousInsurance(Map<String, Object> previousInsurance, String ProductType) throws CustomE2eException, ParseException {
   // public void previousInsurance(Map<String, Object> previousInsurance) throws CustomE2eException, ParseException {
    Map<String, Object> vPreviousInsurance = (Map<String, Object>) previousInsurance.get("PreviousInsurance");

    if (String.valueOf(vPreviousInsurance.get("PreviousInsurance")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PREVIOUS_INSURANCE(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vPreviousInsurance.get("PreviousInsurance")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PREVIOUS_INSURANCE(), "Yes", SelectOptions.TEXT);
    }

    if (String.valueOf(vPreviousInsurance.get("DrivingExperienceNotInYourName")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DRIVING_EXPERIENCE_NOT_IN_YOUR_NAME(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vPreviousInsurance.get("DrivingExperienceNotInYourName")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DRIVING_EXPERIENCE_NOT_IN_YOUR_NAME(), "Yes", SelectOptions.TEXT);
    }


    if (String.valueOf(vPreviousInsurance.get("NCDAppliedToAnyOtherVehicle")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NCD_APPLIED_TO_ANY_OTHER_VEHICLE(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vPreviousInsurance.get("NCDAppliedToAnyOtherVehicle")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NCD_APPLIED_TO_ANY_OTHER_VEHICLE(), "Yes", SelectOptions.TEXT);
    }

    //Van only
    if (ProductType.trim().equalsIgnoreCase("Van")) {
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NUMBER_OF_YEARS_HELD_CONTINUOUSLY(),
              vPreviousInsurance.get("NumberOfYearsHeldContinuously"), SyncType.CLICKABLE);
    }
    ///////////////////////////////////////

    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().TYPE_OF_INSURANCE(), vPreviousInsurance.get(
            "TypeOfInsurance"), SelectOptions.TEXT);

    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NCD_CLAIMED(),
            vPreviousInsurance.get("NCDClaimed"), SyncType.CLICKABLE);

    if (String.valueOf(vPreviousInsurance.get("NCDCurrentlyProtected")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NCD_CURRENTLY_PROTECTED(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vPreviousInsurance.get("NCDCurrentlyProtected")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().NCD_CURRENTLY_PROTECTED(), "Yes", SelectOptions.TEXT);
    }

    if (String.valueOf(vPreviousInsurance.get("ProtectedMCDRequired")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROTECTED_NCD_REQUIRED(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vPreviousInsurance.get("ProtectedMCDRequired")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PROTECTED_NCD_REQUIRED(), "Yes", SelectOptions.TEXT);
    }

    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().POLICY_EXPIRY_DATE(),
            Formatting.changeDateFormatIntoExpected((String) vPreviousInsurance.get("PolicyExpiryDate"),
                    "dd/MM/yyyy", "dd-MMM-yyyy"), SyncType.CLICKABLE);
  }



  public void additionalDrivers(Map<String, Object> additionalDrivers) throws CustomE2eException, ParseException {
    Map<String, Object> vAdditionalDrivers = (Map<String, Object>) additionalDrivers.get("AdditionalDrivers");

    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DRIVING_RESTRICTIONS(), vAdditionalDrivers.get(
            "DrivingRestrictions"), SelectOptions.TEXT);
  }

  public void claimsDetails(Map<String, Object> claimsConviction) throws CustomE2eException, ParseException {
    Map<String, Object> vClaimDetails = (Map<String, Object>) claimsConviction.get("AdditionalDrivers");

    if (String.valueOf(vClaimDetails.get("AnyClaims")) == "false") {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ANY_CLAIMS(), "No", SelectOptions.TEXT);
    } else if  (String.valueOf(vClaimDetails.get("AnyClaims")) == "true"){
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ANY_CLAIMS(), "Yes", SelectOptions.TEXT);
    }
  }

  public void clientUserFields(Map<String, Object> claimsConviction) throws CustomE2eException, ParseException {
    Map<String, Object> vClientUserFields = (Map<String, Object>) claimsConviction.get("ClientUserFields");

    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DRIVING_LICENCE_NUMBER(),
            vClientUserFields.get("DrivingLicenseNumber"), SyncType.CLICKABLE);
  }



  public void policyUserFieldCar(Map<String, Object> policyUserFieldCar) throws CustomE2eException, ParseException {
    Map<String, Object> vPolicyUserFields = (Map<String, Object>) policyUserFieldCar.get("PolicyUserFields");

    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHERE_DID_YOU_HEAR_ABOUT_US(), vPolicyUserFields.get(
            "WhereDidYouHearAboutUs"), SelectOptions.TEXT);
  }

  public void personalBelonginAwayFromHomeCover(Map<String,Object> insuredAmount) throws CustomE2eException {
    var personalBelonging = insuredAmount.containsKey("PersonalBelonginAwayFromHome");
    if (personalBelonging) {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().RISK_DROPDOWN(), this.CommonHelper.convertBooleanIntoString(true), SelectOptions.TEXT);
      typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().PERSONAL_BELONGING_COVER(), insuredAmount.get("PersonalBelonginAwayFromHome"), SyncType.CLICKABLE);
      specifiedContentAwayFromHome();
    } else {
      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().RISK_DROPDOWN(), this.CommonHelper.convertBooleanIntoString(false), SelectOptions.TEXT);
    }
  }

  public void specifiedContentAwayFromHome() throws CustomE2eException {
    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().SPECIFIED_CONTENT_AWAY_FROM_HOME(), this.CommonHelper.convertBooleanIntoString(false), SelectOptions.TEXT);
  }


//    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().WHAT_IS_DAY_TIME_LOCATION_OF_VEHICLE(), vDynamicUnderwriterQuestions.get(
//            "WhatIsTheDaytimeLocationOfTheVehicle"), SelectOptions.TEXT);
//
//    typeText(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().HOW_MANY_CHILDREN_ARE_IN_THE_HOUSEHOLD(),
//            vDynamicUnderwriterQuestions.get("HowManyChildrenAreInTheHousehold"), SyncType.CLICKABLE);
//
//
//    if (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheProposerMemberofIAM")) == "false") {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_PROPOSER_MEMBER_OF_IAM(), "No", SelectOptions.TEXT);
//    } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheProposerMemberofIAM")) == "true"){
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_PROPOSER_MEMBER_OF_IAM(), "Yes", SelectOptions.TEXT);
//    }
//
//
//    if (String.valueOf(vDynamicUnderwriterQuestions.get("AreYouAHomeOwner")) == "false") {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ARE_YOU_A_HOMEOWNER(), "No", SelectOptions.TEXT);
//    } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("AreYouAHomeOwner")) == "true"){
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().ARE_YOU_A_HOMEOWNER(), "Yes", SelectOptions.TEXT);
//    }
//
//    if (String.valueOf(vDynamicUnderwriterQuestions.get("DoYouRegularlyUseTheCarInPeakTime")) == "false") {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_REGULARLY_USE_THE_CAR_IN_PEAKTIME(), "No", SelectOptions.TEXT);
//    } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("DoYouRegularlyUseTheCarInPeakTime")) == "true"){
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_REGULARLY_USE_THE_CAR_IN_PEAKTIME(), "Yes", SelectOptions.TEXT);
//    }


//    if (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleImported")) == "false") {
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_VEHICLE_IMPORTED(), "No", SelectOptions.TEXT);
//    } else if  (String.valueOf(vDynamicUnderwriterQuestions.get("IsTheVehicleImported")) == "true"){
//      selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().IS_THE_VEHICLE_IMPORTED(), "Yes", SelectOptions.TEXT);
//    }
//
//    selectDropdown(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().DO_YOU_HAVE_A_DASHCAM_FITTED_TO_YOUR_CAR(), vDynamicUnderwriterQuestions.get(
//            "DoYouHaveADashcamFittedToYourCar"), SelectOptions.TEXT);



//    scrollIntoView(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES());
//    CheckedWaitForElement2(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES(), SyncType.CLICKABLE,
//            waitDuration,
//            "Scroll into view",
//            "Get quote is clickable");
//    clickElement(this.pageObjectOfEchelon.getEchelonQuoteCreationLocatorModel().GET_QUOTES(), SyncType.CLICKABLE);
//    CheckedWaitForPageLoad("GetQuotes", "QuoteDetailsPage");


  }
