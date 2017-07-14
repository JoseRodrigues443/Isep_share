/**
 * CORE 09 - Charts
 * A new extension to add to Cleansheets the possibility of generating Charts. There are several libraries that can
 * be used for this feature. One very simple option is to use OpenChart2 [1].
 * • Core09.1) Basic Chart Wizard
 *
 * Cleansheets should have a new menu option to launch a wizard to help the user create a bar chart. The
 * wizard should have 2 steps. In the first step, the user should input the name of the chart and the range
 * of cells that contains the data for the plot of the graph. The user should also select if the data is in the
 * rows or columns of the range and if the first row or the first column are to be considered labels. In the
 * second step the wizard should display a preview of the graph. The wizard should allow the user to move
 * between steps 1 and 2. If the wizard is confirmed (not cancelled), Cleansheets should display the chart in
 * a new window that should float next to the range of cells used for the chart (and always on "top" of the
 * worksheet). The cell in the left upper corner of the range should have a icon that indicates that the cell
 * has a chart associated with it. Figure 6.1 illustrates an example of a simple bar chart. The chart should
 * be anchored to the worksheet and move with it.
 * Difficulty: Average.
 * Mandatory: No.
 * • Core09.2) Advanced Chart Wizard
 *
 * The previous bar chart can now be configured to display bars side by side (as in Figure 6.1) or stacked (as
 * in Figure 6.2). Cleansheets should also support a new type of charts: pie charts (see example in Figure
 * 6.3). The wizard should now give the user the possibility to select the type of chart. The charts can now
 * be produced using data that is in a different worksheet of the workbook. That is to say that the charts
 * can be visible in worksheets that are different from the worksheets that has the data. Cleansheets should
 * now include a sidebar that displays the list of existing charts and that can be used to enable/disable the
 * display of each chart as well as give access to the chart wizard so that it is possible to change the existing
 * charts. It should also be possible the delete existing charts using this sidebar.
 * Difficulty: Average.
 * Mandatory: No.
 * • Core09.3) Dynamic Charts
 *
 * The charts should now be dynamic. A dynamic chart is a chart that is automatically updated when its
 * source data changes. It should be possible for the user to reposition and resize the charts. Cleansheets
 * should now mark the range of cells that are source to charts with a surrounding border. Also, when the
 * mouse hovers over the left upper corner of a range of cells that is the source of a chart a preview of the
 * chart should appear (even if the "real" chart is located in another worksheet).
 * Difficulty: Hard.
 * Mandatory: No.
 *
 * <b> Client Questions </b>
 * Should the graph be persistent? Answer: no
 * 
 * The simbol in the cell should be persistent? Answer: no
 * 
 * The pie shart should only use one column of data? Answer : yes
 * 
 * 
 * <p>
 * <b>SSD</b> 
 *
 *
 * <p>
 * The following sequence diagram illustrates the creation of the simple
 * chart script.
 * <img src="ssd_chart.png" alt="image">
 * 
 * 
 * Restritions:
 * 
 * -> Tables of data should not be null
 * -> Only positive numbers
 *
 * <b>DS</b>
 *
 *
 *
 * diagram illustrates the creation of the user interface of Chart Wizard extension.
 *
 * <img src="create_chart_core_9.png" alt="image">
 *

 *
 * <b>Test planing</b> illustrating the setup of the extension
 *
 * range should not be empty
 *
 *
 *
 *
 *
 * @author 1150710@isep.ipp.pt
 *
 */
package lapr4.red.s3.core.n1150710.chartWizard;
