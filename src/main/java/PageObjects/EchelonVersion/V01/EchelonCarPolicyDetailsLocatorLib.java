package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.EchelonCarPolicyDetailsLocatorModel;
import org.openqa.selenium.By;

public class EchelonCarPolicyDetailsLocatorLib implements EchelonCarPolicyDetailsLocatorModel {
  @Override
    public By NAME() {return By.xpath("//label[@class='infolabel' and contains(text(),'Name:')]/following-sibling::label[@class='infocontent']");}
    public By EMAIL_ADDRESS() {return By.cssSelector("[data-id=\"emailAddress\"]");}
    public By  MOBILE_TELEPHONE_NUMBER() {return  By.xpath("(//label[contains(text(),'Mobile Telephone Number:')]/following-sibling::label)[1]");}
    public By ADDRESS() {return By.cssSelector("[data-id=\"address\"]");}

    public By  DATE_OF_BIRTH() {return  By.xpath("(//label[contains(text(),'Date of Birth:')]/following-sibling::label)[1]");}
    public By  MARITAL_STATUS() {return  By.xpath("(//label[contains(text(),'Marital Status:')]/following-sibling::label)[1]");}
    public By  EMPLOYMENT_STATUS() {return By.xpath("(//div[@data-id=\"fullTimeOccupation\"])[1]");}
    public By  OCCUPATION() {return  By.xpath("(//div[@data-id=\"fullTimeOccupation\"])[1]");}
    public By  DRIVING_LICENSE_TYPE() {return  By.xpath("(//label[contains(text(),'Licence Type:')]/following-sibling::label)[1]");}
    public By  YEARS_NO_CLAIMS_DISCOUNT() {return  By.xpath("(//label[contains(text(),'NCD Claimed:')]/following-sibling::label)");}
    public By  JOINT_POLICY_HOLDER_NAME() {return  By.xpath("(//label[contains(text(),'Name:')]/following-sibling::label)[2]");}

    //Vehicle Section (Risk Tab)
    public By  CAR_MAKE() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Make:')]/following-sibling::label[@class='infocontent']");}
    public By  CAR_MODEL() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Description:')]/following-sibling::label[@class='infocontent']");}
    public By  YEAR_OF_MAKE() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Year of Make:')]/following-sibling::label[@class='infocontent']");}
    public By  TRANSMISSION() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Transmission:')]/following-sibling::label[@class='infocontent']");}
    public By  FUEL_TYPE() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Fuel:')]/following-sibling::label[@class='infocontent']");}
    public By  CURRENT_MARKET_VALUE() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Current Market Value:')]/following-sibling::label[@class='infocontent']");}
    public By  CAR_OWNER() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Owner:')]/following-sibling::label[@class='infocontent']");}
    public By  REGISTERED_KEEPER() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Proposer Registered Keeper:')]/following-sibling::label[@class='infocontent']");}
    public By  CAR_LOCATION_OVERNIGHT() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Where Kept Overnight:')]/following-sibling::label[@class='infocontent']");}
    public By  CLASS_OF_USE() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Class of Use:')]/following-sibling::label[@class='infocontent']");}
    //public By  CHANGES_EFFECTIVE_DATE() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Effective Date:')]/following-sibling::label[@class='infocontent']");}
    public By  ANNUAL_MILEAGE() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Annual Mileage:')]/following-sibling::label[@class='infocontent']");}

    //Excesses
    public By  LEVEL_OF_VOLUNTARY_EXCESS() {return  By.xpath("//label[@class='infolabel' and contains(text(),'Level of Voluntary Excess:')]/following-sibling::label[@class='infocontent']");}
   // public By  COMPULSORY() {return  By.xpath("(//label[contains(text(),'Date of Birth:')]/following-sibling::label)[2]");}

    public By  CE_ACCIDENTAL_DAMAGE_AND_MALICIOUS_DAMAGE() {return  By.xpath("(//span[text()='Accidental Damage And Malicious Damage'])[1]");}
    public By  EC_POLICY_SCHEME() {return  By.xpath("(//span[text()='Policy Scheme'])[1]");}
    public By  CE_ACCIDENTAL_DAMAGE_AND_MALICIOUS_DAMAGE_VALUE() {return  By.xpath("(//span[text()='Policy Scheme'])[1]/ancestor::td/following-sibling::td[1]//span");}

    //-------------- Additional Driver ------------------------------
    public By  AD_NAME() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Name:')]/following-sibling::label[@class='infocontent'])[3]");}
    public By  AD_GENDER() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Gender:')]/following-sibling::label[@class='infocontent'])[2]");}
    public By  AD_DATE_OF_BIRTH() {return  By.xpath(" (//label[@class='infolabel' and contains(text(),'Date of Birth:')]/following-sibling::label[@class='infocontent'])[2]");}
    public By  AD_AGE() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Age:')]/following-sibling::label[@class='infocontent'])[2]");}
    public By  AD_FULL_TIME_OCCUPATION() {return  By.xpath("(//div[@data-id=\"fullTimeOccupation\"])[2]");}
    public By  AD_PART_TIME_OCCUPATION() {return  By.xpath("(//div[@data-id=\"partTimeOccupation\"])[2]");}
    public By  AD_LICENSE_TYPE() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Licence Type:')]/following-sibling::label[@class='infocontent'])[2]");}
    public By  AD_LICENSE_DATE() {return  By.xpath("//div[@data-id=\"licenceDate\"]");}
    public By  AD_ACCESS_TO_VEHICLES() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Access to Other Vehicles:')]/following-sibling::label[@class='infocontent'])[2]");}
    public By  AD_RELATIONSHIP_TO_PROPOSER() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Relationship to Proposer:')]/following-sibling::label[@class='infocontent'])[1]");}
    public By  AD_MARITAL_STATUS() {return  By.xpath(" (//label[@class='infolabel' and contains(text(),'Marital Status:')]/following-sibling::label[@class='infocontent'])[2]");}
    public By  AD_DATE_OF_RESIDENCY() {return  By.xpath("//div[@data-id=\"thisCountryResidencyDate\"]");}
    public By  AD_VEHICLE_USE() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Vehicle Use:')]/following-sibling::label[@class='infocontent'])[2]");}
    public By  AD_INSURANCE_PREVIOUSLY_REFUSED() {return  By.xpath("(//label[@class='infolabel' and contains(text(),'Insurance Previously Refused:')]/following-sibling::label[@class='infocontent'])[2]");}
//

}
