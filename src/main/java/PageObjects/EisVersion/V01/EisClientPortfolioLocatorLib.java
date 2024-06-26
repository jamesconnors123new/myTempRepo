package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisClientPortfolioLocatorModel;
import org.openqa.selenium.By;

public class EisClientPortfolioLocatorLib implements EisClientPortfolioLocatorModel {
  @Override
  public By CREATE_QUOTE() {
    return By.cssSelector("[class=\"ant-btn gen-customer-new-quote-link ant-btn-link\"]");
  }

  public By POLICY_ID() {
    return By.xpath("//a[normalize-space(text())=\"<variable>\"]");
  }
}
