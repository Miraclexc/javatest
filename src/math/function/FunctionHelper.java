package math.function;

import java.util.function.Function;

public class FunctionHelper {
	public static double getZeroPointByBisection(Function<Double, ? extends Double> function, double point1, double point2, double accuracy) {
		double a = point1;
		double b = point2;
		double c = 0;
		if(a == b) {
			return a;
		} else if(a > b) {
			double temp = a;
			a = b;
			b = temp;
		}
		
		while(Math.abs(a - b) > accuracy) {
			c = (a + b) / 2;
			double fc = function.apply(c);
			double fa = function.apply(a);
			double fb = function.apply(b);
			if(fa * fc < 0) {
				b = c;
				continue;
			} else if(fc * fb < 0) {
				a = c;
				continue;
			} else if(fc == 0) {
				return c;
			} else if(fa == 0) {
				return a;
			} else if(fb == 0) {
				return b;
			} else {
				System.out.println("no zero point.");
				break;
			}
		}
		return a;
	}
}
