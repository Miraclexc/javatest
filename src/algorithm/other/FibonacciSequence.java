package algorithm.other;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FibonacciSequence {
	/* 黄金比
	 * long[] r = FibonacciSequence.calculate(91);
		System.out.println(Arrays.toString(r));
		BigDecimal b1 = new BigDecimal(r[r.length-2]);
		BigDecimal b2 = new BigDecimal(r[r.length-1]);
		System.out.println(b1.divide(b2,16,BigDecimal.ROUND_HALF_UP).doubleValue());*/
	public static BigInteger[] calculate(int count) {
		BigInteger[] list = new BigInteger[count];
		for(int i=0;i<count;i++) {
			if(i == 0 || i == 1) {
				list[i] = BigInteger.valueOf(1);
			} else {
				list[i] = list[i-2].add(list[i-1]);
			}
		}
		
		return list;
	}
	
	public static void writeFS(int count) {
		long curr = System.currentTimeMillis();
		BigInteger[] r = FibonacciSequence.calculate(count);
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
