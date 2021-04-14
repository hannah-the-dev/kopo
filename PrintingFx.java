import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PrintingFx {
//		prints currency, amounts, fx rates
	void printsSummary(String currency_key, double toCurrency, int change, double fx) throws IOException { 
		System.out.printf("In %s: %.0f %s\nChange: %d\nFx rate: %.2f\n\n", 
				currency_key, toCurrency, FCV.CURRENCY.get(currency_key), change, fx);
	}		
//			prints counts and type of bills
	void printsBills(String currency_key, double toCurrency, int change, double fx, 
			Map changeDolBills, Map changeWonBills, List<String> bills) throws IOException {
		for (String x: bills) {
			System.out.printf("%s %s: %d\n", x, FCV.CURRENCY.get(currency_key), changeDolBills.get(x));
		}
		System.out.println();

		for (String x: FCV.WON_BILLS) {
			System.out.printf("%s %s: %d\n", x, FCV.CURRENCY.get("KRW"), changeWonBills.get(x));
		}
		System.out.println();
	}
	void printsBal(String currency_key) throws IOException {
		System.out.printf("%s Balance is %.2f.\n", currency_key, FCV.BALANCES.get(currency_key));
	}
	void printsErr(String currency_key, double toCurrency, double fx) throws IOException {
		System.out.printf("In %s: %.0f %s\nFx rate: %.2f\n\n", 
				currency_key, toCurrency, FCV.CURRENCY.get(currency_key), fx);
		System.out.printf("%s Balance is not enough.\n", currency_key);
		printsBal(currency_key);
	}
}