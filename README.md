# iopdemo

This project contains Ant build files and their dependent files to build and deploy IBM Integration Bus applications. It takes as its point of departure the work that was documented at this URL. https://developer.ibm.com/integration/blog/2015/10/02/continuous-build-and-deploy-automation-with-ibm-integration-bus-v10-using-ant-git-and-jenkins/

The Ant build is managed by Gradle. The gradle build file sets some ant properties from a gradle.properties file before it imports the Ant build.xml file. A deployment is typically invoked by typing 'gradle deploy' on the command line. Any of the Ant targets can be invoked in this way.

Configuration information or other variable information, such as the parameters one would pass to the mqsicreatebar command, are found in the respective properties files. The mqsiapplybaroverride command (Ant override target) also reads new property values from a properties file.

The following files must be checked and, if required, edited before a build is run.

1. gradle.properties - selects an environment (DEV, QA,PROD) and sets a flag to indicate whether a BAR file must be created from scratch or an existing one deployed.
2. build.properties - selects integration server. Set name of application and barfile. Defines the parameters that must be passed to the mqsicreatebar command.
3. override.properties (This file can be left empty if no overrides are to be applied). This file is completely dependent on the application being built.
4. iib-node.xml file that contains the connection details of the integration node to which the compiled bar file has to be deployed. This file conforms to the IBM broker.xsd schema.

The following files probably need not be edited, or only perhaps once-off.

1. build.gradle
2. build.xml
3. masterbuild.xml
