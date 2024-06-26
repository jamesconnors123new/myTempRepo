package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisMotorClaimAndConvictionLocatorModel;
import org.openqa.selenium.By;

public class EisMotorClaimAndConvictionLocatorLib implements EisMotorClaimAndConvictionLocatorModel {
  @Override
  public By LIST_OF_CLAIMS() {
    return By.xpath("(//tbody[contains(@id,\"policyDataGatherForm\")])[1]/tr");
  }

  @Override
  public By CLAIMS_LABELS_LIST() {
    return By.xpath("(//div[text()=\"Claims on other policies within 5 years\"]/following::table)"
        + "[1]//thead/tr/th");
  }

  @Override
  public By CLAIMS_DETAILS_VALUE() {
    return By.xpath("(//tbody[contains(@id,\"policyDataGatherForm\")])" + "[1]//tr[<variable" +
        ">]//child::td");
  }

  @Override
  public By CLAIMS_DETAILS_LABEL() {
    return By.xpath("(//div[text()=\"Claims on other policies within 5 years\"]/following::table)"
        + "[1]//thead/tr/th[<variable>]");
  }

  @Override
  public By LIST_OF_CONVICTIONS() {
    return By.xpath("(//tbody[contains(@id,\"policyDataGatherForm\")])[2]/tr");
  }

  @Override
  public By CONVICTION_LABELS_LIST() {
    return By.xpath("(//div[text()=\"Convictions within 5 years\"]/following::table)" + "[1" +
        "]//thead/tr/th");
  }

  @Override
  public By CONVICTION_DETAILS_LABEL() {
    return By.xpath("(//div[text()=\"Convictions within 5 years\"]/following::table)" + "[1" +
        "]//thead/tr/th[<variable>]");
  }


  @Override
  public By CONVICTION_DETAILS_VALUE() {
    return By.xpath("(//tbody[contains(@id,\"policyDataGatherForm\")])" + "[2]/tr[<variable" +
        ">]/child::td");
  }

}
