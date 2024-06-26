package IntegrationLayers.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;

import static io.restassured.RestAssured.given;

public class ApiClient{

    private IntegrationBase integrationBase;

    public ApiClient(IntegrationBase object){
        this.integrationBase = object;
    }

    public Response sendPost() throws Exception{
        return sendRequest("POST");
    }

    public Response sendGet() throws Exception{
        return sendRequest("GET");
    }

    public Response sendDelete() throws Exception{
        return sendRequest("DELETE");
    }

    private Response sendRequest(String method) throws Exception {

        var proxy = integrationBase.getProxy();
        if(proxy!=""){RestAssured.proxy(integrationBase.getProxy());}
        RestAssured.baseURI = integrationBase.getBaseURL();
        RequestSpecification request = given();
        request.headers(integrationBase.getHeaderMap());
        Response response = null;
        switch (method){
            case "POST":
                FileInputStream fileInputStream = new FileInputStream(integrationBase.getBodyData());
                response = request.body(IOUtils.toString(fileInputStream,"UTF-8")).post(integrationBase.getResource());
                break;
            case "GET":
                response = request.get(integrationBase.getResource());
                break;
            case "DELETE":
                response = request.delete(integrationBase.getResource());
                break;
        }
        if(integrationBase.getResetTemplate() == "XML"){
            integrationBase.clearXMLDefinitionTemplate("default");
        }
        return response;
    }
}