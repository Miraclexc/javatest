package algorithm.neuralnetwork.ann;

import java.util.Random;
import java.util.stream.IntStream;

//人工神经网络
public class NeuralNet {
	private InputLayer inputLayer;
	private HiddenLayer[] hiddenLayers;
	private OutputLayer outputLayer;
	
	private Trainer trainer;
	
	public NeuralNet(InputLayer inputLayer, HiddenLayer[] hiddenLayers, OutputLayer outputLayer) {
		this.inputLayer = inputLayer;
		this.hiddenLayers = hiddenLayers;
		this.outputLayer = outputLayer;
	}
	
	/**
	 * 初始化一个人工神经网络
	 * @param hiddenLayersSize - 隐藏层数
	 * @param numberOfNeuronI - 输入层神经元数量
	 * @param numberOfNeuronH - 隐藏层神经元数量
	 * @param numberOfNeuronO - 输出层神经元数量
	 * @param activationFunction - 激活函数
	 * @return 初始化后的人工神经网络
	 */
	public static NeuralNet init(int hiddenLayersSize, int numberOfNeuronI, int numberOfNeuronH, int numberOfNeuronO, IActivationFunction activationFunction) {
		Random random = new Random();
		HiddenLayer[] hiddenLayers = new HiddenLayer[hiddenLayersSize];
		if(hiddenLayersSize > 1) {
			IntStream.range(0, hiddenLayersSize).forEach(i -> {
				if(i == 0) {
					hiddenLayers[i] = new HiddenLayer(numberOfNeuronH, numberOfNeuronI, numberOfNeuronH, activationFunction, random);
				} else if(i == hiddenLayersSize - 1) {
					hiddenLayers[i] = new HiddenLayer(numberOfNeuronH, numberOfNeuronH, numberOfNeuronO, activationFunction, random);
				} else {
					hiddenLayers[i] = new HiddenLayer(numberOfNeuronH, numberOfNeuronH, numberOfNeuronH, activationFunction, random);
				}
			});
		} else {
			hiddenLayers[0] = new HiddenLayer(numberOfNeuronH, numberOfNeuronI, numberOfNeuronO, activationFunction, random);
		}
		return new NeuralNet(new InputLayer(numberOfNeuronI, numberOfNeuronH, activationFunction, random), hiddenLayers, new OutputLayer(numberOfNeuronO, numberOfNeuronH, activationFunction, random));
	}
	
	//传入参数并由该人工神经网络计算结果
	public double[] getResult(double[] param) {
		if(this.inputLayer.getNumberOfNeurons() != param.length) {
			throw new IllegalArgumentException("Argument's size didn't equal to inputLayer's size.");
		}
		
		double[] paramIn = param;
		for(int i = 0;i < this.hiddenLayers.length + 2;i++) {
			Layer currentLayer = this.getLayerByIndex(i);
			if(i == this.hiddenLayers.length + 1) {
				double[] newParam = new double[currentLayer.getNumberOfNeurons()];
				for(int j=0;j<newParam.length;j++) {
					newParam[j] = currentLayer.getActivationFunction().activationFunction(currentLayer.getNeuron(j).getWeightIn(0) * paramIn[j]);
				}
				paramIn = newParam;
			} else {
				double[] newParam = new double[this.getLayerByIndex(i + 1).getNumberOfNeurons()];
				for(int j=0;j<newParam.length;j++) {
					newParam[j] = currentLayer.outputValue(paramIn, j);
				}
				paramIn = newParam;
			}
		}
		return paramIn;
	}
	
	public Layer getLayerByIndex(int index) {
		if(index == 0) {
			return this.inputLayer;
		} else if(index == this.hiddenLayers.length + 1) {
			return this.outputLayer;
		} else {
			return this.hiddenLayers[index - 1];
		}
	}
	
	public InputLayer getInputLayer() {
		return this.inputLayer;
	}

	public void setInputLayer(InputLayer inputLayer) {
		this.inputLayer = inputLayer;
	}

	public HiddenLayer[] getHiddenLayers() {
		return this.hiddenLayers;
	}

	public void setHiddenLayers(HiddenLayer[] hiddenLayers) {
		this.hiddenLayers = hiddenLayers;
	}

	public OutputLayer getOutputLayer() {
		return this.outputLayer;
	}

	public void setOutputLayer(OutputLayer outputLayer) {
		this.outputLayer = outputLayer;
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	public NeuralNet setTrainer(Trainer trainer) {
		this.trainer = trainer;
		return this;
	}
}
