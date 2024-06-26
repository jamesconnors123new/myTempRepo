package helpers;

import DataBuilders.PolicyDataBuilders;
import Generic.customExceptions.CustomE2eException;
import StepDefinitions.PortalGeneralStepDefinitions;
import activities.CommonControlDataDefns;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;


public class DataNormalisationHelper {


  public SortedMap<String, Object> dataNormalisation(Map<String, Object> detail) throws CustomE2eException {
    var detailsToReturn = new TreeMap<String, Object>();
    try {
      for (var insuranceType : detail.keySet()) {
        switch (insuranceType) {
          case CommonControlDataDefns.HOME_INSURANCE_INFORMATION:
            detailsToReturn.put(CommonControlDataDefns.HOME_INSURANCE_INFORMATION,
                    DataNormalisationHelper.homeDataFormatEngine(detail.get(CommonControlDataDefns.HOME_INSURANCE_INFORMATION)));
            break;
          case CommonControlDataDefns.VAN_INSURANCE_INFORMATION:
            detailsToReturn.put(CommonControlDataDefns.VAN_INSURANCE_INFORMATION,
                    DataNormalisationHelper.motorAndVanDataFormatEngine(detail.get(CommonControlDataDefns.VAN_INSURANCE_INFORMATION)));
            break;
          case CommonControlDataDefns.MOTOR_INSURANCE_INFORMATION:
            detailsToReturn.put(CommonControlDataDefns.MOTOR_INSURANCE_INFORMATION,
                    DataNormalisationHelper.motorAndVanDataFormatEngine(detail.get(CommonControlDataDefns.MOTOR_INSURANCE_INFORMATION)));
            break;
          default:
        }
      }
    } catch (ParseException exception) {
      throw new CustomE2eException("Failed parsing date format.");
    }
    return detailsToReturn;
  }

  public static List<Map<String, Object>> homeDataFormatEngine(Object formattedDetails) throws ParseException, CustomE2eException {

    var vAdditionalInfo = new TreeMap<String, Object>();
    var vPolAdminSysView = new TreeMap<String, Object>();
    var vPolPortalView = new TreeMap<String, Object>();
    var vUniversalView = new TreeMap<String, Object>();
    var insuranceType = new TreeMap<String, Object>();

    var listOfPolicies = (SortedMap<String, Object>) formattedDetails;
    List<Map<String, Object>> listOfPolicy = new ArrayList<>();
//    var policyNumber = listOfPolicies.entrySet();
//    var individualPolicy = new TreeMap<String, Object>();

    var customerPersonalDetails = new TreeMap<>();
    var insuranceDetails = new TreeMap<>();
    var excessDetails = new TreeMap<>();

    var buildingDetails = new TreeMap<String, Object>();
    buildingDetails.put(CommonControlDataDefns.PROPERTY_TYPE, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.BUILDING_TYPE));
    var builtYear = normalisedBuiltYear((String) searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.YEAR_BUILT_VAR));
    if(builtYear.contains("-") || builtYear.contains("+")) {
      vPolPortalView.put(CommonControlDataDefns.YEAR_BUILT_VAR, builtYear);
    } else{
      vPolAdminSysView.put(CommonControlDataDefns.YEAR_BUILT_VAR, builtYear);
    }

    buildingDetails.put(CommonControlDataDefns.RISK_ADDRESS,
            normalisedAddress((String) ((Map<String, Object>) listOfPolicies.get(CommonControlDataDefns.INSURED_HOME_SPECIFIC_DETAILS)).get(CommonControlDataDefns.RISK_ADDRESS)));

    buildingDetails.put(CommonControlDataDefns.BUILDING_VAR,
            Double.parseDouble(((String)searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.REBUILDING_COST)).replaceAll("[,£]", "")));

    vUniversalView.put(CommonControlDataDefns.OUTSTANDING_BALANCE, 0.0);
    vUniversalView.put(CommonControlDataDefns.USE_DETAILS,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.USE_DETAILS)).orElse("NoValue"));
    vUniversalView.put(CommonControlDataDefns.BUILDING_DETAILS, buildingDetails);
    vUniversalView.put(CommonControlDataDefns.OWNERSHIP_VAR,
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace((String) Optional.ofNullable(searchKeysInMap(listOfPolicies, null, CommonControlDataDefns.OWNERSHIP_TYPE)).orElse("NoValue")));
    var occupancyType = new TreeMap<String, Object>();
    occupancyType.put(CommonControlDataDefns.NUM_CHILD,
            Optional.ofNullable(searchKeysInMap(listOfPolicies,
                    CommonControlDataDefns.INSURED_HOME_SPECIFIC_DETAILS,
                    CommonControlDataDefns.NUM_CHILD)).orElse("NoValue"));
    occupancyType.put(CommonControlDataDefns.NUM_ADULTS,
            Optional.ofNullable(searchKeysInMap(listOfPolicies,
                    CommonControlDataDefns.INSURED_HOME_SPECIFIC_DETAILS,
                    CommonControlDataDefns.NUM_ADULTS)).orElse("NoValue"));
    occupancyType.put(CommonControlDataDefns.OCCUPIED,
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace((String) searchKeysInMap(listOfPolicies, null, CommonControlDataDefns.OCCUPANCY_VAR)));
    occupancyType.put(CommonControlDataDefns.NON_FAMILY_LODGER, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.NON_FAMILY_LODGER));
    var petDetails = Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.PET_DET)).orElse("NoValue").toString();

    occupancyType.put(CommonControlDataDefns.PET_DET, normalisedPetDetails(petDetails));
    vUniversalView.put(CommonControlDataDefns.OCCUPANCY_DETAILS, occupancyType);

    excessDetails.put(CommonControlDataDefns.BUILDING_COMPULSORY_EXCESS,
            Optional.ofNullable(Double.parseDouble((String) searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.BUILDING_COMPULSORY_EXCESS))).orElse(0.0));
    excessDetails.put(CommonControlDataDefns.CONTENT_COMPULSORY_EXCESS,
            Double.parseDouble((String) searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.CONTENT_COMPULSORY_EXCESS)));
    excessDetails.put(CommonControlDataDefns.BUILDING_VOLUNTARY_EXCESS,
            Optional.ofNullable(Double.parseDouble((String)searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.BUILDING_VOLUNTARY_EXCESS))).orElse(0.0));
    excessDetails.put(CommonControlDataDefns.CONTENT_VOLUNTARY_EXCESS,
            Double.parseDouble((String)searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.CONTENT_VOLUNTARY_EXCESS)));
    insuranceDetails.put(CommonControlDataDefns.EXCESS_DET, excessDetails);

    var buildingCover = Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.TYPE_VAR).toString().contains(CommonControlDataDefns.BUILDING_VAR)).orElse(false) ? true : false;
    var contentCover = Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.TYPE_VAR).toString().contains(CommonControlDataDefns.CONTENTS_VAR)).orElse(false) ? true : false;
    insuranceDetails.put(CommonControlDataDefns.BUILDING_COVER, buildingCover);
    insuranceDetails.put(CommonControlDataDefns.CONTENT_COVER, contentCover);
    insuranceDetails.put(CommonControlDataDefns.EXTRA_HOME_EMERGENCY,
            searchKeysInMap(listOfPolicies
                    , null, CommonControlDataDefns.EXTRA_HOME_EMERGENCY));
    insuranceDetails.put(CommonControlDataDefns.EXCESS_PROTECTION, searchKeysInMap(listOfPolicies
            , null, CommonControlDataDefns.EXCESS_PROTECTION));
    insuranceDetails.put(CommonControlDataDefns.LEGAL_EXPENSES, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.LEGAL_EXPENSES));
    vPolAdminSysView.put(CommonControlDataDefns.FREE_FLOODING_THREAT_VAR,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.FREE_FLOODING_THREAT_VAR)).orElse("NoValue"));

    insuranceDetails.put(CommonControlDataDefns.EXCESS_PROTECTION_SUBSIDENCE,
            searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.EXCESS_PROTECTION_SUBSIDENCE_VAR));

    var building = new TreeMap<String, Object>();
    building.put(CommonControlDataDefns.BUILDING_ACCIDENTAL_DAMAGE_COVER,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.BUILDING_ACCIDENTAL_DAMAGE_COVER)).orElse("NoValue"));
    building.put(CommonControlDataDefns.SUBSIDENCE_GROUND_HEAVE_LAND_SLIP,
            Double.parseDouble((String) searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.SUBSIDENCE_GROUND_HEAVE_LAND_SLIP)));
    building.put(CommonControlDataDefns.NUM_OF_BATHROOM, searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.NUM_OF_BATHROOM));
    building.put(CommonControlDataDefns.NUM_OF_BEDROOM, searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.NUM_OF_BEDROOM));
    //building.put(CommonControlDataDefns.BUILT_DETAILS, null);
    building.put(CommonControlDataDefns.EXTENSION_DETAILS,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.EXTENSION_DETAILS)).orElse("NoValue"));
    building.put(CommonControlDataDefns.INTRUDER_ALARM,
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(Optional.ofNullable((String) searchKeysInMap(listOfPolicies, null, CommonControlDataDefns.INTRUDER_ALARM)).orElse("NoValue")));
    building.put(CommonControlDataDefns.LISTING_DETAILS, searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.LISTED_BUILDING_FLAG));
    building.put(CommonControlDataDefns.LOCKING_DETAILS, searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.LOCKING_DETAILS));
    insuranceDetails.put(CommonControlDataDefns.BUILDING_VAR, building);

    vPolAdminSysView.put(CommonControlDataDefns.CLAIM_HISTORY, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.CLAIM_HISTORY));

    var content = new TreeMap<String, Object>();
    content.put(CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME)).orElse("NoValue"));
    content.put(CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME_COST,
            Double.parseDouble(((String)Optional.ofNullable(((String)searchKeysInMap(listOfPolicies,
                    null, CommonControlDataDefns.PERSONAL_BELONGING_AWAY_FROM_HOME_COST))).orElse("0.0")).replaceAll(
                    "[£,]", "")));
    content.put(CommonControlDataDefns.LEAKING_FREEZING,
            Double.parseDouble(((String)searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.LEAKING_FREEZING)).replaceAll("[£,]",
                    "")));
    content.put(CommonControlDataDefns.CONTENT_ACCIDENTAL_DAMAGE_VAR,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.CONTENT_ACCIDENTAL_DAMAGE_VAR)).orElse("NoValue"));
    content.put(CommonControlDataDefns.INSURANCE_HELD,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.PREVIOUS_INSURANCE)).orElse("NoValue"));
//    content.put(CommonControlDataDefns.CONTENTS_VAR,
//        Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
//            CommonControlDataDefns.CONTENTS_VAR)).orElse("NoValue"));
    content.put(CommonControlDataDefns.CONTENT_SUM_INSURED,
            Optional.ofNullable(Double.parseDouble((String) searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.ACCIDENTAL_DAMAGE_COVER))).orElse(0.0));
    content.put(CommonControlDataDefns.INSURED_HOUSE_HOLD_CONENT_LIMIT,
            Optional.ofNullable(Double.parseDouble((String) searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.INSURED_HOUSE_HOLD_CONENT_LIMIT))).orElse(0.0));

    var individualSpecifiedItems = new TreeMap<String, Object>();
    individualSpecifiedItems.put(CommonControlDataDefns.IN_HOME_COUNT,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, CommonControlDataDefns.SPECIFIED_ITEM
                    , CommonControlDataDefns.IN_HOME_COUNT)).orElse("NoValue"));
    individualSpecifiedItems.put(CommonControlDataDefns.IN_HOME,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, CommonControlDataDefns.SPECIFIED_ITEM
                    , CommonControlDataDefns.ITEMS_IN_HOME)).orElse("NoValue"));
    individualSpecifiedItems.put(CommonControlDataDefns.AWAY_FROM_HOME_COUNT,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, CommonControlDataDefns.SPECIFIED_ITEM
                    , CommonControlDataDefns.AWAY_FROM_HOME_COUNT)).orElse(0));
    individualSpecifiedItems.put(CommonControlDataDefns.AWAY_HOME,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, CommonControlDataDefns.SPECIFIED_ITEM
                    , CommonControlDataDefns.ITEMS_AWAY_FROM_HOME)).orElse("NoValue"));

//    Object ob = "NoValue";
    var valuable = getValuableOver2000£(individualSpecifiedItems);

    content.put(CommonControlDataDefns.VALUABLE_OVER_2000£_ITEMS, (valuable == null) ? "NoValue"
            : valuable);

    content.put(CommonControlDataDefns.VALUABLE_OVER_2000£_FLAG, (valuable == null) ? false : true);
    content.put(CommonControlDataDefns.INDIVIDUAL_SPECIFIED_ITEMS, individualSpecifiedItems);
    insuranceDetails.put(CommonControlDataDefns.CONTENTS_VAR, content);

    vUniversalView.put(CommonControlDataDefns.INSURANCE_DET, insuranceDetails);

    customerPersonalDetails.put(CommonControlDataDefns.TITLE, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.TITLE));
    customerPersonalDetails.put(CommonControlDataDefns.FIRST_NAME_VAR,
            searchKeysInMap(listOfPolicies, null, CommonControlDataDefns.FIRST_NAME));
    customerPersonalDetails.put(CommonControlDataDefns.LAST_NAME_VAR,
            searchKeysInMap(listOfPolicies, null, CommonControlDataDefns.LAST_NAME));
    customerPersonalDetails.put(CommonControlDataDefns.DATE_OF_BIRTH,
            Formatting.changeDateFormatIntoExpected((String) searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.DATE_OF_BIRTH), "dd/mm/yyyy", "MM/dd/yyyy"));
    var phoneNumNorm = searchKeysInMap(listOfPolicies, CommonControlDataDefns.CUSTOMER_DETAILS,
            CommonControlDataDefns.PHONE_NUMBER);

    customerPersonalDetails.put(CommonControlDataDefns.PHONE_NUMBER,
            ((String) phoneNumNorm).contains("\n") ? ((String) phoneNumNorm).split("\n")[0] :
                    phoneNumNorm);
    var emailNorm = searchKeysInMap(listOfPolicies, CommonControlDataDefns.CUSTOMER_DETAILS,
            CommonControlDataDefns.EMAIL_ADDRESS);
    customerPersonalDetails.put(CommonControlDataDefns.EMAIL_ADDRESS,
            ((String) emailNorm).contains("\n") ? ((String) emailNorm).split("\n")[0] : emailNorm);
    customerPersonalDetails.put(CommonControlDataDefns.CORRESPONDENCE_ADDRESS,
            normalisedAddress((String) searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.CORRESPONDENCE_ADDRESS)));

//    vPolAdminSysView.put(CommonControlDataDefns.EMPLOYMENT_DET,
//        (Map<String, Object>) searchKeysInMap(listOfPolicies,
//            CommonControlDataDefns.CUSTOMER_DETAILS, CommonControlDataDefns.EMPLOYMENT_DET));
    customerPersonalDetails.put(CommonControlDataDefns.EMPLOYMENT_DET,
            normaliseEmploymentDetails((SortedMap<String, Object>) searchKeysInMap(listOfPolicies,
                    CommonControlDataDefns.CUSTOMER_DETAILS, CommonControlDataDefns.EMPLOYMENT_DET)));

    vUniversalView.put(CommonControlDataDefns.CUSTOMER_DETAILS, customerPersonalDetails);

    vUniversalView.put(CommonControlDataDefns.JOINT_POLICY_HOLDER_FLAG,
            listOfPolicies.get(CommonControlDataDefns.JOINT_POLICY_HOLDER_FLAG));

    if (listOfPolicies.get(CommonControlDataDefns.JOINT_POLICY_HOLDER_FLAG).equals(true)) {
      SortedMap<String, Object> normaliseJph =
              nomalizeJointPolicyHolder((Map<String, Object>) searchKeysInMap(listOfPolicies, null,
                      CommonControlDataDefns.JOINT_POLICY_HOLDER_DET));

      vUniversalView.put(CommonControlDataDefns.JOINT_POLICY_HOLDER_DET, normaliseJph);
    }

    vUniversalView.put(CommonControlDataDefns.POLICY_END_DATE, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.POLICY_END_DATE));
    vUniversalView.put(CommonControlDataDefns.POLICY_EXPIRES_IN, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.POLICY_PERIOD));
    vUniversalView.put(CommonControlDataDefns.POLICY_ID, searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.POLICY_ID));
    vUniversalView.put(CommonControlDataDefns.POLICY_START_DATE, searchKeysInMap(listOfPolicies,
            null, CommonControlDataDefns.POLICY_START_DATE));

    vAdditionalInfo.put(CommonControlDataDefns.EARLIEST_ALLOWED_MTA_DATE, Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
            CommonControlDataDefns.EARLIEST_ALLOWED_MTA_DATE)).orElse("NoValue"));
    vPolAdminSysView.put(CommonControlDataDefns.PREMIUM_DETAILS,
            Optional.ofNullable(searchKeysInMap(listOfPolicies, null,
                    CommonControlDataDefns.ADDITIONAL_PREMIUM)).orElse("NoValue"));

    var vPolicyRecord = PolicyDataBuilders.PolicyRecordAssembler(vUniversalView, vAdditionalInfo,
            vPolAdminSysView, vPolPortalView);

    listOfPolicy.add(vPolicyRecord);
    return listOfPolicy;
  }

  private static String normalisedBuiltYear(String searchKeysInMap) {
    if (!searchKeysInMap.contains("2010+")) {
      if(searchKeysInMap.contains("-")){ //Portal arrangements
        return searchKeysInMap;
      }
      return (Integer.parseInt(searchKeysInMap) >= 2010) ? String.valueOf("2010+") :
              searchKeysInMap;
    } else {
      return searchKeysInMap;
    }
  }

  private static SortedMap<String, Object> nomalizeJointPolicyHolder(Map<String, Object> jph) throws CustomE2eException, ParseException {
    Formatting.changeDateFormatIntoExpected((String) jph.get(CommonControlDataDefns.DATE_OF_BIRTH), "dd/mm/yyyy", "MM/dd/yyy");
    normaliseEmploymentDetails((SortedMap<String, Object>) jph.get(CommonControlDataDefns.EMPLOYMENT_DET));
    return (SortedMap<String, Object>) jph;
  }

  private static TreeMap<String, Object> normalisedAddress(String address) {
    var postCode =
            Formatting.getTextFromRegex(address, CommonControlDataDefns.POST_CODE_REGEX).trim();
    var houseIdentifier = address.replace(postCode, "").trim();
    var addres = new TreeMap<String, Object>();
    addres.put(CommonControlDataDefns.HOUSE_IDENTIFIER, houseIdentifier.trim().replace(",", ""));
    addres.put(CommonControlDataDefns.POSTCODE, postCode.trim());
    return addres;
  }

  private static SortedMap<String, Object> getValuableOver2000£(TreeMap<String, Object> itemsInAwayFromHome) {
    var countOfItemsInHome =
            (Integer) (itemsInAwayFromHome).get(CommonControlDataDefns.IN_HOME_COUNT);
    var countOfItemsAwayFromHome =
            (Integer) (itemsInAwayFromHome).get(CommonControlDataDefns.AWAY_FROM_HOME_COUNT);

    TreeMap<String, Object> valuableOver2000£Items = null;

    if (countOfItemsInHome > 0 || countOfItemsAwayFromHome > 0) {
      valuableOver2000£Items = new TreeMap<>();
    }

    var inHome = new ArrayList<Object>();
    var awayFromHome = new ArrayList<Object>();
    if (countOfItemsInHome > 0) {
      var itemsInHome = (ArrayList) (itemsInAwayFromHome).get(CommonControlDataDefns.IN_HOME);
      for (int itemsCount = 0; itemsCount < countOfItemsInHome; itemsCount++) {
        var inHomeVal =
                Double.parseDouble(String.valueOf(((TreeMap<String, Object>) itemsInHome.get(itemsCount)).get(CommonControlDataDefns.VALUE)));
        if (inHomeVal > 2000) {
          inHome.add(itemsInHome.get(itemsCount));
        }
      }
      valuableOver2000£Items.put(CommonControlDataDefns.IN_HOME, inHome);
    }
    if (countOfItemsAwayFromHome > 0) {
      var itemsAwayFromHome =
              (ArrayList) (itemsInAwayFromHome).get(CommonControlDataDefns.AWAY_HOME);
      for (int itemsCount = 0; itemsCount < countOfItemsAwayFromHome; itemsCount++) {
        var awayHomeVal =
                Double.parseDouble(String.valueOf(((TreeMap<String, Object>) itemsAwayFromHome.get(itemsCount)).get(CommonControlDataDefns.VALUE)));
        if (awayHomeVal > 2000) {
          awayFromHome.add(itemsAwayFromHome.get(itemsCount));
        }
      }
      valuableOver2000£Items.put(CommonControlDataDefns.AWAY_HOME, awayFromHome);
    }
    return valuableOver2000£Items;
  }

  private static SortedMap<String, Object> normaliseEmploymentDetails(SortedMap<String, Object> employDet) {
    var normEmp = new TreeMap<String, Object>();
    var normPrimEmp = new TreeMap<String, Object>();
    var normSecondEmp = new TreeMap<String, Object>();

    normPrimEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(Optional.ofNullable(((String) ((Map<String, Object>) employDet.get(CommonControlDataDefns.PRIMARY_EMPLOYMENT)).get(CommonControlDataDefns.EMPLOYMENT_STATUS)).trim()).orElse("NoValue")));
    normPrimEmp.put(CommonControlDataDefns.OCCUPATION,
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(Optional.ofNullable(((String) ((Map<String,
                    Object>) employDet.get(CommonControlDataDefns.PRIMARY_EMPLOYMENT)).get(CommonControlDataDefns.OCCUPATION)).trim()).orElse("NoValue")));
    normPrimEmp.put(CommonControlDataDefns.INDUSTRY,
            Formatting.capitalizeAllFirstCapitalizeRemoveSpace(Optional.ofNullable(((String) ((Map<String, Object>) employDet.get(CommonControlDataDefns.PRIMARY_EMPLOYMENT)).get(CommonControlDataDefns.INDUSTRY)).trim()).orElse("NoValue")));
    normEmp.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT, normPrimEmp);
    if ((Boolean) ((Map<String, Object>) employDet.get(CommonControlDataDefns.SECONDARY_EMPLOYMENT)).get(CommonControlDataDefns.SECOND_EMP_FLAG)) {
      normSecondEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
              Formatting.capitalizeAllFirstCapitalizeRemoveSpace(Optional.ofNullable(((String) ((Map<String, Object>) employDet.get(CommonControlDataDefns.SECONDARY_EMPLOYMENT)).get(CommonControlDataDefns.EMPLOYMENT_STATUS)).trim()).orElse("NoValue")));
      normSecondEmp.put(CommonControlDataDefns.OCCUPATION,
              Formatting.capitalizeAllFirstCapitalizeRemoveSpace(Optional.ofNullable(((String) ((Map<String, Object>) employDet.get(CommonControlDataDefns.SECONDARY_EMPLOYMENT)).get(CommonControlDataDefns.OCCUPATION)).trim()).orElse("NoValue")));
      normSecondEmp.put(CommonControlDataDefns.INDUSTRY,
              Formatting.capitalizeAllFirstCapitalizeRemoveSpace(Optional.ofNullable(((String) ((Map<String, Object>) employDet.get(CommonControlDataDefns.SECONDARY_EMPLOYMENT)).get(CommonControlDataDefns.INDUSTRY)).trim()).orElse("NoValue")));
    }
    normSecondEmp.put(CommonControlDataDefns.SECOND_EMP_FLAG,
            (Boolean) ((Map<String, Object>) employDet.get(CommonControlDataDefns.SECONDARY_EMPLOYMENT)).get(CommonControlDataDefns.SECOND_EMP_FLAG));
    normEmp.put(CommonControlDataDefns.SECONDARY_EMPLOYMENT, normSecondEmp);
    return normEmp;
  }

  public static SortedMap<String, Object> normalisedPetDetails(String petDet) {
    var petDetails = new TreeMap<String, Object>();
    petDetails.put(CommonControlDataDefns.CAT_VAR, false);
    petDetails.put(CommonControlDataDefns.DOG_VAR, false);
    petDetails.put(CommonControlDataDefns.OTHER_VAR, false);

    if (petDet.toLowerCase().contains("yes")) {
      if (petDet.replace("yes", "").toLowerCase().contains("dog") && petDet.replace("yes", "").toLowerCase().contains("cat")) {
        petDetails.put(CommonControlDataDefns.CAT_VAR, true);
        petDetails.put(CommonControlDataDefns.DOG_VAR, true);
      } else if (petDet.replace("yes", "").toLowerCase().contains("dog")) {
        petDetails.put(CommonControlDataDefns.DOG_VAR, true);
      } else if (petDet.replace("yes", "").toLowerCase().contains("cat")) {
        petDetails.put(CommonControlDataDefns.CAT_VAR, true);
      } else {
        petDetails.put(CommonControlDataDefns.OTHER_VAR, true);
      }
    }
    return petDetails;
  }

  public static SortedMap<String, Object> enhanceCoverNormalisation(Map<String, Object> enhanceCoverData) {
    var enhanceCoverDetails = new TreeMap<String, Object>();
    for (String key : enhanceCoverData.keySet()) {
      switch (key) {
        case "Home Excess Protection":
        case "Excess Protection":
          enhanceCoverDetails.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXCESS_PROTECTION), enhanceCoverData.get(key));
          break;
        case "Legal Expenses":
          enhanceCoverDetails.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.LEGAL_EXP), enhanceCoverData.get(key));
          break;
        case "Home Emergency":
        case "Ageas Extra Home Emergency":
          enhanceCoverDetails.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXTRA_HOME_EMERGENCY), enhanceCoverData.get(key));
          break;
        case "Home Excess Protection Subsidence":
        case "Excess Protect with subsidence":
          enhanceCoverDetails.put(Formatting.capitalizeAllFirstCapitalizeRemoveSpace(PortalGeneralStepDefinitions.EXCESS_PROTECTION_SUBSIDENCE), enhanceCoverData.get(key));
          break;
        default:
      }
    }
    return enhanceCoverDetails;
  }

  private static Object getValueFromMap(Map<String, Object> setOfInformation, String key) {
//    String value = "";
    if (setOfInformation.containsKey(key)) {
      var value = setOfInformation.get(key);
      if (value instanceof String) {
        return value;
      } else if (value instanceof Boolean) {
        return value;
      }
    }
    return null;
  }

  public static Object searchKeysInMap(Map<String, Object> mappedData, Object parentKey,
                                       String childKey) {
    var formattedMap = (SortedMap) mappedData;
    if (parentKey != null) {
      for (int outerPointer = 0; outerPointer < mappedData.size(); outerPointer++) {
        for (var firstLevel : mappedData.entrySet()) {
          if (((TreeMap) mappedData).navigableKeySet().contains(parentKey)) {
//            Found in first level
            return ((Map<String, Object>) mappedData.get(parentKey)).get(childKey);
          } else if ((((Entry) firstLevel).getValue() instanceof TreeMap<?, ?>)) { //Logic to
            // loop in 2nds
            // level
            if (((Map<String, Object>) firstLevel.getValue()).containsKey(parentKey.toString())) {
              if (((Entry) firstLevel).getValue() instanceof Map<?, ?>) {
                for (var secondLevel : ((TreeMap) ((Entry) firstLevel).getValue()).entrySet()) {
                  if (((String) ((Entry) secondLevel).getKey()).contains(parentKey.toString())) {
                    return ((Map) ((Entry<?, ?>) secondLevel).getValue()).get(childKey);
                  }
                }
              }
//              else {
//              return (((Map<String, Object>) parentKey).get(childKey));
            } else {
              //Code to loop in 2nd level of same key if available
              for (var secondLevel : ((TreeMap) firstLevel.getValue()).entrySet()) {
                //check if key is available on 2nd level
                if (((Entry) secondLevel).getValue() instanceof Map<?, ?>) {
                  for (var thirdLevel : ((TreeMap) ((Entry) secondLevel).getValue()).entrySet()) {
                    if (((String) ((Entry) thirdLevel).getKey()).contains(parentKey.toString())) {
                      if (((Entry) thirdLevel).getValue() instanceof Map<?, ?>) {
                        if (((TreeMap) ((Entry) thirdLevel).getValue()).navigableKeySet().contains(parentKey)) {
                          return ((HashMap) ((Entry<?, ?>) thirdLevel).getValue()).get(childKey);
                        }
                      } else {
                        return ((Entry<?, ?>) thirdLevel).getValue();
                      }
                    }
                  }
                } else if (((String) ((Entry) secondLevel).getKey()).contains(parentKey.toString())) {
                  return (((Map<String, Object>) ((Entry) parentKey).getValue()).get(childKey));
                }
              }
            }
          }
        }
      }
    } else {
      for (int outerPointer = 0; outerPointer < mappedData.size(); outerPointer++) {
        //in main list key is not available
        if (!mappedData.containsKey(childKey) && mappedData instanceof Map<String, Object>) {
          for (var innerKey : mappedData.entrySet()) {
            if (innerKey.getKey().contains(childKey)) {
              return ((Map<String, Object>) innerKey.getValue()).get(childKey);
            } else if (innerKey.getValue() instanceof Map<?, ?>) {
              if (((Map<String, Object>) innerKey.getValue()).containsKey(childKey)) {
                return ((Map<String, Object>) innerKey.getValue()).get(childKey);
              } else {
                //Traversing inside loop
                if (innerKey instanceof Map<?, ?> || innerKey.getValue() instanceof TreeMap<?, ?>) {
                  if (((TreeMap) innerKey.getValue()).navigableKeySet().contains(childKey)) {
                    return ((TreeMap) innerKey.getValue()).get(childKey);
                  } else {
                    if (((TreeMap) innerKey.getValue()) instanceof Map<?, ?>)
                      for (var innerMostKey : ((TreeMap) innerKey.getValue()).entrySet()) {
                        if (innerMostKey instanceof Map<?, ?> || ((Entry) innerMostKey).getValue() instanceof TreeMap<?, ?>) {
                          if (((TreeMap) ((Entry) innerMostKey).getValue()).navigableKeySet().contains(childKey)) {
                            return (((TreeMap) ((Entry) innerMostKey).getValue()).get(childKey));
                          } else if (innerMostKey.equals(childKey)) {
                            return innerMostKey;
                          }
                        }
                      }
                  }
                }
              }
            } else if (innerKey.getValue() instanceof ArrayList<?> && ((ArrayList) innerKey.getValue()).size() > 0) {
              if (((TreeMap) ((ArrayList) innerKey.getValue()).get(0)).containsKey(childKey)) {
                return ((TreeMap) ((ArrayList) innerKey.getValue()).get(0)).get(childKey);
              }
            }
          }
        } else if (mappedData.containsKey(childKey)) {
          return mappedData.get(childKey);
        }
      }

    }
    return null; //"NoValue";
  }


  public static Object getFormalizedName(String fullName) {
    return fullName;
  }

  public static TreeMap<String, Object> motorAndVanDataFormatEngine(Object formattedDetails) throws ParseException, CustomE2eException {


    var vUniversalData = new TreeMap<String, Object>();
    var sourceOfBusiness = new TreeMap<String, Object>();
    var policyDetails = new TreeMap<String, Object>();

    var financialStatus = new TreeMap<String, Object>();
    var quoteDetail = new TreeMap<String, Object>();
    var claimHistory = new TreeMap<String, Object>();
    var convictionHistory = new TreeMap<String, Object>();
    var policyHolderPersonalDetails = new TreeMap<String, Object>();
    var policyHolderMotorSpecificDetails = new TreeMap<String, Object>();
    var InsuranceDetails = new TreeMap<String, Object>();
    var preferredDeliveryMethod = new TreeMap<String, Object>();
    var proposerContactDetails = new TreeMap<String, Object>();
    var accessToOtherVehicles = new TreeMap<String, Object>();
    var vehicle = new TreeMap<String, Object>();
    var concernFlag = new TreeMap<String, Object>();
    var cover = new TreeMap<String, Object>();
    var additionalDrivers = new TreeMap<String, Object>();

    var customerDetails =
            (Map<String, Object>) ((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.CUSTOMER_PERSONAL_DET);
    var policyInformation =
            (SortedMap<String, Object>) ((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.POLICY_INFORMATION);
    var driverDetails =
            (SortedMap<String, Object>) ((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.DRIVER_DETAILS);
    var mainDriverDetails =
            ((SortedMap<String, Object>) driverDetails.get(CommonControlDataDefns.MAIN_DRIVER));

    try {
      sourceOfBusiness.put(CommonControlDataDefns.ENQUIRY,
              policyInformation.get(CommonControlDataDefns.ENQUIRY));
      sourceOfBusiness.put(CommonControlDataDefns.AFFINITY,
              policyInformation.get(CommonControlDataDefns.AFFINITY));
      sourceOfBusiness.put(CommonControlDataDefns.SALES_CHANNEL,
              policyInformation.get(CommonControlDataDefns.SALES_CHANNEL));
      vUniversalData.put(CommonControlDataDefns.SOURCE_OF_BUSINESS, sourceOfBusiness);
    } catch (Exception exception) {
      throw new CustomE2eException("Failed to fetch & Store value in SourceOfBusiness");
    }
//
    try {
      policyDetails.put(CommonControlDataDefns.BRAND,
              policyInformation.get(CommonControlDataDefns.BRAND));
      policyDetails.put(CommonControlDataDefns.PROD_TYPE,
              policyInformation.get(CommonControlDataDefns.PROD_TYPE));
      policyDetails.put(CommonControlDataDefns.INCEPTION_DATE,
              policyInformation.get(CommonControlDataDefns.INCEPTION_DATE));
      policyDetails.put(CommonControlDataDefns.POLICY_END_DATE,
              policyInformation.get(CommonControlDataDefns.POLICY_END_DATE));
      policyDetails.put(CommonControlDataDefns.POLICY_START_DATE,
              policyInformation.get(CommonControlDataDefns.POLICY_START_DATE));
      policyDetails.put(CommonControlDataDefns.POLICY_PERIOD,
              policyInformation.get(CommonControlDataDefns.POLICY_PERIOD));
      vUniversalData.put(CommonControlDataDefns.POLICY_DETAILS, policyDetails);
    } catch (Exception exception) {
      throw new CustomE2eException("Failed to fetch & Store value in policyDetails");
    }
//
    try {
      financialStatus.put(CommonControlDataDefns.AFFORDABILITY_THRESHOLD,
              customerDetails.get(CommonControlDataDefns.AFFORDABILITY_THRESHOLD));
      financialStatus.put(CommonControlDataDefns.PREMIUM_FINANCE_REKEY,
              customerDetails.get(CommonControlDataDefns.PREMIUM_FINANCE_REKEY));
      vUniversalData.put(CommonControlDataDefns.FINANCIAL_STATUS, financialStatus);
    } catch (Exception exception) {
      throw new CustomE2eException("Failed to fetch & Store value in financialStatus");
    }
//
    quoteDetail.put(CommonControlDataDefns.ORIGINAL_QUOTE_DATE,
            policyInformation.get(CommonControlDataDefns.ORIGINAL_QUOTE_DATE));
    vUniversalData.put(CommonControlDataDefns.QUOTE_DET, quoteDetail);
    //Loop
    try {
      var claimDetail =
              (ArrayList) ((SortedMap<String, Object>) ((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.VEHICLE_CLAIMS_CONVICTION_SUMMARY)).get(CommonControlDataDefns.CLAIMS);
      var convictionsDetail = (ArrayList) ((SortedMap<String, Object>) ((SortedMap<String,
              Object>) formattedDetails).get(CommonControlDataDefns.VEHICLE_CLAIMS_CONVICTION_SUMMARY)).get(CommonControlDataDefns.CONVICTIONS);

      var claimDetails = new ArrayList<>();
      var convictionDetails = new ArrayList<>();
      if (claimDetail.size() >= 1) {
        for (int claimCount = 0; claimCount < claimDetail.size(); claimCount++) {
          claimHistory.put(CommonControlDataDefns.FIRST_NAME_VAR,
                  Optional.ofNullable(((String) ((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.FULL_NAME)).split(" ")[0]).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.LAST_NAME_VAR,
                  Optional.ofNullable(((String) ((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.FULL_NAME)).split(" ")[1]).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.INCIDENT_DATE,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.INCIDENT_DATE)).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.CLAIM_STATUS,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.CLAIM_STATUS)).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.CLAIM_TYPE,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.CLAIM_TYPE)).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.CLAIM_CAUSE,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.CLAIM_CAUSE)).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.OWN_DAMAGE_COST,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.OWN_DAMAGE_COST)).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.THIRD_PARTY_DAMAGE_COST,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.THIRD_PARTY_DAMAGE_COST)).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.NCD_AFFECTED,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.NCD_AFFECTED)).orElse("NoValue"));
          claimHistory.put(CommonControlDataDefns.PERSONAL_INJURY,
                  Optional.ofNullable(((SortedMap<String, Object>) claimDetail.get(claimCount)).get(CommonControlDataDefns.PERSONAL_INJURY)).orElse(Boolean.valueOf("NoValue")));
          claimDetails.add(claimHistory);
        }
      } else {
        claimDetails.add("NoValue");
      }
      vUniversalData.put(CommonControlDataDefns.CLAIM_HISTORY, claimDetails);
      //Loop
      if (convictionsDetail.size() >= 1) {
        for (int convicCount = 0; convicCount < convictionsDetail.size(); convicCount++) {
          convictionHistory.put(CommonControlDataDefns.FIRST_NAME_VAR,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.FULL_NAME)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.LAST_NAME_VAR,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.FULL_NAME)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.TYPE,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.TYPE)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.OFFENCE_DATE,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.OFFENCE_DATE)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.CONVICTION_DATE,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.CONVICTION_DATE)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.POINTS,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.POINTS)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.MONTHS_SUSPENDED,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.MONTHS_SUSPENDED)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.FINE,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.FINE)).orElse("NoValue"));
          convictionHistory.put(CommonControlDataDefns.DISQUALIFIED,
                  Optional.ofNullable(((SortedMap<String, Object>) convictionsDetail.get(convicCount)).get(CommonControlDataDefns.DISQUALIFIED)).orElse(Boolean.valueOf("NoValue")));
          convictionDetails.add(convictionHistory);
        }
      } else {
        convictionDetails.add("NoValue");
      }
      vUniversalData.put(CommonControlDataDefns.CONVICTION_HISTORY, convictionDetails);
    } catch (Exception exception) {
      throw new CustomE2eException("Failed to fetch & Store value in Claim and Conviction");
    }
    try {
      policyHolderPersonalDetails.put(CommonControlDataDefns.TITLE,
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.TITLE)).orElse("NoValue"));
      policyHolderPersonalDetails.put(CommonControlDataDefns.FIRST_NAME_VAR,
              Optional.ofNullable(((String) customerDetails.get(CommonControlDataDefns.FULL_NAME)).split(" ")[0]).orElse("NoValue"));
      policyHolderPersonalDetails.put(CommonControlDataDefns.LAST_NAME_VAR,
              Optional.ofNullable(((String) customerDetails.get(CommonControlDataDefns.FULL_NAME)).split(" ")[1]).orElse("NoValue"));
//      policyHolderPersonalDetails.put(CommonControlDataDefns.FIRST_NAME_VAR,
//          Optional.ofNullable((String) customerDetails.get(Formatting.addSpacesAfterCapital(CommonControlDataDefns.FIRST_NAME_VAR))).orElse("NoValue"));
//      policyHolderPersonalDetails.put(CommonControlDataDefns.LAST_NAME_VAR,
//          Optional.ofNullable((String) customerDetails.get(Formatting.addSpacesAfterCapital(CommonControlDataDefns.SURNAME))).orElse("NoValue"));
      policyHolderPersonalDetails.put(CommonControlDataDefns.MARITAL_STATUS,
              Optional.ofNullable(Formatting.capitalizeFirstCharacter((String) customerDetails.get(CommonControlDataDefns.MARITAL_STATUS))).orElse("NoValue"));
//          Optional.ofNullable((String) customerDetails.get(Formatting.addSpacesAfterCapital(CommonControlDataDefns.MARITAL_STATUS))).orElse("NoValue"));
      policyHolderPersonalDetails.put(CommonControlDataDefns.DATE_OF_BIRTH,
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.DATE_OF_BIRTH)).orElse("NoValue"));
//          Optional.ofNullable((String) customerDetails.get(Formatting.addSpacesAfterCapital(CommonControlDataDefns.DATE_OF_BIRTH))).orElse("NoValue"));
      policyHolderPersonalDetails.put(CommonControlDataDefns.GENDER,
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.GENDER)).orElse("NoValue"
              ));
      policyHolderPersonalDetails.put(CommonControlDataDefns.RESIDENCE_IN_UK_SINCE,
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.RESIDENCE_IN_UK_SINCE)).orElse("NoValue"));
//          Optional.ofNullable(customerDetails.get("Residence in UK since")).orElse("NoValue"));


      var empDetails = new TreeMap<>();

      var primaryEmp = new TreeMap<>();
      var secondaryEmp = new TreeMap<>();
//
//      primaryEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
//          Optional.ofNullable(
//                  Formatting.capitalizeAllFirstCapitalizeRemoveSpace(
//                          (String) ((HashMap<String, Object>) ((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.EMPLOYMENT_DET)).get(CommonControlDataDefns.PRIMARY_EMPLOYMENT_DET))
//                                  .get(CommonControlDataDefns.EMPLOYMENT_STATUS)
//                  )
//          ).orElse("NoValue"));



      SortedMap<String, Object> EmploymentDetailsMap = (SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.EMPLOYMENT_DET);
      SortedMap<String, Object> PrimaryEmploytmentMap = (SortedMap<String, Object>) EmploymentDetailsMap.get(CommonControlDataDefns.PRIMARY_EMPLOYMENT_DET);
      SortedMap<String, Object> SecondaryEmploytmentMap = (SortedMap<String, Object>) EmploymentDetailsMap.get(CommonControlDataDefns.SECOND_EMPLOYMENT_DET);


      String PrimaryEmploymentStatus =
              Optional.ofNullable(
                      (String) (PrimaryEmploytmentMap.get(CommonControlDataDefns.EMPLOYMENT_STATUS))
              ).orElse("NoValue");

      String PrimaryEmploymentOccupation =
              Optional.ofNullable(
                      (String) (PrimaryEmploytmentMap.get(CommonControlDataDefns.OCCUPATION))
              ).orElse("NoValue");

      String PrimaryEmploymentIndustry =
              Optional.ofNullable(
                      (String) (PrimaryEmploytmentMap.get(CommonControlDataDefns.INDUSTRY))
              ).orElse("NoValue");


      primaryEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS, PrimaryEmploymentStatus);
      primaryEmp.put(CommonControlDataDefns.OCCUPATION, PrimaryEmploymentOccupation);
      primaryEmp.put(CommonControlDataDefns.INDUSTRY, PrimaryEmploymentIndustry);



      String SecondaryEmploymentStatus =
              Optional.ofNullable(
                      (String) (SecondaryEmploytmentMap.get(CommonControlDataDefns.EMPLOYMENT_STATUS))
              ).orElse("NoValue");

      String SecondaryEmploymentOccupation =
              Optional.ofNullable(
                      (String) (SecondaryEmploytmentMap.get(CommonControlDataDefns.OCCUPATION))
              ).orElse("NoValue");

      String SecondaryEmploymentIndustry =
              Optional.ofNullable(
                      (String) (SecondaryEmploytmentMap.get(CommonControlDataDefns.INDUSTRY))
              ).orElse("NoValue");


      secondaryEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS, SecondaryEmploymentStatus);
      secondaryEmp.put(CommonControlDataDefns.OCCUPATION, SecondaryEmploymentOccupation);
      secondaryEmp.put(CommonControlDataDefns.INDUSTRY, SecondaryEmploymentIndustry);



//
//
//      primaryEmp.put(CommonControlDataDefns.OCCUPATION,
//          Optional.ofNullable(Formatting.capitalizeAllFirstCapitalizeRemoveSpace((String) ((HashMap<String, Object>) ((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.EMPLOYMENT_DET)).get(CommonControlDataDefns.PRIMARY_EMPLOYMENT_DET)).get(CommonControlDataDefns.OCCUPATION))).orElse("NoValue"));
//      primaryEmp.put(CommonControlDataDefns.INDUSTRY,
//          Optional.ofNullable(Formatting.capitalizeAllFirstCapitalizeRemoveSpace((String) ((HashMap<String, Object>) ((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.EMPLOYMENT_DET)).get(CommonControlDataDefns.PRIMARY_EMPLOYMENT_DET)).get(CommonControlDataDefns.INDUSTRY))).orElse("NoValue"));

//      secondaryEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
//          Optional.ofNullable(Formatting.capitalizeAllFirstCapitalizeRemoveSpace((String) ((HashMap<String, Object>) ((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.EMPLOYMENT_DET)).get(CommonControlDataDefns.SECOND_EMPLOYMENT_DET)).get(CommonControlDataDefns.EMPLOYMENT_STATUS))).orElse("NoValue"));
//      secondaryEmp.put(CommonControlDataDefns.OCCUPATION,
//          Optional.ofNullable(Formatting.capitalizeAllFirstCapitalizeRemoveSpace((String) ((HashMap<String, Object>) ((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.EMPLOYMENT_DET)).get(CommonControlDataDefns.SECOND_EMPLOYMENT_DET)).get(CommonControlDataDefns.OCCUPATION))).orElse("NoValue"));
//      secondaryEmp.put(CommonControlDataDefns.INDUSTRY,
//          Optional.ofNullable(Formatting.capitalizeAllFirstCapitalizeRemoveSpace((String) ((HashMap<String, Object>) ((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.EMPLOYMENT_DET)).get(CommonControlDataDefns.SECOND_EMPLOYMENT_DET)).get(CommonControlDataDefns.INDUSTRY))).orElse("NoValue"));

      empDetails.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT_DET, primaryEmp);
      empDetails.put(CommonControlDataDefns.SECOND_EMPLOYMENT_DET, secondaryEmp);

      policyHolderPersonalDetails.put(CommonControlDataDefns.EMPLOYMENT_DET, empDetails);
      vUniversalData.put(CommonControlDataDefns.POLICY_HOLDER_PERSONAL_DET,
              policyHolderPersonalDetails);
    } catch (Exception exception) {
      throw new CustomE2eException("Failed to fetch & Store value in PolicyHolderPersonalDetails");
    }
    try {
      policyHolderMotorSpecificDetails.put(CommonControlDataDefns.IAM_MEMBER,
              CommonHelper.convertStringIntoBoolean(customerDetails.get(CommonControlDataDefns.PROPOSER_IAM_OTHER_ORGANISATION)));
      policyHolderMotorSpecificDetails.put(CommonControlDataDefns.HOME_OWNER,
              CommonHelper.convertStringIntoBoolean(customerDetails.get(CommonControlDataDefns.HOME_OWNER)));
      var license = new TreeMap<>();
      license.put(CommonControlDataDefns.LICENCE_TYPE,
              Optional.ofNullable(Optional.ofNullable(customerDetails.get(CommonControlDataDefns.LICENCE_TYPE)).orElse(mainDriverDetails.get(CommonControlDataDefns.LICENCE_TYPE))).orElse("NoValue"));
      license.put(CommonControlDataDefns.LICENCE_NUMBER,
              Optional.ofNullable(Optional.ofNullable(customerDetails.get(CommonControlDataDefns.LICENCE_NUMBER)).orElse(mainDriverDetails.get(CommonControlDataDefns.LICENCE_NUMBER))).orElse("NoValue"));
      license.put(CommonControlDataDefns.HELD_DRIVING_LICENCE,
              Optional.ofNullable(Optional.ofNullable(customerDetails.get(CommonControlDataDefns.HELD_DRIVING_LICENCE)).orElse(mainDriverDetails.get(CommonControlDataDefns.HELD_DRIVING_LICENCE))).orElse("NoValue"));
      license.put(CommonControlDataDefns.LICENCE_OBTAIN,
              Optional.ofNullable(Optional.ofNullable(customerDetails.get(CommonControlDataDefns.LICENCE_OBTAIN)).orElse(mainDriverDetails.get(CommonControlDataDefns.LICENCE_OBTAIN))).orElse("NoValue"));
      license.put(CommonControlDataDefns.NUM_CHILD_UNDER_16,
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.NUM_CHILD_UNDER_16)).orElse("NoValue"));
      policyHolderMotorSpecificDetails.put(CommonControlDataDefns.LICENCE_DET, license);
      vUniversalData.put(CommonControlDataDefns.POLICY_HOLDER_MOTOR_SPECIFIC_DET,
              policyHolderMotorSpecificDetails);
    } catch (Exception exception) {
      throw new CustomE2eException("Failed to fetch & Store value in " +
              "PolicyHolderMotorSpecificDetails");
    }
    try {
      InsuranceDetails.put(CommonControlDataDefns.TYPE_OF_INSURANCE,
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.TYPE_OF_INSURANCE)).orElse("NoValue"));
      InsuranceDetails.put(CommonControlDataDefns.SCHEME,
              Optional.ofNullable(policyInformation.get(CommonControlDataDefns.SCHEME)).orElse(
                      "NoValue"));
      InsuranceDetails.put(CommonControlDataDefns.COVER_TYPE,
              Optional.ofNullable(policyInformation.get(CommonControlDataDefns.COVER_TYPE)).orElse(
                      "NoValue"));
      InsuranceDetails.put(CommonControlDataDefns.DRIVING_RESTRICTION,
              Optional.ofNullable(policyInformation.get(CommonControlDataDefns.DRIVING_RESTRICTION)).orElse("NoValue"));
//    InsuranceDetails.put(CommonControlDataDefns.NCD_FLAG,
//        Optional.ofNullable(policyInformation.get(CommonControlDataDefns.NCD_FLAG)).orElse(
//            "NoValue"));
//    InsuranceDetails.put(CommonControlDataDefns.CONCERN_FLAG,
//        Optional.ofNullable(policyInformation.get(CommonControlDataDefns.CONCERN_FLAG)).orElse(
//            "NoValue"));
//    InsuranceDetails.put(CommonControlDataDefns.INSURED_AMOUNT,
//        Optional.ofNullable(policyInformation.get(CommonControlDataDefns.INSURED_AMOUNT)).orElse(
//            "NoValue")); //specific to home - Removed for VAN and CAR Need to check with HOME

      var insuranceHistory = new TreeMap<String, Object>();

      var prevInsuranceDet = new TreeMap<>();
      prevInsuranceDet.put(CommonControlDataDefns.PREVIOUS_INSURANCE_AVAILABLE,
              CommonHelper.convertStringIntoBoolean(customerDetails.get(CommonControlDataDefns.PREVIOUS_INSURANCE_AVAILABLE)));
      prevInsuranceDet.put(CommonControlDataDefns.PREV_INSURANCE_REFUSED,
              CommonHelper.convertStringIntoBoolean(customerDetails.get(CommonControlDataDefns.PREV_INSURANCE_REFUSED)));

      insuranceHistory.put(CommonControlDataDefns.PREVIOUS_INSURANCE_DETAILS, prevInsuranceDet);


      var prevExpDet = new TreeMap<>();
// Revisit this - Need to find the field name
      prevExpDet.put(CommonControlDataDefns.CLAIM_FREE_YEARS,
              customerDetails.get(CommonControlDataDefns.CLAIM_FREE_YEARS));
//    prevExpDet.put(CommonControlDataDefns.EXPERIENCE_TYPE, );
      prevExpDet.put(CommonControlDataDefns.PREVIOUS_POLICY_EXPIRY_DATE,
              customerDetails.get(CommonControlDataDefns.PREVIOUS_POLICY_EXPIRY_DATE));
      insuranceHistory.put(CommonControlDataDefns.PREVIOUS_EXPERIENCE, prevExpDet);

      var ncdDet = new TreeMap<>();
      ncdDet.put(CommonControlDataDefns.NCD_APPLIED_TO_ANOTHER_VEHICLE,
//          Optional.ofNullable(Optional.ofNullable(customerDetails.get(CommonControlDataDefns
//          .NCD_APPLIED_TO_ANOTHER_VEHICLE))).orElse(customerDetails.get(CommonControlDataDefns
//          .NCD_APPLIED_TO_ANOTHER_VEHICLE))).orElse(Boolean.valueOf("NoValue")));
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.NCD_APPLIED_TO_ANOTHER_VEHICLE)).orElse("NoValue"));
      ncdDet.put(CommonControlDataDefns.NCD_CLAIM_YEARS,
              Optional.ofNullable(Optional.ofNullable(customerDetails.get(CommonControlDataDefns.NCD_CLAIM_YEARS)).orElse(customerDetails.get(CommonControlDataDefns.NCD_CLAIM_YEAR))).orElse("NoValue"));
      ncdDet.put(CommonControlDataDefns.PROTECT_NCD,
              Optional.ofNullable(customerDetails.get(CommonControlDataDefns.PROTECT_NCD)).orElse(Boolean.valueOf("NoValue")));
      insuranceHistory.put(CommonControlDataDefns.NCD_DETAILS, ncdDet);

      var excessDet = new TreeMap<>();
      excessDet.put(CommonControlDataDefns.VOLUNTARY_EXCESS,
              Optional.ofNullable(((SortedMap<String, Object>) ((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.EXCESS_DET)).get(CommonControlDataDefns.VEHICLE_VOLUNTARY_EXCESS)).orElse("NoValue"));
      excessDet.put(CommonControlDataDefns.COVERAGE_CODE, Optional.ofNullable(((SortedMap<String,
              Object>) formattedDetails).get(CommonControlDataDefns.COVERAGE_CODE)).orElse("NoValue"));
      insuranceHistory.put(CommonControlDataDefns.EXCESS_DET, excessDet);
      InsuranceDetails.put(CommonControlDataDefns.INSURANCE_HISTORY, insuranceHistory);

      InsuranceDetails.put(CommonControlDataDefns.OPTIONAL_EXTRAS,
              Optional.ofNullable(((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.OPTIONAL_EXTRAS)).orElse("NoValue"));
      InsuranceDetails.put(CommonControlDataDefns.ENDORSEMENT,
              Optional.ofNullable(((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.ENDORSEMENT)).orElse("NoValue"));
      vUniversalData.put(CommonControlDataDefns.INSURANCE_DET, InsuranceDetails);
    } catch (Exception exception) {
      throw new CustomE2eException("Failed to fetch & Store value in InsuranceDetails");
    }
    vUniversalData.put(CommonControlDataDefns.PREFERRED_DELIVERY,
            Optional.ofNullable(customerDetails.get(CommonControlDataDefns.PREFERRED_DELIVERY)).orElse("NoValue"));


    var correspondenceAddress = new TreeMap<>();
    correspondenceAddress.put(CommonControlDataDefns.HOUSE_IDENTIFIER,
            Optional.ofNullable(((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.ADDRESS)).get(CommonControlDataDefns.HOUSE_IDENTIFIER)).orElse("NoValue"));
    correspondenceAddress.put(CommonControlDataDefns.POST_CODE,
            Optional.ofNullable(((SortedMap<String, Object>) customerDetails.get(CommonControlDataDefns.ADDRESS)).get(CommonControlDataDefns.POST_CODE)).orElse("NoValue"));
    proposerContactDetails.put(CommonControlDataDefns.CORRESPONDENCE_ADDRESS,
            correspondenceAddress);

    proposerContactDetails.put(CommonControlDataDefns.PHONE_NUMBER,
            Optional.ofNullable(customerDetails.get(CommonControlDataDefns.PHONE_NUMBER)).orElse(
                    "NoValue"));
    proposerContactDetails.put(CommonControlDataDefns.EMAIL_ADDRESS,
            Optional.ofNullable(customerDetails.get(CommonControlDataDefns.EMAIL_ADDRESS)).orElse(
                    "NoValue"));
    vUniversalData.put(CommonControlDataDefns.PROPOSER_CONTACT_DETAILS, proposerContactDetails);


    vUniversalData.put(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE,
            mainDriverDetails.get(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE));

    var vehicleDetails =
            ((SortedMap<String, Object>) ((SortedMap<String, Object>) formattedDetails).get(CommonControlDataDefns.VEHICLE_DETAILS));
    var vehicleUse = new TreeMap<>();
    vehicle.put(CommonControlDataDefns.FCA_CLASS,
            Optional.ofNullable(customerDetails.get(CommonControlDataDefns.FCA_CLASS)).orElse(
                    "NoValue"));

    vehicleUse.put(CommonControlDataDefns.VEHICLE_USE_BY_PROPOSER,
            Optional.ofNullable(Optional.ofNullable(customerDetails.get(CommonControlDataDefns.VEHICLE_USE_BY_PROPOSER)).orElse(vehicleDetails.get(CommonControlDataDefns.VEHICLE_USE_BY_PROPOSER))).orElse("NoValue"));
    vehicleUse.put(CommonControlDataDefns.MAIN_USAGE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_USE_FOR)).orElse(Boolean.valueOf("NoValue")));
    vehicleUse.put(CommonControlDataDefns.VEHICLE_ANNUAL_MILEAGE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_ANNUAL_MILEAGE)).orElse("NoValue"));
    vehicleUse.put(CommonControlDataDefns.VEHICLE_BUSINESS_MILEAGE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_BUSINESS_MILEAGE)).orElse("NoValue"));
    ;
    vehicleUse.put(CommonControlDataDefns.VEHICLE_PURCHASE_DATE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_PURCHASE_DATE)).orElse("NoValue"));
    vehicle.put(CommonControlDataDefns.VEHICLE_USE, vehicleUse);
    vUniversalData.put(CommonControlDataDefns.VEHICLE, vehicle);
//
    var parkingDetails = new TreeMap<>();
    parkingDetails.put(CommonControlDataDefns.VEHICLE_KEPT_DURING_DAY_LOC,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_KEPT_DURING_DAY_LOC)).orElse("NoValue"));
    parkingDetails.put(CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_LOC,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_LOC)).orElse("NoValue"));
//    parkingDetails.put(CommonControlDataDefns.OVERNIGHT_LOCATION, );
    parkingDetails.put(CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_POSTCODE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_KEPT_DURING_NIGHT_POSTCODE)).orElse("NoValue"));
    vehicle.put(CommonControlDataDefns.PARKING_DETAILS, parkingDetails);

    // Loop is expected to add multiple vehicle- Need discussion with Neil
    var vehicleCharacterists = new TreeMap<>();
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_MODEL,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_MODEL)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_MAKE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_MODEL)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_FULE_TYPE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_FULE_TYPE)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_BODY_STYLE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_MODEL)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_NUM_SEAT,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_NUM_SEAT)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_NUM_DOORS,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_NUM_DOORS)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_ABI_CODE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_ABI_CODE)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_REG_NUMBER_VAR,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_REG_NUMBER)).orElse("NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_YEAR_OF_MANUFACTURE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.YEAR_OF_MANUFACTURE_VAR)).orElse("NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_ENGINE_CC,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_ENGINE_CC)).orElse(
                    "NoValue"));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_MARKET_VALUE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_MARKET_VALUE)).orElse("NoValue"));

    var vehicleFeature = new TreeMap<>();
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_ALARM,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_ALARM)).orElse(
                    "NoValue"));
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_IMMOBILISER_FLAG,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_IMMOBILISER_FLAG)).orElse(Boolean.valueOf("NoValue")));
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_IMMOBILISER,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_IMMOBILISER)).orElse("NoValue"));
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_TRACKER_FLAG,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_TRACKER_FLAG)).orElse("NoValue"));
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_TRACKER,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_TRACKER)).orElse(
                    "NoValue"));
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_DASH_CAM_FITTED,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_DASH_CAM_FITTED)).orElse("NoValue"));
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_LEFT_HAND_DRIVE,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_LEFT_HAND_DRIVE)).orElse(Boolean.valueOf("NoValue")));
    vehicleFeature.put(CommonControlDataDefns.VEHICLE_IMPORTED,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_IMPORTED)).orElse(Boolean.valueOf("NoValue")));
    vehicleCharacterists.put(CommonControlDataDefns.VEHICLE_FEATURE, vehicleFeature);

    var carModificationDet = new TreeMap<>();
    var modificationDetails = new TreeMap<>();
//
    modificationDetails.put(CommonControlDataDefns.VEHICLE_MODIFIED,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_MODIFIED)).orElse(Boolean.valueOf("NoValue")));
    carModificationDet.put(CommonControlDataDefns.VEHICLE_MODIFICATION_DETAILS,
            modificationDetails);
    vehicleFeature.put(CommonControlDataDefns.CAR_MODIFICATION_DET, carModificationDet);

    vehicle.put(CommonControlDataDefns.VEHICLE_REGISTER_OWNER,
            Optional.ofNullable(Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_REGISTER_OWNER)).orElse(vehicleDetails.get(CommonControlDataDefns.VEHICLE_OWNER))).orElse("NoValue"));
    vehicle.put(CommonControlDataDefns.VEHICLE_PROPOSER_REGISTER_KEEPER,
            Optional.ofNullable(vehicleDetails.get(CommonControlDataDefns.VEHICLE_PROPOSER_REGISTER_KEEPER)).orElse(Boolean.valueOf("NoValue")));
    vehicle.put(CommonControlDataDefns.VEHICLE_CHARACTERISTICS, vehicleCharacterists);
    vUniversalData.put(CommonControlDataDefns.VEHICLE, vehicle);
//    concernFlag.put(CommonControlDataDefns.CONCERN_FLAG, ); // Add it into main MAP
//
    cover.put(CommonControlDataDefns.COVER_SECTIONS,
            Optional.ofNullable(policyInformation.get(CommonControlDataDefns.COVER_SECTIONS)).orElse(
                    "NoValue"));
    cover.put(CommonControlDataDefns.RENEWAL_COUNT,
            Optional.ofNullable(policyInformation.get(CommonControlDataDefns.RENEWAL_COUNT)).orElse(
                    "NoValue"));
    vUniversalData.put(CommonControlDataDefns.COVER_DET, cover);

    var driverType = new TreeMap<>();
    var details = new TreeMap<String, Object>();
    var sizeOfAdditionalDriver =
            ((ArrayList<Object>) driverDetails.get(CommonControlDataDefns.ADDITIONAL_DRIVER)).size();
    var addDriverPersonalDetails = new TreeMap<String, Object>();
    var addDriverMotorSpecificDetails = new TreeMap<String, Object>();

    for (int countOfAddDriver = 0; countOfAddDriver < sizeOfAdditionalDriver; countOfAddDriver++) {
      var addDriverDetails =
              ((TreeMap) ((ArrayList) ((TreeMap) ((TreeMap) formattedDetails).get(CommonControlDataDefns.DRIVER_DETAILS)).get(CommonControlDataDefns.ADDITIONAL_DRIVER)).get(countOfAddDriver));

      addDriverPersonalDetails.put(CommonControlDataDefns.TITLE,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.TITLE)).orElse(" "));
      addDriverPersonalDetails.put(CommonControlDataDefns.FIRST_NAME_VAR,
              Optional.ofNullable(((String) addDriverDetails.get(CommonControlDataDefns.DRIVER_NAME)).split(" ")[0]).orElse("NoValue"));
      addDriverPersonalDetails.put(CommonControlDataDefns.LAST_NAME_VAR,
              Optional.ofNullable(((String) addDriverDetails.get(CommonControlDataDefns.DRIVER_NAME)).split(" ")[1]).orElse("NoValue"));
      addDriverPersonalDetails.put(CommonControlDataDefns.MARITAL_STATUS,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.MARITAL_STATUS)).orElse("NoValue"));
      addDriverPersonalDetails.put(CommonControlDataDefns.DATE_OF_BIRTH,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.DATE_OF_BIRTH)).orElse(
                      "NoValue"));
      addDriverPersonalDetails.put(CommonControlDataDefns.GENDER,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.GENDER)).orElse(
                      "NoValue"));

      addDriverPersonalDetails.put(CommonControlDataDefns.EMPLOYMENT_DET,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.EMPLOYMENT_DET)).orElse("NoValue"));
      details.put(CommonControlDataDefns.CUSTOMER_PERSONAL_DET, addDriverPersonalDetails);

      var addDriverLicense = new TreeMap<>();
      addDriverLicense.put(CommonControlDataDefns.LICENCE_TYPE,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.LICENCE_TYPE)).orElse(
                      "NoValue"));
      addDriverLicense.put(CommonControlDataDefns.HELD_DRIVING_LICENCE,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.HELD_DRIVING_LICENCE)).orElse("NoValue"));
      addDriverLicense.put(CommonControlDataDefns.LICENCE_NUMBER,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.LICENCE_NUMBER)).orElse("NoValue"));
      addDriverLicense.put(CommonControlDataDefns.LICENCE_OBTAIN,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.LICENCE_OBTAIN)).orElse("NoValue"));

      addDriverMotorSpecificDetails.put(CommonControlDataDefns.LICENCE_DET, addDriverLicense);

      var addDriverVehicle = new TreeMap<>();
      addDriverVehicle.put(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.ACCESS_TO_OTHER_VEHICLE)).orElse("NoValue"));
      addDriverMotorSpecificDetails.put(CommonControlDataDefns.VEHICLE, addDriverVehicle);

      details.put(CommonControlDataDefns.POLICY_HOLDER_MOTOR_SPECIFIC_DET,
              addDriverMotorSpecificDetails);

      details.put(CommonControlDataDefns.RELATIONSHIP_TO_PROPOSER,
              Optional.ofNullable(addDriverDetails.get(CommonControlDataDefns.RELATIONSHIP_TO_PROPOSER)).orElse("NoValue"));

      if (((String) addDriverDetails.get(CommonControlDataDefns.TEMP_DRIVER)).equalsIgnoreCase(
              "Yes")) {
        driverType.put(CommonControlDataDefns.TEMP_DRIVER, details);
      } else if (((String) addDriverDetails.get(CommonControlDataDefns.TEMP_DRIVER)).equalsIgnoreCase("No")) {
        driverType.put(CommonControlDataDefns.PERMANENT_DRIVER, details);
      }
    }
    additionalDrivers.put(CommonControlDataDefns.DRIVER, driverType);
    vUniversalData.put(CommonControlDataDefns.ADDITIONAL_DRIVER, additionalDrivers);
    return vUniversalData;
  }
}
