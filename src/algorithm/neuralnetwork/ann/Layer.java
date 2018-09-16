package algorithm.neuralnetwork.ann;

import java.util.Arrays;
import java.util.stream.IntStream;

//层-未定义
public class Layer {
	//该层神经元
	protected Neuron[] neurons;
	//激活函数
	protected IActivationFunction activationFunction;
	
	public Layer(Neuron[] neurons, IActivationFunction activationFunction) {
		this.neurons = neurons;
		this.activationFunction = activationFunction;
	}

	/*public double[] passTo(double[] param, Layer passed) {
		double[] paramIn = new double[passed.getNumberOfNeurons()];
		IntStream.range(0, param.length).forEach(i -> IntStream.range(0, passed.getNumberOfNeurons()).forEach(j -> paramIn[j] = paramIn[j] + passed.getNeuron(j).calculateSingle(param[i], i)));
		IntStream.range(0, paramIn.length).forEach(i -> paramIn[i] = passed.getActivationFunction().activationFunction(paramIn[i]));
		return paramIn;
	}*/
	
	public double outputValue(double[] param, int weightIndex) {
		return this.activationFunction.activationFunction(this.calculateLayerValue(param, weightIndex));
	}
	
	public double calculateLayerValue(double[] param, int weightIndex) {
		return IntStream.range(0, param.length).mapToDouble(i -> getNeuron(i).getWeightOut(weightIndex) * param[i]).sum();
	}
	
	public Neuron getNeuron(int index) {
		return this.neurons[index];
	}
	
	public int getNumberOfNeurons() {
		return this.neurons.length;
	}

	public void setNeurons(Neuron[] neurons) {
		this.neurons = neurons;
	}
	
	public IActivationFunction getActivationFunction() {
		return this.activationFunction;
	}

	public void setActivationFunction(IActivationFunction activationFunction) {
		this.activationFunction = activationFunction;
	}
	
	public String toString() {
		return "{neurons:" + Arrays.toString(this.neurons) + "}";
	}
}
