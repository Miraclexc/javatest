package tools.file;

import java.io.FileWriter;
import java.io.IOException;

public class FileTools {
	public static void printToFile(String string, String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(string);
			fw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
