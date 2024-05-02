package ch07;

import java.util.Arrays;
// 클래스를 만들때 --> 단일 책임 원칙을 설정하는 것이 좋다.
import java.util.Random;

public class LottoRandomNumber {
	
	final int LOTTO_NUMBERCOUNT = 6;
	
	public int[] createNumber() {
		
		int[] lottoWinNum  = new int[LOTTO_NUMBERCOUNT];
		Random random = new Random();
		
		for (int i = 0; i < lottoWinNum.length; i++) {
			lottoWinNum[i] = random.nextInt(45) + 1;
				
			for (int j = 0; j < i; j++) {
				if(lottoWinNum[j] == lottoWinNum[i]) {
					// 값의 중복
					i--;
				}
			}
		}
		Arrays.sort(lottoWinNum); // 오름차순으로 자동 정렬
		
		return lottoWinNum;
	}
	
	public static void main(String[] args) {
		LottoRandomNumber randomNumber = new LottoRandomNumber();
		int [] resultArray = randomNumber.createNumber();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}
	
//	public void RandomNumber() {
//		Random R = new Random();
//		R.nextInt(50);
//		
//		int[] RandomNum = new int[6];
//		for (int i = 0; i < RandomNum.length; i++) {
//			
//		}
//		
//	}
}
