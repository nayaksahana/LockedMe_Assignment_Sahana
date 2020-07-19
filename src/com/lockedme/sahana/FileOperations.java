package com.lockedme.sahana;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {
	Scanner scanner;
	
	public void displayFilesInAscending() {
		
		String cwd = System.getProperty("user.dir");
		File directoryPath = new File(cwd);
		String  files[] = directoryPath.list();
		
		sortFiles(files);
		
		System.out.println("List of files and directories in the specified directory:");
		
		for(String file: files)
			System.out.println(file);
		System.out.println();
	}

	public void addFilesToDirectory() throws IOException {
		
		boolean success = false;
		scanner = new Scanner(System.in);
		
		System.out.println("Enter file name to be created ");
		String filename = scanner.nextLine();
		
		File f = new File(filename);
		
			if (f.exists()){
				System.out.println("File already exists");
			}
			
			else{
				System.out.println("No such file exists, creating now");
				success = f.createNewFile();
				
				if (success){
					System.out.printf("Successfully created new file: %s%n", f);
				}
				
				else {
					System.out.printf("Failed to create new file: %s%n", f);
				}
			}	
	
	}

	public void deleteFilesFromDirectory() throws IOException{
		boolean success = false;
		scanner = new Scanner(System.in);
		
		System.out.println("Enter file name to be deleted ");
		String filename = scanner.nextLine();
		File f = new File(filename);
		
		if (!f.exists()){
			System.out.println("File does not exists");
		}
		else{
			success = f.delete();
			if(success)
				System.out.println("File deleted successfully");
			else
				System.out.println("File deletion failed");
		}

	}

	public void searchFileInDirectory() {
		
		boolean success = false;
		scanner = new Scanner(System.in);
		
		System.out.println("Enter file name to be searched ");
		String filename = scanner.nextLine();
		
		String cwd = System.getProperty("user.dir");
		File directoryPath = new File(cwd);
		String  contents[] = directoryPath.list();
		
		for(String f: contents){
			if(f.equals(filename)){
				success = true;
				break;
			}
		}
		if(success)
			System.out.println("File search successful");
		else
			System.out.println("File not found");

	}

	private void sortFiles(String[] files) {
		int size = files.length;
		for(int i = 0; i<size-1; i++) {
			for (int j = i+1; j<files.length; j++) {
				if(files[i].compareTo(files[j])>0) {
					String temp = files[i];
					files[i] = files[j];
					files[j] = temp;
				}
			}
		}
	}
}
