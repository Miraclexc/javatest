package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	public File file;
	
	public FileManager(String name) {
		this(new File(name));
	}
	
	public FileManager(File file) {
		this.file = file;
	}
	
	public String[] toArray(String encode) {
		try {
			BufferedReader i = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
			String line = null;
			List<String> str = new ArrayList<String>();
			while((line = i.readLine()) != null) {
				str.add(line);
			}
			i.close();
			return FileManager.listToArray(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[] listToArray(List<String> list) {
		String[] str = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			str[i] = list.get(i);
		}
		return str;
	}
}
