package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class FileHandler {

	public String[] readAllLines(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
		// read all Lines from all files in fileName Array

		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					lines.add(line);
				}
			} finally {
				input.close();
			}

			
		} catch (FileNotFoundException ex) {
			System.out.print("ERROR: file " + fileName + " not found");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String[] linesArr = new String[lines.size()];
		for (int i = 0; i < lines.size(); i++) {
			linesArr[i] = lines.get(i);
		}

		return linesArr;
	}

	public boolean writeLines(String fileName, String[] lines) {

		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(fileName));
			try {
				for (String l : lines) {

					output.write(l);
					output.newLine();
				}

				return true;
			} finally {
				output.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.print("ERROR: file " + fileName + " not found");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean writeLine(String fileName, String line) {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(fileName));
			try {
				output.write(line);
				return true;
			} finally {
				output.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.print("ERROR: file " + fileName + " not found");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public HashSet<String> getLinesMap(String fileName) {
		String[] lines = readAllLines(fileName);
		HashSet<String> linesMap = new HashSet();
		for (String line : lines) {
			linesMap.add(line);
		}
		return linesMap;
		
	} 

}
