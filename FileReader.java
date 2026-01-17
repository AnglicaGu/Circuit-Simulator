/*
 * Name: Angelica Gu
 * Date: Jun 13 2025
 * Class: FileReader
 * Description: Class to read the electrical conductivity data
 */


package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Material;

public class FileReader {

	// make an array lists that are visible to other classes
	public static ArrayList<Material> materialData;


	// This method reads the electrical conductivity data and stores them in an array list
	public void readMaterialData() {

		// The array list holds all the data
		materialData = new ArrayList<>();
		// This string holds the filepath
		String filePath;
		filePath = "src/data/materialData.csv";

		// use a try catch to read the file and check if there's any issues with the path
		try {

			// Create scanner object to read files
			Scanner inputFile = new Scanner(new File(filePath));

			// Excludes these arguments from getting scanned
			inputFile.useDelimiter(",|\r\n");

			// For loop to create new object for each index
			while (inputFile.hasNext()) {

				// Declares and assigns a value to all the fields using .txt file
				String name = inputFile.next();
				double conductivity = inputFile.nextDouble();

				// Create a new object for each index
				materialData.add(new Material(name,conductivity));
			}

			// Close scanner object
			inputFile.close();

		}

		// Handles FileNotFoundException
		catch (FileNotFoundException e) { 

			System.out.println("File error");
		}

	}
}
