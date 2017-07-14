/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1140412.sendEmailSMS;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Tiago
 */
public class EmailSMSExtension extends Extension{
    public static final String NAME = "Email/SMS";
    public EmailSMSExtension() {
        super(NAME,"Email/SMS Sender","S3");
    }
    
    /**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIGameCenterExtension}).
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new lapr4.red.s3.core.n1140412.sendEmailSMS.UI.EmailSMSExtension(this, uiController);
	}
    
}
