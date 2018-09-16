package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import console.command.ICommandListener;
import tools.array.ArrayTools;

public class ConsoleInputHelper {
	private static List<ConsoleInputHelper.input> monitors = new ArrayList<ConsoleInputHelper.input>();
	private static Map<String, ICommandListener> commandListener = new HashMap<String, ICommandListener>();
	public static boolean close = false;
	
	public static void init() {
		Thread t = new Thread("consoleInputHelper") {
			public void run() {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				while(!close) {
					String str = "";
					try {
						str = br.readLine();
						if(str == null) {
							continue;
						}
					} catch (IOException e) {
						e.printStackTrace();
						close = true;
					}
					for(ConsoleInputHelper.input member : monitors) {
						member.handleInput(str);
					}
					
					String[] strA = str.split(" ");
					String head = strA[0];
					String[] param = ArrayTools.cloneStringArray(strA, 1, strA.length);
					for(Entry<String, ICommandListener> entry : commandListener.entrySet()) {
						entry.getValue().onExecute(head, param);
					}
				}
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
	
	public static void registerInputMonitor(ConsoleInputHelper.input monitor) {
		ConsoleInputHelper.monitors.add(monitor);
	}
	
	public static void removeInputMonitor(ConsoleInputHelper.input monitor) {
		ConsoleInputHelper.monitors.remove(monitor);
	}
	
	public static void registerCommandListener(String head, ICommandListener listener) {
		ConsoleInputHelper.commandListener.put(head, listener);
	}
	
	public static void removeCommandListener(String head) {
		ConsoleInputHelper.commandListener.remove(head);
	}
	
	public interface input {
		public void handleInput(String input);
	}
}
