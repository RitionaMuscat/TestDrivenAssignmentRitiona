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

	public static void main(String[] args) {
		try {
			if (args.length != 0) {

				System.out.println(getStringMovie(args[0]));
				System.out.println(getJsonDefinition(args[4]));
				System.out.println(getJsonCurrency(Double.parseDouble(args[3]), args[2], args[1]));

			}

		} catch (InputMismatchException ex) {
			System.err.print(ex.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException n) {
			System.out.println("Args is null: " + n.getMessage());
		} catch (IndexOutOfBoundsException I) {
			System.out.println(" " + I.getMessage());
		}

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

}
