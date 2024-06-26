package IntegrationLayers.API;

public enum Resources {
    GET_NEW_BUSINESS_QUOTE (Vendor.CDL),
    GET_WEB_USER_OVERVIEW (Vendor.CDL),
    GET_WEB_USER (Vendor.CDL),
    CLIENT_SEARCH_EMAIL (Vendor.CDL),
    CLIENT_SEARCH_POLICY_NUMBER (Vendor.CDL),
    LOGIN (Vendor.AGEAS),
    GET_INDIVIDUAL (Vendor.AGEAS),
    GET_PERSON_DETAILS (Vendor.AGEAS),
    GET_INDIVIDUAL_PERSON_POLICY (Vendor.AGEAS),
    DELETE_INDIVIDUAL (Vendor.AGEAS);

    Resources(Vendor cdl) {
    }
}
