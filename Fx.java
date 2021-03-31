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
	List<String> bills = new ArrayList<String>();
	boolean exchange(int menu) {
		// get input won amount
		System.out.print("Korean Won: ");
		Scanner sc = new Scanner(System.in);
		int won = sc.nextInt();
		String currency_key = findingKeys(won, menu);			//bills: to fill List
		//위치 중요(바로 멈추게 할 수 있을듯)
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
// === exchange calculation parts starts here ===
class CalculFx {
	boolean amounts(int won, String currency_key, List<String> bills) {
		double fx = FCV.RATES.get(currency_key);		//set the fx rate

		// calculate amounts to return
		double toCurrency = Math.floor(won / fx);  // amount in destination currency
		
		PrintingFx prt = new PrintingFx();
		if (!checkBalance(toCurrency, currency_key)) { //false == no balance
			prt.printsErr(currency_key, toCurrency, fx);
			return false;
		} else {
			int change = (int)(Math.floor((won - (toCurrency * fx))/FCV.MIN_KOR) * FCV.MIN_KOR); 	// amount of change in won
		
			// calculate which bills and how many  
			Map<String, Integer> changeDolBills = new HashMap<String, Integer>();
				for (int i = 0; i < bills.size(); i++) {				//bills.size is variable not working as won bills
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
			
			prt.printsSummary(currency_key, toCurrency, change, fx);
			prt.printsOk(currency_key);
			prt.printsBills(currency_key, toCurrency, change, fx, changeDolBills, changeWonBills);
			
		return true;
		}
	}
	
	boolean checkBalance(double toCurrency, String currency_key) {
		FCV.BALANCE_TEMP = FCV.BALANCES.get(currency_key) - toCurrency;	
		PrintingFx prt = new PrintingFx();
		if (FCV.BALANCE_TEMP < 0) {	
			return false;
		} else {
			FCV.BALANCES.put(currency_key, FCV.BALANCE_TEMP);
			return true;
		}
	}
}

class PrintingFx {
	void printsSummary(String currency_key, double toCurrency, int change, double fx) { 
// === printing parts starts here ===
		System.out.printf("In %s: %.0f %s\nChange: %d\nFx rate: %.2f\n\n", 
				currency_key, toCurrency, FCV.CURRENCY.get(currency_key), change, fx);
	}		
		//나누기//
	void printsBills(String currency_key, double toCurrency, int change, double fx, 
			Map changeDolBills, Map changeWonBills) {
		for (String x: FCV.USD_BILLS) {
			System.out.printf("%s %s: %d\n", x, FCV.CURRENCY.get(currency_key), changeDolBills.get(x));
		}
		System.out.println();

		for (String x: FCV.WON_BILLS) {
			System.out.printf("%s %s: %d\n", x, FCV.CURRENCY.get("KRW"), changeWonBills.get(x));
		}
		System.out.println();
	}
	void printsOk(String currency_key) {
		System.out.printf("%s Balance is %.2f.\n", currency_key, FCV.BALANCES.get(currency_key));
	}
	void printsErr(String currency_key, double toCurrency, double fx) {
		System.out.printf("In %s: %.0f %s\nFx rate: %.2f\n\n", 
				currency_key, toCurrency, FCV.CURRENCY.get(currency_key), fx);
		System.out.printf("%s Balance is not enough.\n\n", currency_key);
	}
}
