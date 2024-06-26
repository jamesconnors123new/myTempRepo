package DataBuilders;

import java.util.*;


public class  PolicyDataBuilders {

    public static final String Key_PolicyRecord_CommonViewOfPolicy = "UniversalView";
    public static final String Key_PolicyRecord_SourceSpecificInfo = "AdditionalInfo";
    public static final String Key_PolicyRecord_PolAdminSysSpecificInfo = "PolAdminSysView";
    public static final String Key_PolicyRecord_PolPortalSpecificInfo = "PolPortalView";

    public static SortedMap<String,Object> PolicyRecordAssembler(
        SortedMap<String,Object> pCommonViewOfPolicy,
        SortedMap<String,Object> pSourceSpecificPolicyInfo,
        SortedMap<String,Object> pPolAdminSysSpecificInfo,
        SortedMap<String,Object> pPolPortalSpecificInfo) {
        var vRecord = new TreeMap<String,Object>();
        vRecord.put(Key_PolicyRecord_CommonViewOfPolicy, pCommonViewOfPolicy);

        var vSourceSpecificPolicyInfo = (pSourceSpecificPolicyInfo!=null)?pSourceSpecificPolicyInfo:new TreeMap<String,Object>();
        vRecord.put(Key_PolicyRecord_SourceSpecificInfo, vSourceSpecificPolicyInfo);

        var vPolAdminSysSpecificInfo =
            (pPolAdminSysSpecificInfo!=null)?
                pPolAdminSysSpecificInfo:new TreeMap<String,Object>();
        vRecord.put(Key_PolicyRecord_PolAdminSysSpecificInfo, vPolAdminSysSpecificInfo);

        var vPolPortalSpecificInfo =
            (pPolPortalSpecificInfo!=null)?
                pPolPortalSpecificInfo:new TreeMap<String,Object>();
        vRecord.put(Key_PolicyRecord_PolPortalSpecificInfo, vPolPortalSpecificInfo);

        return vRecord;
    }

    public static List<Object> PolicySetAssembler(Map<String,Object> pFirstPolicyRecord, Map<String,Object>... pOtherPolicyRecords) {
        var vSet = new ArrayList<Object>();
        vSet.add(pFirstPolicyRecord);
        for(var iRec : pOtherPolicyRecords) {
            vSet.add(iRec);
        }
        return vSet;
    }
}
