package tools.classin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class JavaClassObject extends SimpleJavaFileObject {
	protected final ByteArrayOutputStream bos = new ByteArrayOutputStream();
	
	public JavaClassObject(String name, Kind kind) {
		super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
	}
	
	public byte[] getBytes() {
		return bos.toByteArray();
	}
	
	public OutputStream openOutputStream() throws IOException {
		return bos;
	}
	
	protected void finalize() throws Throwable {
		super.finalize();
		bos.close();
	}
}
