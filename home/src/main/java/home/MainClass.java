package home;

import java.util.InputMismatchException;

public class MainClass {

	static MovieDataLayer data = new MovieDataLayer();
	static DictionaryDataLayer data_1 = new DictionaryDataLayer();
	static CurrencyDataLayer data_2 = new CurrencyDataLayer();

	static CurrencyLogicLayer logic = new CurrencyLogicLayer(data_2);
	static DictionaryLogicLayer logic_1 = new DictionaryLogicLayer(data_1);
	static MovieLogicLayer logic_2 = new MovieLogicLayer(data);

	static int i = 0;

	public static void main(String[] args) {
		try {
			if (args.length != 0)
				APISelections(args);
		} catch (InputMismatchException ex) {
			System.err.print(ex.getMessage());
		} catch (NullPointerException n) {
			System.out.println("Args is null: " + n.getMessage());
		} catch (IndexOutOfBoundsException I) {
			System.out.println(" " + I.getMessage());
		} catch (NumberFormatException nf) {
			System.out.println(" " + nf.getMessage());
		}

	}

	public static void APISelections(String[] args) {
		if (args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				String ARGS = args[i];
				switch (ARGS) {
				case "1":
					System.out.println(logic_2.getMovie(args[0]));
					break;
				case "2":
					System.out.println(logic_1.getDefinition(args[4]));
					break;
				case "3":
					System.out.println(logic.getCurrencyConversion(args[2], args[1], Double.parseDouble(args[3])));
					break;
				}
			}
		}
	}
}
