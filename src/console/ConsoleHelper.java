package console;

public class ConsoleHelper implements ConsoleInputHelper.input {
	public static void init() {
		ConsoleInputHelper.registerInputMonitor(new ConsoleHelper());
	}
	
	@Override
	public void handleInput(String input) {
		if(!input.equals("hello")) {
			System.out.println(input);
		} else {
			System.out.println("Start world");
		}
	}
}
