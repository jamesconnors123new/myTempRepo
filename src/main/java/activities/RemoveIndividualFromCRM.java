package activities;

import IntegrationLayers.API.ApiClient;
import IntegrationLayers.API.BindingsAgeas;
import IntegrationLayers.API.IntegrationBase;
import IntegrationLayers.API.Resources;
import helpers.CommonHelper;
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

public class RemoveIndividualFromCRM implements ActivityEndpoint {

    private static final String YAML_INDIVIDUAL_ID = "IndividualId";

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

            System.out.println(credentials.get(YAML_INDIVIDUAL_ID));
            IntegrationBase deleteIndividual = new BindingsAgeas(Resources.DELETE_INDIVIDUAL,null,credentials.get(YAML_INDIVIDUAL_ID));
            deleteIndividual.setHeaders("authorization","Bearer " + bearerToken);
            ApiClient apiCall1 = new ApiClient(deleteIndividual);
            var getDeleteIndividualResponse = apiCall1.sendDelete().then().extract().response();
            var deleteIndividualStatusCode = getDeleteIndividualResponse.statusCode();
            var deleteIndividualResponseBody = getDeleteIndividualResponse.asString();

            if(deleteIndividualStatusCode == 200){
                actionRecordingService.recordEndOfAnActivityInCaseInstRecord();
                return ActivityExecPeriodReturnImpl.completed(uuid, resultsData);
            }else{
                printStream.println(CommonHelper.wrapMessage("Resource 'DELETE_INDIVIDUAL' returned status code: " + deleteIndividualStatusCode));
                return ActivityExecPeriodReturnImpl.faulted(uuid);
            }
        } catch (Exception e) {
            actionRecordingService.writeToTestCaseInstanceRecord(getClass().getSimpleName() + "Activity failed; \n\n" + e.getStackTrace());
            return ActivityExecPeriodReturnImpl.faulted(uuid);
        }
    }
}
