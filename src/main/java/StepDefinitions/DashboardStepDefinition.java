package StepDefinitions;

import org.openqa.selenium.WebDriver;

public class DashboardStepDefinition extends PortalGeneralStepDefinitions {

    public DashboardStepDefinition(WebDriver driver, PageObjects.PortalModel.Root pageObjectOfPortal) {
        super(driver, pageObjectOfPortal);
    }

//    public String getCurrentStatusOfChangeOfPolicyDoc() throws CustomE2eException {
//        return getText(this.pageObjectOfPortal.getDashboardLocatorModel().GET_STATUS_CHANGE_OF_POLICY());
//    }
//
//    public String getPaymentStatus() throws CustomE2eException {
//        return getText(this.pageObjectOfPortal.getDashboardLocatorModel().GET_PAYMENT_STATUS());
//    }
}
