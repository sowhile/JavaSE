/**
 * @author WangDa
 * @version 1.0
*/

import java.util.Scanner;

public class HollowPyramid{
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		System.out.print("«Î ‰»Î≤„ ˝£∫");
		int layer = myScanner.nextInt();

		for(int i = 1; i <= layer; i++){
			for(int k = 1; k <= (2 * layer - 2) - i; k++){
				System.out.print(" ");
			}
			for(int j = 1; j <= (2 * i - 1); j++){
				if(i != layer && (j == 1 || j == (2 * i - 1)))
		 			System.out.print("*");
		 		else if(i != layer)
		 			System.out.print(" ");
		 		else
		 			System.out.print("*");
			}
			if(i != layer)
				System.out.println();
		}
	}
}