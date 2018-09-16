package text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

import test.jframetest.ImageGUI;

public class PixelWord {
	public static String pictureToPixel(String url) throws MalformedURLException, IOException {
		BufferedImage image = ImageIO.read(new URL(url));
		int[] p = image.getRGB(0, 0, image.getWidth(), image.getHeight(), new int[image.getWidth() * image.getHeight()], 0, image.getWidth());
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<image.getHeight();i++) {
			for(int j=0;j<image.getWidth();j++) {
				int rgb = p[i * image.getWidth() + j];
				rgb = ~new Color(rgb).getRGB();
				if(rgb > 0 && rgb < 160) {//黑
					sb.append("15|");
				} else if(rgb >= 160 && rgb < 1500) {
					sb.append("14|");
				} else if(rgb >= 1500 && rgb < 32800) {
					sb.append("13|");
				} else if(rgb >= 32800 && rgb < 45000) {
					sb.append("5|");
				} else if(rgb >= 45000 && rgb < 4000000) {
					sb.append("4|");
				} else if(rgb >= 4000000 && rgb < 8388650) {
					sb.append("11|");
				} else if(rgb >= 8388650 && rgb < 8400000) {
					sb.append("2|");
				} else if(rgb >= 8400000 && rgb < 8421440) {
					sb.append("9|");
				} else if(rgb >= 8421440 && rgb < 14000000) {
					sb.append("7|");
				}
				//sb.append(~rgb).append("|");
				
				if(j == image.getWidth() - 1) {
					sb.append("\n");
				}
			}
		}
		
		return sb.toString();
	}
	
	public static String wordToPixel(int pixelWide, int pixelHeight, Font font, String string, String[] decollator) {
		BufferedImage image = new BufferedImage(pixelWide, pixelHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setFont(font);
		g.drawString(string, 2/*边距*/, image.getHeight() - 2);
		//g.drawString(string, 2/*边距*/, 54);
		int[] p = image.getRGB(0, 0, image.getWidth(), image.getHeight(), new int[image.getWidth() * image.getHeight()], 0, image.getWidth());
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<image.getHeight();i++) {
			for(int j=0;j<image.getWidth();j++) {
				if(p[i * image.getWidth() + j] == -1) {
					if(i%2 == 0) {
						sb.append(decollator[0]);
					} else {
						sb.append(decollator[1]);
					}
				} else {
					sb.append(decollator[2]);
					if(j == image.getWidth() - 1) {
						sb.append("\n");
					}
				}
			}
		}
		
		return sb.toString();
	}
	
	public static String wordToPixel(int pixelWide, String string) {
		return PixelWord.wordToPixel(string.length() * 34, 64, new Font("宋体", Font.PLAIN, 64), string, new String[] {"*", "*", " "});
	}
	
	public static Font createFont(URL url, int size, boolean iszip) throws IOException, FontFormatException {
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		/*if(iszip) {
			ZipInputStream zis = new ZipInputStream(new CheckedInputStream(bis, new CRC32()));
			ZipEntry ze = null;
			while((ze  = zis.getNextEntry()) != null) {
				if(!ze.isDirectory() && Pattern.matches("^.*\\.ttc$", ze.getName())) {
					if(ze.getSize() > 0) {
						bis = new BufferedInputStream(zis);
					}
					break;
				}
			}
			bis = new BufferedInputStream(zis);
		}*/
		Font definedFont = Font.createFont(Font.TRUETYPE_FONT, bis);
		bis.close();
		return definedFont.deriveFont(Font.PLAIN, size);
	}
}
