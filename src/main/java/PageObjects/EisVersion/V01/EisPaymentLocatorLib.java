package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisPaymentLocatorModel;
import org.openqa.selenium.By;

public class EisPaymentLocatorLib implements EisPaymentLocatorModel {
  @Override
  public By CARD_BELONGS_TO_POLICY_HOLDER() {
    return By.xpath("//label[contains(text(),\" belong to the policyholder?\")" +
        "]/following::input[<variable>]");
  }

  @Override
  public By PERMISSION_TO_STORE_CARD() {
    return By.xpath("//label[contains(text(),\"permission for this card to be stored for future " + "manual and automatic use\")]/following::input[<variable>]");
  }

  @Override
  public By POLICY_AMOUNT_FIELD() {
    return By.xpath("//input[@value=\"New Card\"]/following::input[1]");
  }

  @Override
  public By PAYMENT_PLAN_SELECTION() {
    return By.xpath("//label[text()=\"Payment Plan\"]/following::select[1]");
  }

  @Override
  public By SIGNED_INSTRUCTION_RECEIVED() {
    return By.xpath("//label[contains(text(),\"signed Instruction been\")]/following::input[1]");
  }

  @Override
  public By CREDIT_CARD_PAYMENT_METHOD() {
    return By.cssSelector("[value=\"Credit Card Visa ****1111\"]");
  }

  @Override
  public By ACCOUNT_HOLDER() {
    return By.xpath("//label[text()=\"Are you an Account " + "Holder?\"]/following::label" +
        "[normalize-space(text())=\"<variable>\"]");
  }

  @Override
  public By ACCOUNT_NUM() {
    return By.cssSelector("[id=\"purchaseForm:billingAcccountRecurringPayments_bankAccountNumber" +
        "\"]");
  }

  @Override
  public By ACCOUNT_HOLDER_NAME() {
    return By.cssSelector("[id=\"purchaseForm:billingAcccountRecurringPayments_accountName\"]");
  }

  @Override
  public By BANK_SORT_CODE() {
    return By.cssSelector("[id=\"purchaseForm:billingAcccountRecurringPayments_branchSortCode\"]");
  }

  @Override
  public By CCA_AGREEMENT() {
    return By.cssSelector("[id=\"purchaseForm:cca_CheckBox\"]");
  }

  @Override
  public By PREFERRED_PAYMENT_DATE() {
    return By.xpath("//label[text()=\"Preferred Payment Date\"]/following::select[1]");
  }
  @Override
  public By CLOSE_WORLDPAY_POPUP() {
    return By.xpath("//span[text()=\"Close\"]");
  }
}
