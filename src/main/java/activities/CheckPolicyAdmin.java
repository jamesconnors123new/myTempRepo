package activities;

import IntegrationLayers.API.ApiClient;
import IntegrationLayers.API.BindingsCDL;
import IntegrationLayers.API.IntegrationBase;
import IntegrationLayers.API.Resources;
import helpers.CommonHelper;
import org.w3c.dom.Document;
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

public class CheckPolicyAdmin implements ActivityEndpoint {

    private static final String YAML_POLICY_TYPE = "PolicyType";
    private static final String POLICY_ADMIN_POLICY_TYPE = "policyType";
    private static final String YAML_POLICY_STATUS = "PolicyStatus";
    private static final String POLICY_ADMIN_POLICY_STATUS = "policyStatus";
    private static final String YAML_INCEPTION_DATE = "InceptionDate";
    private static final String POLICY_ADMIN_INCEPTION_DATE = "policyInceptionDate";
    private static final String YAML_AFFINITY = "Affinity";
    private static final String POLICY_ADMIN_AFFINITY = "partyAffinity";
    private static final String YAML_EMAIL = "Email";
    private static final String POLICY_ADMIN_EMAIL = "emailAddress";
    private static final String YAML_CUSTOMER_IDENTIFIER = "CustomerIdentifier";
    private static final String YAML_POLICY_IDENTIFIER = "PolicyIdentifier";
    private static final String POLICY_ADMIN_POLICY_IDENTIFIER = "policyNumber";
    private static final String YAML_POLICY_COUNT = "Count";
    private static final String YAML_MATCH = "Match";


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
        var policy = new HashMap<String, Object>();
        var policyAdmin = new HashMap<String, Object>();
        var crm = new HashMap<String,Object>();

        try {
            IntegrationBase getWebUserOverview = new BindingsCDL(Resources.GET_WEB_USER_OVERVIEW, credentials.get(YAML_CUSTOMER_IDENTIFIER).toString());
            ApiClient apiCall3 = new ApiClient(getWebUserOverview);
            var getWebUserOverviewResponse = apiCall3.sendPost().then().extract();
            var getWebUserStatusCode = getWebUserOverviewResponse.statusCode();
            var getWebUserResponseBody = getWebUserOverviewResponse.response().asPrettyString();

            if (getWebUserStatusCode == 200) {
                policy.put(YAML_MATCH, "FALSE");
                policy.put(YAML_POLICY_IDENTIFIER, "No PolicyIdentifier Found");
                policy.put(YAML_POLICY_TYPE, "No PolicyType Found");
                policy.put(YAML_POLICY_STATUS, "No PolicyStatus Found");
                policy.put(YAML_INCEPTION_DATE, "No InceptionDate Found");
                policy.put(YAML_AFFINITY, "No Affinity Found");
                policy.put(YAML_EMAIL, "No Email Found");
                var responseValue = getWebUserResponseBody.split("<activatedInd>")[1].split("</activatedInd>")[0];
                if (!responseValue.equals("")) {
                    Document doc = CommonHelper.convertStringToXMLDocument(getWebUserResponseBody);
                    var policyCount = doc.getElementsByTagName("policy").getLength();
                    policy.put(YAML_POLICY_COUNT, policyCount);
                    if (policyCount > 0) {
                        for (int i = 0; i < policyCount; i++) {
                            if (doc.getElementsByTagName(POLICY_ADMIN_POLICY_IDENTIFIER).item(i).getTextContent().equalsIgnoreCase(credentials.get(YAML_POLICY_IDENTIFIER).toString())) {
                                policy.replace(YAML_MATCH, "TRUE");
                                policy.replace(YAML_POLICY_IDENTIFIER, doc.getElementsByTagName(POLICY_ADMIN_POLICY_IDENTIFIER).item(i).getTextContent());
                                policy.replace(YAML_POLICY_TYPE, doc.getElementsByTagName(POLICY_ADMIN_POLICY_TYPE).item(i).getTextContent());
                                policy.replace(YAML_POLICY_STATUS, doc.getElementsByTagName(POLICY_ADMIN_POLICY_STATUS).item(i).getTextContent());
                                policy.replace(YAML_INCEPTION_DATE, doc.getElementsByTagName(POLICY_ADMIN_INCEPTION_DATE).item(i).getTextContent());
                                policy.replace(YAML_AFFINITY, doc.getElementsByTagName(POLICY_ADMIN_AFFINITY).item(i).getTextContent());
                                policy.replace(YAML_EMAIL, doc.getElementsByTagName(POLICY_ADMIN_EMAIL).item(i).getTextContent());
                            }
                        }
                    }
                }
            } else {
                printStream.println(CommonHelper.wrapMessage("Resource 'GET_WEB_USER_OVERVIEW' returned status code: " + getWebUserStatusCode));
                printStream.println(CommonHelper.wrapMessage("Response contains identifier for activated individual: " + getWebUserResponseBody.contains("<activatedInd>")));
                return ActivityExecPeriodReturnImpl.faulted(uuid);
            }

            policyAdmin.put("Policy", policy);
            resultsData.put("PolicyAdmin", policyAdmin);

            actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
            return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);

        } catch (Exception e) {
            actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + "Activity failed; \n\n" + e.getStackTrace());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }
}
