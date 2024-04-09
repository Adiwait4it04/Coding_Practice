import java.util.*;
import java.io.*;
class Hash{
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(3);
        set.add(2);
        System.out.println(set.size());
        System.out.println(set);
        boolean a = set.contains(1);
        if (a) {
            System.out.println("contains");
        } else {
            System.out.println("not contains");
        }
        Iterator it =set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }


    }
}