package home;

import java.io.IOException;

public class TestClass {

	public static void main(String[] args) throws IOException {

		DataLayer  dLayer = new DataLayer();
		LogicLayer layer = new LogicLayer(dLayer);

		System.out.println(layer.getCurrencyConversion("EUR","GBP",115.20) + "\n");
		System.out.println(layer.getDefinition("who")+ "\n");
		System.out.println(layer.getMovie("Lucifer")+ "\n");

	}

}
