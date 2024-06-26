package PageObjects.EchelonVersion.V01;

import PageObjects.EchelonModel.*;

public class Root implements PageObjects.EchelonModel.Root {

  private final EchelonClientDetailLocatorModel echelonClientDetailLocatorModel =
      new EchelonClientDetailLocatorLib();

  private final EchelonLoginLocatorModel echelonEchelonLoginLocatorModel =
      new EchelonLoginLocatorLib();

  private final EchelonHomeLocatorModel echelonEchelonHomeLocatorModel =
      new EchelonHomeLocatorLib();

  private final EchelonQuoteCreationLocatorModel echelonEchelonQuoteCreationLocatorModel =
      new EchelonQuoteCreationLocatorLib();

  private final EchelonClientPolicyDetailsLocatorModel echelonEchelonClientDetailLocatorModel =
      new EchelonClientPolicyDetailsLocatorLib();

  private final NewHouseHoldLocatorModel newHouseHoldLocatorModel = new NewHouseHoldLocatorLib();

  private final EchelonSharedLocatorModel echelonSharedLocatorModel =
      new EchelonSharedLocatorLib();

  private final EchelonCarPolicyDetailsLocatorModel echelonCarPolicyDetailsLocatorModel =
      new EchelonCarPolicyDetailsLocatorLib();

  @Override
  public EchelonClientDetailLocatorModel getEchelonClientDetailLocatorModel() {
    return echelonClientDetailLocatorModel;
  }

  @Override
  public EchelonLoginLocatorModel getEchelonLoginLocatorModel() {
    return echelonEchelonLoginLocatorModel;
  }

  @Override
  public EchelonHomeLocatorModel getEchelonHomeLocatorModel() {
    return echelonEchelonHomeLocatorModel;
  }

  @Override
  public EchelonQuoteCreationLocatorModel getEchelonQuoteCreationLocatorModel() {
    return echelonEchelonQuoteCreationLocatorModel;
  }

  @Override
  public EchelonClientPolicyDetailsLocatorModel getEchelonClientPolicyDetailsLocatorModel() {
    return echelonEchelonClientDetailLocatorModel;
  }

  @Override
  public NewHouseHoldLocatorModel getNewHouseHoldLocatorModel() {
    return newHouseHoldLocatorModel;
  }

  @Override
  public EchelonSharedLocatorModel getEchelonSharedLocatorModel() {
    return echelonSharedLocatorModel;
  }

  @Override
  public EchelonCarPolicyDetailsLocatorModel getEchelonCarPolicyDetailsLocatorModel() {
    return echelonCarPolicyDetailsLocatorModel;
  }


}
