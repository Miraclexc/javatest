package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rename {
	public static void ren(File file, String operation, String after) {
		List<String> str = new ArrayList<String>();
		
		try {
			BufferedReader i = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line = null;
			while((line = i.readLine()) != null) {
				str.add(line);
			}
			i.close();
			
			List<String> strl = new ArrayList<String>();
			for(String s:str) {
				strl.add(s.replaceAll("operation", "after"));
			}
			
			System.out.println(strl);
			BufferedWriter o = new BufferedWriter(new FileWriter(file));
			Iterator<String> it = strl.iterator();
			while(it.hasNext()) {
				o.write(it.next().toString());
				o.newLine();
			}
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
