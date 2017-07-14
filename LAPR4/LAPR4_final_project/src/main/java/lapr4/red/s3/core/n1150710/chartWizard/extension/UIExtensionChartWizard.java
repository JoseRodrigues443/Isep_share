package lapr4.red.s3.core.n1150710.chartWizard.extension;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import lapr4.red.s3.core.n1150710.chartWizard.extension.ui.ChartCellDecorator;
import lapr4.red.s3.core.n1150710.chartWizard.extension.ui.ChartWizardMenu;
import lapr4.red.s3.core.n1150710.chartWizard.extension.ui.ChartWizardPanel;

/**
 * This class implements the UI interface extension for the simple extension. A
 * UI interface extension must extend the UIExtension abstract class.
 *
 * @see UIExtension
 * @author 1150710@isep.ipp.pt
 */
public class UIExtensionChartWizard extends UIExtension {

    /**
     * A cell decorator that visualizes charts on cells
     */
    private CellDecorator cellDecorator;

    /**
     * The icon to display with the extension's name
     */
    private Icon icon;

    /**
     * The menu of the extension
     */
    private ChartWizardMenu menu;

    /**
     * A side bar that provides editing of comments
     */
    private JComponent sideBar;

    private ChartWizardPanel chartWizardPanel;

    public UIExtensionChartWizard(Extension extension, UIController uiController) {
        super(extension, uiController);
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns an icon to display with the extension's name.
     *
     * @return an icon with style
     */
    @Override
    public Icon getIcon() {
        return null;
    }

    /**
     * Returns an instance of a class that implements JMenu. In this simple case
     * this class only supplies one menu option.
     *
     * @see ShareCellMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new ChartWizardMenu(uiController);
        }
        return menu;
        //return null;
    }

    /**
     * Returns a cell decorator that visualizes the data added by the extension.
     *
     * @return a cell decorator, or null if the extension does not provide one
     */
    public CellDecorator getCellDecorator() {
        if (cellDecorator == null) {
            cellDecorator = new ChartCellDecorator();
        }
        return cellDecorator;
    }

    /**
     * Returns a table decorator that visualizes the data added by the
     * extension.
     *
     * @return a table decorator, or null if the extension does not provide one
     */
    public TableDecorator getTableDecorator() {
        return null;
    }

    /**
     * Returns a toolbar that gives access to extension-specific functionality.
     *
     * @return a JToolBar component, or null if the extension does not provide
     * one
     */
    public JToolBar getToolBar() {
        return null;
    }

    /**
     * Returns a side bar that provides list off instances.
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            chartWizardPanel = new ChartWizardPanel(uiController);
            sideBar = chartWizardPanel;
        }
        return sideBar;
    }
}
