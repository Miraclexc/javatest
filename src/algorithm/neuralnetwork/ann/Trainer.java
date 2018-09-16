package algorithm.neuralnetwork.ann;

import java.util.ArrayList;
import java.util.stream.IntStream;

import tools.array.ArrayTools;

public class Trainer {
	//学习率
	protected double rate;
	//允许误差
	protected double permissibleError;
	
	public Trainer(double rate, double permissibleError) {
		this.rate = rate;
		this.permissibleError = permissibleError;
	}
	
	public void train(NeuralNet neuralNet, double[][] trainSample, double[][] realResults, ICostFunction costFunction) {
		double[][] netResults = new double[trainSample.length][];
		ArrayList<Integer> offset = new ArrayList<Integer>();
		IntStream.range(0, trainSample.length).forEach(i -> {
			double[] result = neuralNet.getResult(trainSample[i]);
			if(IntStream.range(0, result.length).allMatch(j -> Math.abs(result[j] - realResults[i][j]) <= permissibleError)) {
				offset.add(i);
			}
			netResults[i] = result;
		});
		double[][] netResultsF = new double[netResults.length - offset.size()][];
		double[][] realResultsF = new double[realResults.length - offset.size()][];
		int index = 0;
		for(int i : IntStream.range(0, netResults.length).filter(i -> offset.indexOf(i) == -1).toArray()) {
			netResultsF[index] = netResults[i];
			realResultsF[index] = realResults[i];
			index++;
		}
		
		double deltaWeight = this.rate * costFunction.costFunction(netResultsF, realResultsF);
		System.out.println(ArrayTools.doubleDimensionalDoubleToString(netResultsF) + "," + ArrayTools.doubleDimensionalDoubleToString(realResultsF) + deltaWeight);
		IntStream.range(0, neuralNet.getHiddenLayers().length).forEach(i -> IntStream.range(0, neuralNet.getHiddenLayers()[i].getNumberOfNeurons()).forEach(j -> {
			Neuron neuron = neuralNet.getHiddenLayers()[i].getNeuron(j);
			IntStream.range(0, neuron.getWeightIns().length).forEach(k -> neuron.getWeightIns()[k] -= deltaWeight);
			IntStream.range(0, neuron.getWeightOuts().length).forEach(k -> neuron.getWeightOuts()[k] -= deltaWeight);
		}));
		
	}
}
