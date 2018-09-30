package mainTest;


import java.util.Scanner;

import autocomplete.*;;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("Welcome to mobile keyboard autocompleter test!");
		String input = "";
		AutocompleteProvider ap = new AutocompleteProvider();
		System.out.println("First, let's train your keyboard autocomplete algorithm:");
		// This scanner is reused because of issues with closing and reopening system.in scanners and their effect on the buffer
		Scanner reader = new Scanner(System.in);
		trainer(ap, reader);
		System.out.println("Now, you can either grab some predictions or continue to train your algorithm.");

		// Continuously prompts the user to either train the algorithm, get predictions, or exit
		while(!(input.equals("0")))
		{
			System.out.println("\nPlease enter 1 to train your algorithm, 2 to get predictions, or 0 to exit the program.");
			input = reader.nextLine();
			if(input.equals("1")) 
			{
				trainer(ap, reader);
			}
			else if(input.equals("2")) 
			{
				retriever(ap, reader);
			}
		}
		reader.close();
	}
	
	// Trains the autocompleteProvider based on user input
	public static void trainer(AutocompleteProvider ap, Scanner reader) 
	{
		System.out.println("Please enter text so that we can train your keyboard. Enter STOP to stop training.");
		
		//Grabs input from the user and trains the autocompleteProvider
		String input = reader.nextLine();
		while(!(input.equals("STOP")))
		{
			ap.train(input);
			System.out.println("Continue to enter text or enter STOP to finish.");
			input = reader.nextLine();
		}
	}

	// Retrieves the possible words from the autocompleteProvider and prints them to the user
	public static void retriever(AutocompleteProvider ap, Scanner reader) {
		System.out.println("Now enter word fragments in order to get a list of possible words. ");
		String input = reader.nextLine();
		while(!(input.equals("STOP"))) 
		{
			System.out.println(ap.getWords(input).toString());
			System.out.println("Enter a word fragment or STOP to finish.");
			input = reader.nextLine();
		}
	}
}
