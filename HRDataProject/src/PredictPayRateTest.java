import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import smile.regression.OLS;

/**
 * This class tests the PredictPayRate class.
 */
class PredictPayRateTest {
	Data data = new Data();
	PredictPayRate ppr = new PredictPayRate(data);
	
	/**
	 * This test tests the IndividualPayRateInteractive Method with user input of 1, 30 and 1. 
	 */
	@Test
	void test1PredictIndividualPayRateInteractive() {
		double[] independentValues = new double[3];
		independentValues[0] = 1;
		independentValues[1] = 30;
		independentValues[2] = 1;
		OLS model = ppr.fitTheModel();
		double predictedPayRate = model.predict(independentValues);
		assertEquals(predictedPayRate, 2.449812621005613); 
	}
	
	/**
	 * This test tests the IndividualPayRateInteractive Method with user input of 0, 15 and 2.
	 */
	
	@Test
	void test2PredictIndividualPayRateInteractive() {
		double[] independentValues = new double[3];
		independentValues[0] = 0;
		independentValues[1] = 15;
		independentValues[2] = 2;
		OLS model = ppr.fitTheModel();
		double predictedPayRate = model.predict(independentValues);
		assertEquals(predictedPayRate, 28.373245175260433); 
	}
	
	/**
	 * This test tests the IndividualPayRateInteractive Method with user input of 0, 8 and 3. 
	 */
	
	@Test
	void test3PredictIndividualPayRateInteractive() {
		double[] independentValues = new double[3];
		independentValues[0] = 0;
		independentValues[1] = 8;
		independentValues[2] = 3;
		OLS model = ppr.fitTheModel();
		double predictedPayRate = model.predict(independentValues);
		assertEquals(predictedPayRate, 42.085182180918125); 
	}
	
	/**
	 * This test tests the IndividualPayRateInteractive Method with user input of 1, 6 and 4.
	 */
	
	@Test
	void test4PredictIndividualPayRateInteractive() {
		double[] independentValues = new double[3];
		independentValues[0] = 1;
		independentValues[1] = 6;
		independentValues[2] = 4;
		OLS model = ppr.fitTheModel();
		double predictedPayRate = model.predict(independentValues);
		assertEquals(predictedPayRate, 49.05756318548545); 
	}
	
	/**
	 * This test tests the IndividualPayRateInteractive Method with user input of 1, 9 and 4.
	 */
	
	@Test
	void test5PredictIndividualPayRateInteractive() {
		double[] independentValues = new double[3];
		independentValues[0] = 1;
		independentValues[1] = 9;
		independentValues[2] = 4;
		OLS model = ppr.fitTheModel();
		double predictedPayRate = model.predict(independentValues);
		assertEquals(predictedPayRate, 43.5856236379787); 
	}
	
	/**
	 * This test tests the evaluateAdjustedRSquared() method to check the accuracy of the Adjusted R Squared.
	 */
	
	@Test
	void testevaluateAdjustedRSquared() {
		OLS model = ppr.fitTheModel();
		assertEquals(model.adjustedRSquared(), 0.5079018339944246); 

	}
	
	/**
	 * This test tests the evaluateAdjustedRSquared() method to check the accuracy of the R Squared.
	 */
	
	@Test
	void testevaluateRSquared() {
		OLS model = ppr.fitTheModel();
		assertEquals(model.RSquared(), 0.5147683200317117); 
	}
	
}
	

 