# Client Builder

### Description
Client Builder is to be used for creation of client through Echelon.
with default values passed through by a ClientBuilderEchelon.yaml file. This package will
help create set of clients for any environment where it is used.
This will help in new customer creation along with Quotes and the Payment will need to be
made manually for a policy to be created. The registration and policy creation will be dealt in a separate package.

### Installation
1. Tool required- IntelliJ Community Edition, Java Latest Version
2. Use mentioned path to find the runner: DataTools -> StrataClientSetup -> ClientBuilderEchelon.yaml

### Usage
1. Yaml field details that need to be edited for this to take effect.
2. Number of clients required will be equal to instances in the yaml
3. Table of questions mapping to the keys in yaml will be provided to the user which needs to be
   updated based on the requirements.
4. Email address format explained with the table below- 

   ![img.png](img.png)

## Returns
The output of the Yaml will be stored in the form of logs in location xxx
with the information of Client Number and web reference number for the quote created.

## Meaning of keys in Yaml:
````yaml
      ~ControlData:
         UserCredentials: #User Credentials
            Email: #Email
            Password: #Password   
         SalesDetails:
            QuotesDetails:
               Affinity: Affinity
               ~Gen(InceptionDate): DateRelToTodayAsStr|0|dd/MM/yyyy #Auto Generated
            InsuranceDetails:
               TypeOfHouseHoldCover:
                  Buildings: #true/false
                  Contents: #true/false
                  BuildingAccidentalDamage: #true/false
                  ContentAccidentalDamage:  #true/false
               InsuredAmount:
                  BuildingVoluntaryExcess: #Number
                  ContentVoluntaryExcess: #Number
                  RebuildingCost: #Number input
                  ContentSum: #Number input
               ContentDetails:
                  Safe: #true/false
               BuildingDetails:
                  BuildingType: Detached  #Type of Building
                  ConstructionType: Standard  #Construction Type
                  YearBuilt: #Year
                  NumberOfBedrooms: #Number of Bedroom
                  Address:
                     AddressSelector:
                  HouseIdentifier: #House Number
                     Postcode: RG45LP
                     RiskAddress:
                        HouseIdentifier: 1
                        Postcode: RG45LP
                  AdditionalInformation:
                     ListingStatus: #true/false
                     BuildingWorkStatus: #true/false
                     GoodRepairStatus: #true/false
                     GeologicalThreats: #true/false
                     FreeFromFloodingThreats: #true/false
               Usage:
                  NonFamilyLodger: #true/false
                  LetWithSublet: #true/false
                  BusinessUse: #true/false
                  HolidayHomeStatus: #true/false
                  Occupancy: Occupied
               Security:
                  Locks: #true/false
                  Alarms: Basic DIY Alarm  #Type of alarn
                  NeighbourhoodWatch: #true/false
               ProposerRelationshipToRisk:
                  LegalRelationship: Owned #Leased/Rented/Owned
                  FirstTimeBuyers: #true/false
               PreferredDeliveryMethod: #Email/Download
               ProposerPersonalDetails:
                  Title: #Salutation Mr/Mss etc
                  FirstName: DataBuild
                  LastName: ~(AreaOfTesting)~(LogicalPattern)~(ClientGroupId)~(Index) - Auto Generated
                  MaritalStatus: Single  #Divorced/Married/Single/Civil Partnered/Widowed
                  ~Gen(DateOfBirth): DateRelToTodayAsStr|-14800|dd/MM/yyyy #39 years Old - Auto Generated
                  Gender: Male # Male/Female
                  ~Gen(UkResidentSince): DateRelToTodayAsStr|-14800|dd/MM/yyyy #39 years Old - Auto Generated
                  PrimaryEmploymentStatus:
                     Employed: #true/false
                     Category: Employee
                     Type: BakeryAssistant
                     Industry: FastFood
                  SecondaryEmploymentStatus:
                     Employed: false
               ProposerContactDetails:
                  AddressSelector:
                     HouseIdentifier: 1
                     Postcode: RG45LP
                  MainTelephoneNumber: # Telephone number
                  EmailAddress: ~(TestingTeam)_~(EmailSequenceNumber)_~(Team)_~(LogicalPattern)_~(AreaOfTesting)_~(AreaOfBusiness)_~(TestingType)@~(DomainName) - Auto Generated
               MarketingChoice:
                  Postal: #true/false
                  Email: #true/false
                  Telephone: #true/false
                  SMS: #true/false
               OtherDetails: #Policy User Fields
                  SufferedLossNotResultedInClaim: #true/false
               DynamicUnderwriterQuestions:
                  WallConstructionType: Brick
                  RoofConstructionType: Concrete
                  NumberOfDaysPropertyLeftUnoccupied: #How long is the property left unoccupied?
                  PercentageOfFlatRoof: 35 # Number upto 100 - Approximately what percentage of the roof is flat? 
                  PaymentType:  #Payment Type?
                  UnsatisfiedCountyCourtJudgements: #Has any resident had any unsatisfied County Court Judgements?
                  ResidentDeclaredBankrupt: #Has any resident been declared bankrupt?
                  ExtendedHouse: #Has the property been extended? *
                  NumberOfPeopleLive:
                     Children: #How many children live in the property?
                     Adult: #How many adults live in the property?
                     Pet: #Do you have a pet living at the property? *
                        Cat: #true/false
                        Dog: #true/false
                        Other: #true/false #if first two options are true then other should not be true. condition
                  PropertyOwned: #How is your property owned?
                  JointPolicyHolderDetails: #true/false
                  JointPolicyHolder:
                     Title: #Mr
                     FirstName: #First Name
                     LastName: Last Name
                     MaritalStatus: #Single / Divorce
                     ~Gen(DateOfBirth): DateRelToTodayAsStr|-12800|dd/MM/yyyy #Auto Generated
                     Gender: Male  #Male/Female
                     ~Gen(UkResidentSince): DateRelToTodayAsStr|-12800|dd/MM/yyyy #Auto Generated
                     RelationshipWithPolicyholder: (None) #Single etc
      ~Judgements:
      ~Unconditionals:
````

> **_NOTE:_** User need to update the answer for "No Smoker" question to "NO".