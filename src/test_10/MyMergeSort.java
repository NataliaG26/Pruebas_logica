package test_10;

import java.util.Arrays;

public class MyMergeSort {
	
	public static void main(String[] args) {
		//int a[] = {14, 33, 27, 10, 35, 19, 42, 44};
		//int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int a[] = {14, 33, 27, 10, 35, 19, 42, 0, 44, 14, 33, 27, 10, 35, 19, 42, 44};
		int c[] = MergeSort(a);
		System.out.println(Arrays.toString(c));
	}
	
	private static int[] MergeSort(int[] a){

		return DivMergeSort(a, 0, a.length-1);
	}

	private static int[] DivMergeSort(int[] a, int init, int fin){

		if(init < fin){
			int pos = (init + fin)/2;
			int[] left = DivMergeSort(a, init, pos);
			int [] rigth = DivMergeSort(a, pos+1, fin);
			
			int [] c = new int[left.length + rigth.length];
			int posL = 0;
			int posR = 0;
			
			for(int i = 0; i < c.length; i++) {
				if(posL < left.length && posR < rigth.length && left[posL] <= rigth[posR]){
					c[i] = left[posL];
					posL++;
				}else if(posL < left.length && posR < rigth.length && left[posL] > rigth[posR]){
					c[i] = rigth[posR];
					posR++;
				}else if(posL < left.length){
					c[i] = left[posL];
					posL++;
				}else {
					c[i] = rigth[posR];
					posR++;
				}
			}
			
			return c;
			
		}else{
			int[] c = {a[init]};
			return c;
		}

	}

}
