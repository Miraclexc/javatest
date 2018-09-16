package algorithm.neuralnetwork.ann;

public interface IActivationFunction {
	public static Null NULL = new Null();
	public static Sigmoid SIGMOID = new Sigmoid();
	public static HyperbolicTangent HYPERBOLICTANGENT = new HyperbolicTangent();
	public static BinaryStep BINARYSTEP = new BinaryStep();
	
	public double activationFunction(double netValue);
	
	public class Null implements IActivationFunction {
		@Override
		public double activationFunction(double netValue) {
			return netValue;
		}
	}
	
	public class Sigmoid implements IActivationFunction {
		@Override
		public double activationFunction(double netValue) {
			return 1 / (1 + Math.pow(Math.E, -netValue));
		}
	}
	
	public class HyperbolicTangent implements IActivationFunction {
		@Override
		public double activationFunction(double netValue) {
			/*double ex = Math.pow(Math.E, 2 * netValue);
			return (ex - 1) / (ex + 1);*/
			double ex = Math.pow(Math.E, -netValue);
			return (1 - ex) / (1 + ex);
		}
	}
	
	public class BinaryStep implements IActivationFunction {
		@Override
		public double activationFunction(double netValue) {
			if(netValue < 0) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
