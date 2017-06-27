package stack;

class SpecialStack extends Stack{

	Stack minstack = new Stack(1000);
	
	
	public boolean push(int x) {
		if(isEmpty()){
			super.push(x);
			minstack.push(x);
		}else{
			super.push(x);
			int y = minstack.peek();
			if(x <= y){
				minstack.push(x);
			}
		}
		return true;
	}

	public int pop() {
		int x = super.pop();
		int y = super.peek();
		if(x==y){
		 minstack.pop();
		}
		 return x;
	}
	
	public int min(){
		return minstack.peek();
	}

}
public class StackExample5 {
	public static void main(String[] args) {
		SpecialStack specialStack = new SpecialStack();
		specialStack.push(10);
		specialStack.push(20);
		specialStack.push(30);
	    System.out.println("min value : "+specialStack.min());
	    specialStack.push(5);
	    System.out.println("min value : "+specialStack.min());
	}
}
