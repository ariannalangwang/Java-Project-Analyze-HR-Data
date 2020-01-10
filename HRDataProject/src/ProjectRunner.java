import smile.regression.OLS;

/**
 * This class runs the whole project.
 */
public class ProjectRunner {

	public static void main(String[] args) {
		Data data = new Data();
		Graphs graph = new Graphs(data);
		System.out.println("SUMMARY");
		System.out.println("This is a Java data science project that conducts analysis on a human resource dataset on Kaggle (https://www.kaggle.com/rhuebner/human-resources-data-set)");
		System.out.println("We will conduct data visualisation and machine learning via linear regression in this project.");
		System.out.println();
		System.out.println("DATA VISUALISATION");
		System.out.println("We have plotted pie charts that examine the distribution of employees by gender and departments, a histogram that examines the distribution of employees’ performance, and box plots for employees’ pay rate by citizenship status and position.");
		System.out.println("Note that the graphs have been outputted in different browser tabs ");

		graph.runAllPlots();

		System.out.println();

		System.out.println("LINEAR REGRESSION AND MACHINE LEARNING");		
		System.out.println("We built a linear regression model using gender, employee position and employee performance score to predict an employee's pay rate.");		
		System.out.println("After predicting the employee's pay rate, we also evaluate the model by examining the R Squared.");		
		System.out.println("Please input the details of the employee's gender, position and performance score below as guideded in the console.");		
		System.out.println();
		System.out.println("[User Input Required]");		
		PredictPayRate ppr = new PredictPayRate(data);
		ppr.predictIndividualPayRateInteractive();
		ppr.runRegression();
	}

}
 