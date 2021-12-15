# Upgrade_In_Home_Assignment_QA

Upgrade - In home assignment for SDET/QA Interview

**Steps to set up this framework/ execute tests**

1. Java should be installed in your machine. To check, run java -version, javac -version in terminal
2. Maven should be installed in your machine. To check, run mvn --version in terminal.
3. Clone this repository -> https://github.com/prashantkhanna100/Upgrade_In_Home_Assignment_QA.git
4. Open terminal and go to folder where you downloaded the code repository
5. Run "mvn clean test" and then open this file in browser to see the test results -> "target/surefire-reports/emailable-report.html"


** Things to improve/update in this framework **
1. Add logs for better failure analysis
2. Add try catch blocks for better Exception Handling and better logging
3. Add support for multiple browsers for UI tests
4. Add better reports
5. Add Snapshots in case of failures for UI tests
6. Add Groups, Parameters for better execution capability
7. Add Test Data Management Facility so that we don't need to add test data in code (test classes)
8. and many more based on Product Under Test guidelines and requirements.

