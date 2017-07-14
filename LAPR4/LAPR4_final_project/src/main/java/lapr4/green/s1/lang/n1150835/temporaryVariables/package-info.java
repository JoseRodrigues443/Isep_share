/**
 * Technical documentation regarding the user story Lang02.1: Temporary Variables.
 * 
 * <p>
 * <b>Scrum Master: - no</b>
 * 
 * <p>
 * <b>Area Leader: - no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work. TODO-
 * <p>
 * -TODO-
 *
 * <h2>2. Requirement</h2>
 * 
 * The user should be able to create temporary variables to be used on blocks of instructions or in for loops.. 
 * The variables are only strict to the cells they are being used; this way, multiple cells can have variables with the same name.
 * The variables must start with "_" ( e.g: " _i:=0" translates to the attribution of the value 0 to the variable i) 
 * 
 * <p>
 * <b>Use Case "Create Temporary Variables":</b> Add support for temporary variables. The name of temporary variables must start with the "_" sign. 
 * When a variable is referred in a formula for the first time it is created. To set the value of a variable it must be used on the left of the assign operator (":="). 
 * Temporary variables are variables that only exist the context of the execution of a formula.
 * Therefore, it is possible for several formulas to use temporary variables with the same name and they will be different instances. 
 * Example: "= {_Counter:=1; WhileDo(Eval( "A"&_Counter)> 0; {C1:=C1+Eval("B"&_Counter); _Counter:=_Counter+1 }) }" .
 * In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero.
 * 
 * SSD: 
 * <p>
 * <img src="lang02.1_SDD" alt="image"/> 
 * <p>
 *  
 * <h2>3. Analysis</h2>
 * To this feature, it is required a class that will be responsible for creating a new variable. This creation will occur when an expression 
 * corresponding to the variable is found, and its search will be made for each formula inserted by the user.
 * Each formula should have a list to save all its variables used.
 * Besides that, the Formulla.g4 class needs to have a token to recognize a Variable (TEMPVAR : UNDERSCORE LETTER (LETTER|DIGIT|UNDERSCORE)*):
 * it makes so the variable has to start with an underscore "_" followed by a letter. After that, it can be followed by a letter, a digit or an underscore.
 * 
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case.
 * <p>
 * <img src="lang02.1_SDD" alt="image"/> 
 * <p>
 * After recognizing a variable in the inserted block of instructions, a new Variable object will be created, given a new value
 * and saved on a list of variables, belonging to that specific cell.
 * This process can occur to multiple variables on the same block of instructions.
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Functional Tests</h3>
 * From the analysis and requirements, it's possible to see that the tests need to be around the use of variables in block of instructions.
 * The following tests should be made to test the feature:
 * <ul style="list-style-type:disc">
 * <li>
 * <p>
 * Create in a cell a temporary variable "_count", initialized to 0. In other cell, create a variable with the same name and a different value
 * </p>
 * </li>
 * <li>
 * <p>
 * Create in a cell a temporary variable "_count", initialized to 0, then try to add +1 to the variable.
 * </p>
 * </li>
 * <li>
 * <p>
 * </ul>
 * 
 * <h3>4.2. Sequence Diagram</h3>
 * <p>
 * <img src="lang02.1_SD" alt="image"/> 
 * <p>
 * 
 * <h2>5. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and where used in this issue. As far as possible you should use links to the commits of your work-
 * 
 * <h2>6. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * -TODO-
 * 
 * <h2>7. Final Remarks</h2>
 * 
 *  -TODO-
 * 
 * <h2>8. Work Log</h2> 
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Nothing
 * <p>
 * Today
 * <p>
 * 1. Inital study of the project itself
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Inital study of the project itself
 * <p>
 * Today
 * <p>
 * 1. Continuation of the study of the project.
 * 2. Initiation of the use of Jira
 * 3. Start of the analysis
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 * <b>Wednesday</b>
 * <p>
 * * Yesterday I worked on: 
 * <p>
 * 1. Continuation of the study of the project.
 * 2. Initiation of the use of Jira
 * 3. Start of the analysis
 * <p>
 * Today
 * <p>
 * 1. Nothing
 * <p>
 * Blocking: 
 * <p>
 * 1. Nothing
* <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Nothing
 * <p>
 * Today
 * <p>
 * 1. End of the Analysis
 * 2. Start of the Design
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 *  * <b>Friday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. End of the Analysis
 * 2. Start of the Design
 * <p>
 * Today
 * <p>
 * 1. Continuation of Design
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 *  * <b>Saturday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Continuation of Design
 * <p>
 * Today
 * <p>
 * -TODO-
 * <p>
 * Blocking:
 * <p>
 * -TODO-
 * <p>
 * 
 * <h2>9. Self Assessment</h2> 
 * 
 * <h3>Design and Implementation: -TODO-</h3>
 * 
 * -TODO-
 * 
 * <h3>R6. Rubric Requirements Analysis: -TODO- </h3>
 * 
 *  -TODO-
 * 
 * <h3>R7. Rubric Design and Implement:  -TODO-</h3>
 * 
 *  -TODO-
 * 
 * @author Rui Braga
 */
package lapr4.green.s1.lang.n1150835.temporaryVariables;

