/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.ui;

import javax.swing.JComponent;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import lapr4.red.s3.core.n1150466.extensibleNavigator.Navigator;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 * This class implements the UI interface extension for the comments extension.
 * A UI interface extension must extend the UIExtension abstract class.
 * @see UIExtension
 * @author Alexandre Braganca
 * 
 * edited by Sebastião Pinto to support the extensible navigator
 */
public class UIExtensionContacts extends Navigator {

    /**
     * The icon to display with the extension's name
     */
//	private Icon icon;
    /**
     * A side bar that provides editing of comments
     */
    private JComponent sideBar;


    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui controller
     */
    public UIExtensionContacts(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that provides editing of comments.
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new ContactPanel(uiController);
        }
        sideBar.add(super.button(Contact.class.getDeclaredFields()),BorderLayout.PAGE_START);
        return sideBar;
    }


    @Override
    public void setContent(ArrayList<String> variables) {

        ArrayList<Field> fields = new ArrayList<>();
        Collections.addAll(fields, Contact.class.getDeclaredFields());
        ContactPanel side = (ContactPanel) sideBar;
        DefaultListModel<Contact> model = side.getModel();

        for (int i = 0; i < model.size(); i++) {
            Contact c = model.get(i);
            String cont = "";

            //for (Field field : fields) {
            for (int j = 0; j < fields.size(); j++) {
                Field field = fields.get(j);
                field.setAccessible(true);
                if (variables.contains(field.getName())) {
                    try {
                        cont = String.format("%s%s-%s; ", cont, field.getName(), field.get(c));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            super.content.add(cont);
        }
    }

}
