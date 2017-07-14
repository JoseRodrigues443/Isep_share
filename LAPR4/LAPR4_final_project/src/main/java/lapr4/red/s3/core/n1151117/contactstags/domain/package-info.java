/**
 * Technical documentation regarding the user story CORE10.1.3:Contacts with Tags
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 * It should be possible to associate a tag to a contact, or company contact.<p>
 * It should be possible to search for users based on tags.<p>
 * It should be possible to edit a contact selected by the previous search.<p>
 * It should be possible to display all tags sorted (descending) by it's frequency.<p>
 * It should be possible to remove tags.<p>
 * 
 * Notes:<p>
 * The user is not forced to associate a tag to the contact, it's optional, but if he wants, there should be a functionality to allow it.
 * <p>
 * 
 * <b>Analysis</b><p>
 * In a simple way, the analysis of the use case is:
 * <p>
 * <img src="us_core_10_1_3_analysis.png" alt="image">
 * <p>
 * 
 * <b>Client Questions</b><p>
 * Q: Shoud we create a regular expression to validate a tag?<p>
 * A: No.<p>
 * 
 * Q: If there is a tag named 'test' and another 'test1' and another 'test2' (only examples), when the users search for the tag 'test' should the app display all three options or only the first?<p>
 * A: Only the first.<p>
 * 
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 *
 * <b>Test1:</b> TagValueMustNotBeNull<p>
 * There should be a simple test that should verify if the tag value is null.<p>
 * 
 * <b>Test2:</b> TagValueMustNotBeEmpty<p>
 * There should be a simple test that should verify if the tag is empty.<p>
 * 
 * <b>Test3:</b> TagValueMustNotBeWhiteSpace<p>
 * There should be a simple test that should verify if the tag is only whitespace.<p>
 * 
 * <b>Test4:</b> TagValueMustContainWhiteSpaces<p>
 * There should be a simple test that should verify if the tag contains any whitespace.<p>
 * 
 * <b>Design</b><p>
 * First model regarding the design.
 * 
 * <b>To add a tag</b> <p>
 * <img src="us_core_10_1_3_1_design.png" alt="image"> 
 * 
 * <b>To search for contacts by a tag</b> <p>
 * <img src="us_core_10_1_3_2_design.png" alt="image"> 
 * 
 * <b>To show all tags sorted (descending) by frequency</b> <p>
 * <img src="us_core_10_1_3_3_design.png" alt="image"> 
 * 
 * @author Barros
 */
package lapr4.red.s3.core.n1151117.contactstags.domain;

