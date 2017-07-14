/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150835.overlayImageWindow.application;

import java.util.List;
import lapr4.blue.s1.core.n1150630.insertImage.CellImage;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;

/**
 *
 * @author Rui Braga
 */
public class ImageBrowserController {
    
    private final InsertImageCell imageCell;
    
    public ImageBrowserController(InsertImageCell imageCell){
        this.imageCell = imageCell;
    }
    
    
    public List<CellImage> getImageList(){
        return this.imageCell.getImageList();
    }
    
}
