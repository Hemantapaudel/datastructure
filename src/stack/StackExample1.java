package stack;

import java.util.Stack;

/**
 * java utils stack service : LIFO
 */
public class StackExample1 {

	public static void main(String[] args) {

        Stack<String> s = new Stack<>();
        s.push("10");
        s.push("20");
        s.push("30");

        // look at the top of the stack without remove
        System.out.println(s.peek());

        //remove the top object from the stack
        System.out.println(s.pop());

        //nearest distance of the given element from the top
        System.out.println(s.search("10"));

        while (! s.isEmpty()){
            System.out.println(s.pop());
        }
        System.out.println(s.pop());
	}

}
