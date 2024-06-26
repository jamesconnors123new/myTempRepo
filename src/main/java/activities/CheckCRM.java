package activities;

import IntegrationLayers.API.ApiClient;
import IntegrationLayers.API.BindingsAgeas;
import IntegrationLayers.API.IntegrationBase;
import IntegrationLayers.API.Resources;
import helpers.CommonHelper;
import helpers.Formatting;
import io.restassured.path.json.JsonPath;
import sqc.bstof.skeleton.ActivityEndpoint;
import sqc.bstof.skeleton.ActivityExecPeriodReturn;
import sqc.bstof.skeleton.ActivityInterimState;
import sqc.bstof.skeleton.SequencerFaceToActivity;
import sqc.bstof.skeletonhelp.ActivityExecPeriodReturnImpl;
import sqc.bstof.skeletonhelp.LocalActionRecordingServices;
import sqc.bstof.skeletonhelp.LocalSettingsAndVariableAccessService;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CheckCRM implements ActivityEndpoint {

    private static final String YAML_EMAIL = "Email";
    private static final String CRM_EMAIL = "primary_email";
    private static final String YAML_CUSTOMER_IDENTIFIER = "CustomerIdentifier";
    private static final String CRM_CUSTOMER_IDENTIFIER = "strata_web_ref";
    private static final String YAML_CRM_CUSTOMER_ID = "CrmCustomerId";
    private static final String CRM_CUSTOMER_ID = "customer_id";
    private static final String YAML_DOB = "Dob";
    private static final String CRM_DOB = "date_of_birth";
    private static final String YAML_TITLE = "Title";
    private static final String CRM_TITLE = "title";
    private static final String YAML_FIRST_NAME = "FirstName";
    private static final String CRM_FIRST_NAME = "first_name";
    private static final String YAML_LAST_NAME = "LastName";
    private static final String CRM_LAST_NAME = "last_name";
    private static final String YAML_PHONE_NUMBER = "PhoneNumber";
    private static final String CRM_PHONE_NUMBER = "phone_no";
    private static final String YAML_BRAND_NAME = "BrandName";
    private static final String CRM_BRAND_NAME = "brand_name";
    private static final String YAML_MATCH = "Match";
    private static final String YAML_INDIVIDUAL_ID = "IndividualId";
    private static final String CRM_INDIVIDUAL_ID = "individual_id";
    private static final String YAML_MARKETING_EMAIL = "MarketingEmail";
    private static final String YAML_MARKETING_POST = "MarketingPost";
    private static final String YAML_MARKETING_SMS = "MarketingSMS";
    private static final String YAML_MARKETING_CALL = "MarketingCall";
    private static final String CRM_MARKETING_STATUS = "marketing_status";
    private static final String CRM_MARKETING_TYPE = "marketing_type";


    private static long tokenLastSpawned;
    private static String bearerToken;

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
            PrintStream printStream) {

        var dataAccess = new LocalSettingsAndVariableAccessService(sequencerFaceToActivity);
        actionRecordingService = new LocalActionRecordingServices(sequencerFaceToActivity);

        String strLogLine = getClass().getSimpleName() + " Activity.execute";
        actionRecordingService.recordStartOfAnActivityInCaseInstRecord(strLogLine);

        var credentials = (HashMap) controlData.get(CommonControlDataDefns.CUSTOMER_CREDENTIALS);
        var resultsData = new HashMap<String, Object>();
        var customer = new HashMap<String, Object>();
        var crm = new HashMap<String,Object>();

        try {
            var currentTime = System.currentTimeMillis();
            if (bearerToken == null || currentTime > tokenLastSpawned + 14000) {
                IntegrationBase login = new BindingsAgeas(Resources.LOGIN);
                ApiClient apiCall1 = new ApiClient(login);
                tokenLastSpawned = System.currentTimeMillis();
                var loginResponse = apiCall1.sendPost().then().extract();
                var loginStatusCode = loginResponse.statusCode();
                bearerToken = loginResponse.path("token");
                if (loginStatusCode != 200) {
                    printStream.println(CommonHelper.wrapMessage("Response 'LOGIN' returned status code: " + loginStatusCode));
                    ActivityExecPeriodReturnImpl.faulted(uuid);
                }
            }

            var debugger = controlData.get("Debug");

            customer.put(YAML_MATCH, "FALSE");
            customer.put(YAML_EMAIL, "No Email found");
            customer.put(YAML_TITLE, "No Title found");
            customer.put(YAML_FIRST_NAME, "No First Name found");
            customer.put(YAML_LAST_NAME, "No Last Name found");
            customer.put(YAML_DOB, "No DOB found");
            customer.put(YAML_CUSTOMER_IDENTIFIER, "No CustomerIdentifier found");
            customer.put(YAML_PHONE_NUMBER, "No Phone Number found");
            customer.put(YAML_BRAND_NAME, "No BrandName found");
            customer.put(YAML_INDIVIDUAL_ID, "No Individual ID found");
            customer.put(YAML_CRM_CUSTOMER_ID, "No CRM Customer ID found");
            customer.put(YAML_MARKETING_POST, "No Post Marketing status found");
            customer.put(YAML_MARKETING_EMAIL, "No Email Marketing status found");
            customer.put(YAML_MARKETING_SMS, "No SMS Marketing status found");
            customer.put(YAML_MARKETING_CALL, "No Call Marketing status found");

            IntegrationBase getIndividual = new BindingsAgeas(Resources.GET_INDIVIDUAL, null, credentials.get(YAML_EMAIL));
            getIndividual.setHeaders("authorization", "Bearer " + bearerToken);
            ApiClient apiCall2 = new ApiClient(getIndividual);
            var getIndividualResponse = apiCall2.sendGet().then().extract();
            var getIndividualStatusCode = getIndividualResponse.statusCode();
            var getIndividualResponseBody = getIndividualResponse.response().asString();

            if (getIndividualStatusCode == 200) {
                var j = new JsonPath(getIndividualResponseBody);
                int s = j.getInt("data.size()");
                if (s > 0) {
                    for (int i = 0; i < s; i++) {
                        var itr = "data[" + i + "].";
                        if (credentials.get(YAML_EMAIL).toString().equalsIgnoreCase(j.getString(itr + CRM_EMAIL))) {
                            customer.replace(YAML_MATCH, "TRUE");
                            customer.replace(YAML_EMAIL, j.getString(itr + CRM_EMAIL));
                            customer.replace(YAML_TITLE, j.getString(itr + CRM_TITLE));
                            customer.replace(YAML_FIRST_NAME, j.getString(itr + CRM_FIRST_NAME));
                            customer.replace(YAML_LAST_NAME, j.getString(itr + CRM_LAST_NAME));
                            customer.replace(YAML_DOB, Formatting.dateFormatter(printStream, j.getString(itr + CRM_DOB)));
                            customer.replace(YAML_CUSTOMER_IDENTIFIER, j.getString(itr + CRM_CUSTOMER_IDENTIFIER));
                            customer.replace(YAML_PHONE_NUMBER, j.getString(itr + CRM_PHONE_NUMBER));
                            customer.replace(YAML_BRAND_NAME, j.getString(itr + CRM_BRAND_NAME));
                            customer.replace(YAML_INDIVIDUAL_ID,j.getString(itr + CRM_INDIVIDUAL_ID));

                            IntegrationBase getIndividualPersonPolicy = new BindingsAgeas(Resources.GET_INDIVIDUAL_PERSON_POLICY,null,customer.get(YAML_INDIVIDUAL_ID));
                            getIndividualPersonPolicy.setHeaders("authorization", "Bearer " + bearerToken);
                            ApiClient apiCall3 = new ApiClient(getIndividualPersonPolicy);
                            var getIndividualPersonPolicyResponse = apiCall3.sendGet().then().extract();
                            var getIndividualPersonPolicyStatusCode = getIndividualPersonPolicyResponse.statusCode();
                            var getIndividualPersonPolicyResponseBody = getIndividualPersonPolicyResponse.response().asString();

                            if(getIndividualPersonPolicyStatusCode == 200){
                                j = new JsonPath(getIndividualPersonPolicyResponseBody);
                                customer.replace(YAML_CRM_CUSTOMER_ID, j.getString("individual_person[0]." + CRM_CUSTOMER_ID));

                                IntegrationBase getPersonDetails = new BindingsAgeas(Resources.GET_PERSON_DETAILS,null,customer.get(YAML_CRM_CUSTOMER_ID));
                                getPersonDetails.setHeaders("authorization", "Bearer " + bearerToken);
                                ApiClient apiCall4 = new ApiClient(getPersonDetails);
                                var getPersonDetailsResponse = apiCall4.sendGet().then().extract();
                                var getPersonDetailsStatusCode = getPersonDetailsResponse.statusCode();
                                var getPersonDetailsResponseBody = getPersonDetailsResponse.response().asString();

                                if(getPersonDetailsStatusCode == 200){
                                    j = new JsonPath(getPersonDetailsResponseBody);
                                    s = j.getInt("marketing_permission.size()");
                                    for(int k = 0; k<s; k++){
                                        itr = "marketing_permission[" + k + "].";
                                        if(j.getString(itr + CRM_MARKETING_TYPE).equals("Email")){
                                            customer.replace(YAML_MARKETING_EMAIL, CommonHelper.yesNoSwitch(j.getString(itr+CRM_MARKETING_STATUS)));
                                        }
                                        if(j.getString(itr + CRM_MARKETING_TYPE).equals("Post")){
                                            customer.replace(YAML_MARKETING_POST,CommonHelper.yesNoSwitch(j.getString(itr+CRM_MARKETING_STATUS)));
                                        }
                                        if(j.getString(itr + CRM_MARKETING_TYPE).equals("SMS")){
                                            customer.replace(YAML_MARKETING_SMS,CommonHelper.yesNoSwitch(j.getString(itr+CRM_MARKETING_STATUS)));
                                        }
                                        if(j.getString(itr + CRM_MARKETING_TYPE).equals("Call")){
                                            customer.replace(YAML_MARKETING_CALL,CommonHelper.yesNoSwitch(j.getString(itr+CRM_MARKETING_STATUS)));
                                        }
                                    }
                                }else {
                                    printStream.println(CommonHelper.wrapMessage("Resource 'GET_PERSON_DETAILS' returned status code: " + getIndividualStatusCode));
                                    return ActivityExecPeriodReturnImpl.faulted(uuid);
                                }
                            }else {
                                printStream.println(CommonHelper.wrapMessage("Resource 'GET_INDIVIDUAL_PERSON_POLICY' returned status code: " + getIndividualStatusCode));
                                return ActivityExecPeriodReturnImpl.faulted(uuid);
                            }
                        }
                    }
                }
            } else {
                printStream.println(CommonHelper.wrapMessage("Resource 'GET_INDIVIDUAL' returned status code: " + getIndividualStatusCode));
                return ActivityExecPeriodReturnImpl.faulted(uuid);
            }

            crm.put("Customer", customer);
            resultsData.put("CRM", crm);

            actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
            return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);

        } catch (Exception e) {
            actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + "Activity failed; \n\n" + e.getStackTrace());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }
}
