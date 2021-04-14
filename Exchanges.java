import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Menu {
	int selectMenu() {
		int num = 0;
		System.out.println("Choose Currency :");
		System.out.println("1. USD\n2. EUR\n3. JPY\n0. Exit");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		return num;
	}
}

public class Exchanges {
	List<String> bills = new ArrayList<String>();
	boolean exchange(int menu) throws IOException {
		// get input won amount
		System.out.print("Korean Won: ");
		Scanner sc = new Scanner(System.in);
		int won = sc.nextInt();
		WritingFx wrt = new WritingFx();
		wrt.writesWon(won);
		String currency_key = findingKeys(won, menu);			//bills: to fill List
		CalculFx calcul = new CalculFx();
		boolean balcheck = calcul.amounts(won, currency_key, bills);
		return balcheck;
	}
		
	private String findingKeys(int won, int menu) {
		//deciding which currency and bills to use
		String currency_key = "";
		switch (menu) {
		case FCV.MENU_USD:
			currency_key = "USD";
			this.bills = Arrays.asList(FCV.USD_BILLS);
			break;
		case FCV.MENU_EUR:
			currency_key = "EUR";
			this.bills = Arrays.asList(FCV.EUR_BILLS);
			break;
		case FCV.MENU_JPY:
			currency_key = "JPY";
			this.bills = Arrays.asList(FCV.JPY_BILLS);
			break;
		default:
			break;
		}
		return currency_key;
	}	
}