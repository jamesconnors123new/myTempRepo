package Generic.customExceptions;

import java.util.ArrayList;

public class OpImplMalfunction_MethodCalledWithInvalidParameters extends OpImplMalfunction{
    private static String FormMessage(String pMethod, Object[] pParams) {
        var vParamLineList = new ArrayList<String>();
        for(var iIndex=0; iIndex<pParams.length; iIndex++) {
            vParamLineList.add(String.format("P[%02d]: "+ pParams[iIndex], iIndex));
        }
        var vParamTextBlock = String.join("\n", vParamLineList);
        var vMessageText = String.join("\n", "Call to: " + pMethod + "with invalid parameters", vParamTextBlock);
        return vMessageText;
    }

    public OpImplMalfunction_MethodCalledWithInvalidParameters(String pMethod, Object... pParams) {
        super(FormMessage(pMethod,pParams));
    }
}
