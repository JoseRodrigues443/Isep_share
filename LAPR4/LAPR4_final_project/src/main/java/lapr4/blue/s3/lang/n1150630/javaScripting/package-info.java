/**
 * Lang 7.3 - Cleansheats API
 *
 * Cleansheats API
 *
 * Design and implement a mini API of the Cleansheets objects inside Beanshell.
 * The new API should provide access to objects like workbook, worksheet, cells,
 * macros, variables, etc. This API should prevent as far as possible access to
 * "internal" classes of Cleansheets.
 *
 * "An API is a list of commands as well as the format of those commands that
 * one program can send to another. It is used so that individual programs can
 * communicate with one another directly and use each other's functions."
 *
 *
 *
 * <p>
 * In this phase the user will should be able to run a script in beanshell and
 * show the synchronously and asynchronously results with other funtions and
 * inside other funtions. The user should not need to create new objects (these
 * must already be created).
 *
 *
 *
 * <b>DS</b> illustrating the setup of the extension The following sequence
 *
 *
 *
 * diagram illustrates the creation of the user interface of beanshell.
 *
 * <img src="Design_7-3.png" alt="image">
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
 * @author David
 *
 */
package lapr4.blue.s3.lang.n1150630.javaScripting;
