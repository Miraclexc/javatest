package algorithm.neuralnetwork.ann;

import java.util.Arrays;
import java.util.Random;

//神经元
public class Neuron {
	//输入权值
	private double[] weightIns;
	//输出权值
	private double[] weightOuts;
	
	public Neuron(double[] weightIns, double[] weightOuts) {
		this.weightIns = weightIns;
		this.weightOuts = weightOuts;
	}
	
	public Neuron(int weightInSize, int weightOutSize, Random random) {
		this(ANNUtil.randomWeight(weightInSize, random), ANNUtil.randomWeight(weightOutSize, random));
	}
	
	public double calculateSingle(double param, int weightIndex) {
		return param * this.weightIns[weightIndex];
	}
	
	/**
	 * 获取指定索引的输入权值
	 */
	public double getWeightIn(int index) {
		return this.weightIns[index];
	}
	
	/**
	 * 获取指定索引的输出权值
	 */
	public double getWeightOut(int index) {
		return this.weightOuts[index];
	}
	
	public double[] getWeightIns() {
		return this.weightIns;
	}

	public void setWeightIns(double[] weightIns) {
		this.weightIns = weightIns;
	}

	public double[] getWeightOuts() {
		return this.weightOuts;
	}

	public void setWeightOuts(double[] weightOuts) {
		this.weightOuts = weightOuts;
	}
	
	public String toString() {
		return "{weightIn:" + Arrays.toString(this.weightIns) + ",weightOut:" + Arrays.toString(this.weightOuts) + "}";
	}
}
