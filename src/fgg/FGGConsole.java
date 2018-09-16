package fgg;

import java.util.Scanner;

public class FGGConsole {
	public FGGConsole() {
		start();
	}
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		FGGType random = FGGSystem.randomFG();
		
		FGGSystem.print("���ȭ");
		FGGType player = FGGSystem.cnToType(sc.nextLine());
		
		FGGResult result = FGGResult.determineSOF(player, random);
		FGGSystem.print(FGGResult.resultToCN(result));
		
		FGGSystem.print("�Ƿ������");
		if(sc.nextLine().equals("��")) {
			new FGGConsole();
		}
		sc.close();
	}
}
