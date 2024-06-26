package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.PaymentLocatorModel;
import org.openqa.selenium.By;

public class PaymentLocatorLib implements PaymentLocatorModel {
  @Override
  public By COMPLETE_PAYMENT() {return By.cssSelector("[data-testid=\"buttonTestId\"]");}

  @Override
  public By PAY_NOW() {return By.xpath("(//button[normalize-space(text())=\"Pay now\"])" +
      "[<variable>]");
  }

  @Override
  public By QUOTE_REF() {
    return By.xpath("//div[@class=\"panel-body panel-inner-body \"]/p/strong[2]");
  }

  @Override
  public By PAY_NOW_BUTTON() {
    return By.xpath("//button[normalize-space(text())=\"Pay now\"]");
  }

  @Override
  public By CARD_BELONG_TO_POLICY_HOLDER() {return By.cssSelector("[for=\"ProposerIsCardHolderY\"]");}
  @Override
  public By PERMISSION_USE_CAR() {return By.cssSelector("[for=\"CardPermissionY\"]");}
  @Override
  public By CARD_NUMBER() {return By.id("PayCardNumber");}
  @Override
  public By CARD_HOLDER_NAME() {return By.id("PayCardHolder");}
  @Override
  public By CARD_HOLDER_MONTH() {return By.id("PayCardExpireSplitMM");}
  @Override
  public By CARD_HOLDER_YEAR() {return By.id("PayCardExpireSplitYY");}
  @Override
  public By CARD_CVV() {return By.cssSelector("#CardSecurityCode");}
  @Override
  public By PAYMENT() {return By.xpath("//label[@for=\"InstDepositAmount\"]/following::span");}
  public By POLICY_NUMB() {return By.xpath("(//p[contains(@class,\"QBYourPolicyPanel\")])[1]");}
  public By PAYMENT_SUCCESSFUL_TEXT() {return By.xpath("//h1[text()='Payment Successful']");}
  @Override
  public By NEXT_BUTTON() {return By.cssSelector("[name=\"next.y\"]");}
  @Override
  public By PREMIUM_VALUE() {return By.cssSelector("[data-testid=\"additionalPaymentHome\"]");}
  @Override
  public By REFUND_VALUE() {return By.cssSelector("[data-testid=\"negativePayment\"]");}
  @Override
  public By CLOSE_PAYMENT_POP_UP(){return By.xpath("//button[text()=\"Close\"]");}

  @Override
  public By PAYMENT_BACK_BUTTON() {
    return By.cssSelector("[name=\"back.y\"]");
  }
}
