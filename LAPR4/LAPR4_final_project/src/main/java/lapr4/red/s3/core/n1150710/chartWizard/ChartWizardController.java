/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import lapr4.red.s3.core.n1150710.chartWizard.extension.list.ChartCreatorList;
import lapr4.red.s3.core.n1150710.chartWizard.extension.list.ChartObject;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class ChartWizardController {

    private UIController uic;
    
    private final ChartCreatorList chartCreatorList;

    public ChartWizardController(UIController uic) {
        this.uic = uic;
        this.chartCreatorList = new ChartCreatorList();
    }

    public Cell getSelectedCell() {
        return uic.getActiveCell();
    }

    /**
     * for combobox
     *
     * @return
     */
    public ArrayList<String> chartTypeDescriptionList() {
        return ChartTypeEnum.typeOfChartsValues();
    }

    /**
     * used to create a combobox with a list of strings
     *
     * @param al
     * @return
     */
    public DefaultComboBoxModel defaultListModel(ArrayList<String> al) {
        return new DefaultComboBoxModel(al.toArray());
    }

    /**
     * combobox model with chart type
     *
     * @return
     */
    public DefaultComboBoxModel defaultListModelWithChartType() {
        return defaultListModel(chartTypeDescriptionList());
    }

    public String[][] stringsMatrix(Cell[][] cellses) {
        int defaultSize = 5;
        if (cellses == null || cellses.length < 1) {
            return new String[defaultSize][defaultSize];
        }
        String[][] toReturn = new String[cellses.length][cellses[0].length];
        for (int i = 0; i < cellses.length; i++) {
            for (int j = 0; j < cellses[0].length; j++) {
                if (cellses[i][j] != null){
                    toReturn[i][j] = cellses[i][j].getContent(); 
                }else{
                    toReturn[i][j] = "";
                }
            }
        }
        return toReturn;
    }

    public UIController getUic() {
        return uic;
    }

    public void setUic(UIController uic) {
        this.uic = uic;
    }

    public boolean add(ChartObject e) {
        return chartCreatorList.add(e);
    }

    public ChartCreatorList getChartCreatorList() {
        return chartCreatorList;
    }
    
    
    
    

}
