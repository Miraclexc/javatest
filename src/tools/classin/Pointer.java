package tools.classin;

public class Pointer<T> {
	private T value;
	
	public Pointer(T value) {
		this.value = value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public Pointer<T> clone() {
		return new Pointer<T>(this.value);
	}
}
