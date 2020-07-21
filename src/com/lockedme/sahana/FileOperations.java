package com.lockedme.sahana;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {
	Scanner scanner;
	String cwd = System.getProperty("user.dir");
	File directoryPath = new File(cwd);
	boolean success;
	int result;
	
	public void displayFilesInAscending() {
		
		String  files[] = directoryPath.list();
		
		String[]  sortedFiles = sortFiles(files);
		
		System.out.println("List of files and directories in the specified directory:");
		
		for(String file: sortedFiles)
			System.out.println(file);
		System.out.println();
	}

	public void addFilesToDirectory() throws IOException {
		
		success = false;
		scanner = new Scanner(System.in);
		
		String  files[] = directoryPath.list();
		
		System.out.println("Enter file name to be created ");
		String fileToAdd = scanner.nextLine();
		
		result = search(files, fileToAdd);
		if(result>0){
			System.out.println("File already exists");
		}
		else{
			File f = new File(fileToAdd);
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
		
		scanner = new Scanner(System.in);
		
		String  files[] = directoryPath.list();
		
		System.out.println("Enter file name to be deleted ");
		String fileToDelete = scanner.nextLine();
		
		result = search(files, fileToDelete);
		if(result<0){
			System.out.println("File does not exist");
		}
		else{
			File f = new File(fileToDelete);
			success = f.delete();
			if(success)
				System.out.println("File deleted successfully");
			else
				System.out.println("File deletion failed");
			
		}
	}

	public void searchFileInDirectory() {
		
		scanner = new Scanner(System.in);
		
		System.out.println("Enter file name to be searched ");
		String fileToSearch = scanner.nextLine();
		
		String  files[] = directoryPath.list();
		
		result = search(files, fileToSearch);
		if(result <=0)
			System.out.println("File not found");
		else
			System.out.println("File search successful");

	}

	private String[] sortFiles(String[] files) {
		 for (int i = 1; i < files.length; i++) {
	            String element = files[i];
	            int j;
	            for (j = i - 1; j >= 0 && element.compareTo(files[j]) <= 0; j--)
	                files[j + 1] = files[j];

	            files[j + 1] = element;
	        }
	        return files;
	    }
	
	public int search(String[] files, String fileToSearch) {

	    if (files[0].compareToIgnoreCase(fileToSearch)>0)
	        return 0;
	    if (files[files.length - 1] == fileToSearch)
	        return files.length;

	    int range = 1;

	    while (range < files.length && files[range].compareToIgnoreCase(fileToSearch)<0) {
	        range = range * 2;
	    }

	    return Arrays.binarySearch(files, range / 2, Math.min(range, files.length), fileToSearch);
	}
}