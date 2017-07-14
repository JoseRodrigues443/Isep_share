/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard.ChartCreatorsByType;

import org.jfree.data.general.Dataset;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public interface ChartCreatorInterface {
    
    /**
     * used to create a data set responsible for the charts
     * @return 
     */
    public Dataset createDataset() ;
}
