package jetgreenairlines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JetGreenMenu 
{
	public static void main(String[] args ) throws Exception
	{
		JetGreenUsersList myList = new JetGreenUsersListImpl();
		char option = '$';
		do 
		{
			
			displayMenu();
			option = getChoice();
			switch(option)
			{
			case 'a' : loginList(myList);
			break;
			case 'b' : createNewUserList(myList);
			break;
			case 'c' : forgotLoginList(myList);
			break;
			case 'd' : exitMessage(myList);
			break;
			case 'e' : seeUsers(myList);
			break;
			}
		}
		while(option != 'd');
	}
	


	public static void seeUsers(JetGreenUsersList myList) 
	{
		System.out.println(myList.toString());
		
	}



	public static void exitMessage(JetGreenUsersList myList) 
	{
		Scanner input = new Scanner (System.in);
		boolean saved = myList.isSaved();
		if (saved == false)
		{
			saveToFile(myList);
			System.out.println("Thank you for using our system!");
		}
		
	}




	public static void forgotLoginList(JetGreenUsersList myList) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void createNewUserList(JetGreenUsersList myList)
	{
		userPopulatedList(myList);
		Scanner input = new Scanner(System.in);
		JetGreenUsers user = new JetGreenUsers();
		//user.readFromScanner(input);
		System.out.println("Please enter your email address: ");
		String emailId = input.next();
		System.out.println("Please enter a password: ");
		String passwordId = input.next();
		System.out.println("Please enter your first name: ");
		String fnameId = input.next();
		System.out.println("Please enter your last name: ");
		String lnameId = input.next();
		System.out.println("Please enter your street number: ");
		int numberStreetId = input.nextInt();
		System.out.println("Please enter your street name: ");
		String streetId = input.next();
		System.out.println("Please enter the city you live in: ");
		String cityId  = input.next();
		System.out.println("Please enter the state you live in: ");
		String stateId = input.next();
		System.out.println("Please enter your the name of your first pet: ");
		String petNameId = input.next();
		System.out.println("Please enter your mothers maiden name: ");
		String motherMaidenId = input.next();
		System.out.println("Please enter your favorite movie: ");
		String favMovieId = input.next();
		
		
		
		user.setEmailId(emailId);
		user.setPasswordId(passwordId);
		user.setFNameId(fnameId);
		user.setLNameId(lnameId);
		user.setNumberStreetId(numberStreetId);
		user.setStreetId(streetId);
		user.setCityId(cityId);
		user.setStateId(stateId);
		user.setPetNameId(petNameId);
		user.setMotherMaidenId(motherMaidenId);
		user.setFavMovieId(favMovieId);
		
		if(myList.add(user))
		{
			System.out.println("You were added to our database! Welcome to Jet Green Air!");
			
			
		}
		else
		{
			System.out.println("Sorry, could not add you to our database, please try again.");
			createNewUserList(myList);
			
		}
		saveToFile(myList);
		
	}

	public static void saveToFile(JetGreenUsersList myList) 
	{
		String filename = "UserList.txt";
		myList.saveToFile(filename);
		
	}



	public static void loginList(JetGreenUsersList myList) 
	{
		userPopulatedList(myList);
		saveToFile(myList);
	}

	public static char getChoice()
	{
		char choice;
		String answer;
		Scanner input = new Scanner (System.in);
		
		do 
		{
			System.out.println("Enter your selection: ");
			answer = input.nextLine();
			choice = Character.toLowerCase(answer.charAt(0));
		}
		while(choice !='a' && choice != 'b' && choice !='c' && choice !='d');
			return choice;
	}
	
	public static void userPopulatedList(JetGreenUsersList myList)
	{
		Scanner inFile = null;
		String filename = "UserList.txt";
		try 
		{
			inFile = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Sorry, user list did not import");
			return;
		}
		
		myList.readFromScanner(inFile);
		inFile.close();
	}

	public static void displayMenu() 
	{
		System.out.println();
		System.out.println("                                     *****");
		System.out.println("                                    *    *");
		System.out.println("     *****************************     *  ");
		System.out.println("  *  ()       () () () () ()          *   ");
		System.out.println("*         *    *                   *      ");
		System.out.println(" *******************************-ds        ");
		System.out.println("            *     *                       ");
		System.out.println("             ******                       ");
		System.out.println("Welcome to Jet Green Airlines!");
		System.out.println();
		System.out.println("Please choose an option from our menu");
		System.out.println();
		System.out.println("a. Login");
		System.out.println("b. Create a new user");
		System.out.println("c. Forgot password");
		System.out.println("d. Exit");
		System.out.println("e. See users");
		System.out.println("------ results of the option ------");
		

	}
}
