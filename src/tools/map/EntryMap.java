package tools.map;

import java.util.ArrayList;
import java.util.List;

public class EntryMap<K,V> {
	private List<MapEntry<K,V>> map = new ArrayList<MapEntry<K,V>>();
	private V NoNullValue;
	
	public EntryMap() {
		this(null);
	}
	
	public EntryMap(V NoNullValue) {
		this.NoNullValue = NoNullValue;
	}
	
	public void set(K key, V value) {
		for(int i = 0;i < map.size();i++) {
			if(map.get(i) != null) {
				if(key.equals(map.get(i).getKey())) {
					map.get(i).setValue(value);
				}
				
				map.add(new MapEntry<K,V>(key, value));
			} else {
				map.remove(i);
			}
		}
	}
	
	public V get(K key) {
		for(int i = 0;i < map.size();i++) {
			if(map.get(i) != null) {
				if(key.equals(map.get(i).getKey())) {
					return map.get(i).getValue();
				}
			} else {
				map.remove(i);
			}
		}
		
		return this.NoNullValue;
	}
	
	public void remove(K key) {
		for(int i = 0;i < map.size();i++) {
			if(map.get(i) != null) {
				if(key.equals(map.get(i).getKey())) {
					map.remove(i);
				}
			} else {
				map.remove(i);
			}
		}
	}
	
	public boolean isEmpty(K key) {
		for(int i = 0;i < map.size();i++) {
			if(map.get(i) != null) {
				if(key.equals(map.get(i).getKey())) {
					return false;
				}
			} else {
				map.remove(i);
			}
		}
		
		return true;
	}
}
