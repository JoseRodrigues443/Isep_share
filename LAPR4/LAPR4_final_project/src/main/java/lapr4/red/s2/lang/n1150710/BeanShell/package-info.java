/**
 * Lang 7.1 - BeanShell Window
 *
 * Cleansheets should have an extension to support scripts in the BeanShell scripting language. Macros and
 * BeanShell should be in the same extension. The extension should add a menu option that will launch
 * a window to edit and execute a BeanShell script. BeanShell and Macros should share the same editing
 * window (please see Lang05). The idea is that the user will be able to select (in this window) the type of
 * language he wants to use to customize Cleansheets.
 * In this iteration, and to test BeanShell support, if the user selects the BeanShell language, the edit window
 * should automatically be filled with a script that: (1) opens a new workbook, (2) creates a macro, (3) run
 * the created macro and (4) displays a window with the result of the invocation of the macro. Similarly
 * to macros, the result of a BeanShell script is the last value (result of the last instruction). The result of
 * executing the BeanShell script should be
 *
 *
 *
 *
 * <p>
 * <b>SSD</b> illustrating the setup of the extension
 *
 *
 * <p>
 * The following sequence diagram illustrates the creation of the simple
 * BeanShell script.
 * <img src="Lang07_beanShell.png" alt="image">
 *
 * <b>DS</b> illustrating the setup of the extension The following sequence
 *
 *
 *
 * diagram illustrates the creation of the user interface of beanshell.
 *
 * <img src="beanshellDS.png" alt="image">
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
package lapr4.red.s2.lang.n1150710.BeanShell;
