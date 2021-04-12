package problems;

public class Multiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] k21_rows = {1, 4, 7};						// 1단 4단 7단에서 줄바꿈 하기 위한 array 설정
		for (int k21_x : k21_rows) {					// 1단, 4단, 7단에서 
			for (int k21_i = 1; k21_i < 10; k21_i++) {					// 곱할 숫자 1~9
				for (int k21_k = k21_x; k21_k < k21_x+3; k21_k++) {		// 1-2-3, 4-5-6, 7-8-9 단씩 끊어서 계산	
					if (k21_i == 1 && k21_k == k21_x) {					// 1, 4, 7단의 1번째 줄에서 시작 전 단 나눔 출력
						System.out.printf("************************ *********************** ************************ \n");
						System.out.printf("	구구단 %d단		구구단 %d단		 구구단 %d단\n",  k21_k, k21_k+1, k21_k+2);
						System.out.printf("************************ *********************** ************************ \n");
					}				// 연속된 3단 타이틀 한번에 출력
					
					System.out.printf(" %d * %d = %2d		 ", k21_k, k21_i, k21_k * k21_i);
					// 타이틀 출력 후 [1 * 1 = 1        2 * 1 = 2 ... ]형식으로 연속 출력
					// 단을 바꿔가며(k~k+2) 1줄씩 출력
					if (k21_k % 3 == 0) 
						System.out.printf("\n"); 		// 단이 3의 배수일 경우 줄바꿈
				}
			}
		}
	}
}