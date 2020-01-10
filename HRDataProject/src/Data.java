import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

import smile.math.distance.CorrelationDistance;
import tech.tablesaw.api.*;
import tech.tablesaw.selection.Selection;
import static tech.tablesaw.aggregate.AggregateFunctions.*;

/**
 * This class imports the raw data and cleans it.
 * It also provides methods for various attributes of the data.
 */
public class Data {
	private Table df;

	/**
	 * The constructor reads in the csv file and converts it into a Table called df.
	 * It then do some simple cleaning of the data.
	 */
	public Data() {
		try {
			this.df  = Table.read().csv("HRDataset_v13.csv");  // import the raw data set
			removeColumnsWithMissingValues();  // delete missing values
			this.df = this.df.select("Employee_Name", "EmpID", "MarriedID", "GenderID", "Sex", "EmpStatusID", 
					"DeptID", "Department", "PositionID", "Position", "State", 
					"CitizenDesc", "HispanicLatino", "RaceDesc", "FromDiversityJobFairID",
					"PerfScoreID", "PerformanceScore", "EmpSatisfaction", "PayRate"); 

		} catch (IOException e) {
			System.out.println("File not found. Try again.");
		}
	}

	/**
	 * Getter method for the instance variable df
	 * @return df
	 */
	public Table getDf() {
		return df;
	}

	/**
	 * This method prints the structure of the table
	 */
	public void printTableStructure() {
		Table structure = df.structure();
		System.out.println(structure);
	}

	/**
	 * This method prints the shape of the table
	 */
	public void printTableShape() {
		String shape = df.shape();
		System.out.println(shape);
	}

	/**
	 * This method prints a list of all column names of the Table
	 */
	public void printColumnNames() {
		System.out.println(df.columnNames());
	}	


	/**
	 * This method prints first n rows of the Table
	 */
	public void printFirstNRows(int n) {
		System.out.println(df.first(n));;
	}	

	/**
	 * This method prints last n rows of the Table
	 */
	public void printLastNRows(int n) {
		System.out.println(df.last(n));;
	}	


	/**
	 * This method removes all columns with missing value(s)
	 */
	public void removeColumnsWithMissingValues() {
		df.removeColumnsWithMissingValues();
	}


	/**
	 * This method prints a summary table with mean, max, min, and median values of a specified DoubleColumn  
	 */
	public void printSummary(DoubleColumn colName) {
		Table distribution = df.summarize(colName, mean, max, min, median).apply();
		System.out.println(distribution);

	}

	/**
	 * This method prints a summary table with mean, max, min, and median values of a specified DoubleColumn categorized by another column
	 */
	public void printSummary(DoubleColumn colName, String byColName) {
		Table distribution = df.summarize(colName, mean, max, min, median).by(byColName);
		System.out.println(distribution);
	}

	/**
	 * This method prints a summary table with mean, max, min, and median values of a specified IntColumn  
	 */
	public void printSummary(IntColumn colName) {
		Table distribution = df.summarize(colName, mean, max, min, median).apply();
		System.out.println(distribution);
	}

	/**
	 * This method prints a summary table with mean, max, min, and median values of a specified IntColumn categorized by another column
	 */
	public void printSummary(IntColumn colName, String byColName) {
		Table distribution = df.summarize(colName, mean, max, min, median).by(byColName);
		System.out.println(distribution);
	}

	/**
	 * This method computes the correlation between two numeric columns.
	 * @param x
	 * @param y
	 * @return the correlation coefficient
	 */
	public double getCorrelation(double[] x, double[] y) {
		double result = 1 - (CorrelationDistance.pearson(x, y));
		return result;
	}

	/**
	 * This helper method lists out the position ID and the corresponding position name 
	 * @param position ID
	 * @return the position ID and the position name
	 */

	public void PositionIDandRole(){	
		TreeMap <Integer, String> PositionIDandRole = new TreeMap <Integer, String>();
		PositionIDandRole.put(1, "Accountant");
		PositionIDandRole.put(2, "Administrative Assistant");
		PositionIDandRole.put(3, "Area Sales Manager");
		PositionIDandRole.put(4, "BI Developer");
		PositionIDandRole.put(5, "BI Director");
		PositionIDandRole.put(6, "CIO");
		PositionIDandRole.put(7, "Data Architect");
		PositionIDandRole.put(8, "Database Administrator");
		PositionIDandRole.put(10, "Director of Operations");
		PositionIDandRole.put(11, "Director of Sales");
		PositionIDandRole.put(12, "IT Director");
		PositionIDandRole.put(13, "IT Manager");
		PositionIDandRole.put(14, "IT Support");
		PositionIDandRole.put(15, "Network Engineer");
		PositionIDandRole.put(16, "President & CEO");
		PositionIDandRole.put(17, "Production Mangager");
		PositionIDandRole.put(15, "Network Engineer");
		PositionIDandRole.put(16, "President & CEO");
		PositionIDandRole.put(17, "Production Mangager");
		PositionIDandRole.put(18, "Production Manager");
		PositionIDandRole.put(19, "Production Technician I");
		PositionIDandRole.put(20, "Production Technician II");
		PositionIDandRole.put(21, "Sales Manager");
		PositionIDandRole.put(22, "Senior BI Developer");
		PositionIDandRole.put(23, "Shared Services Manager");
		PositionIDandRole.put(24, "Software Engineer");
		PositionIDandRole.put(25, "Software Engineering Manager");
		PositionIDandRole.put(26, "Senior Accountant");
		PositionIDandRole.put(27, "Senior DBA");
		PositionIDandRole.put(28, "Senior Network Engineer");
		PositionIDandRole.put(29, "Principal Data Architect");
		PositionIDandRole.put(30, "Enterprise Architect");

		for (Integer key: PositionIDandRole.keySet()) {
			System.out.println(key + ": " + PositionIDandRole.get(key));
		}
	}

	/**
	 * Use "main" to test your code.
	 * This method should be commented out after finishing building this class.
	 */
//	public static void main(String[] args) {
//		Data data = new Data(); // instantiate an object for the Data class
//		// Test out all methods:
//		data.printTableStructure();
//		data.printTableShape();
//		data.printColumnNames();
//		data.printFirstNRows(4);
//		data.printLastNRows(4);
//		data.removeColumnsWithMissingValues();
//		data.printTableShape();
//		System.out.println();
//		
//		DoubleColumn payRate = (DoubleColumn) data.df.column("PayRate");
//		IntColumn marriedID = (IntColumn) data.df.column("MarriedID");
//		data.printSummary(payRate);
//		data.printSummary(marriedID);
//		data.printSummary(payRate, "GenderID");
//		data.printSummary(marriedID, "GenderID");
//		
//		IntColumn perfScoreID = data.df.intColumn("PerfScoreID");
//		System.out.println(data.getCorrelation(perfScoreID.asDoubleArray(), payRate.asDoubleArray())); 
//		data.PositionIDandRole();
//	}
	
	
}


 