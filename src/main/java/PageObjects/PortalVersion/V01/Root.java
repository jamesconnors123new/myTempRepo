package PageObjects.PortalVersion.V01;

import PageObjects.PortalModel.*;

public class Root implements PageObjects.PortalModel.Root {

  private final DashboardLocatorModel dashboardLocatorModel =
      new DashboardLocatorLib();

  private final PortalLoginLocatorModel portalLoginLocatorModel =
      new PortalLoginLocatorLib();

  private final JointPolicyHolderLocatorModel jointPolicyHolderLocatorModel =
      new JointPolicyHolderLocatorLib();

  private final PaymentLocatorModel paymentLocatorModel =
      new PaymentLocatorLib();

  private final PerformMTALocatorModel performMTALocatorModel =
      new PerformMTALocatorLib();

  private final PortalRegistrationLocatorModel portalRegistrationLocatorModel =
      new PortalRegistrationLocatorLib();

  private final PortalQuoteCreationLocatorModel portalQuoteCreationLocatorModel=
      new PortalQuoteCreationLocatorLib();

  private final PortalSharedLocatorModel portalSharedLocatorModel=
      new PortalSharedLocatorLib();

  @Override
  public DashboardLocatorModel getDashboardLocatorModel() {
    return dashboardLocatorModel;
  }
  @Override
  public PortalLoginLocatorModel getPortalLoginLocatorModel() {
    return portalLoginLocatorModel;
  }

  @Override
  public JointPolicyHolderLocatorModel getJointPolicyHolderLocatorModel() {
    return jointPolicyHolderLocatorModel;
  }

  @Override
  public PaymentLocatorModel getPaymentLocatorModel() {
    return paymentLocatorModel;
  }

  @Override
  public PerformMTALocatorModel getPerformMTALocatorModel() {
    return performMTALocatorModel;
  }

  @Override
  public PortalRegistrationLocatorModel getPortalRegistrationLocatorModel() {
    return portalRegistrationLocatorModel;
  }

  @Override
  public PortalQuoteCreationLocatorModel getPortalQuoteCreationLocatorModel() {
    return portalQuoteCreationLocatorModel;
  }

  @Override
  public PortalSharedLocatorModel getPortalSharedLocatorModel() {
    return portalSharedLocatorModel;
  }


}
