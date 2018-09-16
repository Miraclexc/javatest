package text;

public class TextUtil {
	public static String fortext(String string, int count) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<count;i++) {
			sb.append(string);
		}
		
		return sb.toString();
	}
}
