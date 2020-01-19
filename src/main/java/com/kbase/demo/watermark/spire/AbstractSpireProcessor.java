package com.kbase.demo.watermark.spire;


import com.kbase.demo.watermark.WatermarkException;

import java.io.File;

public abstract class AbstractSpireProcessor {

    protected File file;

    protected String text; //账号

    public AbstractSpireProcessor(File file, String text) {

        this.file = file;
        this.text = text;
    }

    public abstract void process() throws WatermarkException;
}
