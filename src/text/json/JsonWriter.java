package text.json;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonWriter {
	public static String space = "    ";
	
	private BufferedWriter writer;
	private int spaceIndex;
	
	public JsonWriter(BufferedWriter writer) {
		this.writer = writer;
		this.spaceIndex = 0;
	}
	
	public void writeObject(JSONObject jsonObject) throws IOException {
		int index = 1;
		int size = jsonObject.size();
		
		this.writeObjectHead();
		this.newLine();
		this.plusSpaceIndex();
		for(Entry<String, Object> entry : jsonObject.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			
			this.writeSpace();
			if(value instanceof JSONObject) {
				this.writeKey(key);
				this.writeObject((JSONObject) value);
			} else if(value instanceof JSONArray) {
				this.writeKey(key);
				this.writeArray((JSONArray) value);
			} else if(value instanceof String) {
				this.writeString(key, (String) value);
			} else if(value == null) {
				this.writeKey(key);
				this.writeNull();
			} else {
				this.writeElement(key, value.toString());
			}
			
			if(index < size) {
				this.writeComma();
			}
			this.newLine();
			index++;
		}
		this.minusSpaceIndex();
		this.writeSpace();
		this.writeObjectEnd();
	}
	
	public void writeArray(JSONArray jsonArray) throws IOException {
		this.writeArrayHead();
		this.newLine();
		this.plusSpaceIndex();
		for(int i=0;i<jsonArray.size();i++) {
			Object value = jsonArray.get(i);
			
			this.writeSpace();
			if(value instanceof JSONObject) {
				this.writeObject((JSONObject) value);
			} else if(value instanceof JSONArray) {
				this.writeArray((JSONArray) value);
			} else if(value instanceof String) {
				this.writer.write("\"" + serializeString((String) value) + "\"");
			} else if(value == null) {
				this.writeNull();
			} else {
				this.writer.write(value.toString());
			}
			
			if(i < jsonArray.size() - 1) {
				this.writeComma();
			}
			this.newLine();
		}
		this.minusSpaceIndex();
		this.writeSpace();
		this.writeArrayEnd();
	}
	
	public void writeObjectHead() throws IOException {
		this.writer.write("{");
	}
	
	public void writeObjectEnd() throws IOException {
		this.writer.write("}");
	}
	
	public void writeArrayHead() throws IOException {
		this.writer.write("[");
	}
	
	public void writeArrayEnd() throws IOException {
		this.writer.write("]");
	}
	
	public void newLine() throws IOException {
		this.writer.newLine();
	}
	
	public void writeSpace() throws IOException {
		this.writer.write(generateSpace(this.spaceIndex));
	}
	
	/*public void writeElement(String key, Object value) throws IOException {
		this.plusSpaceIndex();
		this.writeSpace();
		if(value instanceof JSONObject) {
			this.writeKey(key);
			this.writeObject((JSONObject) value);
		} else if(value instanceof JSONArray) {
			this.writeKey(key);
			this.writeArray((JSONArray) value);
		} else if(value instanceof String) {
			this.writeString(key, (String) value);
		} else {
			this.writeElement(key, value.toString());
		}
		this.minusSpaceIndex();
	}*/
	
	public void writeKey(String key) throws IOException {
		this.writer.write("\"" + serializeString(key) + "\": ");
	}
	
	public void writeElement(String key, String value) throws IOException {
		this.writeKey(key);
		this.writer.write(value);
	}
	
	public void writeString(String key, String value) throws IOException {
		this.writeElement(key, "\"" + serializeString(value) + "\"");
	}
	
	public void writeBoolean(String key, boolean value) throws IOException {
		this.writeElement(key, Boolean.toString(value));
	}
	
	public void writeInt(String key, int value) throws IOException {
		this.writeElement(key, Integer.toString(value));
	}
	
	public void writeByte(String key, byte value) throws IOException {
		this.writeElement(key, Byte.toString(value));
	}
	
	public void writeShort(String key, short value) throws IOException {
		this.writeElement(key, Short.toString(value));
	}
	
	public void writeLong(String key, long value) throws IOException {
		this.writeElement(key, Long.toString(value));
	}
	
	public void writeNull() throws IOException {
		this.writer.write("null");
	}
	
	public void writeComma() throws IOException {
		this.writer.write(",");
	}
	
	public void plusSpaceIndex() {
		this.spaceIndex++;
	}
	
	public void minusSpaceIndex() {
		this.spaceIndex--;
	}
	
	public void defaultSpaceIndex() {
		this.spaceIndex = 0;
	}
	
	public static String generateSpace(int index) {
		if(index <= 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		IntStream.range(0, index).forEach(i -> sb.append(space));
		return sb.toString();
	}
	
	public static String serializeString(String string) {
		return string.replace("\\", "\\\\").replace("\"", "\\\"");
	}
}
