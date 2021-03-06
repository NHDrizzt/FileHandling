package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		String[] parts;
		ArrayList<String> listOfOutputLines = new ArrayList<>();
		System.out.println("Folder path: ");

		String strPathTarget = "c:\\Repositorios\\out\\summary.csv";
		String strPathSource = "c:\\Repositorios\\Source.csv";
		System.out.println(strPathTarget);

		File f = new File(strPathTarget);

		f.getParentFile().mkdirs();
		boolean createFile = f.createNewFile();
		if (!createFile) {
			System.out.println("File already exists");
		}
		try (BufferedReader br = new BufferedReader(new FileReader(strPathSource))) {
			String readFile = br.readLine();
			while (readFile != null) {
				parts = readFile.split(",");
				double res = Double.parseDouble(parts[1]) * Integer.parseInt(parts[2]);
				String agroup = parts[0] +","+ String.valueOf(res);
				listOfOutputLines.add(agroup);
				readFile = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPathTarget, true))) {
				for(String line : listOfOutputLines) {
					bw.write(line);
					bw.newLine();
				}
				
			} catch (Error e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("File already exists");
		}

		sc.close();
	}

}
