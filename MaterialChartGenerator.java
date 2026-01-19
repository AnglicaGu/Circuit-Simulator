/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: MaterialChartGenerator
 * Description: A class used to sort electrical conductivity data and 
 * generate bar chart using the sorted data.
 */

package view;

import model.Material;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;

public class MaterialChartGenerator {

	// method to draw the bar chart using sorted data
	public static ChartPanel drawConductivityBarChart(ArrayList<Material> materialList) {

		// do the bubble sort first
		bubbleSortByConductivity(materialList);

		// create the defaut dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// add the data used to generate the graph into the dataset
		// loop through the dataList
		for (Material material : materialList) {
			String materialName = material.getName();
			double conductivity = material.getConductivity();

			dataset.addValue(conductivity, "Conductivity", materialName);
		}

		// create the chart
		JFreeChart barChart = ChartFactory.createBarChart("Material Conductivity Chart", // 图表标题
				"Material Name", // X-axis label
				"Conductivity (S/m)", // Y-axis label
				dataset, // dataset
				PlotOrientation.VERTICAL, // vertical deirction
				true, // contain the legeng or not
				true, // contain the tooltip or not
				false // contain the URL or not
		);

		// turn the y-xias 30°
		CategoryPlot plot = barChart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));

		// return the chartPanel
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setSize(new java.awt.Dimension(879, 350));
		return chartPanel;
	}

	// method useing bubble sort to sort from small to big
	private static void bubbleSortByConductivity(ArrayList<Material> materialList) {
		int n = materialList.size();
		for (int i = 0; i < n - 1; i++) {

			// set a boolean to see if there is swapping in this round
			boolean swapped = false;

			// loop through all the data
			for (int j = 0; j < n - i - 1; j++) {

				// if the data is out of order
				if (materialList.get(j).getConductivity() > materialList.get(j + 1).getConductivity()) {

					// swap two data
					Material temp = materialList.get(j);
					materialList.set(j, materialList.get(j + 1));
					materialList.set(j + 1, temp);
					swapped = true;
				}
			}
			// break the loop if there is no swapping in this round
			if (!swapped)
				break;
		}
	}
}
