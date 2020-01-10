import java.util.HashMap;
import java.util.Scanner;
import smile.regression.OLS;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.selection.Selection;

/**
 * This class uses linear regression to predict individual employees' pay rate.
 */
public class PredictPayRate {
	private Table df;
	private double[][] linearRegressionTrainIndependentArr;
	private double[] linearRegressionTrainDependentArr;
	private double[][] linearRegressionTestIndependentArr;


	/**
	 * The constructor gets data frame from the Data class and prepares input for the regression model.
	 * from the data frame.
	 * @param data
	 */
	public PredictPayRate(Data data) {
		// get the data frame from the Data class
		this.df = data.getDf();
		// prepares the data for the regression model
		modelPreparation();
	}


	/**
	 * This method prepares the data to be used in the regression model.
	 */
	private void modelPreparation() {
		// Splitting the table into two (dependent vs independent)
		NumberColumn linearRegressionDependent = df.numberColumn(18);  
		Table linearRegressionIndependent = (Table) df.removeColumns("Employee_Name", "EmpID", "MarriedID", "Sex",
				"EmpStatusID", "DeptID", "Department", "Position", "State", "CitizenDesc", "HispanicLatino", "RaceDesc",
				"FromDiversityJobFairID", "PerformanceScore", "EmpSatisfaction", "PayRate");
		// Separate testing and training data with 30%/70% split for independent variable
		Table linearRegressionTrainIndependent = (Table) linearRegressionIndependent.where(Selection.withRange(1, 217));
		Table linearRegressionTestIndependent = (Table) linearRegressionIndependent
				.where(Selection.withRange(218, 310));
		// Separate testing and training data with 30%/70% split for dependent variable
		NumberColumn linearRegressionTrainDependent = (NumberColumn) linearRegressionDependent
				.where(Selection.withRange(1, 217));
		NumberColumn linearRegressionTestDependent = (NumberColumn) linearRegressionDependent
				.where(Selection.withRange(218, 310));

		// Convert the training data set to double array for independent variable
		this.linearRegressionTrainIndependentArr = linearRegressionTrainIndependent.as().doubleMatrix();
		// Convert the training data set to array for dependent variable
		this.linearRegressionTrainDependentArr = linearRegressionTrainDependent.asDoubleArray();
		// convert the test independent table to double array
		this.linearRegressionTestIndependentArr = linearRegressionTestIndependent.as().doubleMatrix();
	}


	/**
	 * This method fits the model.
	 * @return LinearRegressionTrainer (the fitted OLS model)
	 */
	public OLS fitTheModel() {
		OLS theLinearModel = new OLS(this.linearRegressionTrainIndependentArr, this.linearRegressionTrainDependentArr);
		return theLinearModel;
	}


	/**
	 * This method predicts the Pay Rate for the testing data.
	 * @param HRdata
	 * @param theLinearModel
	 * @return predicted PayRate
	 */
	private double[] predictPayRate(double[][] EmployeeCharacteristic, OLS theLinearModel) {
		double[] predictedValues = new double[EmployeeCharacteristic.length];
		for (int i = 0; i < EmployeeCharacteristic.length; i++) {
			double[] oneEmpCharacteristics = new double[EmployeeCharacteristic[i].length];
			for (int j = 0; j < EmployeeCharacteristic[i].length; j++) {
				oneEmpCharacteristics[j] = EmployeeCharacteristic[i][j];
			}
			// Predicting
			double predictedaVal = theLinearModel.predict(oneEmpCharacteristics);
			predictedValues[i] = predictedaVal;
		}
		return predictedValues;
	}


	/**
	 * This method evaluates the model by using R-squared.
	 * @param theLinearModel
	 */
	private double evaluateAdjustedRSquared(OLS theLinearModel) {

		return theLinearModel.adjustedRSquared();
	}

	private double evaluateRSquared(OLS theLinearModel) {

		return theLinearModel.RSquared();
	}


	/**
	 * This helper method repeatedly checks for user input until a valid input is given by the user.
	 * @param factorName
	 * @return the user input, which is a double.
	 */
	private double checkInput(String factorName) {
		Scanner in = new Scanner(System.in);
		String question = "";
		int lowerBound;
		int upperBound;
		if (factorName.toLowerCase().contains("gender")) {
			question += "Enter gender ID (1 for male, 0 for female): ";
			lowerBound = 0;
			upperBound = 1;
		}
		else if (factorName.toLowerCase().contains("position")) {
			question += "Enter position ID (an integer from 1 to 30):";
			lowerBound = 1;
			upperBound = 30;
			Data data = new Data();
			data.PositionIDandRole();
		}
		else {
			question += "Enter performance score ID (an integer from 1 (lowest score) to 4 (highest score)): ";
			lowerBound = 1;
			upperBound = 4;
		}

		int result = -1;
		do {
			System.out.println(question);
			String s = in.nextLine();
			try {
				result = Integer.parseInt(s);
			} catch (NumberFormatException e) {
			}
		} while (result < lowerBound || result > upperBound);

		return result;
	}

	/**
	 * This method asks for inputs for the three features of an individual employee, 
	 * then returns the predicted pay rate for the individual employee.
	 * @return the predicted pay rate
	 */
	public void predictIndividualPayRateInteractive() {
		double[] independentValues = new double[3];
		independentValues[0] = checkInput("gender");
		independentValues[1] = checkInput("position");
		independentValues[2] = checkInput("perf");
		OLS model = fitTheModel();
		double predictedPayRate = model.predict(independentValues);
		System.out.println("This employee's pay rate is " + predictedPayRate);
	}


	/**
	 * This method runs the whole regression.
	 */
	public void runRegression() {
		OLS theLinearModel = fitTheModel();
		double[] predictedTestVals = predictPayRate(this.linearRegressionTestIndependentArr, theLinearModel);
		System.out.println("The Linear Regression model is: 'pay rate ~ gender ID + position ID + performance score ID'.");
		System.out.println("The R Squared is " + evaluateRSquared(theLinearModel));
		System.out.println("The adjusted R Squared is " + evaluateAdjustedRSquared(theLinearModel));
	}


}




 