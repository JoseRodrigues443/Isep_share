/**
 * Technical documentation regarding the user story LANG01.2:Monetary Language
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 * Add a new language that begin with the # char.<p>
 * The language should do only calculations related to currencies.<p>
 * It should be only possible to use the addition, subtraction, multiplication and division operators.<p>
 * The user must define the output currency.<p>
 * All expressions must be contained within brackets.<p>
 * It should be possible to set exchange rates. <p>
 * 
 * Notes:<p>
 * There is already defined exchange rates by default when the application starts
 * <p>
 * 
 * <b>Application Workflow</b><p>
 * <img src="us_LANG_01_2_design.png" alt="image">
 * 
 * <b>Analysis</b><p>
 * In a simple way, the analysis of new Monetary operation is:
 * <p>
 * <img src="us_LANG_02_2_sd.png" alt="image">
 * <p>
 * 
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 *
 * <b>Test1:</b> MoneyMustNotBeLowerThanZero<p>
 * There should be a simple test that should verify if any money currency is created lower than 0.<p>
 * 
 * <b>Test2:</b> ExchangeRatesMustNotBeLowerThatZero<p>
 * There should be a simple test that should verify if any exchange rate is created/changed to lower than 0.<p>
 * 
 * <b>Design</b><p>
 * First model regarding the design.
 * 
 * <img src="us_LANG_01_2_design.png" alt="image"> 
 * 
 * @author Barros
 */
package lapr4.red.s2.lang.n1151117.formula.money;

