/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard.ChartCreatorsByType;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class BarChartCreator implements ChartCreatorInterface {

    private String[][] matrix;

    private boolean isFirstRowOrColumnLabel;

    /**
     *
     * @param matrix
     * @param isFirstRowLabel
     */
    public BarChartCreator(String[][] matrix, boolean isFirstRowLabel) {
        this.matrix = matrix;
        this.isFirstRowOrColumnLabel = isFirstRowLabel;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isIsFirstRowLabel() {
        return isFirstRowOrColumnLabel;
    }

    public void setIsFirstRowLabel(boolean isFirstRowLabel) {
        this.isFirstRowOrColumnLabel = isFirstRowLabel;
    }

    /**
     * 1º is value, 2º is the label, 3º is the columns
     *
     *
     * +----------------------------------+---------+------------------------+----------------+
     *
     * | Col1 | Col2 | Col3 | Numeric Column |
     *
     * +----------------------------------+---------+------------------------+----------------+
     *
     * | Value 1 | Value 2 | 123 | 10.0 |
     *
     * | Separate | cols | with a tab or 4 spaces | -2,027.1 |
     *
     * | This is a row with only one cell | | | |
     *
     * +----------------------------------+---------+------------------------+----------------+
     *
     *
     *
     *
     *
     *
     *
     * "beleza" |||||||||||||||||||
     *
     * "inteligencia" ||||||||||||||||
     *
     * "força" |||||||||||||||||
     *
     *
     * Jose tag = |
     *
     *
     *
     *
     *
     */
    //dataset.addValue(5.0, "Jose", "Beleza");
    @Override
    public Dataset createDataset() {

        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        for (int i = 1; i < this.matrix.length; i++) {
            for (int j = 1; j < this.matrix[0].length; j++) {
                try {
                    dataset.addValue(Double.parseDouble(this.matrix[i][j]),
                            this.matrix[0][j],
                            this.matrix[i][0]);
                } catch (NumberFormatException exception) {
                    dataset.addValue(0,
                            this.matrix[0][j],
                            this.matrix[i][0]);
                }
            }
        }

        return dataset;

    }

}
