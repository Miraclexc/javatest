package math;

import java.util.ArrayList;
import java.util.List;

public class Sort {
	//从小到大排列
	public final static double[] num = {0.152, 0.654, 0.158, 0.98, 0.1, 0.352, 0.155, 0.635, 0.7, 0.654};
	public final static double[] result = new double[9];
	
	public static void get() {
		List<Double> list = new ArrayList<Double>(1000);
		//list.addAll(1000, new Double(0));
		for(double o : num) {
			list.set((int)o*1000, o);
		}
		
		int i = 0;
		for(Double n : list) {
			if(n != null && !n.isNaN()) {
				result[i] = n;
				i++;
			} 
		}
		
		System.out.println(result.toString());
	}
}
