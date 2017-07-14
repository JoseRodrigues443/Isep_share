/**
 * Technical documentation regarding the user story Core01.1: Enable and Disable Extensions.
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! You should question what is already done!</b><p>
 * 
 * <b>Requirement</b>
 * Statement:<p>
 * It should be possible for the user to see a list of all avaliable extensions.<p>
 * It should be possible for the user to enable or disable said extensions.<p>
 * 
 * <b>Analisys</b><p>
 * <img src="core10.1.1_enableAndDisableExtensions_ssd.png" alt="image">
 * 
 * <b>Questions:</b><p>
 * What is the effect of disabling an extension?;<p>
 * R: The extensions stops and all its menu options stop being visible.<p>
 * 
 * <b>Glossary:</b><p>
 * Extension = Anything that adds extra functionalities to the main programm. <p>
 * All extensions are loaded at startup. <p>
 * 
 * <b> Description: </b><p>
 * This use case consists on implementing a new UI, triggered by the extensions tab in the main UI.<p>
 * The new UI will have a list of avaliable extensions which the user will be able to activate or deactivate.<p>
 * 
 * <b>Design: </b><p>
 * 
 * Sequence diagram<p>
 * <img src="Sequence_Diagram.png" alt="image">
 * 
 * Class Diagram<p>
 * <img src="Core1.1Classes.png" alt="image">
 * 
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions:<p>
 * {@link lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.EnableAndDisableExtensionsExtension}
 * <p>
 * Package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui<p>
 * {@link lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui.EnableAndDisableExtensionsAction}
 * {@link lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui.EnableAndDisableExtensionsMenu}
 * {@link lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui.EnableDisableExtensionUI}
 * {@link lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui.UIExtensionEnableAndDisableExtensions}
 * <p>
 * Package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.application<p>
 * {@link lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.application.EnableDisableExtensionController}
 * 
 */
package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions;
