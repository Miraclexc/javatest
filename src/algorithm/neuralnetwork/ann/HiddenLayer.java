package algorithm.neuralnetwork.ann;

import java.util.Random;

//隐藏层
public class HiddenLayer extends Layer {
	public HiddenLayer(Neuron[] neurons, IActivationFunction activationFunction) {
		super(neurons, activationFunction);
	}
	
	public HiddenLayer(int numberOfNeuron, int weightInSize, int weightOutSize, IActivationFunction activationFunction, Random random) {
		this(ANNUtil.randomNeurons(numberOfNeuron, weightInSize, weightOutSize, random), activationFunction);
	}
	
	public double calculateSingle(double param, int neuronIndex, int weightIndex) {
		return param * this.neurons[neuronIndex].getWeightIn(weightIndex);
	}
}
