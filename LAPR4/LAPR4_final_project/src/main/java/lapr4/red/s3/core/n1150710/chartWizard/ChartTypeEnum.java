/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard;

import java.util.ArrayList;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public enum ChartTypeEnum {

    /**
     * Use of enum in the oracle documentation (see example planets)
     *
     * https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
     */
    PIE_CHART("Pie Chart"),
    SIMPLE_STACKED_BAR_CHART("Stacked Bar Chart"),
    SIMPLE_BAR_CHART("Bar Chart");

    private final String description;

    ChartTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<String> typeOfChartsValues() {
        ArrayList<String> al = new ArrayList<>();
        for (ChartTypeEnum p : ChartTypeEnum.values()) {
            al.add(p.getDescription());
        }
        return al;
    }

    public static ArrayList<ChartTypeEnum> typeOfCharts() {
        ArrayList<ChartTypeEnum> al = new ArrayList<>();
        for (ChartTypeEnum p : ChartTypeEnum.values()) {
            al.add(p);
        }
        return al;
    }

    /**
     * in the combobox list isw shown the enum description, when that is gotten
     * from the combobox, this method returns the real enum identifier.
     *
     *
     * EX: Selected "Pie Chart"
     *
     * returns PIE_CHART
     *
     *if the description does not exists one it returns default (SIMPLE_BAR_CHART)
     *
     * @param description
     * @return
     */
    public static ChartTypeEnum selectChartFromDescriptionString(String description) {
        for (ChartTypeEnum p : ChartTypeEnum.values()) {
            if (p.getDescription().equalsIgnoreCase(description)) {
                return p;
            }
        }
        /**
         * default
         */
        return SIMPLE_BAR_CHART;
    }
}
