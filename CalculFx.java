import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CalculFx {
	boolean amounts(int won, String currency_key, List<String> bills) throws IOException {
		double fx = FCV.RATES.get(currency_key);		//set the fx rate

		// calculate amounts to return
		double toCurrency = Math.floor(won / fx) - (Math.floor(won / fx) % Integer.parseInt(bills.get(bills.size()-1)));  // amount in destination currency
		
		PrintingFx prt = new PrintingFx();
		WritingFx wrt = new WritingFx();
		if (!checkBalance(toCurrency, currency_key)) { //false == no balance
			prt.printsErr(currency_key, toCurrency, fx);
			wrt.writesSummary(currency_key, toCurrency, fx);
			wrt.writesErr(currency_key, toCurrency, fx);
			return false;
		} else {
			int change = (int)(Math.floor((won - (toCurrency * fx))/FCV.MIN_KOR) * FCV.MIN_KOR); 	// amount of change in won
		
			// calculate which bills and how many  
			Map<String, Integer> changeDesBills = new LinkedHashMap<String, Integer>();
				for (int i = 0; i < bills.size(); i++) {				//bills.size is variable not working as won bills
					changeDesBills.put(bills.get(i), 0);
				}
			Map<String, Integer> changeWonBills = new LinkedHashMap<String, Integer>() {{ // serializable to study  
				for (int i = 0; i < FCV.WON_BILLS.length; i++) {
					put(FCV.WON_BILLS[i], 0);
				}
			}};
	
			//cal dollar bills quantities
			double amountTemp = toCurrency;					//to deduct from foreign currency
			for (String x: bills) {							//calculate quantity of each bills to return 
				int temp = (int)(amountTemp / Integer.parseInt(x));
				changeDesBills.put(x, temp);
				amountTemp -= temp * Integer.parseInt(x);
			}
			
			//cal won bills quantities
			long wonTemp = change;		
			while (wonTemp > 0) {
				for (String x: FCV.WON_BILLS) {
					Integer temp = (int)(wonTemp / Integer.parseInt(x));
					changeWonBills.put(x, temp);
					wonTemp -= temp * Integer.parseInt(x);
				}
			}
			
			prt.printsSummary(currency_key, toCurrency, change, fx);
			prt.printsBal(currency_key);
			prt.printsBills(currency_key, toCurrency, change, fx, changeDesBills, changeWonBills, bills);

			wrt.writesSummary(currency_key, toCurrency, fx);
			wrt.writesBal(currency_key);
			wrt.writesBills(currency_key, toCurrency, change, fx, changeDesBills, changeWonBills, bills);
			
			return true;
		}
	}
	
	boolean checkBalance(double toCurrency, String currency_key) {
		FCV.BALANCE_TEMP = FCV.BALANCES.get(currency_key) - toCurrency;	
		if (FCV.BALANCE_TEMP < 0) {	
			return false;
		} else {
			FCV.BALANCES.put(currency_key, FCV.BALANCE_TEMP);
			return true;
		}
	}
}