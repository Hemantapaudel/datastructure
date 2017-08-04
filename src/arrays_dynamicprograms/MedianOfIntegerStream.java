package arrays_dynamicprograms;

import java.util.PriorityQueue;

public class MedianOfIntegerStream {

	PriorityQueue<Integer> lower =  new PriorityQueue<Integer>(10,(e1, e2)-> -1* (e1 -e2));
	
	PriorityQueue<Integer> upper =  new PriorityQueue<Integer>(10,(e1, e2)->  (e1 -e2));
	
	

	public static void main(String[] args) {
			
		
		
		
		MedianOfIntegerStream medianOfIntegerStream = new MedianOfIntegerStream();
		medianOfIntegerStream.addNumber(5);
		medianOfIntegerStream.addNumber(15);
		medianOfIntegerStream.addNumber(1);
		medianOfIntegerStream.addNumber(3);
	}
	
	public int getMedian(){
		if(lower.size() == upper.size()){
			return (lower.peek()+ upper.peek())/2;
		}else{
			return lower.peek();
		}
	}
	
	
	
	
	public void addNumber(int N){
		
		if(lower.size() ==0 || lower.peek() > N){
			lower.add(N);
		}else{
			upper.add(N);
		}
		 balance();
		 System.out.println(getMedian());
	}
	
	
	public void balance(){
		if(lower.size() - upper.size() >=2){
			upper.add(lower.poll());
		}
		if(upper.size() - lower.size() >=2){
			lower.add(upper.poll());
		}
	}
	

}
