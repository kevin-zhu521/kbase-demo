/*
 * Power by www.xiaoi.com
 */
package com.kbase.demo.watermark;

import java.io.File;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @version 1.0
 * @date 2018年9月17日 下午4:37:19
 */
public abstract class AbstractProcessor {

    protected File file;
    protected File imageFile;

    public AbstractProcessor(File file, File imageFile) {
        this.file = file;
        this.imageFile = imageFile;
    }

    /**
     * 执行文件转换，将 file 添加 imageFile 水印
     *
     * @throws WatermarkException
     * @author eko.zhan at 2018年9月17日 下午6:08:24
     */
    public abstract void process() throws WatermarkException;
}
