package algorithm.neuralnetwork.ann;

public interface ILossFunction {
	public static CrossEntropy CROSSENTROPY = new CrossEntropy();
	
	public double lossFunction(double netResult, double realResult);
	
	public class ZeroAndOne implements ILossFunction {
		@Override
		public double lossFunction(double netResult, double realResult) {
			if(netResult == realResult) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	public class Quadratic implements ILossFunction {
		@Override
		public double lossFunction(double netResult, double realResult) {
			return Math.pow(netResult - realResult, 2) / 2;
		}
	}
	
	public class Absolute implements ILossFunction {
		@Override
		public double lossFunction(double netResult, double realResult) {
			return Math.abs(netResult - realResult);
		}
	}
	
	public class CrossEntropy implements ILossFunction {
		@Override
		public double lossFunction(double netResult, double realResult) {
			return realResult * Math.log(netResult) + (1 - realResult) * Math.log(1 - netResult);
		}
	}
}
