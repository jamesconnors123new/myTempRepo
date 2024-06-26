package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.EchelonSharedLocatorModel;
import org.openqa.selenium.By;

public class EchelonSharedLocatorLib implements EchelonSharedLocatorModel {
  @Override
  public By NEXT_PAGE_ECHELON() { return By.cssSelector("[value=\"Next Page\"]");}

}
