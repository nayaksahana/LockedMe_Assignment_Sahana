package com.lockedme.sahana;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuOptions {
	
	BufferedReader reader; 
	FileOperations operations = new FileOperations();
	Scanner menu;
	int input;
	
	public  void displayMenu() throws IOException {
		
		do{
			System.out.println("Please select your option from the list");
			System.out.println("1. Display file names in ascending order");
			System.out.println("2. File manipulation options");
			System.out.println("3. Exit");
			
			menu = new Scanner(System.in);
			
			try{
				input = menu.nextInt();
			
				switch(input){
					case 1: operations.displayFilesInAscending();
							break;
						
					case 2: displaySubMenu();
							break;
						
					case 3: System.out.println("Closing the application");
							System.out.println("Application closed");
							System.exit(0);
						
					default: System.out.println("Please enter valid input");
				}
			}
			catch(InputMismatchException e){
				System.out.println("Enter only numerical values from list");
			}
			
		}while(true);
}
	
	public void displaySubMenu() throws IOException {
		
		System.out.println("	1. Add a file to directory");
		System.out.println("	2. Delete a file from directory");
		System.out.println("	3. Search a file in directory");
		System.out.println("	4. Main Menu");
		
		menu = new Scanner(System.in);
		input = menu.nextInt();
		
			 switch(input){
				 case 1: operations.addFilesToDirectory();
				 		 break;
				 		 
				 case 2: operations.deleteFilesFromDirectory();
				 		 break;
				 		 
				 case 3: operations.searchFileInDirectory();
					     break;
					     
				 case 4: displayMenu();
				 		break;
				 		
				 default: System.out.println("Please select valid option");
				 			displaySubMenu();
				 			break;
			}
	}
}
