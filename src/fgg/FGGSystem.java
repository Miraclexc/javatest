package fgg;

import java.io.PrintStream;
import java.util.Random;

public class FGGSystem {
	private static PrintStream console = System.out;
	
	public static String STONE = "Ê¯Í·";
	public static String SHEAR = "¼ôµ¶";
	public static String CLOTH = "²¼";
	
	
	public static FGGType randomFG() {
		int random = new Random().nextInt(3);
		return FGGType.getTypeFromId(random);
	}
	
	public static void print(String string) {
		console.println(string);
	}
	
	public PrintStream getConsole() {
		return console;
	}
	
	public static FGGType cnToType(String name) {
		if(name.equals(STONE)) {
			return FGGType.STONE;
		} else if(name.equals(SHEAR)) {
			return FGGType.SHEAR;
		} else if(name.equals(CLOTH)) {
			return FGGType.CLOTH;
		}
		
		return FGGType.EMPTY;
	}
}
