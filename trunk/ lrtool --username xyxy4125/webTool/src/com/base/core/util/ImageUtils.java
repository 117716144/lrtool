package com.base.core.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public final class ImageUtils {

	public ImageUtils() {

	}

	/**
	 * 把图片印刷到图片上
	 * 
	 * @param pressImg
	 *            -- 水印文件
	 * @param targetImg
	 *            -- 目标文件
	 * @param x
	 * @param y
	 */
	public final static void pressImage(String pressImg, String targetImg,
			int x, int y) {
		try {
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);

			// 水印文件
			File _filebiao = new File(pressImg);
			Image src_biao = ImageIO.read(_filebiao);
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.drawImage(src_biao, wideth - wideth_biao - x, height
					- height_biao - y, wideth_biao, height_biao, null);
			// /
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印文字水印图片
	 * 
	 * @param pressText
	 *            --文字
	 * @param targetImg
	 *            -- 目标图片
	 * @param fontName
	 *            -- 字体名
	 * @param fontStyle
	 *            -- 字体样式
	 * @param color
	 *            -- 字体颜色
	 * @param fontSize
	 *            -- 字体大小
	 * @param x
	 *            -- 偏移量
	 * @param y
	 */

	public static void pressText(String pressText, String targetImg,
			String fontName, int fontStyle, int color, int fontSize, int x,
			int y) {
		try {
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			// String s="www.qhd.com.cn";
			g.setColor(Color.RED);
			g.setFont(new Font(fontName, fontStyle, fontSize));

			g.drawString(pressText, wideth - fontSize - x, height - fontSize
					/ 2 - y);
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		pressImage("d:/test/22.jpg", "d:/test/11.jpg", 20, 20);
	}
	
	public static void main2(String arg[]) {

		String filePath = " g:/图片.jpg "; // 图片的位置
		int height = 50;
		int width = 150;
		Icon icon = null;
		try {
			icon = getFixedBoundIcon(filePath, height, width);
		} catch (Exception e) {
			System.out.println(" exception :  " + e);
		}
		System.out.println("  ###  " + icon); // 生成新图片的位置；
	}


	public static Icon getFixedBoundIcon(String filePath, int height, int width)
			throws Exception {
		double Ratio = 0.0;
		// 缩放比例
		File F = new File(filePath);
		if (!F.isFile())
			throw new Exception(F
					+ "  is not image file error in getFixedBoundIcon! ");
		Icon ret = new ImageIcon(filePath);
		BufferedImage Bi = ImageIO.read(F);
		if ((Bi.getHeight() > height) || (Bi.getWidth() > width)) {
			if (Bi.getHeight() > Bi.getWidth()) {
				Ratio = (new Integer(height)).doubleValue() / Bi.getHeight();
			} else {
				Ratio = (new Integer(width)).doubleValue() / Bi.getWidth();
			}
			int lastLength = filePath.lastIndexOf(" . ");
			String subFilePath = filePath.substring(0, lastLength);
			String fileType = filePath.substring(lastLength);
			File zoomFile = new File(subFilePath + " _ " + height + " _ "
					+ width + fileType);
			Image Itemp = Bi.getScaledInstance(width, height, Bi.SCALE_SMOOTH);
			AffineTransformOp op = new AffineTransformOp(AffineTransform
					.getScaleInstance(Ratio, Ratio), null);
			Itemp = op.filter(Bi, null);
			try {
				ImageIO.write((BufferedImage) Itemp, " jpg ", zoomFile);
				ret = new ImageIcon(zoomFile.getPath());
			} catch (Exception ex) {
				System.out.println(" ######## here error :  " + ex);
			}
		}
		return ret;
	}

}
