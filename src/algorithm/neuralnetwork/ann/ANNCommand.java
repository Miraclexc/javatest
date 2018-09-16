package algorithm.neuralnetwork.ann;

import java.util.Arrays;
import java.util.stream.IntStream;

import console.command.ICommandListener;

public class ANNCommand implements ICommandListener {
	public NeuralNet neuralNet;
	
	public ANNCommand(NeuralNet neuralNet) {
		this.neuralNet = neuralNet;
	}
	
	@Override
	public void onExecute(String head, String[] param) {
		if("ann".equals(head)) {
			if(param.length == 0) {
				this.sendHelp();
				return;
			}
			
			switch(param[0]) {
			case "calculate":
				if(param.length == 1) {
					this.sendHelp();
				}
				double[] paramD = new double[param.length - 1];
				IntStream.range(1, param.length).forEach(i -> paramD[i - 1] = Double.parseDouble(param[i]));
				try {
					System.out.println(Arrays.toString(this.neuralNet.getResult(paramD)));
				} catch(IllegalArgumentException e) {
					System.out.println("请输入正确长度的参数");
					System.out.println("参数的正确长度：" + this.neuralNet.getInputLayer().getNumberOfNeurons());
				}
				break;
			case "weights":
				System.out.println("inputLayer:" + this.neuralNet.getInputLayer().toString());
				System.out.println("hiddenLayers:" + Arrays.toString(this.neuralNet.getHiddenLayers()));
				System.out.println("outputLayer:" + this.neuralNet.getOutputLayer().toString());
				break;
			case "train":
				if(param.length == 1) {
					this.sendHelp();
				}
				for(int i=0;i<Integer.parseInt(param[1]);i++) {
					this.neuralNet.getTrainer().train(this.neuralNet, new double[][] {{1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}}, new double[][] {{0}, {0}, {0}, {1}}, ICostFunction.CROSSENTROPY);
				}
				break;
			default:
				this.sendHelp();
				break;
			}
		}
	}
	
	public void sendHelp() {
		System.out.println("人工神经网络命令：");
		System.out.println("ann calculate (参数) -- 根据参数计算出值");
		System.out.println("ann weights -- 显示所有神经元的权值");
	}
}
