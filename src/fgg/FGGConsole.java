package fgg;

import java.util.Scanner;

public class FGGConsole {
	public FGGConsole() {
		start();
	}
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		FGGType random = FGGSystem.randomFG();
		
		FGGSystem.print("请出拳");
		FGGType player = FGGSystem.cnToType(sc.nextLine());
		
		FGGResult result = FGGResult.determineSOF(player, random);
		FGGSystem.print(FGGResult.resultToCN(result));
		
		FGGSystem.print("是否继续？");
		if(sc.nextLine().equals("是")) {
			new FGGConsole();
		}
		sc.close();
	}
}
