package com.kbase.demo.watermark.spire;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Img {

    /**
     * 导入本地图片到缓冲区
     */
    private static BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 创建背景透明的文字图片
     *
     * @param str       文本字符串
     * @param width     图片宽度
     * @param height    图片高度
     * @param font      设置字体
     * @param fontColor 字体颜色
     * @param alpha     文字透明度，值从0.0f-1.0f，依次变得不透明
     */
    private static BufferedImage createImageWithText(String str, int width, int height, Font font, Color fontColor, float alpha) {
        BufferedImage textImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = textImage.createGraphics();

        //设置背景透明
        textImage = g2.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g2.dispose();
        g2 = textImage.createGraphics();

        //开启文字抗锯齿
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //设置字体
        g2.setFont(font);
        //设置字体颜色
        g2.setColor(fontColor);
        //设置透明度:1.0f为透明度 ，值从0-1.0，依次变得不透明
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        //计算字体位置：上下左右居中
        FontRenderContext context = g2.getFontRenderContext();
        LineMetrics lineMetrics = font.getLineMetrics(str, context);
        FontMetrics fontMetrics = FontDesignMetrics.getMetrics(font);
        float offset = (width - fontMetrics.stringWidth(str)) / 2;
        float y = (height + lineMetrics.getAscent() - lineMetrics.getDescent() - lineMetrics.getLeading()) / 2;
        //绘图
        g2.drawString(str, (int) offset, (int) y);
        //释放资源
        g2.dispose();
        return textImage;
    }

    private static void createImageWithText(String destImgPath, String imgType, String str, int width, int height, Font font, Color fontColor, float alpha) {
        BufferedImage image = Img.createImageWithText(str, width, height, font, fontColor, alpha);
        try {
            ImageIO.write(image, imgType, new File(destImgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文本写到图片上
     *
     * @param srcImgPath  源图片路径
     * @param destImgPath 处理结果图片路径
     * @param imgType     图片格式：png,jpg等
     * @param text        文本字符串
     * @param font        字体
     * @param fontColor   字体颜色：Color.RED等
     */
    private static boolean writeTextOnImage(String srcImgPath, String destImgPath, String imgType, String text, Font font, Color fontColor) {
        BufferedImage image = Img.loadImageLocal(srcImgPath);
        int width = image.getWidth();
        int height = image.getHeight();

        Graphics2D g2 = image.createGraphics();

        //开启文字抗锯齿
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //设置字体
        g2.setFont(font);
        //设置字体颜色
        g2.setColor(fontColor);

        //设置透明度:1.0f为透明度 ，值从0-1.0，依次变得不透明
        //g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        //计算字体位置：上下左右居中
        FontRenderContext context = g2.getFontRenderContext();
        LineMetrics lineMetrics = font.getLineMetrics(text, context);
        FontMetrics fontMetrics = FontDesignMetrics.getMetrics(font);
        float offset = (width - fontMetrics.stringWidth(text)) / 2;
        float y = (height + lineMetrics.getAscent() - lineMetrics.getDescent() - lineMetrics.getLeading()) / 2;
        //绘图
        g2.drawString(text, (int) offset, (int) y);
        //释放资源
        g2.dispose();
        //写入文件
        boolean ret = false;
        try {
            ret = ImageIO.write(image, imgType, new File(destImgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }


    public static void main(String[] args) {
        String imgPath1 = "images/green.png";
        Font font = new Font("fonts/MSYH.TTF", Font.BOLD, 80);

        String destPath = "d://av3.png";
        Img.createImageWithText(destPath, "png", "认真的头像", 500, 500, font, new Color(211,217,211), 1.0f);

//        String destPath3 = "images/pic31.png";
//        Img.writeTextOnImage(imgPath1, destPath3, "png", "aaAA123", font, Color.RED);
    }
}

