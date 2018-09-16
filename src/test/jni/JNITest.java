package test.jni;

public class JNITest {
	public native static String teststr();
	
	public native static void print(String string);
	
	public static void main(String[] args) {
		System.loadLibrary("JniTest");
		System.out.println(JNITest.teststr());
		JNITest.print("qwq");
	}
}