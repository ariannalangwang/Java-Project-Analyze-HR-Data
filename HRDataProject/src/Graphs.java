import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.*; //import all the plot varieties
import tech.tablesaw.plotly.components.Figure;

/**
 * This class does all the visualization (plots all graphs)  
 */
public class Graphs {
	private Table df; 
	private IntColumn empID; 
	private IntColumn marriedID;
	private IntColumn genderID;  
	private StringColumn sex;
	private StringColumn department;
	private StringColumn position;
	private StringColumn state;
	private StringColumn citizenDesc;
	private StringColumn raceDesc;
	private IntColumn fromDiversityJobFairID;
	private IntColumn perfScoreID;
	private StringColumn performanceScore;
	private IntColumn empSatisfaction;
	private DoubleColumn payRate;
	
	/**
	 * The constructor initializes all the columns from the data frame
	 * @param data
	 */
	public Graphs(Data data) {
		// get the data frame from the Data class
		this.df = data.getDf(); 
		// get all the columns from the data frame
		this.empID = df.intColumn("EmpID");
		this.marriedID = df.intColumn("MarriedID");
		this.genderID = df.intColumn("GenderID");  
		this.sex = df.stringColumn("Sex");
		this.department = df.stringColumn("Department");
		this.position = df.stringColumn("Position");
		this.state = df.stringColumn("State");
		this.citizenDesc = df.stringColumn("CitizenDesc");
		this.raceDesc = df.stringColumn("RaceDesc");
		this.fromDiversityJobFairID = df.intColumn("FromDiversityJobFairID");
		this.perfScoreID = df.intColumn("PerfScoreID");
		this.performanceScore = df.stringColumn("PerformanceScore");
		this.empSatisfaction = df.intColumn("EmpSatisfaction");
		this.payRate = df.doubleColumn("PayRate");
	}
	
	/**
	 * This method prints out a pie plot for Gender Distribution.
	 */
	private void piePlotForGenderDistribution() {
		Table plotData =Table.create("Data", sex, empID);
		Figure figure = PiePlot.create("Gender Distribution", plotData, "sex", "empID");
		Plot.show(figure);
	}
	
	/**
	 * This method prints out a pie plot for Department Distribution.
	 */
	private void piePlotForDepartmentDistribution() {
		Table plotData =Table.create("Data", department, empID);
		Figure figure = PiePlot.create("Department Distribution", plotData, "department", "empID");
		Plot.show(figure);
	}
	
	/**
	 * This method prints out a histogram for all employees' performance score.
	 * Performance score is from 1 to 4. 4 being the highest.
	 */  	
	private void histogramForPerformanceScore() {
		Table plotData =Table.create("Data", perfScoreID);
		Figure figure = Histogram.create("All Employees' Performance Score Distribution", plotData, "perfScoreID");
		Plot.show(figure);
	}
	
	/**
	 * This method prints out a box plot for pay rate based on citizenship status.
	 */  
	private void boxPlotForPayRateBasedOnCitizenship() {
		Table plotData =Table.create("Data", citizenDesc, payRate); // groupingColumn, numericColumn
		Figure figure = BoxPlot.create("Pay Rate Based on Citizenship Status", plotData, "citizenDesc", "payRate");
		Plot.show(figure);
	}
	 
	/**
	 * This method prints out a box plot for Pay Rate based on Performance Score.
	 */  
	private void boxPlotForPayRateBasedOnPosition() {
		Table plotData =Table.create("Data", position, payRate);
		Figure figure = BoxPlot.create("Pay Rate Based on Position", plotData, "position", "payRate");
		Plot.show(figure);
	}
		
	/**
	 * This method runs all the plots
	 * @param args
	 */
	public void runAllPlots() {
		piePlotForGenderDistribution();
		piePlotForDepartmentDistribution();
		histogramForPerformanceScore();
		boxPlotForPayRateBasedOnCitizenship();
		boxPlotForPayRateBasedOnPosition();
	}
		
	
	/**
	 * Use "main" to test your code.
	 * This method should be deleted after finishing building this class.
	 */
//	public static void main(String[] args) {
//		Data data = new Data();
//		Graphs graph = new Graphs(data);
//		graph.runAllPlots();
//	}

}
