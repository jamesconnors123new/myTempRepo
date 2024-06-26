package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisPolicyDashboardLocatorModel;
import org.openqa.selenium.By;

public class EisPolicyDashboardLocatorLib implements EisPolicyDashboardLocatorModel {

  @Override
  public By SELECT_POLICY_NUMBER_LIST() {
    return By.xpath("//span[text()=\"Policies\"]/following::table[1]/tbody/tr/td[2]");
  }

  @Override
  public By SELECT_POLICY_NUMBER() {
    return By.xpath("//a/span[text()=\"<variable>\"]");
  }

  @Override
  public By SELECT_CUSTOMER_FROM_LIST() {
    return By.xpath("//button[@class=\"ant-btn ant-btn-link\"]");
  }

  @Override
  public By SELECT_DECLINES_APPLIED(){return By.cssSelector("#productContextInfoForm\\:declinesApplied");}
  @Override
  public By SELECT_REFERRALS_APPLIED(){return By.xpath("//*[@id=\"productContextInfoForm:referralsApplied\"]"); }


  @Override
  public By VIEW_ALL_POLICY() {
    return By.xpath("//span[text()=\"View All\"]/parent::button[1]");
  }
}
