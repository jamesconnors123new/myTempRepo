package PageObjects.EisVersion.V01;

import PageObjects.EisModel.*;


public class Root implements PageObjects.EisModel.Root {
    private final EisLoginLocatorModel getEisLocatorModel =
            new EisLoginLocatorLib();
    private final EisHomeLocatorModel eisHomeLocatorModel =
            new EisHomeLocatorLib();

    private final EisClientCreationLocatorModel eisClientCreationLocatorModel =
            new EisClientCreationLocatorLib();

    private final EisClientPortfolioLocatorModel eisEisClientPortfolioLocatorModel =
            new EisClientPortfolioLocatorLib();

    private final EisPaymentLocatorModel eisEisPaymentLocatorModel =
            new EisPaymentLocatorLib();

    private final EisSharedLocatorModel eisSharedLocatorModel =
            new EisSharedLocatorLib();
    private final EisPolicyDashboardLocatorModel eisPolicyDashboardLocatorModel
            = new EisPolicyDashboardLocatorLib();
    private final EisHomeQuoteCreationLocatorModel eisHomeQuoteCreationLocatorModel = new EisHomeQuoteCreationLocatorLib();

    private final EisMotorQuoteCreationLocatorModel eisMotorQuoteCreationLocatorModel =
            new EisMotorQuoteCreationLocatorLib();
    private final EisMotorPolicyPersonalDetailsLocatorModel eisMotorPolicyPersonalDetailsLocatorModel =
        new EisMotorPolicyPersonalDetailsLocatorLib();

    private final EisMotorVehicleLocatorModel eisEisMotorVehicleLocatorModel =
        new EisMotorVehicleLocatorLib();

    private final EisMotorClaimAndConvictionLocatorModel getEisMotorClaimAndConvictionLocatorModel =
        new EisMotorClaimAndConvictionLocatorLib();

    private final EisMotorPremiumAndCoveragesLocatorModel getEisMotorPremiumAndCoveragesLocatorModel =
        new EisMotorPremiumAndCoveragesLocatorLib();

    private final EisMotorPolicyBasicInfoLocatorModel getEisMotorPolicyBasicInfoLocatorModel=
        new EisMotorPolicyBasicInfoLocatorLib();

    private final EisHomePolicyDetailsLocatorModel getEisHomePolicyDetailsLocatorModel=
        new EisHomePolicyDetailsLocatorLib();


    @Override
    public EisHomeLocatorModel getEisHomeLocatorModel() {
        return eisHomeLocatorModel;
    }

    @Override
    public EisLoginLocatorModel getEisLocatorModel() {
        return getEisLocatorModel;
    }

    @Override
    public EisClientCreationLocatorModel getEisClientCreationLocatorModel() {
        return eisClientCreationLocatorModel;
    }

    @Override
    public EisClientPortfolioLocatorModel getEisClientPortfolioLocatorModel() {
        return eisEisClientPortfolioLocatorModel;
    }

    @Override
    public EisHomeQuoteCreationLocatorModel getEisQuoteCreationLocatorModel() {
        return eisHomeQuoteCreationLocatorModel;
    }

    @Override
    public EisPaymentLocatorModel getEisPaymentLocatorModel() {
        return eisEisPaymentLocatorModel;
    }

    @Override
    public EisSharedLocatorModel getEisSharedLocatorModel() {
        return eisSharedLocatorModel;
    }
    @Override
    public EisPolicyDashboardLocatorModel getEisPolicyDashboardLocatorModel(){
        return eisPolicyDashboardLocatorModel;
    }
    @Override
    public EisMotorQuoteCreationLocatorModel getEisMotorQuoteCreationLocatorModel(){
        return eisMotorQuoteCreationLocatorModel;
    }

    @Override
    public EisMotorPolicyPersonalDetailsLocatorModel getEisMotorPolicyPersonalDetailsLocatorModel() {
        return eisMotorPolicyPersonalDetailsLocatorModel;
    }

    @Override
    public EisMotorVehicleLocatorModel getEisMotorVehicleLocatorModel() {
        return eisEisMotorVehicleLocatorModel;
    }

    @Override
    public EisMotorClaimAndConvictionLocatorModel getEisMotorClaimLocatorModel() {
        return getEisMotorClaimAndConvictionLocatorModel;
    }

    @Override
    public EisMotorPremiumAndCoveragesLocatorModel getEisMotorPremiumAndCoveragesLocatorModel() {
        return getEisMotorPremiumAndCoveragesLocatorModel;
    }

    @Override
    public EisMotorPolicyBasicInfoLocatorModel getEisMotorPolicyBasicInfoLocatorModel() {
        return getEisMotorPolicyBasicInfoLocatorModel;
    }

    @Override
    public EisHomePolicyDetailsLocatorModel getEisHomePolicyDetailsLocatorModel() {
        return getEisHomePolicyDetailsLocatorModel;
    }


}

