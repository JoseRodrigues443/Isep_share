/**
 * Technical documentation regarding the user story Core04.2: Extensions in Navigator.
 * 
 * <p>
 * <b>-Note: this is a template/example of the individual documentation that each team member must produce each sprint. Suggestions on how to build this documentation will appear between '-' like this one. You should remove these suggestions in your own technical documentation. You may also define a different template for your team to use with the agreement of your supervisor-</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work 
 * during the sprint.
 * For instance, if you spend significant time helping a colleague or if you 
 * work in more than a feature.-
 *
 * <h2>2. Requirement</h2>
 * 
 * <p>
 * <b>Use Case "Extensions in Navigator":</b> The user selects this use case.
 * The system displays the list of extensions disabled and enabled extensions.
 * 
 * <h2>3. Analysis</h2>
 * 
 * 
 * <h3>"analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously 
 * described use case. We call this diagram an "analysis" use case realization 
 * because it functions like a draft that we can do during analysis or early 
 * design in order to get a previous approach to the design. For that reason we 
 * mark the elements of the diagram with the stereotype "analysis" that states 
 * that the element is not a design element and, therefore, does not exists as 
 * such in the code of the application (at least at the moment that this diagram 
 * was created).
 * <p>
 * <img src="CORE04.2_extension_navigator_analysis.png" alt="image"> 
 * <p>
 * 
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Functional Tests</h3>
 * <p>
 * see: <code>lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorControllerTest</code><p>
 *
 * <h3>4.2. UC Realization</h3>
 * For the sidebar we need to implement a JPanel. In the code of the extension 
 * <code>csheets.ext.style</code> 
 * we can find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution 
 * for this use case.
 * <p>
 * <img src="CORE04.2_extension_navigator_design.png" alt="image">
 * 
 * <h3>4.3. Classes</h3>
 * 
 * Modified classes: EnableAndDisableExtensionsController
 * New classes: ExtensionNavigatorUI, ExtensionNavigatorController
 * 
 * <h2>5. Final Remarks</h2>
 * 
 * -In this section present your views regarding alternatives, extra work and 
 * future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if 
 * the cell has a comment. This "feature" is not documented in this page.
 * 
 * 
 * <h2>6. Work Log</h2> 
 * 
 * -Insert here a log of you daily work. This is in essence the log of your daily 
 * standup meetings.-
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. The previous issue
 * <p>
 * Today
 * <p>
 * 1. Understanding this issue
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Understanding the issue
 * <p>
 * Today
 * <p>
 * 1. Analysis
 * <p>
 * Blocking:
 * <p>
 * 1. none
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Analysis
 * <p>
 * Today
 * <p>
 * 1. Design
 * <p>
 * Blocking: 
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Design
 * <p>
 * Today
 * <p>
 * 1. Implementation
 * <p>
 * Blocking: 
 * <p>
 * 1. How do I show the lists? and make the user click only on the extension and 
 * not it's props to run
 * 2. How do I fill the array of the enabled extensions?
 * 3. If a person clicks on a disabled extension does it not run or do I have to do
 * the verification ?
 * 
 * <h2>8. Self Assessment</h2> 
 * 
 * -Insert here your self-assessment of the work during this sprint regarding Rubrics R3, R6 and R7.-
 * 
 * <h3>R3. Rubric Requirements Fulfilment: 3</h3>
 * 
 * 3- some defects. The student did fulfil all the requirements and also did justify the eventual options related to the interpretation/analysis of the problem.
 * 
 * <h3>R6. Rubric Requirements Analysis: 4</h3>
 * 
 * 4- correct. There is a robust and very complete analysis of the problem with well chosen technical artifacts (diagrams, grammars, etc.) for its documentation and without errors.
 * 
 * <h3>R7. Rubric Design and Implement: 2</h3>
 * 
 * 2- many defects. The code follows good practices although some design patterns should have been applied. The technical documentation covers the majority of the solution although it may have some errors. However the appropriate type of technical artifacts for documenting design are present and the ideia behind the solution is understandable. Code does not "goes against" the design options of the original code of the project. Unit tests seem to cover a significant amount of functionalities (e.g., more than 50%) but there was not test first approach.
 * 
 * @author Catarina Sousa 1150767
 */
package lapr4.green.s2.core.n1150767.extensionNavigator;

