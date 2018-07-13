# Appium Test

Steps to setup
1. git clone this project 
2. go to the project folder and run 'mvn clean install' to install dependencies
3. after installing dependencies set parameters 'suiteFile' & 'driverConfig' in maven configuration and use command 'clean compile test' to run
4. or run by command mvn test -DsuiteFile="suiteFile.xml" -DdriverConfig="configFile.json"