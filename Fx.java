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
				break;
			}
			else if (num != 1 || num != 2 || num != 3) {
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
		System.out.println("1. USD\n2. EUR\n3. JPY");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		return num;
	}
}

class Exchanges {
	final static double W2Dfx = 1134.30;
	final static double W2Efx = 1333.09;
	final static double W2Yfx = 10.30;
	final static String[] currency = {"USD", "EUR", "JPY"};
	final static String[] wonBills = {"1000", "500", "100", "50", "10"};
	final static String[] dolBills = {"100", "50", "20", "10", "5", "1"};
	final static String[] eurBills = {"500", "200", "100", "50", "20", "10"};
	final static String[] jpyBills = {"10000", "5000", "2000", "1000"};
	
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
		double fx = 0.0;
		List<String> bills = new ArrayList<String>();
		switch (menu) {
		case 1:
			fx = W2Dfx;
			bills = Arrays.asList(dolBills);
			break;
		case 2:
			fx = W2Efx;
			bills = Arrays.asList(eurBills);
			break;
		case 3:
			fx = W2Yfx;
			bills = Arrays.asList(jpyBills);
			break;
		default:
			break;
		}
		
		//for bankers use
		double toCurrency = Math.floor(won / fx);  // amount in destination currency
//		long wonc = (Math.round((dollar - dollarc) * fx)/10) * 10 ; // or
		int change = (int)(Math.floor((won - (toCurrency * fx))/10) * 10); 	// amount of change in won
		String cur = currency[menu-1];
		System.out.printf("In %s: %.0f dollars\nChange: %d\nfx rate: %.2f\n\n", cur, toCurrency, change, fx);
	
		System.out.println(1);
		double amountTemp = toCurrency;					//to deduct
		long wonTemp = change;
		Map<String, Integer> changeDolBills = new HashMap<String, Integer>(); 
			for (int i = 0; i < bills.size(); i++) {
				changeDolBills.put(bills.get(i), 0);
			}
		Map<String, Integer> changeWonBills = new HashMap<String, Integer>() {{ 
			for (int i = 0; i < wonBills.length; i++) {
				put(wonBills[i], 0);
			}
		}};
		
		//cal dollar bills
		for (String x: bills) {
			int temp = (int)(amountTemp / Integer.parseInt(x));
			changeDolBills.put(x, temp);
			amountTemp -= temp * Integer.parseInt(x);
		}
		System.out.println(2);
		//sort by keys, destination currency
		List<Integer> desKeyInt = new ArrayList<>() {{
			for (String x: changeDolBills.keySet()) {
				add(Integer.parseInt(x));
			}
		}};
		desKeyInt.sort(Integer::compareTo);
		System.out.println(3);
		
		for (Integer x: desKeyInt) {
			System.out.println(x +": "+ changeDolBills.get(x+""));
		}
		System.out.println();
		
		//cal won bills
		while (wonTemp > 0) {
			for (String x: wonBills) {
				Integer temp = (int)(wonTemp / Integer.parseInt(x));
				changeWonBills.put(x, temp);
				wonTemp -= temp * Integer.parseInt(x);
			}
		}
		//sort by keys, won
		List<Integer> wonKeyInt = new ArrayList<>() {{
			for (String x: changeWonBills.keySet()) {
				add(Integer.parseInt(x));
			}
		}};
		wonKeyInt.sort(Integer::compareTo);
		for (Integer x: wonKeyInt) {
			System.out.println(x +": "+ changeWonBills.get(x+""));
		}	
		System.out.println();
	}
}
