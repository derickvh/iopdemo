# iopdemo

This project contains Gradle & Ant build and other files to build and deploy IBM Integration Bus applications. It takes as its point of departure the work that was documented here: https://developer.ibm.com/integration/blog/2015/10/02/continuous-build-and-deploy-automation-with-ibm-integration-bus-v10-using-ant-git-and-jenkins/

The Ant build is managed by Gradle. The gradle build file sets some ant properties from a build.config file before it imports the Ant build.xml file. 

A build is typically started by typing 'gradle multiDeploy' or 'gradle mD' on the command line. Any of the Ant targets/Gradle tasks can be invoked in this way. For this particular project there is an ant testHTTP target that executes an HTTP client to test the functionality of the built IIB applications.

Configuration information or other variable information, such as the parameters one would pass to the mqsicreatebar command, are also found in the build.config file. The mqsiapplybaroverride command (Ant override target) reads new property values from a properties file. This file must be left empty if no overrides are required.

The following files must be checked and, if required, edited before a build is run.

1. build.config - Selects an environment (DEV, QA,PROD) and specifies other properties used to configure mqsi commands.
2. override.properties This file is completely dependent on the application being built and can be left empty if no overrides are to be applied. 
3. gradle.properties. Supplies platform specific information on IIB and SoapUI executables (Linux, MacOS, Windows).
