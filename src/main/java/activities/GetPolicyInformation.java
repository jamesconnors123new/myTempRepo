package activities;

import IntegrationLayers.API.ApiClient;
import IntegrationLayers.API.BindingsCDL;
import IntegrationLayers.API.IntegrationBase;
import IntegrationLayers.API.Resources;
import helpers.CommonHelper;
import helpers.Formatting;
import org.w3c.dom.Document;
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

public class GetPolicyInformation implements ActivityEndpoint {

    private static final String YAML_POLICY_IDENTIFIER = "PolicyIdentifier";
    private static final String YAML_CUSTOMER_IDENTIFIER = "CustomerIdentifier";
    private static final String YAML_POSTCODE = "Postcode";
    private static final String YAML_DOB = "Dob";
    private static final String YAML_CLIENT_STATUS = "ClientStatus";
    private static final String YAML_EMAIL = "Email";
    private static final String YAML_ADDRESS = "Address";
    private static final String YAML_NAME_LINE = "NameLine";
    private static final String YAML_MATCH = "Match";
    private static final String POLICY_ADMIN_CUSTOMER_IDENTIFICATION_ATTRIBUTE = "proposerID";
    private static final String POLICY_ADMIN_CUSTOMER_DOB_ATTRIBUTE = "dateOfBirth";
    private static final String POLICY_ADMIN_CUSTOMER_POSTCODE_ATTRIBUTE = "postcode";
    private static final String POLICY_ADMIN_CUSTOMER_NAMELINE_ATTRIBUTE = "nameline";
    private static final String POLICY_ADMIN_CUSTOMER_ADDRESS_LINE_ATTRIBUTE = "addressLine";
    private static final String POLICY_ADMIN_CUSTOMER_EMAIL_ATTRIBUTE = "emailAddress";
    private static final String POLICY_ADMIN_CUSTOMER_CLIENT_STATUS_ATTRIBUTE = "clientStatus";

    public boolean tryOneOffInitialisation() {
        return true;
    }

    LocalActionRecordingServices actionRecordingService;

    @Override
    public ActivityExecPeriodReturn execute(
            SequencerFaceToActivity sequencerFaceToActivity,
            UUID uuid,
            Map<String, Object> controlData,
            ActivityInterimState activityInterimState,
            PrintStream printStream){

        actionRecordingService = new LocalActionRecordingServices(sequencerFaceToActivity);
        String strLogLine = getClass().getSimpleName() + " Activity.execute";
        actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

        var resultsData = new HashMap<String, Object>();
        var policyAdmin = new HashMap<String,Object>();
        var services = new HashMap<String,Object>();
        var customer = new HashMap<String,Object>();

        try {
            var cdCredentials = (((HashMap)controlData.get(CommonControlDataDefns.CUSTOMER_CREDENTIALS)));

            customer.put(YAML_MATCH, "FALSE");
            customer.put(YAML_DOB,"No DOB found");
            customer.put(YAML_POSTCODE,"No Postcode found");
            customer.put(YAML_CUSTOMER_IDENTIFIER,"No CustomerIdentifier found");
            customer.put(YAML_EMAIL,"No Email found");
            customer.put(YAML_ADDRESS, "No Address found");
            customer.put(YAML_CLIENT_STATUS, "No ClientStatus found");
            customer.put(YAML_NAME_LINE, "No NameLine found");

            IntegrationBase policyAdminCustomerSearch = new BindingsCDL(Resources.CLIENT_SEARCH_POLICY_NUMBER,
                    (cdCredentials).get(YAML_POLICY_IDENTIFIER).toString());
            ApiClient apiCall1 = new ApiClient(policyAdminCustomerSearch);

            var policyAdminCustomerSearchResponse = apiCall1.sendPost().then().extract();
            var policyAdminCustomerSearchResponseBody = policyAdminCustomerSearchResponse.response().asPrettyString();
            var policyAdminCustomerSearchStatusCode = policyAdminCustomerSearchResponse.statusCode();

            Document doc = CommonHelper.convertStringToXMLDocument(policyAdminCustomerSearchResponseBody);

            if(policyAdminCustomerSearchStatusCode == 200){
                if(doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_IDENTIFICATION_ATTRIBUTE).item(0) != null){
                    customer.replace(YAML_MATCH, "TRUE");
                    customer.replace(YAML_DOB,Formatting.dateFormatter(printStream,doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_DOB_ATTRIBUTE).item(0).getTextContent()));
                    customer.replace(YAML_POSTCODE,doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_POSTCODE_ATTRIBUTE).item(0).getTextContent());
                    customer.replace(YAML_CUSTOMER_IDENTIFIER,doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_IDENTIFICATION_ATTRIBUTE).item(0).getTextContent());
                    customer.replace(YAML_EMAIL,doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_EMAIL_ATTRIBUTE).item(0).getTextContent());
                    customer.replace(YAML_ADDRESS, Formatting.addressSingleLinePatternMatch(doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_ADDRESS_LINE_ATTRIBUTE).item(0).getTextContent(),cdCredentials.get("Address").toString()));
                    customer.replace(YAML_CLIENT_STATUS, doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_CLIENT_STATUS_ATTRIBUTE).item(0).getTextContent());
                    customer.replace(YAML_NAME_LINE, doc.getElementsByTagName(POLICY_ADMIN_CUSTOMER_NAMELINE_ATTRIBUTE).item(0).getTextContent());
                }
            }else{
                printStream.println(CommonHelper.wrapMessage("Resource 'CLIENT_SEARCH_POLICY_NUMBER' returned status code: " + policyAdminCustomerSearchStatusCode));
                return ActivityExecPeriodReturnImpl.faulted(uuid);
            }

            services.put("StatusCode", policyAdminCustomerSearchStatusCode);
            services.put("strStatusCode",String.valueOf(policyAdminCustomerSearchStatusCode));
            policyAdmin.put("Customer",customer);
            policyAdmin.put("Services", services);
            resultsData.put("PolicyAdmin", policyAdmin);

            actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
            return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);

        } catch (Exception e) {
            actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + "Activity failed; \n\n" + e.getStackTrace());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }
}
