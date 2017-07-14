/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class Test {

    public Test() {
        //testRun();

    }

    public void testRun() {
        PieChart demo;
        demo = new PieChart("Qualidade das equipas", "Qual a tua equipa");
        demo.pack();
        demo.setVisible(true);

        BarChart demo1;
        demo1 = new BarChart("Qualidade das equipas", "Qual a tua equipa");
        demo1.pack();
        demo1.setVisible(true);

        StackedBarChart demo2;
        demo2 = new StackedBarChart("Qualidade das equipas", "Qual a tua equipa");
        demo2.pack();
        demo2.setVisible(true);
    }

    public JPanel pieChartJPanel() {
        JPanel jPanel = new JPanel();
        PieChart demo = new PieChart("Example", "title");
        jPanel.add(demo.pieChartJPanel());
        jPanel.add(new JLabel("Muahhahaha sou o rei"));
        jPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        return jPanel;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        Test t = new Test();
    }

    public class PieChart extends JFrame {

        private static final long serialVersionUID = 1L;

        public PieChart(String applicationTitle, String chartTitle) {
            super(applicationTitle);
            // This will create the dataset
            PieDataset dataset = createDataset();
            // based on the dataset we create the chart
            JFreeChart chart = createChart(dataset, chartTitle);
            // we put the chart into a panel
            ChartPanel chartPanel = new ChartPanel(chart);
            // default size
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            // add it to our application
            setContentPane(chartPanel);

        }

        public ChartPanel pieChartJPanel() {
            PieDataset dataset = createDataset();
            // based on the dataset we create the chart
            JFreeChart chart = createChart(dataset, "test");
            // we put the chart into a panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            return chartPanel;
        }

        /**
         * Creates a sample dataset
         */
        private PieDataset createDataset() {
            DefaultPieDataset result = new DefaultPieDataset();
            result.setValue("Red", 51);
            result.setValue("Blue", 20);
            result.setValue("Green", 29);
            return result;

        }

        /**
         * Creates a chart
         */
        private JFreeChart createChart(PieDataset dataset, String title) {

            JFreeChart chart = ChartFactory.createPieChart3D(
                    title, // chart title
                    dataset, // data
                    true, // include legend
                    true,
                    false
            );

            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(290);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            return chart;

        }
    }

    public class BarChart extends JFrame {

        private static final long serialVersionUID = 1L;

        public BarChart(String applicationTitle, String chartTitle) {
            super(applicationTitle);
            // This will create the dataset
            CategoryDataset dataset = createDataset();
            // based on the dataset we create the chart
            JFreeChart chart = createChart(chartTitle);
            // we put the chart into a panel
            ChartPanel chartPanel = new ChartPanel(chart);
            // default size
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            // add it to our application
            setContentPane(chartPanel);

        }

        /**
         * Creates a chart
         */
        private JFreeChart createChart(String chartTitle) {

            JFreeChart barChart = ChartFactory.createBarChart(
                    chartTitle,
                    "Category",
                    "Score",
                    createDataset(),
                    PlotOrientation.VERTICAL,
                    true, true, false);

            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
            setContentPane(chartPanel);
            return barChart;

        }

        private CategoryDataset createDataset() {
            final String redTeam = "Red";
            final String blueTeam = "Blue";
            final String greenTeam = "Green";

            final String beauty = "Beauty";
            final String dedication = "Dedication";
            final String courage = "Courage";
            final String successfullUcNumber = "Successfull tasks";

            final DefaultCategoryDataset dataset
                    = new DefaultCategoryDataset();

            dataset.addValue(5.0, redTeam, beauty);
            dataset.addValue(5.0, redTeam, courage);
            dataset.addValue(5.0, redTeam, dedication);
            dataset.addValue(5.0, redTeam, successfullUcNumber);

            dataset.addValue(3.0, blueTeam, beauty);
            dataset.addValue(4.0, blueTeam, courage);
            dataset.addValue(4.0, blueTeam, dedication);
            dataset.addValue(3.0, blueTeam, successfullUcNumber);

            dataset.addValue(4.0, greenTeam, beauty);
            dataset.addValue(3.0, greenTeam, courage);
            dataset.addValue(3.0, greenTeam, dedication);
            dataset.addValue(4.0, greenTeam, successfullUcNumber);
            return dataset;
        }

    }

    public class StackedBarChart extends JFrame {

        public StackedBarChart(String applicationTitle, String chartTitle) {
            super(applicationTitle);
            // This will create the dataset
            CategoryDataset dataset = createDataset();
            // based on the dataset we create the chart
            JFreeChart chart = createChart(dataset, chartTitle, "Categorie", "Value");
            // we put the chart into a panel
            ChartPanel chartPanel = new ChartPanel(chart);
            // default size
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            // add it to our application
            setContentPane(chartPanel);

        }

        private CategoryDataset createDataset() {
            DefaultCategoryDataset result = new DefaultCategoryDataset();

            result.addValue(20.3, "Red", "Beauty");
            result.addValue(27.2, "Red", "Dedication");
            result.addValue(30.7, "Red", "Courage");

            result.addValue(1.3, "Green", "Beauty");
            result.addValue(1.2, "Green", "Dedication");
            result.addValue(1.7, "Green", "Courage");

            result.addValue(2.9, "Blue", "Beauty");
            result.addValue(2.0, "Blue", "Dedication");
            result.addValue(2.7, "Blue", "Courage");

            return result;
        }

        /**
         * Creates a sample chart.
         *
         * @param dataset the dataset for the chart.
         *
         * @return A sample chart.
         */
        private JFreeChart createChart(final CategoryDataset dataset, String title, String category, String value) {

            final JFreeChart chart = ChartFactory.createStackedBarChart(
                    title, // chart title
                    category, // domain axis label
                    value, // range axis label
                    dataset, // data
                    PlotOrientation.VERTICAL, // the plot orientation
                    true, // legend
                    true, // tooltips
                    false // urls
            );

            return chart;
        }
    }
}
