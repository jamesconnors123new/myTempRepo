package PageObjects.EisVersion.V01;

import PageObjects.EisModel.EisMotorVehicleLocatorModel;
import org.openqa.selenium.By;

public class EisMotorVehicleLocatorLib implements EisMotorVehicleLocatorModel {

  @Override
  public By TEMP_VEHICLE() {
    return By.xpath("//label[text()=\"Temporary Vehicle\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_REG_NUMBER() {
    return By.xpath("//label[text()=\"Vehicle Registration Number\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_TYPE() {
    return By.xpath("//label[text()=\"Vehicle Type\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_MAKE() {
    return By.xpath("//label[text()=\"Make\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_MODEL() {
    return By.xpath("//label[text()=\"Model\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_YEAR_OF_MANUFACTURE() {
    return By.xpath("//label[text()=\"Year of Manufacture\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_IMPORTED() {
    return By.xpath("//label[text()=\"Is the vehicle imported?\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_FULE_TYPE() {
    return By.xpath("//label[text()=\"Fuel Type\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_TRANSMISSION() {
    return By.xpath("//label[text()=\"Transmission\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_BODY_STYLE() {
    return By.xpath("//label[text()=\"Body Style\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_NUM_DOORS() {
    return By.xpath("//label[text()=\"Number of Doors\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_NUM_SEAT() {
    return By.xpath("//label[text()=\"Number of Seats\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_ENGINE_CC() {
    return By.xpath("//label[text()=\"Engine CC\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_ABI_CODE() {
    return By.xpath("//label[text()=\"ABI Code\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_MARKET_VALUE() {
    return By.xpath("//label[text()=\"Market value\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_ALARM() {
    return By.xpath("//label[text()=\"Alarm\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_IMMOBILISER_FLAG() {
    return By.xpath("//label[contains(text(),\"vehicle have an immobiliser fitted?\")" +
        "]/following::span[1]");
  }

  @Override
  public By VEHICLE_TRACKER_FLAG() {
    return By.xpath("//label[contains(text(),\"vehicle have a tracker fitted\")" +
        "]/following::span[1]");
  }

  @Override
  public By VEHICLE_DASHCAM_FITTED() {
    return By.xpath("//label[contains(text(),\"ashcam fitted to your vehicle?\")" + "]/following" +
        "::span[1]");
  }

  @Override
  public By VEHICLE_IMMOBILISER() {
    return By.xpath("//label[text()=\"Immobiliser\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_TRACKER() {
    return By.xpath("//label[text()=\"Tracker\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_LEFT_HAND_DRIVE() {
    return By.xpath("//label[text()=\"Left Hand Drive\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_MODIFIED() {
    return By.xpath("//label[contains(text(),\"car been modified \")]/following::span[1]");
  }

  @Override
  public By VEHICLE_RACKING_FLAG() {
    return By.xpath("//label[contains(text(),\"vehicle fitted with racking\")]/following::span[1]");
  }

  @Override
  public By VEHICLE_SIGNAGE_FLAG() {
    return By.xpath("//label[contains(text(),\"vehicle carry any signage\")]/following::span[1]");
  }

  @Override
  public By USE_VEHICLE_BY_PROPOSER() {
    return By.xpath("//label[text()=\"Use of vehicle by proposer\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_USE_FOR() {
    return By.xpath("//label[contains(text(),\"you use your car for\")]/following::span[1]");
  }

  @Override
  public By VEHICLE_USE_FOR_TYPE() {
    return By.xpath("//label[contains(text(),\"purely for social domestic and pleasure use\")" +
        "]/following::span[1]");
  }

  @Override
  public By VEHICLE_ANNUAL_MILEAGE() {
    return By.xpath("//label[text()=\"Annual Mileage\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_BUSINESS_MILEAGE() {
    return By.xpath("//label[text()=\"Business Mileage\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_BUY_DATE() {
    return By.xpath("//label[contains(text(),\"you buy your car\")]/following::span[1]/input[1]");
  }

  @Override
  public By VEHICLE_PUBLIC_LIABILITY_IN_FORCE() {
    return By.xpath("//label[contains(text(),\"Public Liability in force?\")]/following::span[1]");
  }

  @Override
  public By VEHICLE_HAZARDOUSE_GOOD() {
    return By.xpath("//label[contains(text(),\"vehicle carry any hazardous goods?\")" +
        "]/following::span[1]");
  }

  @Override
  public By VEHICLE_KEPT_DURING_DAY_LOC() {
    return By.xpath("//label[contains(text(),\"vehicle kept during the day?\")" +
        "]/following::span[1]");
  }

  @Override
  public By VEHICLE_KEPT_DURING_NIGHT_LOC() {
    return By.xpath("//label[contains(text(),\"vehicle kept during the night?\")" + "]/following" +
        "::span[1]");
  }

  @Override
  public By VEHICLE_OVERNIGHT_LOC() {
    return By.xpath("//label[text()=\"Overnight Location\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_KEPT_DURING_NIGHT_POSTCODE() {
    return By.xpath("//label[contains(text(),\"Kept Postcode\")]/following::span[1]");
  }

  @Override
  public By VEHICLE_OWNER() {
    return By.xpath("//label[text()=\"Vehicle owner\"]/following::span[1]");
  }

  @Override
  public By VEHICLE_PROPOSER_REGISTER_KEEPER() {
    return By.xpath("//label[text()=\"Proposer registered keeper\"]/following::span[1]");
  }
}
