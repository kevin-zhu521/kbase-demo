package com.kbase.demo.watermark.spire;

import com.kbase.demo.utils.FileExtensionUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class WatermarkSpireProcessor {

    public static void process(File file, String text) {
        AbstractSpireProcessor processor = null;
        if (FileExtensionUtils.isWord(file.getName())) {
            processor = new WordSpireWatermark(file, text);
        } else if (FileExtensionUtils.isExcel(file.getName())) {
        } else if (FileExtensionUtils.isPpt(file.getName())) {
        } else if (FileExtensionUtils.isPdf(file.getName())) {
        } else if (FileExtensionUtils.isImage(file.getName())) {
        }
        if (processor != null) {
            try {
                processor.process();
            } catch (com.kbase.demo.watermark.WatermarkException e) {
                e.printStackTrace();
            }
        } else {
            throw new WatermarkException("不支持文件格式为 " + FilenameUtils.getExtension(file.getName()) + " 的水印处理");
        }
    }
}
