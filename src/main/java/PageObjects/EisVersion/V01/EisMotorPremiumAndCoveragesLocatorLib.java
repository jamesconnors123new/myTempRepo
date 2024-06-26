package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisMotorPremiumAndCoveragesLocatorModel;
import org.openqa.selenium.By;

public class EisMotorPremiumAndCoveragesLocatorLib implements EisMotorPremiumAndCoveragesLocatorModel {

  @Override
  public By VOLUNTARY_EXCESS() {
    return By.xpath("(//label[text()=\"Voluntary Excess\"]/following::span[1])[1]");
  }

  @Override
  public By NET_PREMIUM() {
    return By.xpath("//tbody[contains(@id,\"policyDataGatherForm:premiumTable\")]/tr[1]/td[2]");
  }

  @Override
  public By GROSS_PREMIUM() {
    return By.xpath("//tbody[contains(@id,\"policyDataGatherForm:premiumTable\")]/tr[1]/td[6]");
  }

  @Override
  public By SELLING_PRICE() {
    return By.xpath("//label[text()=\"Total Selling Price\"]/following::span[1]");
  }

  @Override
  public By COVERAGE_CODE() {
    return By.xpath("//label[text()=\"Coverage Code\"]/following::span[1]");
  }

  @Override
  public By DESCRIPTION() {
    return By.xpath("");
  }

}
