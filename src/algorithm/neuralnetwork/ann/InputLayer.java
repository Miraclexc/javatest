package algorithm.neuralnetwork.ann;

import java.util.Random;

//输入层
public class InputLayer extends Layer {
	public InputLayer(Neuron[] neurons, IActivationFunction activationFunction) {
		super(neurons, activationFunction);
	}
	
	public InputLayer(int NumberOfNeuron, int weightOutSize, IActivationFunction activationFunction, Random random) {
		this(ANNUtil.randomNeurons(NumberOfNeuron, 1, weightOutSize, random), activationFunction);
	}
}
