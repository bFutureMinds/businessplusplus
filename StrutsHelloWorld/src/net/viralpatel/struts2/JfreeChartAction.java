package net.viralpatel.struts2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.Action;

public class JfreeChartAction implements Action {

	private JFreeChart chart;

	public String execute() throws Exception {

		DefaultPieDataset dataSet = new DefaultPieDataset();
		dataSet.setValue("Agriculture", 10);
		dataSet.setValue("Residential heating", 4);
		dataSet.setValue("Commercial products", 15);
		dataSet.setValue("Industry", 42);
		dataSet.setValue("Transportation", 26);
		dataSet.setValue("Others", 3);

		chart = ChartFactory.createPieChart(
				"Source of Air Pollution ", // Title
				dataSet,                    // Data
				true,                       // Display the legend
				true,                       // Display tool tips
				false                       // No URLs
				);

		chart.setBorderVisible(true);

		return SUCCESS;
	}

	// This method will get called if we specify <param name="value">chart</param>
	public JFreeChart getChart() {
		return chart;
	}
}
