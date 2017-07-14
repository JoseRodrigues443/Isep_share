package lapr4.red.s3.core.n1150466.extensibleNavigator;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import lapr4.red.s3.core.n1150466.extensibleNavigator.ui.ChooseContentDialog;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author Sebastiao
 */
public abstract class Navigator extends UIExtension {

    public ArrayList<String> content;

    public Navigator(Extension extension, UIController uiController) {
        super(extension, uiController);
        content = new ArrayList<>();
    }

    /**
     * Returns the content previously created.
     *
     * @return content
     */

    /**
     * The method should be implemented to create a list of individual nodes
     * that would be shown in the navigation tree. these nodes should contain
     * the information that the user wants to see in the tree example: if
     * implemented in the contacts UIExentension the programmer should add to an
     * array the wanted information about a contact. this is merely an example,
     * and the programmer is free to add any relevant information given the
     * fields the user selected in the add button method.
     */
    public abstract void setContent(ArrayList<String> content);

    /**
     * Customize the button to add to the extension in order to select the
     * extension contents to include
     */

    public JPanel button(Field[] fields) {
        JPanel panel = new JPanel(new BorderLayout());
        JButton button = new JButton("Navigator Content");
        List<String> content_variables = new ArrayList<>();

        for (Field field : fields) {
            content_variables.add(field.getName());

        }
        Navigator ext = this;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseContentDialog(content_variables, ext);
            }
        });
        panel.add(button);
        
        return panel;
    }

    public ArrayList<String> getContent() {
        return content;
    }
}
