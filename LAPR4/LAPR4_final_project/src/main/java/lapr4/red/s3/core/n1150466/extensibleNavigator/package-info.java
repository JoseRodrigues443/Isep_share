/**
 * <h1>Technical documentation regarding the user story Core04.3 - Extensible Navigator.</h1>
 *
 * <h2>2. Requirement</h2>
 * The Navigator feature should be extensible. Extensions of Cleansheets should be able to extend the navigator with specific content.
 * These content should be displayed in a branch of the navigator tree. The features Core04.1 
 * and Core04.2 should be provided as navigator extensions.
 *
 * 
 * <h2>3. Analysis</h2>
 *
 * <h3>First analysis workflow sequence diagram</h3>
 * 
 * <p>
 * <img src="extensible_navigator_analysis.png" alt="image">
 * <p>
 * This functionality requires a major change in how all the extensions are implemented.
 * Therefore, the decision that was made is that we will not extend the Extension class with
 * a navigator abstract class neither implement an interface, but each individual extension (ex: FindWorkbooksExtension)
 * should implement or extend the Navigator class and consequently implement the method that
 * collects the specific information to include in the navigator tree. We do this because this functionality
 * would have a massive scale impact on the program and for the purposes of the functionality demonstration
 * and application integrity, it will only be implemented in a few extensions, such as CRM extensions that
 * are good examples to show how the navigable content works. 
 * </p>
 *
 * <h2>4. Design</h2>
 * <p>
 * In order to make the navigator extensible and to provide the option for the user
 * to specify the content to be shown in the navigator tree nodes, changes had to be made
 * how each extension should implement/extend the UIExtension class.
 * The abstract class Navigator was created for this purpose. It extends the UIExtension class
 * and should serve as a superclass for any functionality that desires to have a customizable navigator.
 * Therefore, future extensions should rewrite the method that dictates which specific content
 * is to be included. This responsibility falls onto the programmer of the given functionality. Since
 * it would be very massive to implement now on every extension.
 * </p>
 * <h3>4.1. UC Realization</h3>
 * <p>
 * Firstly, the user has to select what content is to be included in the navigator.
 * This is shown in the sequence diagram below. <br/>
 * The user selects the fields which he wants to include, such as declared fields in the 
 * domain class that the extension reflects upon. Further refinement should only reveal
 * domain relevant content.
 * The content is stored in a list present in the abstract class instantiated for 
 * each specific extension that extends it.
 * </p>
 * <img src="extensible_navigator_design.png" alt="image">
 * <p>
 * Then after choosing the content, when the navigator is opened, in a cycle,
 * all the extensions are queried for the information (getContent) that the user
 * entered.
 * </p>
 * <img src="extensible_navigator_design2.png" alt="image">
 * <br/>
 * <p>
 * Finally, the following class diagram illustrates the logic behind the 
 * new hierarchy between UIExtension, Navigator and the class specific UIExtension.
 * </p>
 * <img src="extensible_navigator_class.png" alt="image">
 */

package lapr4.red.s3.core.n1150466.extensibleNavigator;
