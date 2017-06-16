package stack;

public class StackExample1 {

	public static void main(String[] args) {
		Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        while(!s.isEmpty()){
        	System.out.println("stack element:"+s.pop());
        }
	}

}
