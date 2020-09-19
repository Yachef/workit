package com.testbackend.demo.workit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    String inputFileName;
    public InputReader(String inputFileName){
        this.inputFileName = inputFileName;
    }

    public List<String> getInputWords(){
        List<String> inputWords = new ArrayList<String>();
        try{
            // input file must be inside resource folder.
            File inputFile = new ClassPathResource(this.inputFileName).getFile();
            Scanner inputReader = new Scanner(inputFile);
            while (inputReader.hasNextLine()) {
                String word = inputReader.nextLine();
                inputWords.add(word);
            }
            inputReader.close();
        }catch (FileNotFoundException e){
            System.err.println("Input File Not Found. Input file should be on the resources file of the application.");
            System.err.println("Error : "+e);
            System.exit(1);
        }finally {
            return inputWords;
        }
    }

}
