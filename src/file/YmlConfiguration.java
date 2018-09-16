package file;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class YmlConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Map<String, Object> root;
	
	public YmlConfiguration(String[] config) {
		this(config, 2);
	}
	
	public YmlConfiguration(String[] config, int spaceCount) {
		YMLReader.space = spaceCount;
		this.root = new HashMap<String, Object>();
		YMLReader.reader(config, this.root, 0);
	}
	
	public Object getValue(String key) {
		String[] keys = key.split("\\.");
		Map<String, Object> map = this.root;
		for(int i=0;i<keys.length;i++) {
			if(i == keys.length-1) {
				return map.get(keys[i]);
			} else if(map.get(keys[i]) instanceof Map) {
				map = (Map<String, Object>)map.get(keys[i]);
			} else {
				return null;
			}
		}
		
		return null;
	}
	
	public String getValueAsString(String key) {
		Object value = this.getValue(key);
		if(value != null) {
			String str = (String)value;
			if((str.substring(0, 1).equals("\"") && str.substring(str.length() - 1, str.length()).equals("\"")) || (str.substring(0, 1).equals("'") && str.substring(str.length() - 1, str.length()).equals("'"))) {
				return str.substring(1, str.length()-1);
			}
			return null;
		}
		return null;
	}
	
	public Integer getValueAsInteger(String key) {
		Object value = this.getValue(key);
		if(value != null) {
			String str = (String)value;
			try {
				return Integer.parseInt(str);
			} catch(NumberFormatException e) {
				return null;
			}
		}
		
		return null;
	}
	
	public Boolean getValueAsBoolean(String key) {
		Object value = this.getValue(key);
		if(value != null) {
			String str = (String)value;
			if(str.equalsIgnoreCase("true")) {
				return true;
			} else if(str.equalsIgnoreCase("false")) {
				return false;
			}
		}
		
		return null;
	}
}
