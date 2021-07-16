package home;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestCaseStubs {
	Stubs stubs = new Stubs();

	@Test
	void movieTest() {

		stubs.testMovies();

	}

	@Test
	void jsonDictionaryTest() {

		stubs.testGetDefinition();

	}

	@Test
	void jsonCurrencyConversion() {

		stubs.testJSONCurrency();

	}
}
