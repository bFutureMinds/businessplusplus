package matrix;

import static java.lang.System.out;
import java.util.*;

import javastat.*;
import javastat.inference.nonparametric.*;
import static javastat.util.Argument.*;
import static javastat.util.Output.*;
import javastat.util.*;

/**
 *
 * <p>Example: class SignRankTest.</p>
 * <p>Data Source: Hollander, M. and Wolfe, D. A. (1999).
 *    Nonparametric Statistical Methods. John Wiley and Sons, INC., p. 41. </p>
 */

public class SignRankTestExample
{

	public static void main(String arg[])
	{
		double[] testdata1 = {750,350,250};
		DataManager dm = new DataManager();

		SignRankTest testclass1 = new SignRankTest(testdata1);
		double tAlpha = testclass1.tAlpha;
		double testStatistic = testclass1.testStatistic;
		double pValue = testclass1.pValue;

		SignRankTest testclass2 = new SignRankTest();
		testStatistic = testclass2.testStatistic(0, testdata1);
		tAlpha = testclass2.tAlpha(0.05, 0, testdata1);
		pValue = testclass2.pValue(0, "greater", testdata1);
		System.out.println(testStatistic+"=="+tAlpha+"=="+pValue);
		Hashtable argument1 = new Hashtable();
		argument1.put(ALPHA, 0.02);
		argument1.put(NULL_VALUE, 0);
		argument1.put(SIDE, "greater");
		StatisticalAnalysis testclass3 =
				new SignRankTest(argument1, testdata1).statisticalAnalysis;
		tAlpha = (Double) testclass3.output.get(TALPHA);
		testStatistic = (Double) testclass3.output.get(TEST_STATISTIC);
		pValue = (Double) testclass3.output.get(PVALUE);
		System.out.println(testStatistic+"=="+tAlpha+"=="+pValue);
		Hashtable argument2 = new Hashtable();
		SignRankTest testclass4 = new SignRankTest(argument2, null);
		argument2.put(NULL_VALUE, 100.0);
		testStatistic = testclass4.testStatistic(argument2, testdata1);
		tAlpha = testclass4.tAlpha(argument2, testdata1);
		argument2.put(SIDE, "equal");
		pValue = testclass4.pValue(argument2, testdata1);
		System.out.println(testStatistic+"=="+tAlpha+"=="+pValue);
	}

}
