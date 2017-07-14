/**
 * Lang 7.2 - BeanShell Integration
 *
 * BeanShell Integration
 * 
 * It should now be possible to invoke Beanshell scripts from macros and formulas using a new function.
 * The new function should be able to execute Beanshell scripts synchronously or asynchronously. If the
 * execution mode is synchronous, then the function should wait for the script to end its execution. In this
 * case the return value of the function should be the value of the last expression of the Beanshell script.
 * If the execution mode is asynchronous then the function should return immediately after launching the
 * execution of the script: the script and the formula/macro will execute in parallel. Existing var
 *
 *
 * <b>Client questions (Q&A):</b>
 *
 * Q: Should be the scripts be persistent? A: No, they should be available in a
 * list, but not permanent.
 *
 *
 * <p>
 * In this phase the user will should be able to run a script in beanshell and
 * show the synchronously and asynchronously results with other funtions and
 * inside other funtions.
 *
 *
 *
 * <p>
 * <b>SSD</b> illustrating the setup of the extension
 *
 *
 * <p>
 * The following sequence diagram illustrates the creation of the simple
 * BeanShell script inside a function or macro.
 * <img src="Lang07_2beanShell.png" alt="image">
 *
 * <b>DS</b> illustrating the setup of the extension The following sequence
 *
 *
 *
 * diagram illustrates the creation of the user interface of beanshell.
 *
 * <img src="beanshell_7.2_DS.png" alt="image">
 *
 * This DS uses the macro window, and then with the value that is receiverd
 * interpreters with eht bsh.Interpreter
 *
 *
 *
 *
 *
 *
 * <img src="macro_08_01_analyse.png" alt="image">
 *
 * This DS show how th window of beanshel is integrated with the macro UI
 *
 * <img src="Lang07_beanShell_ window creation.png" alt="image">
 *
 *
 * <b>Test planing</b> illustrating the setup of the extension
 *
 * There aren't business rules, because these extension only is used to execute
 * Java code. there aren't any restrictions. If the interpreter fails, then the
 * functional test fails, if it succeeds the tests passes.
 *
 *
 *
 *
 *
 * @author 1150710@isep.ipp.pt
 *
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;
