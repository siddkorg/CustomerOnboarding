# Automate Customer Onboarding process 

### 1. Requirement
Instead of user goes to bank physically to open account, 
this process of Onboarding can  be done digitally through REST api application

API endpoint created to adhere the requirement
```bash
1. /bank/v1/logon
2. /bank/v1/customer/register
3. /bank/v1/overview/{username}
  
```

Specification can be found in onboarding.yaml file

### 2. Business rules

a. Customer must be above 18 years old

b. Support of these API only for customers living in country Nederland, Germany, Belgium 

These business rules can easily updated through 'application.properties'

### 3. Error Code
| Error    | Description | Http Code|
| --- | --- | ---|
| ERR_000 | invalid inputs | 400|
| ERR_001 | unauthorized | 401 |
| ERR_002 | age restriction | 400 |
| ERR_003 | country restriction | 400 |
| ERR_004 | overview not found | 404 |
| ERR_005 | customer exist| 409 |
| ERR_999 | unknown error | 500|


### 4. Extended scope
a. Actual security to provide auth token to customer/ MFA

b. Get multipart details of customer eg. photo of customer, id proof etc. and provide email confirmation

b. KYC process implementation

d. Actual IBAN creation which generate valid IBAN.

e. Save & Resume : Store the state of application so customer can provide details in intervals(within different sessions).

e. Normalized Db tables.



### 5. Appraoch taken
a. Brainstorm on requirements w.r.t scalibility & flexibility 

b. Finalize tech-stack eg springboot, mvn, docker, mysql -JPA

c. Create skeleton of application with spring & docker and make sure containers are up and server simple /test request

d. Along with development, create pre-requisite script (data.sql) to showcase existing onboarded customers.


Note : Project setup related README.md can be found  [here](../README.md)

