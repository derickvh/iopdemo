# iopdemo

This project contains Gradle & Ant build files and dependent files to build and deploy IBM Integration Bus applications. It takes as its point of departure the work that was documented at this URL. https://developer.ibm.com/integration/blog/2015/10/02/continuous-build-and-deploy-automation-with-ibm-integration-bus-v10-using-ant-git-and-jenkins/

The Ant build is managed by Gradle. The gradle build file sets some ant properties from a gradle.properties file before it imports the Ant build.xml file. A deployment is typically invoked by typing 'gradle multiDeploy' or 'gradle mD' on the command line. Any of the Ant targets/Gradle tasks can be invoked in this way.

Configuration information or other variable information, such as the parameters one would pass to the mqsicreatebar command, are found in the respective properties files. The mqsiapplybaroverride command (Ant override target) also reads new property values from a properties file.

The following files must be checked and, if required, edited before a build is run.

1. gradle.properties - selects an environment (DEV, QA,PROD) and other properties
2. override.properties (This file can be left empty if no overrides are to be applied). This file is completely dependent on the application being built.
3. broker.properties. Contain information of the brokers (integration nodes) to which the compiled bar file must be deployed.

