package IntegrationLayers.API;

import java.util.Map;

public interface IntegrationBase {

    Map<String,Object> setHeaders(String h1Key, Object h1Value);
    Map<String,Object> setHeaders(String h1Key, Object h1Value, String h2Key, Object h2Value);
    Map<String,Object> setHeaders(String h1Key, Object h1Value, String h2Key, Object h2Value, String h3Key, Object h3Value);
    Map<String,Object> setHeaders(String h1Key, Object h1Value, String h2Key, Object h2Value, String h3Key, Object h3Value, String h4Key, Object h4Value);
    Map<String, Object> getHeaderMap();
    String getBaseURL();
    String getProxy();
    String getBodyData();
    String getResource();
    String getResetTemplate();
    void setResource(Resources resources) throws Exception;
    void setXMLDefinitionTemplate() throws Exception;
    void clearXMLDefinitionTemplate(String defaultValue) throws Exception;
}
