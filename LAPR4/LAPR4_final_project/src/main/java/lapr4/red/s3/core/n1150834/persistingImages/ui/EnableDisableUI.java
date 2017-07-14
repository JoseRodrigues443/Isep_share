package lapr4.red.s3.core.n1150834.persistingImages.ui;

import lapr4.red.s3.core.n1150834.persistingImages.AutomaticBehavior;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import lapr4.red.s3.core.n1150834.persistingImages.PersistentImageBrowserListener;

/**
 * Enable/Disable automatic window user interface
 *
 * @author 1150834
 */
public class EnableDisableUI extends JFrame {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * The focusOwner
     */
    private SpreadsheetTable focusOwner;
    /**
     * Buttons with the options for enable/disable
     */
    private ButtonGroup options;
    /**
     * Button to enable automatic window
     */
    private JRadioButton btnYes;
    /**
     * Button to disable automatic window
     */
    private JRadioButton btnNo;

    /**
     * Creates a new EnableDisableUI
     *
     * @param uiController the user interface controller
     * @param focusOwner the focusOwner
     */
    public EnableDisableUI(UIController uiController, SpreadsheetTable focusOwner) {
        this.uiController = uiController;
        this.focusOwner = focusOwner;
        setTitle("Enable/Disable Automatic Window");

        setPreferredSize(new Dimension(300, 100));
        setLayout(new GridLayout(2, 1));

        JPanel opChooser = optionsPanel();
        JPanel confirm = confirmPanel();

        add(opChooser);
        add(confirm);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private JPanel optionsPanel() {
        JPanel panel = new JPanel();

        options = new ButtonGroup();
        btnYes = new JRadioButton("Enable");
        btnNo = new JRadioButton("Disable");
        options.add(btnYes);
        options.add(btnNo);
        if (AutomaticBehavior.currentBehavior()) {
            options.setSelected(btnYes.getModel(), true);
        } else {
            options.setSelected(btnNo.getModel(), true);
        }

        panel.add(btnYes);
        panel.add(btnNo);

        return panel;
    }

    private JPanel confirmPanel() {
        JPanel panel = new JPanel();
        JButton btnConfirm = new JButton("Confirm");

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonModel model = options.getSelection();

                if (model.equals(btnYes.getModel())) {
                    AutomaticBehavior.enable();
                    focusOwner.addMouseMotionListener((MouseMotionListener) new PersistentImageBrowserListener());
                }
                if (model.equals(btnNo.getModel())) {
                    AutomaticBehavior.disable();
                    focusOwner.addMouseListener((MouseListener) new PersistentImageBrowserListener());
                }
                dispose();
            }

        });
        panel.add(btnConfirm);
        return panel;
    }
}
