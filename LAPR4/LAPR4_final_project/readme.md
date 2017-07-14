Cleansheets 2017
================
  
This readme file is written in [markdown](http://daringfireball.net/projects/markdown/). 

1. Startup Guide
----------------
 
This project uses gradle. It should be possible to work with the project using any IDE (e.g., Netbeans, Eclipse, IntelliJ).

However, this project was essentially tested with the Netbeans IDE. Even if using an IDE some tasks should be executed from a console or terminal window, specially the execution of the application during demonstrations. These tasks are described at the bottom of this file.  

### First Step - Requirements

The first thing you need to do is to make sure you have all the requirements. Please read the section about requirements in this file.

### Second Step - Build and Run Cleansheets

Open the project with Netbeans. Right click the project and select "Clean and Build". Right click on the project and select "Run" (gradle will run the class "csheets.CleanSheets"). 

**Note About the Build:** 
- Cleansheets uses ANTLR grammars. The grammars are specified in ".g" files. The build process generates java code based on the grammars before compiling the java code. Grammars are located in the "src/main/antlr3" folder. Antlr generated code is produced to the "build/generated-src/antlr/main" folder. 

### Third Step - Study the Project

The third step we propose is to study the code and documentation. In particular, you should study the extension mechanism of Cleansheets. 

You will find a very simple extension named "Simple Extension". This extension is documented in javadoc. You can start by this one since, as the name implies, it is very simple.

To generate the javadoc right click on the project and select "Generate Javadoc". You may get several warning messages. For the moment you can ignore them.

The generated javadoc is located in "build/docs/javadoc". Open "index.html" to access the overview page of the javadoc. 

Open the javadoc documentation and read the documentation regarding the package "csheets.ext.simple". Note: To see the documentantion for a package click on the link for the package.

You should also take a look at the overview page of the javadoc.

**Note About the Javadoc:** As you can see, the javadoc also includes technical diagrams (i.e., UML). These diagrams ('png' files) are generated from textual specification that are located in '.puml' files. These files are processed by plantuml during the javadoc generation process. The plantuml plugin of Netbeans is also able to dynamically generate a visual representation of a '.puml' file when the file is open. There are also plantuml plugins for other IDEs.   

### Fourth Step - Study the Example Use Case 

You can find an example of the implementation of a complete feature increment in the package 'lapr4.white.s1.core.n1234567.comments'. As much as possible, all contributions to the LAPR4 project should appear in sub-packages of 'lapr4' (following the directions contained in the LAPR4 manual). 

### Fifth Step - Execute the Unit Tests 

To execute the unit tests right click on the project and select "Test". Take a look at the unit tests.

You can also right click on the project and select "Tasks/jacocoTestReports". This option will generate a report of the code coverage of unit tests. You can see the generated report in "build/reports/jacoco/test/html/index.html".

2. Global Requirements
----------------------

### Graphviz
You should install [Graphviz](http://www.graphviz.org/) in your computer to be able to generate all type of uml diagrams with plantuml in javadoc.

### Plantuml
[Plantuml](http://www.plantuml.com) is jar file that is already integrated in the project. However we strongly suggest that you download the user manual for future reference when specifying your own plantuml diagrams.  

Netbeans Requirements
---------------------

### Plantuml

This plugin adds support for realtime preview of plantuml diagrams. You should install it from the Plugins window of Netbeans.

### Markdown Support

This plugin adds support for markdown syntax on readme files (like this one). You should download the plugin from [Flow NetBeans Markdown](https://github.com/madflow/flow-netbeans-markdown) and install it.

### Display Readme Files in Project View

This is a very simple plugin that simple displays readme files in the project view. You should install it from the Plugins window of Netbeans.

### ANTLRWorks

You may install this netbeans plugin to have a smart editor for grammar files. This plugin is optional since the ANTLRWorks jar file that comes with the project does everything this plugin does and more.

**This plugin was only tested with Netbeans 8.0.1!**

### JaCoCo 

This plugin adds support for code coverage information (for instance test coverage information). The name of the plugin is "TikiOne JaCoCoverage". For further information see the web site of the projet ([jacoco](http://eclemma.org/jacoco/)). This plugin may not work as desired in this project because it requires the use o maven.

3. Tasks Executed From the Terminal/Console
-------------------------------------------

**VERY IMPORTANT: ALL THE SPRINT DEMONSTRATIONS ARE REQUIRED TO BE EXECUTED WITHOUT NETBEANS (OR ANY IDE). The demonstrations are required to be executed from a terminal/console.** 

The Cleansheets version of 2017 uses gradle ([gradle](https://gradle.org)) for its tasks. Therefore, many of the tasks presented in this section are tasks performed by gradle. In OSX and Linux systems you should always execute this tasks in a terminal and having the root folder of the project as the current directory. The command should always start by "./gradlew". In Windows the same applies but the command should start by "gradlew". 

### Clean Generated Artifacts

To clean all generated artifacts type:

    ./gradlew clean

### Build the Project

To build the project type:

    ./gradlew build

This will also execute all the tests of the project, build distribution archives and generate the coverage reports. 

### To Run only the Unit Tests

To run the unit tests type:

    ./gradlew clean test

You may remove "clean" from the command if you do not wish to force the execution of the unit tests.

After that, to produce the coverage report for unit tests type:

    ./gradlew jacocoTestReport 

### To Run only the Acceptance Tests

The project contains a second set of junit tests that is named "acceptanceTest". This set should contain Behavior tests as in TDD and BDD (see [TDD](https://en.wikipedia.org/wiki/Test-driven_development)). The source code for these tests is located in "src/acceptance-test/java".

To run the acceptance tests type:

    ./gradlew clean acceptanceTest

You may remove "clean" from the command if you do not wish to force the execution of the acceptance tests.

After that, to produce the coverage report for acceptance tests type:

    ./gradlew acceptanceTestCoverageReport

### To Generate a Distribution Archive

To generate a full distribution archive file type:

    ./gradlew assemble

Gradle will produce distribution archive files (tar and zip) in the "build/distributions" folder. These archive files will also contain a script that can be used to execute the application.

### To Generate the Javadoc Technical Documentation

To generate the javadoc technical documentation for the project type:

    ./gradlew javadoc

Open the file "build/docs/javadoc/index.html" in a bowser to access the javadoc documentation.

### Execute Cleansheets from the Distribution Archive File

Using a distribution archive file (explained in the previous section) it is possible to execute the application.

First, use an archive tool (i.e., tar or zip) to extract the distribution files from the archive. 

Then, in OSX or Linux type:

    ./build/distributions/csheets-1.0-SNAPSHOT/bin/csheets

Then, in Windows type:

    build/distributions/csheets-1.0-SNAPSHOT/bin/csheets.bat

### Execute a Console to Tests Formulas

Cleansheets comes with a second "main" class (i.e., csheets.core.formula.compiler.Console) that can be used to execute a console to interactively test formulas.

To execute this console type:

    ./gradlew runCompilerConsole

Note: The tasks seams to freeze almost at the end. It is simply waiting for formula expressions to execute. Type "=1+2" and see what happens. To exit simply type ctrl+D.

### Execute ANTLRWorks

ANTLRWorks is already included in the project.

ANTLR v3 (and ANTLRWorks) are used in the formula parser and lexer. The antlr-3.5.2-complete.jar contains both APIs of ANTLR: v2 and v3. ANTLRWorks is contained in a jar file that is located in the lib folder (antlrworks-1.5.2-complete.jar). You can run this jar
to open the IDE for developing ANTLR v3 grammars. Using ANTLRWorks gives you the possibility to have a smart editor for your grammar and also to view a graphical parser tree of expressions (using the "interpreter"). 

To run ANTLRWorks execute in the terminal:
    
    cd tools
    java -jar antlrworks-1.5.2-complete.jar
 



