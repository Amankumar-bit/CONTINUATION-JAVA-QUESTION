package work7;

import java.util.Arrays;
import java.util.Scanner;

public class vivek {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();

		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scn.nextInt();
			}
			System.out.println(game(arr));
			System.out.println(findMaxDivideCount(arr));

		}

	}

	public static int game(int[] arr) {
		if (arr.length < 2) {
			return 0;
		}
		int[] arr1 = { 0 };
		int[] arr2 = { 0 };
		for (int m = 1; m <= arr.length - 1; m++) {
			arr1 = new int[m];
			arr2 = new int[arr.length - m];
			long sum = 0;
			long lum = 0;
			int k = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i < m) {
					arr1[i] = arr[i];
					sum = sum + arr[i];
				} else {

					arr2[k] = arr[i];
					lum = lum + arr[i];
					k++;
				}
			}
			if (sum == lum) {

				return 1 + Math.max(game(arr1), game(arr2));

			}

		}
		return 0;

	}

	
	private static int findMaxDivideCount(int[] inputs) {
        int n = inputs.length;
        
                if(n < 2) {
            return 0;
        }

       
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += inputs[i];
        }

      
        int leftSum = 0;
        int partitionIndex = 0;
        boolean isEqual = false;
        do {
            
            leftSum += inputs[partitionIndex];
            rightSum -= inputs[partitionIndex];

            
            if(leftSum == rightSum){
                isEqual = true;
                break;
            }
            
        } while(++partitionIndex < n);
        
       
        if(!isEqual) {
            return 0;
        }

        return 1 + Math.max(
                    findMaxDivideCount(Arrays.copyOfRange(inputs, 0, partitionIndex + 1)),       
                    findMaxDivideCount(Arrays.copyOfRange(inputs, partitionIndex + 1, n))
        );
    }
}
