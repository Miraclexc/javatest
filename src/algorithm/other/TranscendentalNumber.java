package algorithm.other;

import java.math.BigDecimal;

public class TranscendentalNumber {
	public static double calculateE(int count) {
		BigDecimal part = new BigDecimal(1).divide(new BigDecimal(count));
		BigDecimal e = new BigDecimal(1);
		for(int i=1;i<=count;i++) {
			e = e.multiply(part.add(new BigDecimal(1)));
		}
		
		return e.doubleValue();
	}
}
