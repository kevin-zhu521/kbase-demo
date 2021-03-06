package com.kbase.demo;

import com.kbase.demo.watermark.WatermarkProcessor;
import com.kbase.demo.watermark.spire.WatermarkSpireProcessor;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * 水印测试
 *
 * @author kevin.zhu
 * @date 2020/1/17 18:25
 */
public class WaterMarkTest extends DemoApplicationTests {

    /**
     * 处理word文档，图片水印
     *
     * @author kevin.zhu
     * @date 2020/1/17 18:31
     */
    @Test
    public void handlerWord() {
        try {
            File file = new File("C:\\Users\\User\\Desktop\\dahua01191026.docx");
            File imgFile = new File("C:\\Users\\User\\Desktop\\pic\\jshrss-logo-s.png");
            WatermarkProcessor.process(file, imgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理word文档，文本水印
     *
     * @author kevin.zhu
     * @date 2020/1/17 18:31
     */
    @Test
    public void handlerWordText() {
        try {
            File file = new File("C:\\Users\\User\\Desktop\\dahua01191026.docx");
            WatermarkSpireProcessor.process(file, "小i机器人");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理excel文档
     *
     * @author kevin.zhu
     * @date 2020/1/17 18:32
     */
    @Test
    public void handlerExcel() {
        try {
            File file = new File("C:\\Users\\User\\Desktop\\dahua01171827.xlsx");
            File imgFile = new File("C:\\Users\\User\\Desktop\\pic\\jshrss-logo-s.png");
            WatermarkProcessor.process(file, imgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
