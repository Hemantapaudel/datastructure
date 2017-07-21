package arrays;






public class StockBuySell {
	
	
	private static  void stockBuySell(int[]arr){
	/*	//pojo class
		class Stock{
			int start;
			int end;
			
			public void setEnd(int end) {
				this.end = end;
			}
			
			public Stock(int start, int end){
				this.start =start;
				this.end = end;
			}
			
			@Override
			public String toString() {
				return "start = "+ start+ " end= "+end;
			}
		}
		
		Stock stock = null;
		for(int current =0; current < arr.length-1; current++){
			
			int nextIndex = current+1;
			if( arr[nextIndex] > arr[current] && stock == null){
				stock = new Stock(current,0);
			}
			if(stock != null &&  arr[current] > arr[nextIndex]){
				stock.setEnd(current);
				System.out.println(stock);
				stock = null;
			}
		}
		if(stock != null){
			stock.setEnd(arr.length-1);
			System.out.println(stock);
		}
		*/
		int buy =0;
		boolean isBuy= false;
		for(int i =0; i < arr.length-1; i++){
			
			if(isBuy == false  && arr[i] < arr[i+1]){
				buy = i;
				isBuy = true;
			} 
			if(isBuy == true && arr[i] > arr[i+1]){
				System.out.println("buy = "+buy + " sell ="+ i);
				isBuy = false;
			}
		}
		if(isBuy == true){
			System.out.println("buy = "+buy + " sell ="+ (arr.length-1));
		}
	}
	
	public static void main(String[] args) {
		 int price[] = {100, 180, 260, 310, 40, 535, 695,120,110,100,200};
		 stockBuySell(price);
	}
}
