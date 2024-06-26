package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.JointPolicyHolderLocatorModel;
import org.openqa.selenium.By;

public class JointPolicyHolderLocatorLib implements JointPolicyHolderLocatorModel {

  @Override
  public By ADD_JOINT_POLICY_HOLDER_BUTTON() {return  By.xpath("//button[text()=\"Add Joint Policyholder\"]");}
  @Override
  public By JOINT_POLICY_HOLDER_EDIT_LINK() {return  By.xpath("//h1[text()=\"Joint " +
      "Policyholder\"]/following::a[1]");}
  @Override
  public By INSURED_ADDRESS_EDIT_LINK() {return  By.xpath("//h1[text()=\"Insured " +
      "Address\"]/following::a[1]");}
  @Override
  public By QUESTION_LIST() {return  By.xpath("(//div[@data-testid=\"containerHidden" +
      "\"]/child::label)");}
  @Override
  public By JOINT_POLICY_HOLDER_NAME() {return  By.xpath("(//div[contains(@class,\"PolicyHolderDetailsstyles__PolicyHolder\")]/p)[2]");}
  @Override
  public By TITLE() {return  By.xpath("//div[@data-testid=\"titleRadioGroupWrapper\"]/child::div/input");}
  @Override
  public By FIRST_NAME() {return  By.cssSelector("#firstName");}
  @Override
  public By SURNAME_NAME() {return  By.cssSelector("#surname");}
  @Override
  public By MARITAL_STATUS() {return  By.xpath("//div[@data-testid=\"maritalStatusRadioGroupWrapper\"]/child::div/label[@for=\"maritalStatus-<variable>\"]");}
  @Override
  public By JPH_MARITAL_STATUS() {return  By.xpath("(//div[contains(@data-testid," +
      "\"maritalStatusRadioGroupWrapper\")]//input)[<variable>]");}
  @Override
  public By DATE_OF_BIRTH() {return  By.cssSelector("#dateOfBirthday");}
  @Override
  public By DATE_OF_MONTH() {return  By.cssSelector("#dateOfBirthmonth");}
  @Override
  public By DATE_OF_YEAR() {return  By.cssSelector("#dateOfBirthyear");}
  @Override
  public By EMPLOYMENT_STATUS() {return  By.cssSelector("#employmentStatus");}
  @Override
  public By OCCUPATION() {return  By.cssSelector("#occupation");}
  @Override
  public By INDUSTRY_TYPE() {return  By.cssSelector("#industryType");}
  @Override
  public By SECOND_JOB_CHECKED() {return  By.xpath("//div[@id=\"secondJob\"]/child::div/input");}
  @Override
  public By SECOND_EMPLOYMENT_STATUS() {return  By.cssSelector("#secondOccupationEmploymentStatus");}
  @Override
  public By SECOND_JOB_OCCUPATION() {return  By.cssSelector("#secondOccupation");}
  @Override
  public By SECOND_JOB_INDUSTRY_TYPE() {return  By.cssSelector("#secondIndustryType");}
  @Override
  public By RELATIONSHIP_STATUS() {return  By.cssSelector("#relationshipToProposer");}
  @Override
  public By CANCEL_BUTTON() {return  By.cssSelector("[data-testid=\"cancelAddPolicyHolderFormButton\"]");}
  @Override
  public By SAVE_BUTTON() {return  By.cssSelector("[data-testid=\"addPolicyHolderFormSubmitButton\"]");}
  @Override
  public By BACK_BUTTON() {return  By.cssSelector("[data-testid=\"backButton\"]");}
  @Override
  public By UPDATE_CHANGES() {return  By.cssSelector("[data-testid=\"backModalYes\"]");}
  @Override
  public By EFFECTIVE_DATE_MESSAGE() {return  By.xpath("//p[contains(@class,\"EffectiveDates\")]");}
  @Override
  public By REMOVE_JOINT_POLICYHOLDER() {return  By.xpath("//a[text()=\"Delete\"]");}
  @Override
  public By OCCUPATION_LIST() {return  By.xpath("//div[@data-testid=\"occupation-children-container\"]/child::div/div/ul");}
  @Override
  public By INDUSTRY_LIST() {return  By.xpath("//div[@data-testid=\"industryType-children-container\"]/child::div/div/ul");}
  @Override
  public By SECOND_JOB_OCCUPATION_LIST() {return  By.xpath("//div[@data-testid=\"secondOccupation-children-container\"]/child::div/div/ul");}
  @Override
  public By SECOND_JOB_INDUSTRY_LIST() {return  By.xpath("//div[@data-testid=\"secondIndustryType-children-container\"]/child::div/div/ul");}
  @Override
  public By SECOND_JOB() {return  By.xpath("//label[@for=\"secondJob-<variable>\"]");}
  //@Override
  //   public By SECOND_JOB_NO() {return  By.xpath("//div[@id=\"secondJob\"]/child::div/label[@data-testid=\"secondJob-false\"]");}
  @Override
  public By OCCUPATION_VALUE() {return  By.xpath("//li[@data-testid=\"suggestion-0\"]");}
}
