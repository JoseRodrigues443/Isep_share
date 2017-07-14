/**
 * Technical documentation regarding the user story Lang01.3: Eval and While Loops
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! You should question what is already done!</b><p>
 * 
 * <b>Requirement</b>
 * Statement:<p>
 * Add a Eval function that checks the value of a string and returns, for example, 5 if the input is "= eval (" 2 + 3 ")"<p>
 * Add a DoWhile and a WhileDo function that has three parameters: condition, result, alternative (in order)<p>
 * The DoWhile function first executes an expression and then tests another that will indicate if it's to continue.<p>
 * The cycle WhileDo should test an expression that indicates if a second expression/block is to execute or not.<p>
 * The first function executes before testing, the second tests before executing.<p>
 * 
 * <b>Analisys</b><p>
 * <img src="ssd_lang_013.png" alt="image"><p>
 * The user selects a cell to write. This cell is activated and the user inserts the instruction.<p>
 * After the user inserts an instruction and presses enter, the Controller starts to process the instrucions given.<p>
 * If it is valid, the FormulaCompiler compiles the given instruction and returns the result to the Controller.<p>
 * If not, the expression is directly returned.<p>
 * Finnaly the Controller edits the cell's content with the returned result.<p>
 * 
 * <b>Questions:</b><p>
 * No questions were made.<p>
 *  
 * <b>Design: </b><p>
 * It's necessary to create three domain classes, one for each operation ("val, DoWhile, WhileDo).
 * The following diagram ilustrates the main aspects of the design of the solution for this use case.
 * 
 * Sequence diagram<p>
 * <img src="sd_lang_013.png" alt="image"><p>
 * 
 * 
 * <b>Tests</b><p>
 *  An important part is to test the newly created classes. The desired result must be equal to the result
 * returned by the function. In our classes, the <code>Eval</code> should change
 * the content of the selected cell to the result of the evaluation of the
 * string. The cycle <code>DoWhile</code> should execute its operations and
 * continue to the second iteration of them only if the expression is true, finnally
 * the cycle <code>WhileDo</code> should first evaluate the expression and only
 * if it's true, it can execute the operations.
 * 
 */


package lapr4.blue.s3.lang.n1150433.evalWhileLoops;
