package helpers;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class ControlDataHelpers {
    public static boolean ValidateMapContainsFieldWithNonEmptyStringValue(Map<String,Object> pMap, String pTag) {
        if(pMap==null||!pMap.containsKey(pTag)){
            return false;
        }
        var vValueAsObject = pMap.get(pTag);
        if(!(vValueAsObject instanceof String)) {
            return false;
        }
        var vValueAsString = (String)vValueAsObject;
        if(StringUtils.isBlank(vValueAsString)) {
            return false;
        }
        return true;
    }

    public static boolean ValidateMapContainsFieldWithChildMap(Map<String,Object> pMap, String pTag) {
        if(pMap==null||!pMap.containsKey(pTag)){
            return false;
        }
        var vValueAsObject = pMap.get(pTag);
        try {
            var vValueAsMap = (Map<String,Object>)vValueAsObject;
            return true;
        } catch(Throwable pThrown) {
            return false;
        }
    }

    public static boolean ValidateMapContainsNonEmptyStringValueAtPath(Map<String,Object> pMap, String... pTags) {
        var vLevels = pTags.length;
        var vSource = pMap;
        for(var iLevel=0; iLevel<vLevels; iLevel++) {
            if(iLevel==vLevels-1) {
                return ValidateMapContainsFieldWithNonEmptyStringValue(vSource,pTags[iLevel]);
            } else {
                //Looking for map
                if(!ValidateMapContainsFieldWithChildMap(vSource,pTags[iLevel])) {
                    return false;
                } else {
                    vSource = (Map<String,Object>)vSource.get(pTags[iLevel]);
                }
            }
        }
        return false;
    }

    public static String MissingValueErrorMessage(String... pPath) {
        var vPath = String.join(".", pPath);
        return "Appropriate value not provides for: "+vPath;
    }
}
