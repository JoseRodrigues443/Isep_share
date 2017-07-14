/**
 * Technical documentation regarding the user story Core10.3.1: Email and Phone Edition
 * <p>
 *
 * <b></b>
 *
 *
 *
 * <h2>1. Requirement</h2>
 *
 * There should be a window to create, edit and remove telephone numbers and
 * emails of contacts. Cleansheets should only accept syntactically correct
 * emails and telephone numbers. Each company can have a main email and
 * telephone number and several secondary emails and telephone numbers. Each
 * individual contact can have the following types of telephone numbers: work;
 * home; celular1 and celular2. Each individual contact can have a main email
 * and several secondary emails. Cleansheets should validate the syntax of the
 * telephone numbers based on the country code. The list o countries and its
 * phone prefixes should be imported and updated from an external file. It
 * should also validate the format o emails.
 * <p>
 *
 * <h2>2. Analysis</h2>
 *
* The user opens the "Find Workbooks" sidebar. The user selects the directory.
 * The user clicks one time to preview the workbook. The user clicks two times
 * to open the workbook.
 *
 * Client questions The word "pattern" is referred to in what context? It can be
 * considered an expression or pattern similar to a regular expression. Ex:
 * abc*.cls. The user decides the pattern, right? There should be opened a
 * window were the user can write the pretendes pattern? Yes.
 * <p>
 *
 * <img src="IPC02.2_advancedWorkbookSearch_SSD.png" alt="image">
 *
 * <p>
 *
 * <h2>3. Tests</h2>
 *
 * The data inserted by the user in this use case is saved persistently. So, the
 * main tests we will have to do is to verify if the data is being correctly
 * saved. Therefore, when the user adds emails and phone numbers to a contact we
 * will test if those emails and numbers were registered in the contact
 * selected. When the user modifies a email or number, we have to guarantee that
 * those values were changed and when the user removes data we will test if
 * those data were removed successfully. Therefore, will be made tests about the
 * Contact methods that this US uses.
 * <p>
 *
 * <h2>4. Design</h2>
 *
 * <b>Sequence Diagrams</b><p>
 *
 * <p>
 * <img src="IPC02.2_advancedWorkbookSearch_SD.png" alt="image">
 *
 *
 * @author 1150595
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition;
