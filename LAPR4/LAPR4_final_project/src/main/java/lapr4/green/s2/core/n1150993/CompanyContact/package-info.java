/*
 * * Technical documentation regarding the user story Core10.1.2: Company Contact
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! You should question what is already done!</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the sprint's work.-
 * <p>
 * -In this section you should register important notes regarding your work during the sprint.
 * For instance, if you spend significant time helping a colleague or if you work in more than one feature.-
 *
 * <h2>2. Requirement</h2>
 * A contact may also be a company. If a contact is a company then it has a name (no first and no last
 * name). A person contact may now be related to a company contact. A person contact may have also a
 * profession. The profession should be selected from a list. The list of professions should be loaded (and/or
 * updated) from a external xml file or an existing configuration file of Cleansheets. The window for company
 * contacts should display all the person contacts that are related to it. The company window should also
 * have an agenda. The agenda of a company should be read only and display all the events of the individual
 * contacts that are related to it.
 *
 * <h2>3. Analysis</h2>
 * <p>
 * For this use case will need to change the database to include Company contact. It will
 * also be necessary for each person have a profession that will be imported from
 * a external xml file, or a configuration file of Csheets. A new slide bar will also
 * be created in order to show the information: 
 * -The companies.
 * -Contacts related to that company.
 * -Events of all the contacts related whith this company.
 *
 * <p>
 * The following diagram describes the realization of the user's case.
 * <p>
 * <img src="\javadoc\lapr4\green\s2\core\n1150993\CompanyContact\10.1.2_company_analysis_diagram.png" alt="image">
 * <p>
 *
 * <h2>4. Design</h2>
 * <h2>User choose create a company contact.</h2>
 * The following diagram describes how to create a company. It works as follows:
 *   .User selects contact on side bar.
 *   .User select type of company.
 *   .User select create option.
 *   .User choose the informations about company.
 * <img src="\javadoc\lapr4\green\s2\core\n1150993\CompanyContact\10.1.2_Create_Company_Design.png">
 * <br/>
 *
 * <h2>User choose edit a company contact</h2>
 * This diagram describes how to edit a company. 
 *  .User select an company.
 *  .User select the new name of company.
 * <img src="\javadoc\lapr4\green\s2\core\n1150993\CompanyContact\10.1.2_Edit_Company_Design.png">
 * <br/>
 *
 * <h2>User choose remove a company</h2>
 * The follow sequence diagram about remove, the user choose a company from the
 * list and remove it.
 * <img src="\javadoc\lapr4\green\s2\core\n1150993\CompanyContact\10.1.2_Remove_Company_Design.png">
 * <br/>
 *
 * <h2>5. Tests</h2>
 * <h3>Functional Tests Company</h3><br/>
 * <br/>
 * -Create Company Contact
 * -Edit Company Contact
 * -Remove Company Contact
 * -Fill information about company
 * <br/>
 *
 *<h3>Functional Tests Company Repository</h3><br/>
 * <br/>
 * -Save Company Contact
 * -Edit Company Contact
 * -Remove Company Contact
 * -Get all company contacts
 * -Get people related with company
 * <br/>
 *
 *
 * <h2>6. Work Log</h2> 
 * 
 * <b>Monday: </b>
 * <p>
 * Yesterday worked on analysis.
 * <p>
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: Analysis and Design
 */
package lapr4.green.s2.core.n1150993.CompanyContact;

