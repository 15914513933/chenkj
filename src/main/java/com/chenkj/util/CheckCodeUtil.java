package com.chenkj.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

public class CheckCodeUtil {
	public static final String CHECKCODE_SESSION = "CHECKCODE_SESSION";
	private static final int width = 130;
	private static final int height = 42;
	private static final int count = 200;
	private static final int lineWidth = 1;
	private static final String All_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static BufferedImage createImage(HttpSession session) throws Exception{
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D) image.getGraphics();

        // 设定背景颜色
        graphics.setColor(Color.WHITE); // ---1.Color.WHITE为白色
        graphics.fillRect(0, 0, width, height);//填充衍射
        // 设定边框颜色
        //graphics.setColor(getRandColor(100, 200)); // ---2.这是以数字型来设置颜色，颜色模式是指使用三种基色：红、绿、蓝，通过三种颜色的调整得出其它各种颜色，这三种基色的值范围为0～255
        graphics.drawRect(0, 0, width - 1, height - 1);
        
        Random random = new Random();
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < count; i++) {
            graphics.setColor(getRandColor(150, 200)); // ---3.

            final int x = random.nextInt(width - lineWidth - 1) + 1; // 保证画在边框之内
            final int y = random.nextInt(height - lineWidth - 1) + 1;
            final int xl = random.nextInt(lineWidth);
            final int yl = random.nextInt(lineWidth);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        String resultCode = getRandomCode();
        System.out.println(resultCode);
        for (int i = 0; i < resultCode.length(); i++) {
            // 设置字体颜色
            graphics.setColor(Color.BLACK);
            // 设置字体样式
            //graphics.setFont(new Font("Arial Black", Font.ITALIC, 18));
            graphics.setFont(new Font("Times New Roman", Font.BOLD, 24));
            // 设置字符，字符间距，上边距
            graphics.drawString(String.valueOf(resultCode.charAt(i)), (23 * i) + 8, 26);
        }
        // 将认证码存入SESSION
        session.setAttribute(CHECKCODE_SESSION, resultCode);
        // 图象生效
        graphics.dispose();
        //ImageIO.write(image,"jpg",new File("d:/code.jpg")); 
		return image;
	}
	
	private static Color getRandColor(int fc, int bc) { // 取得给定范围随机颜色
        final Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        final int r = fc + random.nextInt(bc - fc);
        final int g = fc + random.nextInt(bc - fc);
        final int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
	
	private static String getRandomCode(){
        char[] randomcodes = new char[5]; 
        for (int i = 0; i < randomcodes.length; i++) { 
            int code = (int) (Math.random() * All_CHAR.length()); 
            randomcodes[i] = All_CHAR.charAt(code); 
        } 
        return  String.valueOf(randomcodes).toLowerCase();
	}
}
