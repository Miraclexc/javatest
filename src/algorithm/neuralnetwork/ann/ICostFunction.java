package algorithm.neuralnetwork.ann;

import java.util.stream.IntStream;

public interface ICostFunction {
	public static Loss CROSSENTROPY = new Loss(ILossFunction.CROSSENTROPY);
	
	public double costFunction(double[][] netResults, double[][] realResults);
	
	public class Loss implements ICostFunction {
		private ILossFunction lossFunction;
		
		public Loss(ILossFunction lossFunction) {
			this.lossFunction = lossFunction;
		}
		
		@Override
		public double costFunction(double[][] netResults, double[][] realResults) {
			return IntStream.range(0, netResults.length).mapToDouble(i -> IntStream.range(0, netResults[i].length).mapToDouble(j -> lossFunction.lossFunction(netResults[i][j], realResults[i][j])).sum()).sum() / netResults.length;
		}

		public ILossFunction getLossFunction() {
			return this.lossFunction;
		}

		public void setLossFunction(ILossFunction lossFunction) {
			this.lossFunction = lossFunction;
		}
	}
}
