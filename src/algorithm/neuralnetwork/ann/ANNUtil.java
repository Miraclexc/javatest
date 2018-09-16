package algorithm.neuralnetwork.ann;

import java.util.Random;
import java.util.stream.IntStream;

public class ANNUtil {
	//随机生成权值数组
	public static double[] randomWeight(int size, Random random) {
		double[] weight = new double[size];
		IntStream.range(0, size).forEach(i -> weight[i] = random.nextDouble());
		return weight;
	}
	
	public static Neuron[] randomNeurons(int size, int weightInSize, int weightOutSize, Random random) {
		Neuron[] neurons = new Neuron[size];
		IntStream.range(0, size).forEach(i -> neurons[i] = new Neuron(weightInSize, weightOutSize, random));
		return neurons;
	}
}
