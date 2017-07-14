/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard.extension.list;

import java.util.ArrayList;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class ChartCreatorList {

    private final ArrayList<ChartObject> chartCreatorsList;

    public ChartCreatorList() {
        chartCreatorsList = new ArrayList<>();
    }

    public ArrayList<ChartObject> getChartCreators() {
        return chartCreatorsList;
    }

    public boolean add(ChartObject e) {
        return chartCreatorsList.add(e);
    }
    
    

}
