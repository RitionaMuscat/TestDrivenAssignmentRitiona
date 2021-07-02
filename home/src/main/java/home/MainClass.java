package home;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	
	static MovieDataLayer data = new MovieDataLayer();
	static DictionaryDataLayer data_1 = new DictionaryDataLayer();
	static CurrencyDataLayer data_2 = new CurrencyDataLayer();
	
	static CurrencyLogicLayer logic = new CurrencyLogicLayer(data_2);
	static DictionaryLogicLayer logic_1 = new DictionaryLogicLayer(data_1);
	static MovieLogicLayer logic_2 = new MovieLogicLayer(data);

	static Scanner sc = new Scanner(System.in);
	static int i = 0;
	
	public static void main(String[] args) throws IOException {
		Menu();
		
	}


	public static String getStringMovie(String input) throws IOException {
		return logic_2.getMovie(input);
	}

	public static String getJsonCurrency(Double amount, String currencyFrom, String currencyTo) {
		return logic.getCurrencyConversion(currencyTo, currencyFrom, amount);
	}

	public static List<String> getJsonDefinition(String word) {
		return logic_1.getDefinition(word);
	}

	public static void Menu() throws IOException {
		
		try {
			do {
				System.out.print("Choose From The Below To Get Data From: \n");
				System.out.println("1 - Movies");
				System.out.println("2 - Currency Conversion");
				System.out.println("3 - Get Word Definition");
				System.out.println("4 - Exit");

				String userChoice = sc.next();

				i++;

				if (userChoice.equals("1")) {
					System.out.println("Please enter Movie Name: ");
					String input = sc.next();
					if (input.length() != 0) {
						System.out.println("\n" + getStringMovie(input));
					}
				} else if (userChoice.equals("2")) {
					System.out.println("Enter Amount: ");
					Double Amount = sc.nextDouble();
					System.out.println("Enter Currency to Convert From: ");
					String currencyFrom = sc.next();
					System.out.println("Enter Currency to Convert to: ");
					String currencyTo = sc.next();
					if (currencyTo != "" && currencyFrom != "" && Amount != 0) {
						System.out.println("\n" + getJsonCurrency(Amount, currencyTo, currencyFrom));
					}
				} else if (userChoice.equals("3")) {
					System.out.println("Enter Word to search: ");
					String word = sc.next();
					System.out.println("\n" + getJsonDefinition(word));
				} else if (userChoice.equals("4")) {
					System.exit(0);
				} else {
					System.out.println("Incorrect Key!");
				}
			} while (i != 3);
		} catch (InputMismatchException ex) {
			System.err.print(ex.getMessage());
		}
	}
}
