package text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
	public static void test(String regexp, String string) {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(string);
		while(m.find()) {
			System.out.println(m.group());
		}
	}
}
