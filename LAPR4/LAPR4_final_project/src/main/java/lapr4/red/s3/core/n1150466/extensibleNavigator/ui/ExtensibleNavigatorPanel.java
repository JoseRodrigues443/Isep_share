package lapr4.red.s3.core.n1150466.extensibleNavigator.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lapr4.blue.s1.core.n1150662.navigationWindow.NavigationWindowExtension;
import lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorController;
import lapr4.green.s2.core.n1150767.extensionNavigator.ui.DisabledExtensionsPanel;
import lapr4.green.s2.core.n1150767.extensionNavigator.ui.EnabledExtensionsPanel;
import lapr4.green.s2.core.n1150767.extensionNavigator.ui.ExtensioNavigationPanel;

/**
 *
 * @author Sebastiao
 */
public class ExtensibleNavigatorPanel extends JPanel {

    private ExtensionNavigatorController ctrl;

    private JButton bDisabled = new JButton("Disabled Extensions");

    private JButton bEnabled = new JButton("Enabled Extensions");

    public ExtensibleNavigatorPanel(UIController UIcontroller) {
        //Configure Panel
        super(new BorderLayout());
        setName(NavigationWindowExtension.NAME);

        //Create controller
        ctrl = new ExtensibleNavigatorController(UIcontroller);

        add(panel());

        bDisabled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new DisabledExtensionsPanel(UIcontroller, new ExtensioNavigationPanel(UIcontroller), ctrl);
            }
        });

        bEnabled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new EnabledExtensionsPanel(UIcontroller, new ExtensioNavigationPanel(UIcontroller), ctrl);
            }
        });

    }

    public JPanel panel() {
        bDisabled.setPreferredSize(new Dimension(50, 50));
        bDisabled.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        bDisabled.setAlignmentX(Component.CENTER_ALIGNMENT);
        bDisabled.setVisible(true);

        bEnabled.setPreferredSize(new Dimension(50, 50));
        bEnabled.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        bEnabled.setAlignmentX(Component.CENTER_ALIGNMENT);
        bEnabled.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(130, 336));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        panel.add(bDisabled);
        panel.add(bEnabled);
        return panel;
    }
}
