import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Fx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		while (true) {
			Menu menu = new Menu();
			num = menu.selectMenu();
			if (num == 0) {
				System.out.println("System Terminated.");
				break;
			}
			else if (num != 1 && num != 2 && num != 3) {
				System.out.println("Wrong menu ID.");
				break;
			}
			Exchanges exc = new Exchanges();
			exc.exchange(num);
		}
	}
}

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

class Exchanges {
	void exchange(int num) {
		// get input won amount
		System.out.print("Korean Won: ");
		Scanner sc = new Scanner(System.in);
		int won = sc.nextInt();
		calculation(won, num);
		//exact
//		double dollar = won / fx;
//		System.out.printf("In USD: %.2f dollars\nfx rate: %.2f\n", dollar, fx);
//		System.out.println();
	}
		
	void calculation(int won, int menu) {
		List<String> bills = new ArrayList<String>();
		String currency_key = "";
		//deciding which currency and bills to use
		switch (menu) {
		case FCV.MENU_USD:
			currency_key = "USD";
			bills = Arrays.asList(FCV.USD_BILLS);
			break;
		case FCV.MENU_EUR:
			currency_key = "EUR";
			bills = Arrays.asList(FCV.EUR_BILLS);
			break;
		case FCV.MENU_JPY:
			currency_key = "JPY";
			bills = Arrays.asList(FCV.JPY_BILLS);
			break;
		default:
			break;
		}
		double fx = FCV.RATES.get(currency_key);		//set the fx rate
		
// === exchange calculation parts starts here ===
		// calculate amounts to return
		double toCurrency = Math.floor(won / fx);  // amount in destination currency
		int change = (int)(Math.floor((won - (toCurrency * fx))/FCV.MIN_KOR) * FCV.MIN_KOR); 	// amount of change in won
	
		// calculate which bills and how many  
		Map<String, Integer> changeDolBills = new HashMap<String, Integer>(); 
			for (int i = 0; i < bills.size(); i++) {
				changeDolBills.put(bills.get(i), 0);
			}
		Map<String, Integer> changeWonBills = new HashMap<String, Integer>() {{ 
			for (int i = 0; i < FCV.WON_BILLS.length; i++) {
				put(FCV.WON_BILLS[i], 0);
			}
		}};

		//cal dollar bills quantities
		double amountTemp = toCurrency;					//to deduct from foreign currency
		for (String x: bills) {							//calculate quantity of each bills to return 
			int temp = (int)(amountTemp / Integer.parseInt(x));
			changeDolBills.put(x, temp);
			amountTemp -= temp * Integer.parseInt(x);
		}
		
		//cal won bills quantities
		long wonTemp = change;							//to deduct from change
		while (wonTemp > 0) {
			for (String x: FCV.WON_BILLS) {
				Integer temp = (int)(wonTemp / Integer.parseInt(x));
				changeWonBills.put(x, temp);
				wonTemp -= temp * Integer.parseInt(x);
			}
		}
// === printing parts starts here ===
		System.out.printf("In %s: %.0f %s\nChange: %d\nFx rate: %.2f\n\n", 
				currency_key, toCurrency, FCV.CURRENCY.get(currency_key), change, fx);
		
		for (String x: FCV.USD_BILLS) {
			System.out.printf("%s %s: %d\n\n", x, FCV.CURRENCY.get(currency_key), changeDolBills.get(x));
		}

		for (String x: FCV.WON_BILLS) {
			System.out.printf("%s %s: %d\n\n", x, FCV.CURRENCY.get("KRW"), changeWonBills.get(x));
		}
		System.out.println();
	}
}
