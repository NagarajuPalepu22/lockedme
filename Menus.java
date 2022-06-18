	package com.lockedMe.Project;
import java.io.IOException;
import java.util.Scanner;

public class Menus {
	Scanner sc = new Scanner(System.in);
	FileOperations FO = new FileOperations();

	public void introScreen() {
		
		System.out.println("__________________________________________________");
		System.out.println("*               LOCKEDME.COM                    *");
		System.out.println("_________________________________________________");
		System.out.println("Developed by : Palepu Nagaraju");
		System.out.println("\n\n");
		
		
	}
	
	public void exitScreen() {
		
		
		System.out.println("*    THANK YOU FOR VISITING LOCKEDME.COM        *");
		System.out.println("*                                               *");
		
		System.out.println("\n\n");
		
		
	}
	
	public void mainMenuOptions() {
		System.out.println("------------------------------------");
		System.out.println("|            MAIN MENU              |");
		System.out.println("|-----------------------------------|");
		System.out.println(" Select any one of the following:  ");
	    System.out.println("   1 - List All Files              ");
	    System.out.println("   2 - More Options                ");
	    System.out.println("   3 - Exit                        ");
	    System.out.println("");
	    System.out.println("Enter your choice : ");
	}
	
	public void subMenuOptions() {
		
		System.out.println("------------------------------------");
		System.out.println("|            SUB MENU               |");
		System.out.println("-------------------------------------");
		System.out.println(" Select any one of the following:  ");
	    System.out.println("   1 - Add a file                  ");
	    System.out.println("   2 - Delete a file               ");
	    System.out.println("   3 - Search a file               ");
	    System.out.println("   4 - Go Back                     ");
	    System.out.println("\n");
	    System.out.println("Enter your choice : ");
	}
	public void mainMenu() {
	int choice = 0 ;
	char decision = 0;
	do {
	mainMenuOptions();
	try {
		choice = Integer.parseInt(sc.nextLine());
	}  catch (NumberFormatException e) {
		System.out.println("invalid input");
		mainMenu();
		
	}
	switch (choice) {
	
	case 1 :
		System.out.println();
		try {
	FO.listAllFiles(Main.path);
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		break;
		
	case 2 :
		 subMenu();
		break;
		
	case 3 :
		System.out.println("Are you want to exit");
		System.out.println("(y) - yes    (N) - No  ");
		
	decision = sc.nextLine().toUpperCase().charAt(0);
			
			if(decision=='Y') {
				exitScreen();
			}else if(decision=='N') {
				System.out.println("\n");
	
			}else {
				System.out.println("invalid inputs");
		
					
			}
	default:
		System.out.println("\nInvalid Input \nValid Input Integers:(1-3)\n");

}
}while(true);
	}
	public void subMenu() {
		String file = null;
		String fileName = null;
		int choice = 0;
		
		do {
			
			subMenuOptions();
			
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input \nValid Input Integers:(1-4)");
				subMenu();
			}
			
			
			switch (choice) {
			case 1: 
					System.out.println("\n==> Adding a File...");
					System.out.println("Please enter a file name : ");
					file = sc.nextLine();
					fileName = file.trim();
					try {
						FO.createNewFile(Main.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println("Error occurred while adding file..");
						System.out.println("Please try again...");
					}catch(Exception e) {
						System.out.println("Error occurred while adding file..");
						System.out.println("Please try again...");
					}
					System.out.println("\n**********************************\n");
					break;
					
			case 2: 
					System.out.println("\n==> Deleting a File...");
					System.out.println("Please enter a file name to Delete : ");
					file = sc.nextLine();
					fileName = file.trim();
					try {
						FO.deleteFile(Main.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IOException e) {
						System.out.println("Error occurred while Deleting File..");
						System.out.println("Please try again...");
					}catch(Exception e) {
						System.out.println("Error occurred while Deleting File..");
						System.out.println("Please try again...");
					}
					System.out.println("\n***********************************\n");
					break;
					
			case 3: 
					System.out.println("\n==> Searching a File...");
					System.out.println("Please enter a file name to Search : ");
					file = sc.nextLine();
					fileName = file.trim();
					try {
						FO.searchFile(Main.path, fileName);
					}catch(NullPointerException e) {
						System.out.println(e.getMessage());
					}catch(IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\n***********************************\n");
					break;
			case 4: mainMenu();
					break;
					
			default:
				System.out.println("Invalid Input \nValid Input Integers:(1-4)");
				subMenu();
				
			}
			
		file = null;
		fileName = null;
			
		}while(true);
		
}
}
  
