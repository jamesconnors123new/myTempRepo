package StepDefinitions;

import Generic.customExceptions.CustomE2eException;
import activities.CommonControlDataDefns;
import activities.GetCustomerDetailsPortal;
import activities.GetPolicyInformationPortal;
import helpers.AgeasDigitalReactPortalHelpers;
import helpers.Formatting;
import helpers.SyncType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.SortedMap;
import java.util.TreeMap;

public class JointPolicyHolderStepDefinition extends AgeasDigitalReactPortalHelpers {
  private final WebDriver driver;
  public static final String ATT_NAME_VALUE = "value";

  public JointPolicyHolderStepDefinition(WebDriver driver,
                                         PageObjects.PortalModel.Root pageObjectOfPortal) {
    super(driver, pageObjectOfPortal);
    this.driver = driver;
  }


  private void editJointPolicyHolder() throws CustomE2eException {
    PerformActionThatMightBeBlockedByBusySpinner(Duration.ofSeconds(300),
        () ->clickElement(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().JOINT_POLICY_HOLDER_EDIT_LINK(), SyncType.CLICKABLE));
    NoThrowSleep(Duration.ofSeconds(15));
  }

  public SortedMap<String, Object> getJointPolicyHolderInformationFromUi() throws CustomE2eException {
    var empDet = new TreeMap<String, Object>();
    var primEmp = new TreeMap<String, Object>();
    var secEmp = new TreeMap<String, Object>();
    //redirectToHomeTab();
    editPersonalDetailsInHomeTab();
    importantInformationPage();
    selectEffectiveDate();
    TreeMap<String, Object> jPHDetails = new TreeMap<>();
    if (isElementVisible(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().JOINT_POLICY_HOLDER_EDIT_LINK())) {
      editJointPolicyHolder();
      var listOfQuestions =
          getTextAllWebElementMatchingLocator(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().QUESTION_LIST());
      for (int listOfQuestionVar = 0; listOfQuestionVar < listOfQuestions.size(); listOfQuestionVar++) {
        var que = listOfQuestions.get(listOfQuestionVar);
        int positionOfElement = listOfQuestionVar + 1;
        que = (que.contains("\n")) ? que.split("\n")[0] : que;
        switch (Formatting.capitalizeAllFirstCapitalizeRemoveSpace(que)) {
          case CommonControlDataDefns.TITLE:
            jPHDetails.put(GetCustomerDetailsPortal.TITLE,
                getTitle(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement))));
            break;
          case CommonControlDataDefns.JPH_FIRST_NAME_VAR: // "What's their first name?":
            jPHDetails.put(GetCustomerDetailsPortal.NAME, getFirstName());
            break;
          case CommonControlDataDefns.JPH_LAST_NAME_VAR:  //"What’s their surname?":
            jPHDetails.put(GetCustomerDetailsPortal.LAST_NAME, getLastName());
            break;
          case CommonControlDataDefns.JPH_MARITAL_STATUS:  //"What's their marital status?":
            jPHDetails.put(GetPolicyInformationPortal.MARITAL_STATUS,
                getMaritalStatus(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement))));
            break;
          case CommonControlDataDefns.JPH_DATE_OF_BIRTH:  //"What's
            // their date of birth?":
            jPHDetails.put(GetPolicyInformationPortal.DATE_OF_BIRTH, getDateOfBirth());
            break;
          case CommonControlDataDefns.JPH_EMPLOYMENT_STATUS: //"What's their employment
            // status?": //
            primEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
                getEmploymentDetails(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().EMPLOYMENT_STATUS()));
//            break;
//          case "What's their job?":
            primEmp.put(GetPolicyInformationPortal.OCCUPATION, getJobDetails());
//            break;
//          case "What type of industry do they work in?":
            primEmp.put(CommonControlDataDefns.INDUSTRY, getIndustryDetails());
            empDet.put(CommonControlDataDefns.PRIMARY_EMPLOYMENT, primEmp);
            break;
          case CommonControlDataDefns.JPH_SECOND_JOB: //"Do they have a second job?":
            var secJobFlag =
                Boolean.parseBoolean(getSecondEmploymentStatus(xpathBuilder(this.pageObjectOfPortal.getPortalSharedLocatorModel().CHOICE_ANSWER_SELECTED(), String.valueOf(positionOfElement))));
            secEmp.put(CommonControlDataDefns.SECOND_EMP_FLAG, secJobFlag);
//            break;
//          case "What's the employment status of their second job?":
            if (secJobFlag) {
              secEmp.put(CommonControlDataDefns.EMPLOYMENT_STATUS,
                  getSecondEmploymentDetails(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_EMPLOYMENT_STATUS()));
//            break;
//          case "What's their second job?":
              secEmp.put(GetPolicyInformationPortal.OCCUPATION, getSecondJobDetails());
//            break;
//          case "What type of industry is their second job in?":
              secEmp.put(CommonControlDataDefns.INDUSTRY, getSecondIndustryDetails());
            }
            empDet.put(CommonControlDataDefns.SECONDARY_EMPLOYMENT, secEmp);
            jPHDetails.put(CommonControlDataDefns.EMPLOYMENT_DET, empDet);
            break;
          case CommonControlDataDefns.JPH_RELATIONSHIP_TO_YOU:
            //"What's their relationship to you?":
            jPHDetails.put(GetPolicyInformationPortal.RELATIONSHIP_STATUS, getRelationShipStatus());
            break;
          default:
        }
      }
      clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().CANCEL_BUTTON(), SyncType.CLICKABLE);
    } else{
      jPHDetails = null;
    }
    return jPHDetails;
  }

  public String getTitle(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return (String) getAnswerSelected(getChildNodes);
  }

  private void selectEffectiveDate() throws CustomE2eException {
    int dateCounter = 1;
    boolean isEffectiveDate = false;
    do {
      selectEffectiveDateFromList(dateCounter);
      isEffectiveDate =
          isElementVisible(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().EFFECTIVE_DATE_MESSAGE());
      if (!isEffectiveDate) {
        break;
      } else {
        dateCounter++;
      }
    } while (isEffectiveDate);
    clickElementRetryX3onClickIntEx(this.pageObjectOfPortal.getPerformMTALocatorModel().CONTINUE_EFFECTIVE_BTN(), SyncType.CLICKABLE);
  }

  private String getRelationShipStatus() throws CustomE2eException {
    return getSelectedValueFromDropDown(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().RELATIONSHIP_STATUS(), "getRelationShipStatus failed");
  }

//  private SortedMap<String, Object> getSecondJobDetails() throws CustomE2eException {
//    var secondEmpDetails = new TreeMap<String, Object>();
//    if (isElementVisible(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel()
//    .SECOND_EMPLOYMENT_STATUS()) {
//      secondEmpDetails.put(GetPolicyInformationPortal.EMPLOYMENT_STATUS,
//      getSelectedValueFromDropDown(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel()
//      .SECOND_EMPLOYMENT_STATUS(), "Second employmentStatus failed"));
//      secondEmpDetails.put(GetPolicyInformationPortal.SECOND_JOB_OCCUPATION, getAttribute(this
//      .pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_JOB_OCCUPATION(),
//      ATT_NAME_VALUE, "Second job failed"));
//      secondEmpDetails.put(GetPolicyInformationPortal.SECOND_JOB_INDUSTRY_TYPE, getAttribute
//      (this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_JOB_INDUSTRY_TYPE(),
//      ATT_NAME_VALUE, "Second job industry type"));
//    }
//    return secondEmpDetails;
//  }

  //  private SortedMap<String, Object> getEmploymentDetails() throws CustomE2eException {
//    var employmentDetails = new TreeMap<String, Object>();
//    employmentDetails.put(GetPolicyInformationPortal.EMPLOYMENT_STATUS,
//    getSelectedValueFromDropDown(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel()
//    .EMPLOYMENT_STATUS(), "Selection of employment status failed"));
//    employmentDetails.put(GetPolicyInformationPortal.OCCUPATION, getAttribute(this
//    .pageObjectOfPortal.getJointPolicyHolderLocatorModel().OCCUPATION(), ATT_NAME_VALUE,
//    "Selection of occupation failed"));
//    employmentDetails.put(GetPolicyInformationPortal.INDUSTRY_TYPE, getAttribute(this
//    .pageObjectOfPortal.getJointPolicyHolderLocatorModel().INDUSTRY_TYPE(), ATT_NAME_VALUE,
//    "Selection of Industry type failed"));
//    return employmentDetails;
//  }
  private String getEmploymentDetails(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Value is not available");
  }

  private String getJobDetails() throws CustomE2eException {
    return getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().OCCUPATION(),
        ATT_NAME_VALUE, "Selection of" + " occupation failed");
  }

  private String getIndustryDetails() throws CustomE2eException {
    return getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().INDUSTRY_TYPE(), ATT_NAME_VALUE, "Selection of" + " Industry type failed");
  }

  private String getSecondEmploymentStatus(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return (String) getAnswerSelected(getChildNodes);
  }

  private String getSecondEmploymentDetails(By component) throws CustomE2eException {
    return getSelectedValueFromDropDown(component, "Second employmentStatus failed");
  }

  private String getSecondJobDetails() throws CustomE2eException {
    return getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_JOB_OCCUPATION(), ATT_NAME_VALUE, "Second job " + "failed");
  }

  private String getSecondIndustryDetails() throws CustomE2eException {
    return getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SECOND_JOB_INDUSTRY_TYPE(), ATT_NAME_VALUE, "Selection of" + " Industry type failed");
  }

  private String getDateOfBirth() throws CustomE2eException {
    return getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().DATE_OF_BIRTH(), ATT_NAME_VALUE, "getDateOfBirth failed") + "/" + getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().DATE_OF_MONTH(), ATT_NAME_VALUE, "getDateOfBirth failed") + "/" + getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().DATE_OF_YEAR(), ATT_NAME_VALUE, "getDateOfBirth failed");
  }

  private String getStatusOfSecondJob(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return (String) getAnswerSelected(getChildNodes);
  }

  private String getMaritalStatus(By component) {
    var getChildNodes = getElementsMatchingToLocator(component);
    return getMaritalStatusFromValueAtt((String) getAnswerSelected(getChildNodes));
  }

  private String getMaritalStatusFromValueAtt(String value) {
    String status = null;
    switch (value) {
      case "S":
        status = "Single";
        break;
      case "M":
        status = "Married";
        break;
      case "V":
        status = "Civil Partnered";
        break;
      case "D":
        status = "Divorced";
        break;
      case "W":
        status = "Widowed";
        break;
      default:
    }
    return status;
  }


  public String getFirstName() throws CustomE2eException {
    return getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().FIRST_NAME(),
        ATT_NAME_VALUE, "getFullName failed");
  }

  public String getLastName() throws CustomE2eException {
    return getAttribute(this.pageObjectOfPortal.getJointPolicyHolderLocatorModel().SURNAME_NAME()
        , ATT_NAME_VALUE, "getFullName failed");
  }

//  public String getSelectedRadioButtonText(By title) {
//    var listOfElement = getElementsMatchingToLocator(title);
//    String textOfSelectedRadio = null;
//    int counter = 1;
//    try {
//      for (var element : listOfElement) {
//        if (isAttributePresent(element, "checked")) {
//          textOfSelectedRadio = getAttribute(element,
//              ATT_NAME_VALUE);
//          break;
//        }
//        counter++;
//      }
//    } catch (Exception exception) {
//
//    }
//    return textOfSelectedRadio;
//  }
}
