package activityRunner;

import activities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sqc.bstof.builtinops.DataGraphEquality_Inputs;
import sqc.bstof.builtinops.DataGraphEquality_RuntimeValues;
import sqc.bstof.builtinops.datatools.AlternativeDataChoices;
import sqc.bstof.builtinops.datatools.DataExporter;
import sqc.bstof.builtinops.datatools.RecordLoader;
import sqc.bstof.builtinops.initiators.LiteralCaseIdInitiator;
import sqc.bstof.builtinops.initiators.LiteralCaseInstanceListInitiator;
import sqc.bstof.builtinops.miscellaneous.EchoControlData;
import sqc.bstof.controller.SequenceController;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;


public class TestRunner {


    public static final String OP_LITERAL_CASE_INITIATOR = "InitiateCase";
    public static final String OP_LITERAL_CASE_LIST_INITIATOR = "InitiateList";
    public static final String OP_LOAD_RECORD_SET = "LoadRecSet";
    public static final String OP_ECHO_CONTROL_DATA = "EchoControlData";

    public static final String OP_DATA_EXPORTER = "DataExporter";

    public static void main(String[] args) {
        var vCatalogue = new HashMap<String,Class>();
        vCatalogue.put(OP_LITERAL_CASE_INITIATOR, LiteralCaseIdInitiator.class);
        vCatalogue.put(OP_LITERAL_CASE_LIST_INITIATOR, LiteralCaseInstanceListInitiator.class);
        vCatalogue.put(OP_LOAD_RECORD_SET, RecordLoader.class);
        vCatalogue.put(OP_ECHO_CONTROL_DATA, EchoControlData.class);
        vCatalogue.put(OP_DATA_EXPORTER, DataExporter.class);


        final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

        //TestSuiteRunner
        var availableActivities = new HashMap<String, Class>();

        //Default
        availableActivities.put("Initiate", LiteralCaseIdInitiator.class);
        availableActivities.put("InitiateList", LiteralCaseInstanceListInitiator.class);
        availableActivities.put("ConditionalDataSelection", AlternativeDataChoices.class);
        availableActivities.put("LoadRecSet", RecordLoader.class);
        availableActivities.put("DataExporter", DataExporter.class );
        availableActivities.put("EchoControlData", EchoControlData.class);
        availableActivities.put("CompareData", DataGraphEquality_RuntimeValues.class);
        availableActivities.put("CompareDataInputs", DataGraphEquality_Inputs.class);


//        availableActivities.put("StringEventMatcher", StringEventMatcher.class);
//        availableActivities.put("XmlEventMatcher", XmlEventMatcher.class);
//        availableActivities.put("XmlInjector", InjectXmlFromFileV2.class);
//        availableActivities.put("FixedWidthFileInjector", FixedWidthFileInjector.class);

        //Application
        availableActivities.put("PortalLogon",PortalLogon.class);
        availableActivities.put("EchelonLogon",EchelonLogon.class);
        availableActivities.put("PortalRegisterPolicy", PortalRegisterPolicy.class);
        availableActivities.put("CheckPolicyAdmin", CheckPolicyAdmin.class);
        availableActivities.put("CheckCRM", CheckCRM.class);
        availableActivities.put("GetPolicyInformation", GetPolicyInformation.class);
        availableActivities.put("ForgotUsername", ForgotUsername.class);
        availableActivities.put("ForgotPassword", ForgotPassword.class);
        availableActivities.put("RemoveIndividualFromCRM", RemoveIndividualFromCRM.class);
        availableActivities.put("PortalChangeMarketing", PortalChangeMarketing.class);
        availableActivities.put("CreateQuotesOnPortal", QuoteCreationOnQnBuyPortal.class);
        availableActivities.put("GetCustomerDetailsPortal", GetCustomerDetailsPortal.class);
        availableActivities.put("GetPolicyInformationPortal", GetPolicyInformationPortal.class);
        availableActivities.put("CheckMTAIsAllowed", CheckMTAIsAllowed.class);
        availableActivities.put("GetCustomerDetailsEchelonUI", GetCustomerDetailsEchelonUI.class);
        availableActivities.put("PerformMTAOnPolicy", PerformMTAOnPolicy.class);
        availableActivities.put("GetPolicyDetailsEchelonUI", GetPolicyDetailsEchelonUI.class);
        availableActivities.put("PaymentOnPortal", PaymentOnPortal.class);
        availableActivities.put("RegisterNewUser", RegisterNewUser.class);
        availableActivities.put("QuoteCreationInEchelonUI", QuoteCreationInEchelonUI.class);
        availableActivities.put("PolicyCreationOnEchelonUI", PolicyCreationOnEchelonUI.class);
        availableActivities.put("CreateClientOnEis", CreateClientOnEis.class);
        availableActivities.put("QuoteCreationInEis", QuoteCreationInEis.class);
        availableActivities.put("GetCarPolicyDetailsPortal", GetCarPolicyDetailsPortal.class);
//        availableActivities.put("CreateHomePolicyEchelonUI", QuoteCreationInEchelonUI.class);
        availableActivities.put("PolicyCreationOnEis", PolicyCreationOnEis.class);
        availableActivities.put("GetPolicyDetailsEis", GetPolicyDetailsEis.class);
        availableActivities.put("AddCCForExistingClient", AddCCForExistingClient.class);
        availableActivities.put("SearchMotorForAGivenVRN", SearchMotorForAGivenVRN.class);
       // availableActivities.put("QnBuyQuoteCreationInPortalUI", QnBuyQuoteCreationInPortalUI.class);
//        availableActivities.put("QuoteCreationMotorOnEchelonUI", QuoteCreationMotorOnEchelonUI.class);
        availableActivities.put("PolicyCreationMotorOnEchelonUI", PolicyCreationMotorOnEchelonUI.class);


        availableActivities.put("QuoteCreationOnQnBuyPortal", QuoteCreationOnQnBuyPortal.class);
        availableActivities.put("PolicyCreationOnQnBuyPortal", PolicyCreationOnQnBuyPortal.class);

        //Call the Framework to run the test suite as defined in the yml file passed in as a command line parameter
        if (!SequenceController.runTestSuite(args[0], availableActivities)) {
            LOGGER.error(String.format("Operation completed. returning non-Zero (Error) status value of One"));
            System.exit(1);
        } else {
            LOGGER.info(String.format("Operation completed. returning Zero (Good) status value of Zero"));
            System.exit(0);
        }
    }
}
