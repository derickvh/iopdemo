# iopdemo

This project contains Ant build files and their dependent files to build and deploy IBM Integration Bus applications. It takes as its point of departure the work that was documented at this URL. https://developer.ibm.com/integration/blog/2015/10/02/continuous-build-and-deploy-automation-with-ibm-integration-bus-v10-using-ant-git-and-jenkins/

The intention is to move to gradle soon. At the moment the Ant build.xml file can be imported into a gradle build.gradle file and its various targets executed. Try targets test, or deploy. Or try target read.bar that simply reads the compiled BAR file and lists its defined properties and the files it contains. Set the Ant property deploy.only to true to prevent the BAR file from being compiled from scratch.

Configuration information or other variable information, such as the parameters one would pass to the mqsicreatebar command, are found in the respective properties files. The mqsiapplybaroverride command (Ant override target) also reads new property values from a properties file.

