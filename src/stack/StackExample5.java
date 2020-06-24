package stack;

class SpecialStack<T> extends Stack{

	Stack<Integer> minstack = new Stack<>(1000);
	
	
	public boolean push(Integer x) {
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



	public Integer pop() {
		Integer x = (Integer) super.pop();
		Integer y = (Integer) minstack.peek();
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
		specialStack.push(5);
		specialStack.push(5);
		specialStack.push(15);
		specialStack.push(5);

	    System.out.println("min value : "+specialStack.min());
	    specialStack.pop();
		specialStack.pop();
		specialStack.pop();
		specialStack.pop();

	    System.out.println("min value : "+specialStack.min());
	}
}
