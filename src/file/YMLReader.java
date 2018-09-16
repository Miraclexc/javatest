package file;

import java.util.HashMap;
import java.util.Map;

public class YMLReader {
	public static int space = 2;
	
	public static Map<String, Object> readArray(String[] array) {
		Map<String, Object> root = new HashMap<String, Object>();
		YMLReader.reader(array, root, 0);
		return root;
	}
	
	public static void reader(String[] array, Map<String, Object> map, int interval) {
		for(int i=0;i<array.length;i++) {
			String str = array[i];
			if(!str.replaceAll(" ", "").isEmpty()) {
				int count = YMLReader.getSpaceCount(str);
				
				if(count == interval) {
					if(YMLReader.getValue(str).replaceAll(" ", "").isEmpty()) {
						Map<String, Object> parent = new HashMap<String, Object>();
						YMLReader.reader(YMLReader.subArray(array, i+1, array.length-1), parent, interval + YMLReader.space);
						map.put(YMLReader.clearSpace(YMLReader.getKey(str)), parent);
					} else {
						map.put(YMLReader.clearSpace(YMLReader.getKey(str)), YMLReader.getValue(str));
					}
				} else if(count < interval) {
					return;
				}
			}
		}
	}
	
	public static int getSpaceCount(String string) {
		int count = 0;
		for(int i=0;i<string.length();i++) {
			if(string.substring(i, i+1).equals(" ")) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	
	public static String clearSpace(String string) {
		int count = YMLReader.getSpaceCount(string);
		return string.substring(count, string.length());
	}
	
	public static String getKey(String string) {
		if(string.indexOf(":") >= 0) {
			return string.substring(0, string.indexOf(":"));
		}
		
		return string;
	}
	
	public static String getValue(String string) {
		if(string.indexOf(":") >= 0) {
			return string.substring(string.indexOf(":") + 1, string.length());
		}
		
		return "";
	}
	
	public static String[] subArray(String[] array, int start, int end) {
		if(start > end) {
			start = end;
			end = start;
		}
		String[] newArray = new String[end - start + 1];
		int index = 0;
		for(int i=start;i<=end;i++) {
			newArray[index] = array[i];
			index++;
		}
		
		return newArray;
	}
}
