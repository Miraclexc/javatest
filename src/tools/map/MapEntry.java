package tools.map;

public class MapEntry<K,V> {
	private Object[] kv = new Object[1];
	
	public MapEntry(K key, V value) {
		this.kv[0] = key;
		this.kv[1] = value;
	}
	
	public void setKey(K key) {
		this.kv[0] = key;
	}
	
	public void setValue(V value) {
		this.kv[1] = value;
	}
	
	@SuppressWarnings("unchecked")
	public K getKey() {
		return (K)this.kv[0];
	}
	
	@SuppressWarnings("unchecked")
	public V getValue() {
		return (V)this.kv[1];
	}
}
