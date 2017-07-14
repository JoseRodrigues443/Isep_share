/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage;

import java.util.EventListener;

/**
 *
 * @author David
 */
public interface InsertImageCellListener extends EventListener {

    /**
     * Method called when an image is insert to the selected cell
     *
     * @param cell the cell that was selected
     */
    public void insertImageChanged(InsertImageCell cell);
}
