/**
 * Technical documentation regarding the user story LANG02.1: Temporary Variables. 
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 * It should be possible to define a temporary variable using the "_" before the variable. <p>
 * It should be possible to assign a value to a temporary variable when the variable is referred for the first time using the assign operator.<p>
 * It shouldnt be possible to reference a temporary variable outside the context where it is created (different cell). <p>
 * 
 * <b>Analysis</b><p>
 * <img src="LANG02.1_TemporaryVariables.png" alt="image">
 * <p>
 * <b>Notes:</b><p>
 * 
 * This analysis is a very simple view of the creation of the temporary variable. 
 * Is also demonstrates how we can assign a value to a temporary variable.
 
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 *
 * <b>Test1:</b> TemporaryVariableAcessDeniedOutsideContext<p>
 * There should be a simple test that should verify if the user cannot access the temporary variable from other context than the creation context.<p>
 *
 * <b>Design</b>
 * First model regarding the design. (Prone to changes)
 * <p>
 * 
 * <img src="LANG02.1_TemporaryVariables_Design.png" alt="image"/>
 * <p>
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
package lapr4.red.s2.lang.n1141114.temporaryVariables;
