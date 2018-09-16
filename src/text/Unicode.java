package text;

public class Unicode {
	public static String cnToUnicode(String cn) {
		char[] chars = cn.toCharArray();
	    String returnStr = "";
	    for (int i = 0; i < chars.length; i++) {
	      returnStr += "\\u" + Integer.toString(chars[i], 16);
	    }
	    return returnStr;
	}
	
	public static String unicodeToCn(String unicode) {
	    String[] strs = unicode.split("\\\\u");
	    String returnStr = "";
	    for (int i = 1; i < strs.length; i++) {
	      returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
	    }
	    return returnStr;
	}
}
