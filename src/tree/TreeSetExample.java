package tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {

        TreeSet<String> set = new TreeSet<>();

        //null not allow in tree set
       // set.add(null);

        set.add("A");
        set.add("A");
        set.add("A");


        set.add("D");
        set.add("E");
        set.add("C");
        set.add("B");

        // no duplicate and sorted all element
        for(String s : set){
            System.out.println(s);
        }

    }
}
