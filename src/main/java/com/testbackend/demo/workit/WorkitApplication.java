package com.testbackend.demo.workit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class WorkitApplication {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Name of text input file (must be located in resource folder), ex - input : ");
		String inputFileName = userInput.nextLine();
		if(inputFileName.contains(".txt") == false){
			inputFileName += ".txt";
		}
		System.out.print("Filtering string : ");
		String filter = userInput.nextLine();

		try{
			// Reads input file
			InputReader inputReader = new InputReader(inputFileName);

			// Store input words from input file inside inputWords
			List<String> inputWords = inputReader.getInputWords();

			// filter input words to only write words containing the filter
			List<String> outputWords = filterOutputWords(filter, inputWords);

			// Creates output.txt and writes outputWords to output.txt
			OutputWriter.write(outputWords);

		}catch (Exception e) {
			System.err.println("Error : "+e);
		}
	}

	public static List<String> filterOutputWords(String filter, List<String> inputWords) {
		List<String> outputWords = new ArrayList<String>();
		for(int i = 0; i< inputWords.size();i++){
			if(inputWords.get(i).contains(filter)){
				outputWords.add(inputWords.get(i));
			}
		}
		return outputWords;
	}

}
