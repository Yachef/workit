package com.testbackend.demo.workit;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {
    public static void write(List<String> outputWords) {
        try{
            String rootPath = System.getProperty("user.dir");
            String path = rootPath + "/output.txt";
            File outputFile = new File(path);
            FileWriter fw = new FileWriter(outputFile);
            int i = 0;
            while (i < outputWords.size()){
                fw.write(outputWords.get(i));
                fw.write(System.getProperty("line.separator"));
                i++;
            }
            fw.close();
            System.out.println("Output file created successfully ! Location : "+path);
        }catch (IOException e){
            System.err.println("An error happened while writing the output file");
            System.err.println("Error : " + e);

        }
    }
}
