package queue;

import java.util.Queue;
import java.util.LinkedList;


public class GenerateBinaryNumbers {
	
	
	// using queue
	public static void  generateBinaryNumberUsingQueue(int n){
		Queue<String> queue = new LinkedList<String>();
		queue.add("1");
		int count =1;
		while(n > 0){
			String binaryNumber = queue.remove();
			System.out.println(count + " === "+binaryNumber);
			queue.add(binaryNumber.concat("0"));
			queue.add(binaryNumber.concat("1"));
			n --;
			count++;
		}
		System.out.println("Now size of queue is :"+queue.size());
	}
	
	
	public static  void printBinary(int n){
		int [] binary = new int[10];
		int index =0;
		while(n>0){
			binary[index++] =  n%2;
			n= n/2;
		}	
		System.out.println();
		index--;
		while(index >=0){
			System.out.print(binary[index--]);
		}
		System.out.println();
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		GenerateBinaryNumbers.generateBinaryNumberUsingQueue(20);
		GenerateBinaryNumbers.printBinary(8);
	}

}
