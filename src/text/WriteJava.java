package text;

import java.io.File;
import java.io.FileOutputStream;

public class WriteJava {
	public File javaFile = new File("F:\\text.java");
	public static String value = "    public static int value";
	public static String first = "public class text {";
	public static String end = "}";
	
	public WriteJava() {
		try {
			createFile(javaFile);
			writeTxtFile(javaFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean createFile(File fileName) throws Exception{
		boolean flag = false;
		try {
			if(!fileName.exists()){
				fileName.createNewFile();
				flag=true;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean writeTxtFile(File fileName)throws Exception{
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			
			o.write(first.getBytes("GBK"));
			o.write(System.getProperty("line.separator").getBytes("GBK"));
			for(int i=0;i<100;i++) {
				String str = value + Long.toString(i) + ";";
				o.write(str.getBytes("GBK"));
				o.write(System.getProperty("line.separator").getBytes("GBK"));
			}
			o.write(end.getBytes("GBK"));
			
			o.close();
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
