package net.viralpatel.struts2;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import matrix.ProbabilityExample;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;


public class PieChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int count=1;
	private static int count1=1;
	private static boolean flag=true;
	private Connection dbConnection = null;

	public PieChartServlet() {
		//dbConnection = DataAccessObject.getConnection();
	}

	public List<Double>  calc(boolean flag){		
		List<Double> df=new ArrayList<Double>();
		df=ProbabilityExample.calc(flag);		
		return df;		
	}
	public Map<Integer,Integer> collate(List<Double> df){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(Double i:df){
			Double val=i*10000;
			System.out.println(val);
			if(val.compareTo(19.0)>=0 && val.compareTo(23.5)<=0){
				//System.out.println("adding 0");
				if(map.get(0)==null){
					map.put(0,1);
				} else {
					map.put(0,map.get(0)+1);
				}
			}

			if(val.compareTo(23.51)>=0 && val.compareTo(25.0)<=0){
				//System.out.println("adding 1");
				if(map.get(1)==null){
					map.put(1,1);
				} else {
					map.put(1,map.get(1)+1);
				}
			}

			if(val.compareTo(25.01)>=0 && val.compareTo(29.2)<=0){
				//System.out.println("adding 2");
				if(map.get(2)==null){
					map.put(2,1);
				} else {
					map.put(2,map.get(2)+1);
				}
			}

			if(val.compareTo(29.21)>=0 && val.compareTo(31.5)<=0){
				//System.out.println("adding 3");
				if(map.get(3)==null){
					map.put(3,1);
				} else {
					map.put(3,map.get(3)+1);
				}
			}
			if(val.compareTo(31.51)>=0 && val.compareTo(38.2)<=0){
				//System.out.println("adding 4");
				if(map.get(4)==null){
					map.put(4,1);
				} else {
					map.put(4,map.get(4)+1);
				}
			}
			else {
				//System.out.println("adding 5");
				if(map.get(5)==null){
					map.put(5,1);
				} else {
					map.put(5,map.get(5)+1);
				}
			}

		}
		return map;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//JDBCPieDataset dataset = new JDBCPieDataset(dbConnection);
		String strChartType = request.getParameter("type");
		System.out.println("strChartType="+strChartType);
		if (strChartType != null)
		{
		if (strChartType.equals("Test2"))
		{
			/*DefaultPieDataset dataset = new DefaultPieDataset();

			dataset.setValue("Graphic Novels", 192);
			dataset.setValue("History", 125);
			dataset.setValue("Military Fiction", 236); 
			dataset.setValue("Mystery", 547); 
			dataset.setValue("Performing Arts", 210);
			dataset.setValue("Science, Non-Fiction", 70);
			dataset.setValue("Science Fiction", 989); 

			chart = ChartFactory.createPieChart(
					"Books by Type",  // Title
					dataset,          // Data
					true,             // Yes, display the legend
					false,            // No, don't display tooltips
					false             // No, no URLs
					);
			chart.setBackgroundPaint(Color.white);*/

			response.setContentType("text/html");
			 PrintWriter pw = response.getWriter();
		      pw.println("<html>");
		      pw.println("<head><title>List Of Users With Score details :</title></title>");
		      pw.println("<body>");		      
		      pw.println("<table align='center' style='width:65%'> ");
		      pw.println("<tr><td><h1 ><div align='Center'><font color='#2CA6DF'> Barclays Bank Admin Page</font> <br> </div></h1></td></tr></table>");
		      pw.println("<h1>List Of Users With Score details :</h1>");
		      pw.println("<table align='center' style='width:65%' border='1'> ");
		      pw.println("<tr>    <td>Name</td>    <td>Financial Score</td>     <td>Social Score</td> <td>Cumulative Score</td>  <td>Customer Range</td>  </tr>");
		      double input[][]=new double[14][2];
		      input[0][0]=825;input[0][1]=850;input[5][0]=200;input[5][1]=37;
	    		input[1][0]=750;input[1][1]=625;input[6][0]=450;input[6][1]=950;
	    		input[2][0]=650;input[2][1]=680;input[7][0]=562;input[7][1]=450;
	    		input[3][0]=500;input[3][1]=499;input[8][0]=950;input[8][1]=950;
	    		input[4][0]=200;input[4][1]=247;input[9][0]=450;input[9][1]=450;
	    		double val[][]=MongoDBJDBC.dbcall();

	    		 List<String>  map=MongoDBJDBC.name();
		        
	    		int ii=0;int ji=0;
	    		for(int i=10;i<14;i++){
	    			for(int j=0;j<2;j++){
	    				input[i][j]=val[ii][ji];
	    				ji++;
	    			}
	    			ji=0;ii++;
	    		}
	    		 List<Double> li = ProbabilityExample.calc(false);
			      for(int i=0;i<14;i++){
			    	  if(i<10){
			    		  pw.println(" <tr>    <td>"+"user"+(i+1)+"</td>    <td>"+input[i][0]+"</td>     <td>"+input[i][1]+"</td> <td>"+li.get(i)*10000+"</td> <td> "+cal(li.get(i))+"</td>  </tr>"); 
			    	  } else {
			    		  pw.println(" <tr>    <td> <mark>"+map.get(i-10)+"</mark></td>    <td>"+input[i][0]+"</td>     <td>"+input[i][1]/1000+"</td> <td> <mark>"+li.get(i)*10000+"</mark></td> <td> <mark>"+cal(li.get(i))+"</mark></td>  </tr>"); 
			    	  }
			      }
		      pw.println("</table></body></html>"); return;
		}
		}

		try {
			//dataset.executeQuery("SELECT SOURCE,PERCENTAGE FROM AIR_POLLUTION ORDER BY PERCENTAGE");

			DefaultPieDataset dataSet = new DefaultPieDataset();
			int i=0;
			List<Double> df=calc(true);
			Map<Integer,Integer> map = new HashMap<Integer, Integer>();
			if(flag){
				flag=false;
				df=calc(true);
			}else {

				df=calc(false);
			}
			System.out.println(df.size());
			map=collate(df);
			System.out.println(map.get(0));
			System.out.println(map.get(1));
			System.out.println(map.get(2));
			System.out.println(map.get(3));
			System.out.println(map.get(4));
			System.out.println(map.get(5));
			dataSet.setValue("Highly Efficient Users", map.get(0));			 
			dataSet.setValue("Above Average", map.get(1));
			dataSet.setValue("Average", map.get(2));
			dataSet.setValue("Below Average", map.get(3));
			dataSet.setValue("Defaulters", map.get(4));
			dataSet.setValue("Black Lists", map.get(5));
			count1=2;count=1;
			JFreeChart chart;
			System.out.println("strChartType="+strChartType);
			if (strChartType != null)
			{
				if (strChartType.equals("Test1"))
				{
					chart = ChartFactory.createPieChart3D(
							"Application Chart - Displaying - User Sector", // Title
							dataSet,                    // Data
							true,                       // Display the legend
							true,                       // Display tool tips
							false                       // No URLs
							);
					chart.setBorderVisible(true);
					if (chart != null) {
						PiePlot plot4 = (PiePlot) chart.getPlot();
						plot4.setForegroundAlpha(0.6f);
						plot4.setBackgroundPaint(Color.WHITE);
						PiePlot piePlot = (PiePlot) chart.getPlot();
						StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} {1} {2}");
						piePlot.setLabelGenerator(labelGenerator);
						piePlot.setLegendLabelGenerator(labelGenerator);
						response.setContentType("html");

						ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 800, 600);
					}
				}

				
			}




		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	public String cal(Double val){
		val*=10000;		
		if(val.compareTo(19.0)>=0 && val.compareTo(23.5)<=0){return "Highly Efficient Users";
		}

		if(val.compareTo(23.51)>=0 && val.compareTo(25.0)<=0){return "Above Average";}

		if(val.compareTo(25.01)>=0 && val.compareTo(29.2)<=0){return "Average";}

		if(val.compareTo(29.21)>=0 && val.compareTo(31.5)<=0){return "Below Average";}
		if(val.compareTo(31.51)>=0 && val.compareTo(38.2)<=0){return "Defaulters";}
		else {return "Black Lists";}
	}
}