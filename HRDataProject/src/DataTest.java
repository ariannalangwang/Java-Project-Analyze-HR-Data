import static org.junit.jupiter.api.Assertions.assertEquals;
import static tech.tablesaw.aggregate.AggregateFunctions.max;
import static tech.tablesaw.aggregate.AggregateFunctions.mean;
import static tech.tablesaw.aggregate.AggregateFunctions.median;
import static tech.tablesaw.aggregate.AggregateFunctions.min;

import org.junit.jupiter.api.Test;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;

/**
 * This class tests the Data class
 */
class DataTest {
	Data data = new Data();

	/**
	 * This test tests the getCorrelation method from the Data class
	 */
	@Test
	void testGetCorrelation() {
		IntColumn perfScoreID = data.getDf().intColumn("PerfScoreID");
		DoubleColumn payRate = data.getDf().doubleColumn("PayRate");
		assertEquals(data.getCorrelation(perfScoreID.asDoubleArray(), payRate.asDoubleArray()), 0.02069491097229048);
	}
	
	/**
	 * This test tests the printSummary method for an integer column from the Data class.
	 * Particularly, it tests if the method computes the mean correctly.
	 */
	@Test
	void testPrintSummaryForIntColumnMean() {
		IntColumn marriedID = data.getDf().intColumn("MarriedID");
		Table distribution = data.getDf().summarize(marriedID, mean, max, min, median).apply();
		double mean = distribution.row(0).getDouble(0);
		assertEquals(mean, 0.39677419354838717);
	}
	
	/**
	 * This test tests the printSummary method for an integer column from the Data class.
	 * Particularly, it tests if the method computes the max correctly.
	 */
	@Test
	void testPrintSummaryForIntColumnMax() {
		IntColumn marriedID = data.getDf().intColumn("MarriedID");
		Table distribution = data.getDf().summarize(marriedID, mean, max, min, median).apply();
		double max = distribution.row(0).getDouble(1);
		assertEquals(max, 1.0);
	}
	
	/**
	 * This test tests the printSummary method for an integer column from the Data class.
	 * Particularly, it tests if the method computes the min correctly.
	 */
	@Test
	void testPrintSummaryForIntColumnMin() {
		IntColumn marriedID = data.getDf().intColumn("MarriedID");
		Table distribution = data.getDf().summarize(marriedID, mean, max, min, median).apply();
		double min = distribution.row(0).getDouble(2);
		assertEquals(min, 0.0);
	}
	
	/**
	 * This test tests the printSummary method for an integer column from the Data class.
	 * Particularly, it tests if the method computes the median correctly.
	 */
	@Test
	void testPrintSummaryForIntColumnMedian() {
		IntColumn marriedID = data.getDf().intColumn("MarriedID");
		Table distribution = data.getDf().summarize(marriedID, mean, max, min, median).apply();
		double median = distribution.row(0).getDouble(3);
		assertEquals(median, 0.0);
	}
	
	/**
	 * This test tests the printSummary method for a double column from the Data class.
	 * Particularly, it tests if the method computes the mean correctly.
	 */
	@Test
	void testPrintSummaryForDoubleColumnMean() {
		DoubleColumn payRate = data.getDf().doubleColumn("PayRate");
		Table distribution = data.getDf().summarize(payRate, mean, max, min, median).apply();
		double mean = distribution.row(0).getDouble(0);
		assertEquals(mean, 31.28480645161292);
	}
	
	/**
	 * This test tests the printSummary method for a double column from the Data class.
	 * Particularly, it tests if the method computes the max correctly.
	 */
	@Test
	void testPrintSummaryForDoubleColumnMax() {
		DoubleColumn payRate = data.getDf().doubleColumn("PayRate");
		Table distribution = data.getDf().summarize(payRate, mean, max, min, median).apply();
		double max = distribution.row(0).getDouble(1);
		assertEquals(max, 80.0);
	}
	
	/**
	 * This test tests the printSummary method for a double column from the Data class.
	 * Particularly, it tests if the method computes the min correctly.
	 */
	@Test
	void testPrintSummaryForDoubleColumnMin() {
		DoubleColumn payRate = data.getDf().doubleColumn("PayRate");
		Table distribution = data.getDf().summarize(payRate, mean, max, min, median).apply();
		double min = distribution.row(0).getDouble(2);
		assertEquals(min, 14.0);
	}
	
	/**
	 * This test tests the printSummary method for a double column from the Data class.
	 * Particularly, it tests if the method computes the median correctly.
	 */
	@Test
	void testPrintSummaryForDoubleColumnMedian() {
		DoubleColumn payRate = data.getDf().doubleColumn("PayRate");
		Table distribution = data.getDf().summarize(payRate, mean, max, min, median).apply();
		double median = distribution.row(0).getDouble(3);
		assertEquals(median, 24.0);
	}
	
	/**
	 * This test tests the printSummary method for a double column grouped by another column.
	 * Particularly, it tests if the method computes the mean correctly.
	 */
	@Test
	void testPrintSummaryForDoubleColumnByAnotherColumnMean() {
		DoubleColumn payRate = data.getDf().doubleColumn("PayRate");
		Table distribution = data.getDf().summarize(payRate, mean, max, min, median).by("GenderID");
		double mean = distribution.row(0).getDouble(1);
		assertEquals(mean, 29.472146892655367);
	}
	
	/**
	 * This test tests the printSummary method for a double column grouped by another column.
	 * Particularly, it tests if the method computes the median correctly.
	 */
	@Test
	void testPrintSummaryForDoubleColumnByAnotherColumnMedian() {
		DoubleColumn payRate = data.getDf().doubleColumn("PayRate");
		Table distribution = data.getDf().summarize(payRate, mean, max, min, median).by("GenderID");
		double median = distribution.row(1).getDouble(4);
		assertEquals(median, 26.0);
	}
	
	/**
	 * This test tests the printSummary method for an integer column grouped by another column.
	 * Particularly, it tests if the method computes the mean correctly.
	 */
	@Test
	void testPrintSummaryForIntColumnByAnotherColumnMean() {
		IntColumn marriedID = data.getDf().intColumn("MarriedID");
		Table distribution = data.getDf().summarize(marriedID, mean, max, min, median).by("GenderID");
		double mean = distribution.row(0).getDouble(1);
		assertEquals(mean, 0.40677966101694923);
	}
	
	/**
	 * This test tests the printSummary method for an integer column grouped by another column.
	 * Particularly, it tests if the method computes the median correctly.
	 */
	@Test
	void testPrintSummaryForIntColumnByAnotherColumnMedian() {
		IntColumn marriedID = data.getDf().intColumn("MarriedID");
		Table distribution = data.getDf().summarize(marriedID, mean, max, min, median).by("GenderID");
		double median = distribution.row(1).getDouble(4);
		assertEquals(median, 0.0);
	}

}
