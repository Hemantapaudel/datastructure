package matrix;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gopinath
 * 
 * In the grid of NXN, you have to find element appears k times consecutively (up, down, left right, diagonal)
 *  if yes return the element or return -1.
 *  if multiple element exist then return smallest element 
 *
 */
public class MatrixExample1 {

	public static void main(String[] asd)throws Exception{
		int n=5;
		int k=3;
		int arr[][]={{3,5,3,9,5},{4,3,2,1,8},{9,4,3,1,9},{8,4,7,6,4},{1,2,5,9,1}};
		System.out.println(new MatrixExample1().itsThere(n,arr,k));

	}
	public int itsThere(int input1,int[][] input2,int input3){
		
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<input2.length;i++){
			for(int j=0;j<input2[i].length;j++){
				if(checkdown(input2,i,j,input3)){
					list.add(input2[i][j]); 
				}
				if(checkside(input2,i,j,input3)){
					list.add(input2[i][j]); 
				}
				if(checkdiagonal(input2,i,j,input3)){
					list.add(input2[i][j]); 
				}
			}
		}
		int min=Integer.MAX_VALUE;
		for(int re:list){
			if(min>re)min=re;
		}
		if(min==Integer.MAX_VALUE) return -1;
		return min;
	}
	
	private boolean checkdiagonal(int[][] arr, int i, int j, int k) {
		boolean flag=true;
		for(int p=1;p<k;p++){
			if((j+p)<arr[0].length && (i+p)<arr.length){
				if(arr[i+p][j+p]!=arr[i+p-1][j+p-1]){
					flag=false;
					break;
				} 
			} else {
				flag=false;
				break;
			}
		}
		return flag;
	}
	private boolean checkdown(int[][] arr, int i, int j, int k) {
		boolean flag=true;
		for(int p=1;p<k;p++){
			if((i+p)<arr.length){
				if(arr[i+p][j]!=arr[i+p-1][j]){
					flag=false;
					break;
				} 
			} else {
				flag=false;
				break;
			}
		}
		return flag;
	}
	private boolean checkside(int[][] arr, int i, int j, int k) {
		boolean flag=true;
		for(int p=1;p<k;p++){
			if((j+p)<arr[0].length){
				if(arr[i][j+p]!=arr[i][j+p-1]){
					flag=false;
					break;
				} 
			}else {
				flag=false;
				break;
			}
		}
		return flag;
	}
}