package IntegrationLayers.API;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.CommonHelper;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BindingsAgeas implements IntegrationBase{

    private static final String PROXY = "";
    private String base_URL;
    private String resourcePath;
    private String bodyTemplateLocation;
    private Map<String ,Object> headerMap;
    private String bodyTemplateTag;
    private String bodyTemplateValue;
    private File file;
    private static String userDir = System.getProperty("user.dir");
    private Object param;
    private String resetTemplate;

    {
        setHeaders("Content-Type","application/json");
    }

    public BindingsAgeas(Resources resources, String bodyTemplateValue, Object param) throws Exception {
        this.bodyTemplateValue = bodyTemplateValue;
        this.param = param;
        setResource(resources);
    }

    public BindingsAgeas(Resources resources) throws Exception {
        setResource(resources);
    }

    public void setResource(Resources resources) throws Exception {
        switch (resources){
            case LOGIN:
                this.base_URL = "https://azinduscrmapitest.brokerwebservice.co.uk/api";
                this.resourcePath = "/admin/login";
                this.bodyTemplateLocation = userDir + "\\src\\main\\java\\IntegrationLayers\\API\\JSONSchemaDefinition\\Login.json";
                break;
            case GET_INDIVIDUAL:
                this.base_URL = "https://azinduscrmapitest.brokerwebservice.co.uk/api";
                this.resourcePath = "/individuals/getAllIndividual?page=1&email=" + param;
                break;
            case GET_INDIVIDUAL_PERSON_POLICY:
                this.base_URL = "https://azinduscrmapitest.brokerwebservice.co.uk/api";
                this.resourcePath = "/admin/getIndividalPersonPolicy/" + param;
                break;
            case GET_PERSON_DETAILS:
                this.base_URL = "https://azinduscrmapitest.brokerwebservice.co.uk/api";
                this.resourcePath = "/admin/getPersonDetails/" + param;
                break;
            case DELETE_INDIVIDUAL:
                this.base_URL = "https://azinduscrmapitest.brokerwebservice.co.uk/api";
                this.resourcePath = "/admin/deleteIndividual/" + param;
                break;
        }
    }

    public Map<String,Object> setHeaders(String h1Key, Object h1Value){
        headerMap = new HashMap<>();
        headerMap.put(h1Key,h1Value);
        return headerMap;
    }

    public Map<String,Object> setHeaders(String h1Key, Object h1Value, String h2Key, Object h2Value){
        headerMap = new HashMap<>();
        headerMap.put(h1Key,h1Value);
        headerMap.put(h2Key,h2Value);
        return headerMap;
    }

    public Map<String,Object> setHeaders(String h1Key, Object h1Value, String h2Key, Object h2Value, String h3Key, Object h3Value){
        headerMap = new HashMap<>();
        headerMap.put(h1Key,h1Value);
        headerMap.put(h2Key,h2Value);
        headerMap.put(h3Key,h3Value);
        return headerMap;
    }
    public Map<String,Object> setHeaders(String h1Key, Object h1Value, String h2Key, Object h2Value, String h3Key, Object h3Value, String h4Key, Object h4Value){
        headerMap = new HashMap<>();
        headerMap.put(h1Key,h1Value);
        headerMap.put(h2Key,h2Value);
        headerMap.put(h3Key,h3Value);
        headerMap.put(h4Key,h4Value);
        return headerMap;
    }

    public String getBaseURL(){
        return base_URL;
    }

    public String getProxy() {
        return PROXY;
    }

    public String getBodyData() {
        return bodyTemplateLocation;
    }

    public Map<String, Object> getHeaderMap() {
        return headerMap;
    }

    public String getResource() {
        return resourcePath;
    }

    public String getResetTemplate(){
        return resetTemplate;
    }

    public void setXMLDefinitionTemplate() throws Exception {
        file = new File(bodyTemplateLocation);
        Document document = CommonHelper.readXmlDocument(file);
        CommonHelper.makeChanges(document, bodyTemplateTag, bodyTemplateValue);
        Transformer transformer = CommonHelper.createXmlTransformer();
        CommonHelper.overwriteXmlFile(file, document, transformer);
    }

    public void clearXMLDefinitionTemplate(String defaultValue) throws Exception {
        file = new File(bodyTemplateLocation);
        Document document = CommonHelper.readXmlDocument(file);
        CommonHelper.makeChanges(document, bodyTemplateTag, defaultValue);
        Transformer transformer = CommonHelper.createXmlTransformer();
        CommonHelper.overwriteXmlFile(file, document, transformer);
    }

    public void setJsonDefinitionTemplate() throws IOException {
        file = new File(bodyTemplateLocation);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readValue(file, JsonNode.class);
        String jsonString = mapper.writeValueAsString(jsonNode);
        System.out.println(jsonString);
    }

}
