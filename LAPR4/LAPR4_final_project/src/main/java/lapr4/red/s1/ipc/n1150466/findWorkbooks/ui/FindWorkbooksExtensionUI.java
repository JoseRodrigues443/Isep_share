package lapr4.red.s1.ipc.n1150466.findWorkbooks.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

public class FindWorkbooksExtensionUI extends UIExtension {

    /**
     * The sidebar ui
     */
    private JComponent sideBar;

    public FindWorkbooksExtensionUI(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new FindWorkbooksSideBar(uiController);

        }
        return sideBar;
    }

}
