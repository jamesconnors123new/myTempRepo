package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisHomePolicyDetailsLocatorModel;
import org.openqa.selenium.By;

public class EisHomePolicyDetailsLocatorLib implements EisHomePolicyDetailsLocatorModel {


  @Override
  public By UNSATISFIED_COUNTY_COURT_JUDGEMENTS() {
    return By.xpath("//label[contains(text(),\"unsatisfied County Court Judgements?\")" +
        "]/following::span[1]");
  }

  @Override
  public By DELCARED_BANKRUPT() {
    return By.xpath("//label[contains(text(),\"been declared bankrupt?\")]/following::span[1]");
  }

  @Override
  public By NET_PREMIUM() {
    return By.xpath("(//td[contains(@id,\"policyDataGatherForm:riskItemPremiumInfoTable\")" +
        "]/span[1])[2]");
  }

  @Override
  public By GROSS_PREMIUM() {
    return By.xpath("(//td[contains(@id,\"policyDataGatherForm:riskItemPremiumInfoTable\")" +
        "]/span[1])[7]");
  }

  @Override
  public By SELLING_PRICE() {
    return By.xpath("//span[@id=\"policyDataGatherForm" +
        ":sedit_AgeaHomeTotalSellingPriceLastYearPremium_totalSellingPrice\"]");
  }
}
