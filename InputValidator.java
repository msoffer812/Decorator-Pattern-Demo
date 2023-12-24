package assignment6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
	Scanner in;
	
	public InputValidator(Scanner in) {
		this.in = in;
	}
	
	public String getStringInput(String message)
	{
		String ans;
		/*
		 * Loop while the user enters string that isn't allowed
		 * Generally for either a symbol or name that was taken already
		 */
		do
		{
			System.out.println(message);
			ans = in.nextLine().trim();
			message = "Please enter actual input";
		} while(ans.length() == 0);
		
		return ans;
	}
	
	public int getIntInput(String message, 
			int minInputValue, int maxInputValue)
	{
		int input = -1;
		System.out.println(message);
		boolean cont = false;
		/* 
		 * Loops while the user input is invalid:
		 * either it's not an int or it's below or above the maximum allowed value
		 */
		do
		{
			/*
			 * If loop just ran and there was invalid input, 
			 * print out the prompt to reenter
			 */
			if(cont)
			{
				System.out.println("Invalid input, please reenter");
			}
			cont = false;
			try
			{
				//Get input and keyboard buffer
				input = in.nextInt();
				in.nextLine();
			} catch(InputMismatchException e)
			{
				cont = true;
				in.nextLine();
			}
			
			if(input < minInputValue || input>maxInputValue)
			{
				cont = true;
			}
		}while(cont);
		return input;
	}
}
