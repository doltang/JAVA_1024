package day04;

public class NestingForStarEx02 {

	public static void main(String[] args) {
		/* *		row = 1  * = 1
		 * **		row = 2  * = 2
		 * ***		row = 3  * = 3
		 * ****		row = 4  * = 4
		 * *****	row = 5  * = 5
		 * 					 * = row  -> 이 규칙을 조건식에 대입!
		 * */
		
		int num = 5;
		int row, col;
		
		for (col = 1; col <= num; col++) { 
			for (row = 1; row <= col; row++) { 
				System.out.print("*");
			}
			System.out.println();
		}
		/*      *  row = 1 공백 = 4 		* = 1
		 *     **  row = 2 공백 = 3 		* = 2
		 *    ***  row = 3 공백 = 2 		* = 3
		 *   ****  row = 4 공백 = 1 		* = 4
		 *  *****  row = 5 공백 = 0 		* = 5
		 *  			   공백 = 5-row  * = row  -> 이 규칙을 조건식에 대입!
		 *  */ 
		
		for (row = 1; col <= num; row++) { 
			// 공백 출력 5-row 개
			for (col = 1; col <= num-row; col++) { 
				System.out.print(" ");
			}
			// *출력 row개
			for (col = 1; col <= row; col++) { 
				System.out.print("*");
			}
			// 엔터
			System.out.println();
		}
	/*   *		row = 1 공백 = 4 		* = 1
	    ***		row = 2 공백 = 3 		* = 3
	   *****	row = 3 공백 = 2 		* = 5
	  *******	row = 4 공백 = 1 		* = 7
	 *********	row = 5 공백 = 0 		* = 9
	 *					공백 = 5-row 		* = row*2-1 -> 이 규칙을 조건식에 대입!
	 */
		for (row = 1; row <= num; row++) { 
			// 공백 출력 5-row 개
			for (col = 1; col <= num-row; col++) { 
				System.out.print(" ");
			}
			// *출력 row개
			for (col = 1; col <= row*2-1; col++) { 
				System.out.print("*");
			}
			// 엔터
			System.out.println();
		}
		
		// 또 다른 방법
		for (row = 1; row <= num; row++) { 
			// 공백 출력 5-row 개
			for (col = 1; col <= num-row; col++) { 
				System.out.print(" ");
			}
			// *출력 row개
			for (col = 1; col <= row; col++) { 
				System.out.print("*");
			}
			// *출력 row-1개
			for (col = 1; col <= row-1; col++) { 
				System.out.print("*");
			}
			// 엔터
			System.out.println();
		}
	}

}
