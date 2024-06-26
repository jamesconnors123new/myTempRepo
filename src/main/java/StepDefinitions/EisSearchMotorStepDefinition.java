package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import PageObjects.EisModel.Root;
import activities.CommonControlDataDefns;
import helpers.CdlEisHelpers;
import helpers.CommonHelper;
import helpers.SyncType;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class EisSearchMotorStepDefinition extends CdlEisHelpers {
    public static final String PRODUCT_TYPE = "ProductType";
    public static final String REGISTRATION_NUMBER = "RegistrationNumber";
    public static final long waitDuration = 60000L;
    EisGeneralStepDefinitions eisGeneralStepDefinitions;
    EisHomeQuoteCreationStepDefinition eisHomeQuoteCreationStepDefinition;
    EisMotorQuoteCreationStepDefinition eisMotorQuoteCreationStepDefinition;
    private final helpers.CommonHelper CommonHelper;
    CommonControlDataDefns commonControlDataDef = new CommonControlDataDefns();

    public EisSearchMotorStepDefinition(WebDriver pDriver, Root pageObjectOfEis) {
        super(pDriver, pageObjectOfEis);
        eisGeneralStepDefinitions = new EisGeneralStepDefinitions(pDriver, pageObjectOfEis);
        eisHomeQuoteCreationStepDefinition = new EisHomeQuoteCreationStepDefinition(pDriver, pageObjectOfEis);
        eisMotorQuoteCreationStepDefinition = new EisMotorQuoteCreationStepDefinition(pDriver, pageObjectOfEis);
        this.CommonHelper = new CommonHelper(pDriver);
    }

    public Map<String, Object> vehicleDetails(Map<String, Object> salesDetails) throws CustomE2eException {
        Map<String, Object> vehicleDetails = new HashMap<>();
        eisHomeQuoteCreationStepDefinition.selectProduct(salesDetails.get(PRODUCT_TYPE));
        clickVehicleTab();
        eisMotorQuoteCreationStepDefinition.addNewVehicle();
        eisMotorQuoteCreationStepDefinition.enterVRN(salesDetails.get(REGISTRATION_NUMBER));
        eisMotorQuoteCreationStepDefinition.searchVehicle();
        vehicleDetails.put("VehicleMake", eisMotorQuoteCreationStepDefinition.getVehicleMake());
        vehicleDetails.put("VehicleModel", eisMotorQuoteCreationStepDefinition.getVehicleModel());
        vehicleDetails.put("FuelType",eisMotorQuoteCreationStepDefinition.getFuelType());
        vehicleDetails.put("YearOfManufacture",eisMotorQuoteCreationStepDefinition.getYearOfManufacture());
        vehicleDetails.put("AbiCode",eisMotorQuoteCreationStepDefinition.getABICode());
        vehicleDetails.put("MarketValue",eisMotorQuoteCreationStepDefinition.getVehicleMarketValue());
        vehicleDetails.put("NumberOfSeats",eisMotorQuoteCreationStepDefinition.getNumberOfSeats());
        return vehicleDetails;
    }

    public void clickVehicleTab() throws CustomE2eException {
        waitForElement2(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_TAB(), SyncType.CLICKABLE, waitDuration);
        RetryOnStaleElementException(5,
                () -> clickElementRetryX3onClickIntEx(this.pageObjectOfEis.getEisMotorQuoteCreationLocatorModel().VEHICLE_TAB(), SyncType.CLICKABLE), "");
    }

}
