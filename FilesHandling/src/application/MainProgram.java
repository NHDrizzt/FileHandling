package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		File file = new File("c:\\Repositorios\\Mano.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String readFile = br.readLine();
			while(readFile != null) {
				System.out.println(readFile);
				readFile = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
