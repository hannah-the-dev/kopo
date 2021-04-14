import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Fx {
	public static void main(String[] args) throws IOException {
		String file = "C:\\Users\\kopo21\\Desktop\\Fx_History.txt";		// declare file path
		BufferedWriter bw = new BufferedWriter (new FileWriter(file, true));
		WritingFx wrt = new WritingFx();
	
		int num = 0;
		while (true) {
			Menu menu = new Menu();
			num = menu.selectMenu();
			Exchanges exc = new Exchanges();
			if (num == 0) {
				System.out.println("System Terminated.");
				break;
			} else if (num != 1 && num != 2 && num != 3) {
				System.out.println("Wrong menu ID.");
				break;
			} else {
				Calendar cal = Calendar.getInstance();
				wrt.writesDate(cal.getTime());
				exc.exchange(num);
			}
			wrt.writesAll();
		}
		bw.close();
	}
}