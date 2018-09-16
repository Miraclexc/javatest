package algorithm.neuralnetwork.ann;

import java.util.Random;

//输出层
public class OutputLayer extends Layer {
	public OutputLayer(Neuron[] neurons, IActivationFunction activationFunction) {
		super(neurons, activationFunction);
	}
	
	public OutputLayer(int NumberOfNeuron, int weightInSize, IActivationFunction activationFunction, Random random) {
		this(ANNUtil.randomNeurons(NumberOfNeuron, weightInSize, 1, random), activationFunction);
	}
}
