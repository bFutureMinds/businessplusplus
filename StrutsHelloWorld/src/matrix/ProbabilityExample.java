package matrix;

import static java.lang.System.out;

import java.util.*;

import net.viralpatel.struts2.MongoDBJDBC;
import javastat.*;
import javastat.probability.*;
import static javastat.util.Argument.*;
import static javastat.util.DistributionType.*;
import static javastat.util.Output.*;
 
/**
 *
 * <p>Example: class Probability.</p>
 */
 
public class ProbabilityExample
{
 
    public static void main(String arg[])
    {
    	for(Double i:calc(false)){
    		System.out.println(i*10000);
    	}
    }
    
    public static double[][] setval(boolean flag){
    	
    	if(flag){
    		double[][] input=new double[10][2];
        	input[0][0]=825;input[0][1]=850;input[5][0]=200;input[5][1]=37;
    		input[1][0]=750;input[1][1]=625;input[6][0]=450;input[6][1]=950;
    		input[2][0]=650;input[2][1]=680;input[7][0]=562;input[7][1]=450;
    		input[3][0]=500;input[3][1]=499;input[8][0]=950;input[8][1]=950;
    		input[4][0]=200;input[4][1]=247;input[9][0]=450;input[9][1]=450;
    		return input;
    	 /*input={{825, 850},{750, 625},{650, 680},{500, 499},{200, 247},{200,37},{450,950},{562,450},{950,950},{450,450}};*/
    	}
    	else{
    		double[][] input=new double[14][2];
        	input[0][0]=825;input[0][1]=850;input[5][0]=200;input[5][1]=37;
    		input[1][0]=750;input[1][1]=625;input[6][0]=450;input[6][1]=950;
    		input[2][0]=650;input[2][1]=680;input[7][0]=562;input[7][1]=450;
    		input[3][0]=500;input[3][1]=499;input[8][0]=950;input[8][1]=950;
    		input[4][0]=200;input[4][1]=247;input[9][0]=450;input[9][1]=450;
    		try{
    		double val[][]=MongoDBJDBC.dbcall();
    		int ii=0;int ji=0;
    		for(int i=10;i<14;i++){
    			for(int j=0;j<2;j++){
    				input[i][j]=val[ii][ji];
    				if(ji==1) input[i][j]=(val[ii][ji]/1000) + 500;
    				ji++;
    				System.out.print(input[i][j]+"=");
    			}
    			System.out.println();
    			ji=0;ii++;
    		}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		return input;
    	}
    }
    
    public static List<Double> calc(boolean flag){
    	List<Double> df=new ArrayList<Double>();
    	double return1=0.0;
    	double[][] input=setval(flag);
    	
    		
for(int i=0;i<input.length;i++){
        double[] normalPara =input[i];
        double[] normalPercentiles = {1 -1.96 * 2, 1 + 1.96 * 2};
        double normalX = normalPara[0];
        double normalProb = 0.90;
        Probability normal =
            new Probability(NORMAL, normalPara, normalPercentiles,
normalX, normalProb);
     //   System.out.println("return="+normal.cumulative);
        df.add(i,normal.cumulative);
        return1=normal.cumulative;
 /*
        double[] betaPara = {2.0, 3.0};
        double[] betaPercentiles = {0.0, 0.5};
        double betaX = 0.5;
        double betaProb = 0.90;
        Probability beta =
            new Probability(BETA, betaPara, betaPercentiles, betaX,
betaProb);
 
        double[] binomialPara = {10.0, 0.3};
        double[] binomialPercentiles = {0.0, 5.0};
        double binomialX = 5.0;
        double binomialProb = 0.96;
        Probability binomial =
            new Probability(BINOMIAL, binomialPara, binomialPercentiles,
                          binomialX, binomialProb);
 
        double[] cauchyPara = {0.0, 1.0};
        double[] cauchyPercentiles = {-2.0, 2.0};
        double cauchyX = 0.0;
        double cauchyProb = 0.90;
        Probability cauchy =
            new Probability(CAUCHY, cauchyPara, cauchyPercentiles,
cauchyX, cauchyProb);
 
        double[] chisquarePara = {1.0};
        double[] chisquarePercentiles = {1.0, 2.0};
        double chisquareX = 1.0;
        double chisquareProb = 0.90;
        Probability chisquare =
            new Probability(CHISQUARE, chisquarePara, chisquarePercentiles,
chisquareX, chisquareProb);
 
        double[] exponentialPara = {2.0};
        double[] exponentialPercentiles = {1.0, 2.0};
        double exponentialX = 1.0;
        double exponentialProb = 0.90;
        Probability exponential =
            new Probability(EXPONENTIAL, exponentialPara,
                          exponentialPercentiles, exponentialX, exponentialProb);
 
        double[] fPara = {2.0, 3.0};
        double[] fPercentiles = {0.0, 4.0};
        double fX = 7.0;
        double fProb = 0.95;
        Probability f = new Probability(F, fPara, fPercentiles, fX, fProb);
 
        double[] gammaPara = {2.0, 3.0};
        double[] gammaPercentiles = {0.0, 2.0};
        double gammaX = 1.0;
        double gammaProb = 0.95;
        Probability gamma =
new Probability(GAMMA, gammaPara, gammaPercentiles,
                          gammaX, gammaProb);
 
        double[] geometricPara = {0.6};
        double[] geometricPercentiles = {0.0, 2.0};
        double geometricX = 1.0;
        double geometricProb = 0.92;
        Probability geometric =
            new Probability(GEOMETRIC, geometricPara,
                          geometricPercentiles, geometricX,
                          geometricProb);
 
        double[] hypergeometricPara = {50, 10, 20};
        double[] hypergeometricPercentiles = {0.0, 4.0};
        double hypergeometricX = 1.0;
        double hypergeometricProb = 0.90;
        Probability hypergeometric =
            new Probability(HYPERGEOMETRIC, hypergeometricPara,
                          hypergeometricPercentiles, hypergeometricX,
                          hypergeometricProb);
 
        double[] lognormalPara = {0.0, 1.0};
        double[] lognormalPercentiles = {0.0, 2.0};
        double lognormalX = 1.0;
        double lognormalProb = 0.95;
        Probability lognormal =
            new Probability(LOGNORMAL, lognormalPara, lognormalPercentiles,
lognormalX, lognormalProb);
 
        double[] negativeBinomialPara = {3.0, 0.7};
        double[] negativeBinomialPercentiles = {0.0, 2.0};
        double negativeBinomialX = 3.0;
        double negativeBinomialProb = 0.95;
        Probability negativeBinomial =
            new Probability(NEGATIVE_BINOMIAL, negativeBinomialPara,
                         negativeBinomialPercentiles, negativeBinomialX,
                         negativeBinomialProb);
        double[] paretoPara = {2.0, 3.0};
        double[] paretoPercentiles = {3.0, 7.0};
        double paretoX = 4.0;
        double paretoProb = 0.9;
        Probability pareto =
            new Probability(PARETO, paretoPara, paretoPercentiles,
                          paretoX, paretoProb);
 
        double[] poissonPara = {5.0};
        double[] poissonPercentiles = {3.0, 7.0};
        double poissonX = 5.0;
        double poissonProb = 0.9;
        Probability poisson =
            new Probability(POISSON, poissonPara, poissonPercentiles,
                          poissonX, poissonProb);
 
        double[] tPara = {9.0};
        double[] tPercentiles = {-2.0, 2.0};
        double tX = 0.0;
        double tProb = 0.95;
        Probability t =
            new Probability(T, tPara, tPercentiles, tX, tProb);
 
        double[] weibullPara = {3.0};
        double[] weibullPercentiles = {0.0, 1.0};
        double weibullX = 1.0;
        double weibullProb = 0.95;
        Probability weibull =
            new Probability(WEIBULL, weibullPara, weibullPercentiles,
weibullX, weibullProb);
 
        Hashtable argument = new Hashtable();
        argument.put(DISTRIBUTION_TYPE, NORMAL);
        argument.put(DISTRIBUTION_PARAMETER, normalPara);
        StatisticalAnalysis testclass1 =
            new Probability(argument, normalPercentiles, normalX,
normalProb).statisticalAnalysis;*/
 
}
return df;
    
    }
 
}