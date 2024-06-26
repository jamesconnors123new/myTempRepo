package activities;


import Generic.customExceptions.CustomE2eException;
import StepDefinitions.PortalGeneralStepDefinitions;
import StepDefinitions.QnBuyPortalQuotesCreationStepDefinition;
import UiWrappers.Browser;
import UiWrappers.Portal.Site.PortalVer001;
import activities.bases.AgeasPortalLoggedInBase;
import helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.LocalActionRecordingServices;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class QuoteCreationOnQnBuyPortal extends AgeasPortalLoggedInBase<PortalVer001> implements ActivityEndpoint {
    private static final String WEBSITE_ROOT = "AgeasQuotePortal";
    private static final String PRODUCT_TYPE = "ProductType";
    private static final String HOME = "Home";
    private static final String VAN = "VAN";
    private static final String MOTOR = "MOTOR";

    public static final String DEFAULT_DATA_LOCATION = "DefaultDataLoc";
    public static final String OVERRIDES = "Overrides";
    public static final String GENERIC = "Generic";
    public static final String HOME_QUOTE = "HomeQuote";
    public static final String QUOTES = "Quotes";
    public static final String QUOTE_DET = "QuoteDetails";
    public static final String QUOTE_REF = "QuoteReference";

    public static final String HOME_DETAILS = "HomeDetails";
    public static final String COVER_DETAILS = "CoverDetails";
    public static final String CONTENT_COVER = "ContentCover";
    public static final String BUILDING_COVER = "BuildingCover";
    public static final String ABOUT_YOU = "AboutYou";
    public static final String ADDITIONAL_INFORMATION = "AdditionalInformation";
    public static final String COVER_TYPE = "CoverType";


    public static final String HOUSEHOLD_COVER_TYPE = "TypeOfHouseHoldCover";
    public static final String VALUABLE_IN_HOME_SPECIFIED_ITEMS = "ValuableInHomeSpecifiedItems";
    public static final String IND_AWAY_HOME_SPECIFIED_ITEMS = "IndAwayHomeSpecifiedItems";
    public static final String VALUABLES_OVER_2000£_SPECIFIED_ITEMS_AVAIL = "ValuablesOver2000£SpecifiedItemsAvailable";
    public static final String IND_BELONGINGS_SPECIFIED_ITEMS_AVAIL = "IndBelongingsSpecifiedItemsAvailable";
    public static final String PERS_BELONGINGS_SPECIFIED_ITEMS_AVAIL = "PersBelongingsSpecifiedItemsAvailable";
    //public static final String PROPOSAL_PERSONAL_DETAILS = "ProposerPersonalDetails";
    public static final String TYPE_OF_LODGERS = "TypeOfLodgers";

    //TYPE OF LODGERS
    public static final String GUEST_LIVING_NO = "No";
    public static final String GUEST_LIVING_LODGERS = "Yes - Lodgers";
    public static final String GUEST_LIVING_STUDENTS = "Yes - Students";
    public static final String GUEST_LIVING_STUDENTS_AND_LODGERS = "Yes - Students & Lodgers";


    public static final String ADDRESS = "Address";

    public static final String PROPERTY_OWNED = "PropertyOwned";

    public static final String BUILDING_TYPE = "BuildingType";

    /*public static final String BUNGALOW = "Bungalow";
    public static final String HOUSE = "House";
    public static final String TOWN_HOUSE = "Town House";
    public static final String SELF_CONTAINED_FLAT = "Self-contained flat";
    public static final String MAISONETTE = "Maisonette";
    public static final String BEST_DESC_YOUR_HOME = "BestDescribesYourHome";
    public static final String DETACHED = "Detached";
    public static final String SEMI_DETACHED = "Semi-Detached";
    public static final String END_TERRACED = "End Terraced";
    public static final String MID_TERRACED = "Mid-Terraced";*/
    public static final String BUILT_STD_CONST = "ConstructionType";
    public static final String BUILT_STD_CONST_YES_NO = "BuiltStandardConstYesOrNo";
    public static final String ROOF_MADE_OF = "RoofMadeOf";
    public static final String EXTERNAL_WALL_MADE_OF = "ExternalWallsMadeFrom";
    public static final String PERCENTAGE_OF_FLAT_ROOF = "PercentageOfFlatRoof";
    //public static final String BATHROOM_NUM = "BathroomNumber";
    //public static final String BEDROOM_NUM = "BedroomNumber";
    //public static final String BUILT_YEAR = "BuiltYear";
    //public static final String HOME_EXTENSION = "HomeExtension";
    public static final String HOME_EXTENSION = "ExtendedHouse";
    public static final String GRADE = "Grade";
    public static final String HOME_FLOODED = "HomeFloodedIn25Years";
    public static final String MULTI_LOCKING_SYSTEM = "MultiPointLockingSystem";
    public static final String TYPE_INTRUDER_ALARM = "TypeOfIntruderAlarm";
    public static final String RENT_OWN = "RentOrOwn";
    public static final String FURNISHED_HOME = "FurnishedHome";
    public static final String OWNED_OUTRIGHT = "Owned Outright";
    public static final String OWNED_ON_MORTGAGE = "Owned on Mortgage";
    public static final String PRIVATELY_RENTED = "Privately Rented";
    public static final String HOUSING_ASSOCIATION = "Housing Association";
    public static final String COUNCIL_RENTED = "Council Rented";
    public static final String GRADE1 = "Grade 1";
    public static final String GRADE2 = "Grade 2";
    public static final String GRADE2_STAR = "Grade 2*";
    //public static final String NO_GRADE = "No Grade";
    public static final String NO_GRADE = "No";
    public static final String COVER_START_DATE = "InceptionDate";
    //public static final String INSURANCE_PAY_FREQUENCY = "PaymentType";
    public static final String NORMALLY_OCCUPIED = "Occupied";
    public static final String DAY_AND_NIGHT = "Day and night";
    public static final String DURING_DAY = "During the day";
    public static final String DURING_NIGHT = "During the night";
    public static final String UNOCCUPIED = "Unoccupied";
    public static final String HELD_CONTENT_LAST_2_YEAR = "ContentsCover";
    public static final String CLAIM_FREE_YEARS = "ClaimFreeYears";
    public static final String BUILDING_CLAIM_FREE_YEARS = "BuildingClaimFreeYears";
    public static final String INSTANCE_CLAIM_HISTORY = "InstanceClaimHistory";
    public static final Integer CLAIM_FREE_YEARS_VAR = 0;
    public static final String COST_REPLACE_CONTENTS = "ContentSum";
    public static final String ACCIDENTAL_DAMAGE_COVER = "ContentAccidentalDamage";
    public static final String VALUABLES_DETAILS = "ValuablesDetails";
    public static final String YES_OR_NO = "YesOrNo";
    public static final String DETAILS = "Details";
    public static final String CATEGORY = "Employee";
    public static final String ITEM = "Item";
    public static final String DESCRIPTION = "Description";
    public static final String VALUE = "Value";
    public static final String COST = "Cost";
    public static final String PERSONAL_BELONGINGS_AWAY_COST = "PersonalBelongingsAwayCost";
    public static final String EXTRA_COVER_AWAY_FROM_HOME = "ExtraCoverPersonalBelongingsAwayFromHome";
    public static final String INDIVIDUAL_ITEM_AWAY_FROM_HOME = "IndividualItemsAwayFromHome";

    public static final String ANNUALLY = "Annual";
    public static final String MONTHLY = "Monthly";
    public static final String HELD_BUILDING_INSURANCE = "HeldBuildingInsuranceLast2Years";

    public static final String ACCIDENTAL_DAMAGE_COVER_NEEDED = "AccidentalDamageCoverNeeded";

    public static final String TITLE = "Title";
    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String EMAIL_ADDRESS = "EmailAddress";
    public static final String PREFERRED_NUM = "PreferredTelephoneNumber";
    public static final String MAIN_TELEPHONE_NUM = "MainTelephoneNumber";
    //public static final String CORRESPONDENCE_ADD = "CorrespondenceAddress";
    public static final String HOUSE_NUM = "HouseNumber";
    public static final String DATE_OF_BIRTH = "DateOfBirth";
    public static final String UK_RESIDENT_DETAILS = "UkResidentYesOrNo";
    public static final String MARITAL_STATUS = "MaritalStatus";
    public static final String RELATIONSHIP_WITH_POLICY_HOLDER = "RelationshipWithPolicyholder";
    public static final String RELATIONSHIP = "Relationship";
    public static final String POST_CODE = "Postcode";
    public static final String EMPLOYMENT_STATUS = "EmploymentStatus";
    public static final String EMPLOYEE = "Employee";
    public static final String PRIM_JOB_CATEGORY_EMPLOYEE_VAR = "Employee";
    public static final String SELF_EMPLOYED = "Self Employed";
    public static final String RETIRED = "Retired";
    public static final String COMP_DIRECTOR = "Company Director";
    public static final String GOVT_EMPLOYEE = "Government";
    public static final String BUSINESS_OWNER = "Business Owner";
    public static final String FULL_TIME_EDUCATION = "Full Time Education";
    public static final String SPECIFIED_ITEMS = "SpecifiedItems";
    public static final String JOB_TYPE = "Type";
    public static final String JOB_INDUSTRY = "Industry";
    public static final String SECOND_JOB = "SecondJob";
    public static final String STUDENT_TYPE = "StudentType";
    public static final String EMPLOYMENT_DETAILS = "EmploymentDetails";
    public static final String SECOND_JOB_DETAILS = "Employed";
    //public static final String JOINT_HOLDER_DETAILS = "JointPolicyholderDetails";
    public static final String HOUSE_NUMBER = "HouseIdentifier";

    public static final String RISK_ADDRESS_HOUSE_NUMBER = "RiskAddressHouseIdentifier";
    public static final String RISK_POSTCODE = "RiskPostcode";
    public static final String ADULT_NUMBER = "Adult";
    public static final String CHILD_NUMBER = "Children";
    public static final String PETS_LIVING = "PetsLivingInHome";
    public static final String PAYING_GUEST = "PayingGuestInHome";
    public static final String HOUSE_USED_BUSINESS_PURPOSE = "BusinessUse";
    public static final String CLERICAL_USAGE = "ClericalUsage";
    public static final String CLAIM_IN_LAST_FIVE_YEAR = "ClaimInLast5Years";
    public static final String DATE_OF_INCIDENT = "IncidentDate";
    public static final String SECTION_POLICY = "SectionOfPolicy";
    public static final String CLAIM_DESC = "ClaimDescription";
    public static final String ACCIDENTAL_DAMAGE = "Accidental Damage";
    public static final String CLAIM_COST = "CostClaim";
    public static final String SUFFERED_LOSS_IN_LAST_FIVE_YEAR = "SufferedLossesIncidentLast5Years";
    public static final String CONTACT_PREFERENCE = "ContactPreference";
    public static final String CAR_INSURANCE_RENEWAL = "CarInsuranceRenewal";

    public static final String CONTACT_PREFERENCE_TEXT = "Text";
    public static final String CONTACT_PREFERENCE_POST = "Post";
    public static final String CONTACT_PREFERENCE_EMAIL = "Email";
    public static final String CONTACT_PREFERENCE_PHONE = "Phone";

    //public static final String BEST_DESC_YOUR_HOME = "BestDescribesYourHome";
    public static final String BEST_DESC_YOUR_HOME_DETACHED = "Detached";
    public static final String BEST_DESC_YOUR_HOME_SEMI_DETACHED = "Semi-Detached";
    public static final String BEST_DESC_YOUR_HOME_END_TERRACED = "End Terraced";
    public static final String BEST_DESC_YOUR_HOME_MID_TERRACED_VAR = "Mid-Terraced";

    //PETS OPTION LIST
    public static final String NO_PET = "No";
    public static final String CAT_LIVING = "Yes - Cats";
    public static final String CAT_AND_DOG_LIVING = "Yes - Cats and Dogs";
    public static final String DOG_LIVING = "Yes - Dogs";
    public static final String OTHER_ANIMAL_LIVING = "Yes - Other";

    public static final String USAGE_VAR = "Usage";

    public static final String NO_CAR_INSURANCE = "No Car Insurance";


    LocalActionRecordingServices actionRecordingService = null;
    ActivityExecPeriodReturn executionResult;

    @Override
    protected WebDriver ProvideWebDriver() throws CustomE2eException {
        return SeleniumHelper.openBrowser();
    }


    @Override
    protected boolean requiresLogin() {
        return false;
    }

    @Override
    public ActivityExecPeriodReturn performActionLoggedIntoPortal(
            PageObjects.PortalModel.Root pageObjectOfPortal,
            Browser<PageObjects.PortalModel.Root, PortalGeneralStepDefinitions> pBrowser,
            SequencerFaceToActivity sequencerFaceToActivity,
            UUID uuid,
            Map<String, Object> controlData,
            ActivityInterimState activityInterimState,
            PrintStream printStream) {

        //WebDriver driver = null;
        Map<String, Object> resultsData = new HashMap<>();
        Map<String, Object> returnYaml = new HashMap<>();

        //var dataAccess = new LocalSettingsAndVariableAccessService(sequencerFaceToActivity);
        //var rootUrl = (String) dataAccess.getGlobalSetting(WEBSITE_ROOT);

        actionRecordingService = new LocalActionRecordingServices(sequencerFaceToActivity);
        String strLogLine = getClass().getSimpleName() + " Activity.execute";
        actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

        //Open Browser

        try {
            var quoteCreationPage = new QnBuyPortalQuotesCreationStepDefinition(pBrowser.Wd(), pageObjectOfPortal);
            var commonPageObject = new PortalGeneralStepDefinitions(pBrowser.Wd(), pageObjectOfPortal);
            var commonControlDataDef = new CommonControlDataDefns();
            //var eisHomeQuoteCreationStepDefinition = new EisHomeQuoteCreationStepDefinition();
            var salesDetails = ((Map<String, Object>) controlData.get(commonControlDataDef.SALES_DETAILS_VAR));
            var quotesDetails = (Map<String, Object>) salesDetails.get(commonControlDataDef.QUOTE_DETAILS);
            var insuranceDetails = (Map<String, Object>) salesDetails.get(commonControlDataDef.INSURANCE_DETAILS);
            var buildingDetails = (Map<String, Object>) insuranceDetails.get(commonControlDataDef.BUILDING_DETAILS);


            commonPageObject.acceptCookieBtn(); // Accept cookies
            var typeOfQuote = (String) quotesDetails.get(PRODUCT_TYPE);
            //for (String quote : typeOfQuotes) {
            if (typeOfQuote.equalsIgnoreCase(HOME)) {
                quoteCreationPage.enterHomeDetails(salesDetails, (Map<String, Object>) insuranceDetails.get(HOUSEHOLD_COVER_TYPE),
                        (Map<String, Object>) ((Map<Object, Object>) salesDetails.get(commonControlDataDef.PROPOSER_CONTACT_DETAILS)).get(commonControlDataDef.CORRESPONDENCE_ADDRESS),
                        buildingDetails, (Map<String, Object>) salesDetails.get(commonControlDataDef.DYNAMIC_UNDERWRITER_QUESTIONS), (Map<String, Object>) buildingDetails.get(commonControlDataDef.ADDITIONAL_INFORMATION_VAR));
                quoteCreationPage.enterCoverDetails(salesDetails);

                quoteCreationPage.enterContentCover(insuranceDetails);
                quoteCreationPage.enterBuildingCover(insuranceDetails);

                quoteCreationPage.enterAboutYouDetails(salesDetails, insuranceDetails, (Map<String, Object>) salesDetails.get(commonControlDataDef.PROPOSER_PERSONAL_DETAILS),
                        (Map<String, Object>) salesDetails.get(commonControlDataDef.PROPOSER_CONTACT_DETAILS), (Map<String, Object>) salesDetails.get(commonControlDataDef.MARKETING_CHOICE_VAR));
                String quoteNumber = quoteCreationPage.enterAdditionalInformation(salesDetails, (Map<String, Object>) salesDetails.get(commonControlDataDef.DYNAMIC_UNDERWRITER_QUESTIONS),
                        (Map<String, Object>) insuranceDetails.get(USAGE_VAR), (Map<String, Object>) salesDetails.get(commonControlDataDef.OTHER_VAR));
                returnYaml.put(QUOTE_REF, quoteNumber);

                Map<?, ?> enhancePolicyCover = quoteCreationPage.enhancePolicyCover((Map<?, ?>) salesDetails.get(commonControlDataDef.OPTIONAL_EXTRAS), resultsData);
                returnYaml.put(commonControlDataDef.BUILDING_EXCESS, enhancePolicyCover.get(commonControlDataDef.BUILDING_EXCESS));
                returnYaml.put(commonControlDataDef.CONTENT_EXCESS, enhancePolicyCover.get(commonControlDataDef.CONTENT_EXCESS));
                returnYaml.put(commonControlDataDef.MONTHLY_PAYMENT, enhancePolicyCover.get(commonControlDataDef.MONTHLY_PAYMENT));
                returnYaml.put(commonControlDataDef.ANNUAL_PAYMENT, enhancePolicyCover.get(commonControlDataDef.ANNUAL_PAYMENT));
                returnYaml.put(commonControlDataDef.EXTRA_HOME_COVER_VALUE, enhancePolicyCover.get(commonControlDataDef.EXTRA_HOME_COVER_VALUE));
            } else if (typeOfQuote.equals(VAN)) {
                //In Progress
            } else if (typeOfQuote.equals(MOTOR)) {
                //In Progress
            }
            //}

            actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + " Activity completed");
            resultsData.put(commonControlDataDef.QUOTE_DET, returnYaml);
            return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
        } catch (Exception customE2eException) {
            useActionRecordingService().reportRuntimeFaultIssue(customE2eException);
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }
}
