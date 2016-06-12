package matrix;

public class MultiLinearRegression {

	public static void main(String[] args) throws NoSquareException {
		Matrix X = new Matrix(new double[][]{{850},{650}});
		Matrix Y = new Matrix(new double[][]{{1000},{1000}});
		MultiLinear ml = new MultiLinear(X, Y);
		Matrix beta = ml.calculate();
		double[][] data=beta.getValues();
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				System.out.println(data[i][j]);
			}
		}

	}
	
	

}
