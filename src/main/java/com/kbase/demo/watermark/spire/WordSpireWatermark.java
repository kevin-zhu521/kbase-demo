package com.kbase.demo.watermark.spire;

import com.kbase.demo.watermark.WatermarkException;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.TextWatermark;
import com.spire.doc.documents.WatermarkLayout;
import org.apache.commons.io.FilenameUtils;

import java.awt.*;
import java.io.File;

public class WordSpireWatermark extends AbstractSpireProcessor {

    public WordSpireWatermark(File file, String text) {
        super(file,text);
    }

    public void sprieProcess() {
        //加载测试文档
        Document document = new Document();
        document.loadFromFile(file.getAbsolutePath());

        //插入文本水印
        InsertTextWatermark(document.getSections().get(0));

        String filename = file.getName();
        if (FilenameUtils.getExtension(filename).toLowerCase().equals("docx")){
            //保存文档
            document.saveToFile(file.getAbsolutePath(), FileFormat.Docx );
        }else{

            //保存文档
            document.saveToFile(file.getAbsolutePath(), FileFormat.Doc );
        }


    }

    //自定义方法指定文本水印字样，并设置成水印
    private void InsertTextWatermark(Section section){
        TextWatermark txtWatermark = new TextWatermark();
        txtWatermark.setText(text);
        txtWatermark.setFontSize(80);
        txtWatermark.setColor(new Color(48,85,210));
        txtWatermark.setLayout(WatermarkLayout.Diagonal);
        section.getDocument().setWatermark(txtWatermark);
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\User\\Desktop\\dahua01191026.doc");
       new WordSpireWatermark(file,"小i机器人").sprieProcess();
    }

    @Override
    public void process() throws WatermarkException {
        sprieProcess();
    }
}
