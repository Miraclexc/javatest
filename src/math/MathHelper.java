package math;

public class MathHelper {
	public static int floor(double number) {
		int value = (int) number;
		if(value > number) {
			return value - 1;
		} else {
			return value;
		}
	}
	
	public static int ceil(double number) {
		int value = (int) number;
		if(value > number) {
			return value;
		} else {
			return value + 1;
		}
	}
}
