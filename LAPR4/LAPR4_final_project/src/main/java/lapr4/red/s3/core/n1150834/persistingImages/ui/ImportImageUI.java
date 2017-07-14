package lapr4.red.s3.core.n1150834.persistingImages.ui;

import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * A user interface for importing images
 *
 * @author 1150834
 */
public class ImportImageUI extends JFrame {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * The controller for importing images
     */
    private ImportImageController controller;
    /**
     * The image path
     */
    private JLabel path;

    /**
     * Creates a new ImportImageUI
     *
     * @param uiController the user interface controller
     */
    public ImportImageUI(UIController uiController) {
        super("Import Image");
        this.uiController = uiController;

        setPreferredSize(new Dimension(400, 130));
        setLayout(new GridLayout(2, 1));

        JPanel chosenLink = chosenLinkPanel();
        JPanel options = optionsPanel();

        add(chosenLink);
        add(options);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private JPanel chosenLinkPanel() {
        JPanel panel = new JPanel();
        path = new JLabel();

        panel.add(path);

        return panel;
    }

    private JPanel optionsPanel() {
        JPanel panel = new JPanel();
        JButton btnChooser = chooseButton();
        JButton btnSave = saveButton();
        JButton btnCancel = new JButton("Cancel");

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(btnChooser);
        panel.add(btnSave);
        panel.add(btnCancel);

        return panel;
    }

    private JButton chooseButton() {
        JButton btnChooser = new JButton("Choose");
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "png", "jpg", "gif"));
        btnChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = chooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    path.setText(chooser.getSelectedFile().getPath());
                }
            }
        });
        return btnChooser;
    }

    private JButton saveButton() {
        JButton btn = new JButton("Save");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller = new ImportImageController(uiController);
                    controller.importImage(path.getText());
                    dispose();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Select a proper image link",
                            "Image Link", JOptionPane.WARNING_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "File could not be found",
                            "File Not Found", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Image Import Failed",
                            "Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return btn;
    }

}
