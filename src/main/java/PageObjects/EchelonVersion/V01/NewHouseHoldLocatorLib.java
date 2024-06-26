package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.NewHouseHoldLocatorModel;
import org.openqa.selenium.By;

public class NewHouseHoldLocatorLib implements NewHouseHoldLocatorModel {
  @Override
  public By AFFINITY() {
    return  By.cssSelector("[name=\"newQuoteDetails:affinity\"]");
  }

  @Override
  public By INCEPTION_DATE() {
    return By.xpath("//input[@name=\"newQuoteDetails:inceptionDate\"]");
  }

  @Override
  public By HOUSE_HOLD_COVER() {
    return By.cssSelector("[name=\"newQuoteDetails:riskType\"]");
  }
}
