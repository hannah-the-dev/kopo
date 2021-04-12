package problems;

public class Calendar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k21_dayOfWeek = 6; 			// 1/1 금요일부터 시작 (1: 일요일)
		int[] k21_endOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 각 월 막날
		
		for(int k21_month = 1; k21_month < 13; k21_month++) {			// 1월~12월
			System.out.printf("\n\n         %d월\n",k21_month);	
			System.out.printf("=====================\n");
			System.out.printf(" 일 월 화 수 목 금 토\n");	//
			for (int k21_j = 0; k21_j < (k21_dayOfWeek % 7) - 1; k21_j++) {	// 요일 인덱스 번호(일자 고유 번호 % 7) -1 번 반복
				System.out.printf("   ");					// 금요일이면 목요일까지 빈칸(한글 2char+공백) 출력
			}
			for (int k21_i = 1; k21_i < k21_endOfMonth[k21_month - 1] + 1; k21_i++) {	// 각 월 일자만큼 반복
				System.out.printf(" %2d", k21_i);					// 일자 출력
				if (k21_dayOfWeek % 7 == 0) System.out.printf("\n");		// 토요일자 출력 후 줄바꿈
				k21_dayOfWeek++;
			}
		}
	}
}
