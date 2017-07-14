/**
 * Technical documentation regarding the user story IPC06.1: Secure Communication.
 * <p>
 * 
 * <b>Requirement</b><p>
 * Statement:<p>
 * It should be possible to allow secure communication between instances of cleansheet.<p>
 * It should be possible to have a hard to break cypher, although it doesn't need to be professional.<p>
 * It should be possible to have a log that records all of the communications to and from the instance.<p>
 * 
 * Notes:<p>
 * The log exists while the instance is active and can only be accessed when it's in use.<p>
 * Because of a misinterpretation of the analysis there is a triple cypher for strings with
 * random key generator while the one for objects is a constant. It will still suffer
 * a minor alteration so that it also possesses a random key or a list of options so that it's harder to break.<p>
 * 
 * <b>Application Workflow</b><p>
 * <img src="ipc_06_1_flow.png" alt="image">
 * 
 * <b>Notes:</b><p>
 * The encryption doesn't have a design since it's implementation is done in other classes by other use cases.<p>
 * The encryption is implemented right before the object is sent and right after it's received.<p>
 * 
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 *
 * <b>Test1:</b> StringEncryptDecrypt<p>
 * Verifys if the string after the encryption and decryption is the same.<p>
 * 
 * <b>Test2:</b> ObjectEncryptDecrypt<p>
 * Verifys if the object after the encryption and decryption is the same<p>
 * 
 * <img src="ipc_06_1_design2.png" alt="image">
 * <p>
 * Design that explains how the extension functionality works.<p>
 * 
 * <p>
 * <img src="ipc_06_1_design.png" alt="image"> 
 * <p>
 * 
 * @author João Coelho
 */
package lapr4.red.s1.ipc.n1150825.networkingTools.ui;

