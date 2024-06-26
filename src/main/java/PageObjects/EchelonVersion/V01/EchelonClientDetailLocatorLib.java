package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.EchelonClientDetailLocatorModel;
import org.openqa.selenium.By;

public class EchelonClientDetailLocatorLib implements EchelonClientDetailLocatorModel {

  @Override
  public By NAME() {
    return By.xpath("//label[@class='infolabel' and contains(text(),'Name:')" +
        "]/following-sibling::label[@class='infocontent']");
  }
  @Override
  public By SALUTATION() {
    return By.xpath("//label[@class='infolabel' and contains(text(),'Salutation:')" +
        "]/following-sibling::label[@class='infocontent']");
  }

  @Override
  public By MAIN_ADDRESS() {
    return By.cssSelector("[data-id=\"address\"]");
  }

  @Override
  public By MAIN_ADDRESS_POSTCODE() {
    return By.xpath("//div[@class='infolabel' and contains(text(),'Main Address:')" +
        "]/following-sibling::div[@class='infocontent' and @data-id='address']/div[6]/text()");
  }

  @Override
  public By GENDER() {
    return By.xpath("//label[@class='infolabel' and contains(text(),'Gender:')" +
        "]/following-sibling::label[@class='infocontent']");
  }

  @Override
  public By DATE_OF_BIRTH() {
    return By.xpath("//label[@class='infolabel' and contains(text(),'Date of Birth:')" +
        "]/following-sibling::label[@class='infocontent']\n");
  }

  @Override
  public By AGE() {
    return By.xpath("//label[@class='infolabel' and contains(text(),'Age:')" +
        "]/following-sibling::label[@class='infocontent']");
  }

  @Override
  public By MOBILE_TELEPHONE_NUMBER() {
    return By.xpath("//label[@class='infolabel' and contains(text(),'Mobile Telephone Number:')" +
        "]/following-sibling::label[@class='infocontent']");
  }

  @Override
  public By EMAIL_ADDRESS() {
    return By.xpath("//div/span[@data-id='emailAddress']");
  }

  @Override
  public By EXIT_QUOTE() {
    return By.name("backButton");
  }

  @Override
  public By HOME_INSURANCE() {
    return By.xpath("//td/span[text()=\"Household\"]");
  }

  @Override
  public By VIEW_HOME_POLICY_DETAILS() {
    return By.xpath("(//td/span[text()=\"Household\"]/following::a[@data-id=\"viewPolicyDetails" +
        "\"])[1]");
  }

  @Override
  public By POLICY_NUMBER() {
    return By.xpath(" //div[@data-id=\"policyNumber\"]//label[2]");
  }


  @Override
  public By HOME_EXTENSION_DET() {
    return By.xpath("//label[text()=\"Has the property been " + "extended?\"]/following-sibling" +
        "::label");
  }

  @Override
  public By NUMBER_OF_ADULT() {
    return By.xpath("//label[text()=\"How many adults live in " + "the property?\"]/following" +
        "-sibling::label");
  }

  @Override
  public By NUMBER_OF_CHILD() {
    return By.xpath("//label[text()=\"How many children live in" + " the property?\"]/following" +
        "-sibling::label");
  }

  @Override
  public By PET_DET() {
    return By.xpath("//label[text()=\"Do you have a pet living at the " + "property?\"]/following" +
        "-sibling::label");
  }

  @Override
  public By NON_FAMILY_LODGER() {
    return By.xpath("//label[text()=\"Non Family Lodgers:\"]/following::label");
  }

  @Override
  public By HOME_OWN_RENT_DET() {
    return By.xpath("//label[text()=\"How is your property " + "owned?\"]/following-sibling" +
        "::label");
  }

  @Override
  public By HOME_ALARM_DETAILS() {
    return By.xpath("//label[text()=\"Burglar " + "Alarm:\"]/following-sibling::label");
  }

  @Override
  public By HOME_LOCKING() {
    return By.xpath("//label[text()=\"Door/Window " + "Locks:\"]/following-sibling::label");
  }

  @Override
  public By LISTING_DETAILS() {
    return By.xpath("//label[text()=\"Listed " + "Building:\"]/following-sibling::label");
  }

  @Override
  public By HOME_OCCUPIED_DETAILS() {
    return By.xpath("//label[text()" + "=\"Occupancy:\"]/following-sibling::label");
  }

  @Override
  public By HOME_BUILT_DET() {
    return By.xpath("//label[text()=\"Construction " + "Type:\"]/following-sibling::label");
  }

  @Override
  public By HOME_ROOF_DETAILS() {
    return By.xpath("//label[text()=\"Approximately what " + "percentage of the roof is " +
        "flat?\"]/following-sibling::label");
  }

  @Override
  public By HOME_ROOF_MADE_OF() {
    return By.xpath("//label[text()=\"Type of wall " + "construction?\"]/following-sibling::label");
  }

  @Override
  public By HOME_WALL_MADE_OF() {
    return By.xpath("//label[text()=\"Type of roof " + "construction?\"]/following-sibling::label");
  }

  @Override
  public By BUSINESS_USE() {
    return By.xpath("//label[text()=\"Business " + "Use:\"]/following-sibling::label");
  }

  @Override
  public By CLERICAL_USE() {
    return By.xpath("//label[text()=\"Is business use solely " + "clerical with no employees or visitors?\"]/following-sibling::label");
  }

  @Override
  public By FREE_FROM_FLOOD_THREAT() {
    return By.xpath("//label[text()=\"Free From Flooding:\"]/following::label[1]");
  }

}
