package helpers;

import Generic.customExceptions.CustomE2eException;
import UiWrappers.Browser;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DropDownNumericListUpdater {
    public record ChangeDetails(int OldIndex, int NewIndex) {};

    public interface CurrentValueReader {
        int Read(Browser pBrowser, By pControlLocator) throws CustomE2eException;
    }

    public interface ValueToUiTextConvertor {
        String Convert(int pValue);
    }
    public interface UiTextToValueConvertor {
        int Convert(String pUiText);
    }
    public interface ProposedValueValidator {
        boolean Check(int pProposedValue);
    }

    public enum ListOperatingMode {
        ValueIsMax,
        ValueIsMin
    }

    private static int ExtractChangeAmountFromChangeSpecificaton(String pChangeSpecification) throws CustomE2eException {
        if(pChangeSpecification.length()>2) {
            var vValuePart = pChangeSpecification.substring(2);
            if(StringUtils.isNumeric(vValuePart)) {
                return Integer.parseInt(vValuePart);
            }
        }
        throw new CustomE2eException(String.format("Issue with change specification value part %s", pChangeSpecification));
    }

    private static int LocateIndexForValue(List<Pair<Integer,Integer>> pRangeList, int pValue ) {
        for(var iRangeIndex=0; iRangeIndex<pRangeList.size(); iRangeIndex++) {
            var vRange = pRangeList.get(iRangeIndex);
            if(pValue>= vRange.getLeft() && pValue<=vRange.getRight()) {
                return iRangeIndex;
            }
        }
        return -1;
    }

    static void EnforceChangeCheck(boolean pEnforceChange, int vOriginalIndex, int vNewIndex) throws CustomE2eException {
        if(pEnforceChange&&(vOriginalIndex==vNewIndex)) {
            throw new CustomE2eException(String.format("Index did not change from %d", vOriginalIndex));
        }
    }

    public static ChangeDetails ChangeNumericDropDownSelector(
            // Tailoring parameters
            By byLocator,
            CurrentValueReader pCurrentValue,
            ValueToUiTextConvertor pValToUiTextConv,
            UiTextToValueConvertor pUiTextToValConv,
            ProposedValueValidator pProposedValueValidator,
            ListOperatingMode pListOperatingMode,
            boolean pEnforceChange,
            // Use parameters
            Browser pBrowser,
            Object pChangeSpecification) throws CustomE2eException
    {
        // analyse the list
        var vValueSelectorDropdown = new Select(pBrowser.Sh().findElement(byLocator, SyncType.VISIBLE, String.format("Locating dropdown failed [%s].", byLocator.toString())));
        var vValueOptions = vValueSelectorDropdown.getOptions();
        var vRangeList = new ArrayList<Pair<Integer, Integer>>();
        if (pListOperatingMode.equals(ListOperatingMode.ValueIsMax)) {
            var vLowerValueForRange = 0;
            for (var iValueOption : vValueOptions) {
                var vValueFromListEntry = pUiTextToValConv.Convert((iValueOption.getText()));
                vRangeList.add(new ImmutablePair<>(vLowerValueForRange, vValueFromListEntry));
                vLowerValueForRange = vValueFromListEntry + 1;
            }
        } else if (pListOperatingMode.equals(ListOperatingMode.ValueIsMin)) {
            var vUpperValueForRange = Integer.MAX_VALUE;
            for (var iIndex = vValueOptions.size() - 1; iIndex >= 0; iIndex--) {
                var vValueFromListEntry = pUiTextToValConv.Convert(vValueOptions.get(iIndex).getText());
                vRangeList.add(new ImmutablePair<>(vValueFromListEntry, vUpperValueForRange));
                vUpperValueForRange = vValueFromListEntry - 1;
            }
            Collections.reverse(vRangeList);
        }
        if (vRangeList.isEmpty()) {
            throw new CustomE2eException(String.format("No ranges to select from on [%s]", byLocator.toString()));
        }

        // Obtain the current value information
        var vCurrentValue = pCurrentValue.Read(pBrowser, byLocator);
        var vCurrentValueUiTextForm = pValToUiTextConv.Convert(vCurrentValue);
        var vOrigValueIndex = pBrowser.Sh().getIndex(byLocator, vCurrentValueUiTextForm, String.format("Could not find index for value of %s in %s", vCurrentValueUiTextForm, byLocator.toString()));

        if(pChangeSpecification instanceof String) {


            // Preliminary validation of pChangeSpecification
            if (StringUtils.isBlank((String)pChangeSpecification)) {
                throw new CustomE2eException(String.format("Invalid change specification [%s]", (String)pChangeSpecification));
            }
            var vChangeSpecification = ((String)pChangeSpecification).trim();





            // Determine if we have an explicitly specified numeric change
            var vNumericChangeAmountSpecified = false;
            var vChangeAmount = 0;
            if (vChangeSpecification.startsWith("++")) {
                // Add to the numeric value
                vChangeAmount = ExtractChangeAmountFromChangeSpecificaton(vChangeSpecification);
                vNumericChangeAmountSpecified = true;

            } else if (vChangeSpecification.startsWith("--")) {
                vChangeAmount = -ExtractChangeAmountFromChangeSpecificaton(vChangeSpecification);
                vNumericChangeAmountSpecified = true;
            }

            // Action if we have an explicitly specified numeric change
            if (vNumericChangeAmountSpecified) {
                var vNewValue = vCurrentValue + vChangeAmount;
                if (!pProposedValueValidator.Check(vNewValue)) {
                    throw new CustomE2eException(String.format("Generated new value proposal is not acceptable [%d]", vNewValue));
                }
                var vNewValueIndex = LocateIndexForValue(vRangeList, vNewValue);
                if (vNewValueIndex >= 0) {
                    vValueSelectorDropdown.selectByIndex(vNewValueIndex);
                } else {
                    throw new CustomE2eException(String.format("Value of %d did not match an option offered by %s", vNewValue, byLocator.toString()));
                }
                EnforceChangeCheck(pEnforceChange,vOrigValueIndex,vNewValueIndex);
                return new ChangeDetails(vOrigValueIndex ,vNewValueIndex);
            }

            if (vChangeSpecification.equals("$$")) {
                // Randome choice of a different options
                if (vRangeList.size() < 2) {
                    throw new CustomE2eException(String.format("Cannot force difference option selection as the number of choices available is %d", vRangeList.size()));
                }
                var vCurIndex = LocateIndexForValue(vRangeList, vCurrentValue);
                var vRandomGenerator = new Random();
                var vNewValueIndex = vCurIndex;
                while (vNewValueIndex == vCurIndex) {
                    vNewValueIndex = vRandomGenerator.nextInt(vRangeList.size());
                }
                vValueSelectorDropdown.selectByIndex(vNewValueIndex);
                EnforceChangeCheck(pEnforceChange,vOrigValueIndex,vNewValueIndex);
                return new ChangeDetails(vCurIndex ,vNewValueIndex);
            }

            if (vChangeSpecification.equals("$+")) {
                // Next highest
                //var vOrigValueIndex = LocateIndexForValue(vRangeList, vCurrentValue);
                var vNewValueIndex = vOrigValueIndex + 1;
                if (vNewValueIndex >= vRangeList.size()) {
                    throw new CustomE2eException(String.format("Cannot select a successor range, already on last range"));
                }
                vValueSelectorDropdown.selectByIndex(vNewValueIndex);
                EnforceChangeCheck(pEnforceChange,vOrigValueIndex,vNewValueIndex);
                return new ChangeDetails(vOrigValueIndex ,vNewValueIndex);
            }

            if (vChangeSpecification.equals("$-")) {
                // Next highest
                //var vOrigValueIndex = LocateIndexForValue(vRangeList, vCurrentValue);
                var vNewValueIndex = vOrigValueIndex - 1;
                if (vNewValueIndex < 0) {
                    throw new CustomE2eException(String.format("Cannot select a predecessor range, already on first range"));
                }
                vValueSelectorDropdown.selectByIndex(vNewValueIndex);
                EnforceChangeCheck(pEnforceChange,vOrigValueIndex,vNewValueIndex);
                return new ChangeDetails(vOrigValueIndex ,vNewValueIndex);
            }
        }

        var vHaveSpecifiedNumericValue = false;
        var vSpecifiedNumeriValue = -1;
        if(pChangeSpecification instanceof Integer) {
            vSpecifiedNumeriValue = (Integer)pChangeSpecification;
            vHaveSpecifiedNumericValue = true;
        } else if(pChangeSpecification instanceof String && StringUtils.isNumeric((String)pChangeSpecification)) {
            vSpecifiedNumeriValue = Integer.parseInt((String)pChangeSpecification);
            vHaveSpecifiedNumericValue = true;
        }

        if(vHaveSpecifiedNumericValue) {
            var vNewValueIndex = LocateIndexForValue(vRangeList,vSpecifiedNumeriValue);
            if(vNewValueIndex<0) {
                throw new CustomE2eException(String.format("No range supports a numeric value of %d", vSpecifiedNumeriValue));
            }
            if(pEnforceChange&&vNewValueIndex==vOrigValueIndex ) {
                throw new CustomE2eException(String.format("New value %d has same index as existing value %d", vSpecifiedNumeriValue, vNewValueIndex));
            }

            vValueSelectorDropdown.selectByIndex(vNewValueIndex);
            EnforceChangeCheck(pEnforceChange,vOrigValueIndex,vNewValueIndex);
            return new ChangeDetails(vOrigValueIndex ,vNewValueIndex);
        }
        throw new CustomE2eException(String.format("Unrecognised form of change specification [%d]", pChangeSpecification));
    }
}
