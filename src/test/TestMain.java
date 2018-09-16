package test;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import algorithm.sort.Sort;
import math.function.FunctionHelper;
import text.PixelWord;
import text.RegExp;
import text.json.JsonWriter;
import tools.classin.DynamicEngine;
import tools.file.FileTools;
import world.matter.macro.life.animal.bird.CommonBird;

public class TestMain {
	public static void main(String[] args) throws IOException {
		//RegExp.test("(?<=<image src=(\\\"|')).+(?=(\\\"|')>)", "<p><image src=\"http:\\\\minecraft.net\"></p>");
		//RegExp.test("[0-9]{6,16}@qq\\.com", "2280761425@qq.com");
		//System.out.println(Pattern.matches("www\\..+\\..+[^\\\"]", "www.baidu.com"));
		//System.out.println(Pattern.matches("www\\..+\\..+[^\\\"]", "<image src=\"http:\\\\www.baidu.com\">"));*/
		//System.out.println(PixelWord.wordToPixel(134, 62, PixelWord.createFont(new URL("https://sh-btfs-yun-ftn.weiyun.com/ftn_handler/795e34a516d7208bbfba5560191afec94c2a95c523f68e9427c9a05e1acaec0c50bcd59476570337e6b0370368f39d898155830daafc442ff226f74bf215ab0c/simsun.ttc?fname=simsun.ttc&from=30113&version=2.0.0.2&uin=2280761425"), 64, true), "滑稽", new String[] {"*", "*", " "}));
		//System.out.println(PixelWord.wordToPixel(34, 16, new Font("宋体", Font.PLAIN, 16), "奇迹", new String[] {"*", "*", " "}));
		//FileTools.printToFile(PixelWord.pictureToPixel("http://bbs.pvpin.com/uploads/files/1502241625666-huaji.png"), "F:\\t.txt");
		//System.out.println(PixelWord.pictureToPixel("http://bbs.pvpin.com/uploads/files/1502241625666-huaji.png"));
		//Arrays.asList("asdDasda", "intSasdasdsDcdasIj", "IdsadPron").stream().forEach(str -> {IntStream.range(0, str.length()).forEach(i -> {if(str.substring(i).matches("[A-Z]")){ str.replace(str.substring(i), "_" + str.substring(i)) ;i--;}});System.out.println(str);});
		
		//System.out.println(FunctionHelper.getZeroPointByBisection(x -> x*x-10*x-100, -40, 30, 0.001));
	}
	
	public static void jsontest() throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter("F:\\qwq.json"));
		JsonWriter jw = new JsonWriter(w);
		JSONObject j = JSON.parseObject("{\"高频震荡弓\":{\"appearance\":{\"itemStack\":\"高频震荡弓\",\"addLore\":[\" \",\"§6需要： 150金币\"]},\"level\":1,\"levelOnly\":false,\"type\":\"barter\",\"need\":[[{\"itemStack\":\"gold\",\"amount\":150}]],\"result\":\"高频震荡弓\"},\"聚合铁箭\":{\"appearance\":{\"itemStack\":\"聚合铁箭\",\"amount\":10,\"addLore\":[\" \",\"§6需要： 50金币\"]},\"level\":1,\"levelOnly\":false,\"type\":\"barter\",\"need\":[[{\"itemStack\":\"gold\",\"amount\":50}]],\"result\":{\"itemStack\":\"聚合铁箭\",\"amount\":10}},\"牛排\":{\"appearance\":{\"itemStack\":\"牛排\",\"amount\":4,\"addLore\":[\" \",\"§6需要： 20金币\"]},\"level\":-1,\"levelOnly\":false,\"type\":\"barter\",\"need\":[[{\"itemStack\":\"gold\",\"amount\":20}]],\"result\":{\"itemStack\":\"牛排\",\"amount\":4}},\"锋刃1~2\":{\"appearance\":\"{id:\\\"minecraft:enchanted_book\\\",Count:1,Damage:0s,tag:{StoredEnchantments:[{id:18,lvl:2}],display:{Name:\\\"§e附魔：锋刃1~2级\\\",Lore:[\\\"§2给你手里的武器附魔随机等级【1~2】的节肢杀手\\\",\\\" \\\",\\\"§6需要： 60金币\\\"]}}}\",\"level\":1,\"levelOnly\":false,\"type\":\"enchantment\",\"need\":[[{\"itemStack\":\"gold\",\"amount\":60}]],\"ench\":[{\"slot\":\"mainhand\",\"ench\":[{\"name\":\"DAMAGE_ARTHROPODS\",\"level\":2}]}]},\"保护1\":{\"appearance\":\"{id:\\\"minecraft:enchanted_book\\\",Count:1,Damage:0s,tag:{StoredEnchantments:[{id:0,lvl:1}],display:{Name:\\\"§e附魔：保护1级\\\",Lore:[\\\"§2给你身上的装备【全套】附魔1级的保护\\\",\\\" \\\",\\\"§6需要： 150金币\\\"]}}}\",\"level\":1,\"levelOnly\":false,\"type\":\"enchantment\",\"need\":[[{\"itemStack\":\"gold\",\"amount\":150}]],\"ench\":[{\"slot\":\"head\",\"ench\":[{\"name\":\"PROTECTION_ENVIRONMENTAL\",\"level\":1}]},{\"slot\":\"chest\",\"ench\":[{\"name\":\"PROTECTION_ENVIRONMENTAL\",\"level\":1}]},{\"slot\":\"legs\",\"ench\":[{\"name\":\"PROTECTION_ENVIRONMENTAL\",\"level\":1}]},{\"slot\":\"feet\",\"ench\":[{\"name\":\"PROTECTION_ENVIRONMENTAL\",\"level\":1}]}]}}");
		jw.writeObject(j);
		w.close();
	}
}
