package algorithm.other;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class OtherMain {
	public static void main(String[] args) {
		long curr = System.currentTimeMillis();
		BigInteger[] r = FibonacciSequence.calculate(100000);
		try {
			BufferedOutputStream fw = new BufferedOutputStream(new FileOutputStream("F:\\t.txt"));
			for(BigInteger str : r) {
				fw.write((str.toString() + "\n").getBytes("UTF-8"));
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BigDecimal b1 = new BigDecimal(r[r.length-2]);
		BigDecimal b2 = new BigDecimal(r[r.length-1]);
		System.out.println(b1.divide(b2,16,BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println((System.currentTimeMillis() - curr));
	}
}
