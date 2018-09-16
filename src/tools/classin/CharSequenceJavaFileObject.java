package tools.classin;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class CharSequenceJavaFileObject extends SimpleJavaFileObject {
	private String content;
	/*String fullName = "test.testclass.MyClass";
		String src = "package test.testclass; public class MyClass {public String say(String str){return \"hello\"+str;}}";
		
		DynamicEngine de = DynamicEngine.getInstance();
		Object instance =  de.javaCodeToObject(fullName,src);
		
		System.out.println(instance);*/
	public CharSequenceJavaFileObject(String className, String content) {
		super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
		this.content = content;
	}
	
	public String getCharContent(boolean ignoreEncodingErrors) {
		return content;
	}
}
