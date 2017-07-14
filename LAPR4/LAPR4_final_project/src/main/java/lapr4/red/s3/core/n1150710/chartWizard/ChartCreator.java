/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard;

import lapr4.red.s3.core.n1150710.chartWizard.ChartCreatorsByType.BarChartCreator;
import lapr4.red.s3.core.n1150710.chartWizard.ChartCreatorsByType.StackedBarChartCreator;
import lapr4.red.s3.core.n1150710.chartWizard.ChartCreatorsByType.PieChartCreator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class ChartCreator {

    /**
     * pie, bar , stacked bar etc
     */
    private ChartTypeEnum typeChart;

    /**
     * name
     */
    private String name;

    private boolean isRowsOrColumnsWithData;

    private boolean isFirstRowOrColumnLabel;

    private PlotOrientation isVertical;

    /**
     *
     */
    private String[][] matrixWithDataForGraph;

    /**
     *
     * @param typeChart
     * @param name
     * @param isRowsOrColumnsWithData will the borders of the table serve as
     * labels
     * @param isVerticalOrHorizontal the shappe of the graph is vertical or
     * horizontal
     * @param matrixWithDataForGraph
     * @param isFirstRowOrColumnLabel true = rows/default/do nothing = data,
     * false = columns/transpose matrix = data
     */
    public ChartCreator(ChartTypeEnum typeChart, String name,
            boolean isRowsOrColumnsWithData,
            PlotOrientation isVerticalOrHorizontal, String[][] matrixWithDataForGraph, boolean isFirstRowOrColumnLabel) {
        this.typeChart = typeChart;
        this.name = name;
        this.isRowsOrColumnsWithData = isRowsOrColumnsWithData;
        this.matrixWithDataForGraph = matrixWithDataForGraph;
        if (!isRowsOrColumnsWithData) {
            this.matrixWithDataForGraph = addLabels(matrixWithDataForGraph);
        }

        this.isVertical = isVerticalOrHorizontal;

        this.isFirstRowOrColumnLabel = isFirstRowOrColumnLabel;
        if (!isFirstRowOrColumnLabel) {
            this.matrixWithDataForGraph = transposeMatrix(this.matrixWithDataForGraph);
        }
    }

    public boolean isIsFirstRowOrColumnLabel() {
        return isFirstRowOrColumnLabel;
    }

    public void setIsFirstRowOrColumnLabel(boolean isFirstRowOrColumnLabel) {
        this.isFirstRowOrColumnLabel = isFirstRowOrColumnLabel;
    }

    public boolean isIsRowsOrColumnsWithData() {
        return isRowsOrColumnsWithData;
    }

    public void setIsRowsOrColumnsWithData(boolean isRowsOrColumnsWithData) {
        this.isRowsOrColumnsWithData = isRowsOrColumnsWithData;
    }

    public PlotOrientation getIsVertical() {
        return isVertical;
    }

    public void setIsVertical(PlotOrientation isVertical) {
        this.isVertical = isVertical;
    }

    public ChartTypeEnum getTypeChart() {
        return typeChart;
    }

    public void setTypeChart(ChartTypeEnum typeChart) {
        this.typeChart = typeChart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[][] getMatrixWithDataForGraph() {
        return matrixWithDataForGraph;
    }

    public void setMatrixWithDataForGraph(String[][] matrixWithDataForGraph) {
        this.matrixWithDataForGraph = matrixWithDataForGraph;
    }

    /**
     * creates the panel with the chart to be show
     *
     * NOTE: CHARTPANEL extends JPANEL
     *
     * @return
     */
    public ChartPanel jpWithGraph() {

        Dataset d = dataSetForChart();
        JFreeChart chart = freeChart(d, name, name, name, isVertical);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        return chartPanel;
    }

    /**
     * creates a free chart with a PieDataSet or a categoryDataSet
     *
     * @param datasetForChart
     * @param title
     * @param category
     * @param value
     * @param verticalOrHorizontal
     * @return
     */
    private JFreeChart freeChart(Dataset datasetForChart, String title, String category,
            String value, PlotOrientation verticalOrHorizontal) {
        //return createChart(dataset, chartTitle, "Categorie", "Value");
        JFreeChart chart = null;
        switch (this.typeChart) {
            case PIE_CHART:
                PieDataset pieDataset = (PieDataset) datasetForChart;
                chart = ChartFactory.createPieChart3D(
                        title, // chart title
                        pieDataset, // data
                        true, // include legend
                        true,
                        false
                );
                break;
            case SIMPLE_BAR_CHART:
                CategoryDataset categoryDatasetSimpleBar = (CategoryDataset) datasetForChart;
                chart = ChartFactory.createBarChart(
                        title,
                        category,
                        value,
                        categoryDatasetSimpleBar,
                        verticalOrHorizontal,
                        true, true, false);

                break;
            case SIMPLE_STACKED_BAR_CHART:
                CategoryDataset categoryDataset = (CategoryDataset) datasetForChart;
                chart = ChartFactory.createStackedBarChart(
                        title, // chart title
                        category, // domain axis label
                        value, // range axis label
                        categoryDataset, // data
                        verticalOrHorizontal, // the plot orientation
                        true, // legend
                        true, // tooltips
                        false // urls
                );
                break;
            default:
                categoryDatasetSimpleBar = (CategoryDataset) datasetForChart;
                chart = ChartFactory.createBarChart(
                        title,
                        "Category",
                        "Score",
                        categoryDatasetSimpleBar,
                        verticalOrHorizontal,
                        true, true, false);

                break;
        }

        return chart;
    }

    /**
     * creates the data set necessary to create a freejart
     *
     * @return
     */
    private Dataset dataSetForChart() {
        Dataset chartDataset = null;
        switch (this.typeChart) {
            case PIE_CHART:
                PieChartCreator pieChartCreator = new PieChartCreator(matrixWithDataForGraph, isFirstRowOrColumnLabel);
                chartDataset = pieChartCreator.createDataset();
                break;
            case SIMPLE_BAR_CHART:
                BarChartCreator barChartCreator = new BarChartCreator(matrixWithDataForGraph, isFirstRowOrColumnLabel);
                chartDataset = barChartCreator.createDataset();
                break;
            case SIMPLE_STACKED_BAR_CHART:
                StackedBarChartCreator stackedBarChartCreator = new StackedBarChartCreator(matrixWithDataForGraph, isFirstRowOrColumnLabel);
                chartDataset = stackedBarChartCreator.createDataset();
                break;
            default:
                break;
        }

        return chartDataset;
    }

    private String[][] transposeMatrix(String[][] m) {
        //System.out.println("££££££££  ==>>>>»»» TRANSPOSTA");
        // printMatrix(m);
        String[][] toReturn = new String[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                toReturn[j][i] = m[i][j];
            }
        }
        // printMatrix(toReturn);
        return toReturn;
    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private String[][] addLabels(String[][] matrixWithDataForGraph) {
        //printMatrix(matrixWithDataForGraph);
        /**
         * with one more line and row
         */
        int countX = 0;
        int countY = 0;
        String[][] toReturn = new String[matrixWithDataForGraph.length + 1][matrixWithDataForGraph[0].length + 1];
        for (int i = 1; i < toReturn[i].length; i++) {
            toReturn[0][i] = "Element " + countY;
            countY++;
        }
        for (int i = 1; i < toReturn.length; i++) {
            toReturn[i][0] = "Label " + countX;
            countX++;
            for (int j = 1; j < toReturn[i].length; j++) {
                toReturn[i][j] = matrixWithDataForGraph[i - 1][j - 1];
            }
        }
        //printMatrix(toReturn);

        return toReturn;
    }

}
