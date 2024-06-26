package PageObjects.PortalVersion.V02;

import PageObjects.PortalModel.DashboardLocatorModel;
import org.openqa.selenium.By;

public class DashboardLocatorLib extends PageObjects.PortalVersion.V01.DashboardLocatorLib implements DashboardLocatorModel {

  @Override
  public By WELCOME_BANNER() {
    return By.cssSelector("[data-testid=\"titleTestId\"]");
  }

}
