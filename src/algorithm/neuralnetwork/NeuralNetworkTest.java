package algorithm.neuralnetwork;

import algorithm.neuralnetwork.ann.ANNCommand;
import algorithm.neuralnetwork.ann.IActivationFunction;
import algorithm.neuralnetwork.ann.NeuralNet;
import algorithm.neuralnetwork.ann.Trainer;
import console.ConsoleInputHelper;

public class NeuralNetworkTest {
	public static void main(String[] string) {
		NeuralNet neuralNet = NeuralNet.init(1, 3, 3, 1, IActivationFunction.SIGMOID);
		neuralNet.setTrainer(new Trainer(0.25, 0.4));
		ConsoleInputHelper.registerCommandListener("ann", new ANNCommand(neuralNet));
		ConsoleInputHelper.init();
	}
}
