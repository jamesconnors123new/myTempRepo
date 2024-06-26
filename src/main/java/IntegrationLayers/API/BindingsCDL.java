package IntegrationLayers.API;

import helpers.CommonHelper;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BindingsCDL implements IntegrationBase{

    private static final String BASE_URL = "https://ageasdirect-api.uat.cdlcloud.co.uk";
    private static final String PROXY = "http://ipv4.86.149.60.141.webdefence.global.blackspider.com:8081";
    private String resourcePath;
    private String bodyTemplateLocation;
    private Map<String ,Object> headerMap;
    private String bodyTemplateTag;
    private String bodyTemplateValue;
    private File file;
    private String resetTemplate;

    {
        setHeaders("Content-Type","text/xml");
    }

    public BindingsCDL(Resources resources, String bodyTemplateValue) throws Exception {
        this.bodyTemplateValue = bodyTemplateValue;
        setResource(resources);

    }

    public void setResource(Resources resources) throws Exception {
        var userDir = System.getProperty("user.dir");
        switch (resources){
            case GET_WEB_USER_OVERVIEW:
                this.resourcePath = "/strataws/services/v45/StrataPort";
                this.bodyTemplateLocation = userDir + "\\src\\main\\java\\IntegrationLayers\\API\\XMLSchemaDefinition\\GetWebUserOverview.xml";
                this.bodyTemplateTag = "username";
                this.resetTemplate = "XML";
                setXMLDefinitionTemplate();
                break;
            case GET_WEB_USER:
                this.resourcePath = "/strataws/services/v45/StrataPort";
                this.bodyTemplateLocation = userDir + "\\src\\main\\java\\IntegrationLayers\\API\\XMLSchemaDefinition\\GetWebUser.xml";
                this.bodyTemplateTag = "username";
                this.resetTemplate = "XML";
                setXMLDefinitionTemplate();
                break;
            case CLIENT_SEARCH_EMAIL:
                this.resourcePath = "/strataws/services/v45/StrataPort";
                this.bodyTemplateLocation = userDir + "\\src\\main\\java\\IntegrationLayers\\API\\XMLSchemaDefinition\\ClientSearchViaUsername.xml";
                this.bodyTemplateTag = "email";
                this.resetTemplate = "XML";
                setXMLDefinitionTemplate();
                break;
            case CLIENT_SEARCH_POLICY_NUMBER:
                this.resourcePath = "/strataws/services/v45/StrataPort";
                this.bodyTemplateLocation = userDir + "\\src\\main\\java\\IntegrationLayers\\API\\XMLSchemaDefinition\\ClientSearchViaPolicyNumber.xml";
                this.bodyTemplateTag = "policyNumber";
                this.resetTemplate = "XML";
                setXMLDefinitionTemplate();
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
        return BASE_URL;
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


}
