import java.util.*;
public class Hashset {
    public static void main(String[] args) {
         HashSet<Integer> set = new HashSet<>();
         set.add(5);
         set.add(6);
         set.add(1);
         set.add(2);
        //  System.out.println(set);
        //  System.out.println(set.contains(5));
        //  System.out.println(set.size());
        //  System.out.println(set.isEmpty());
        //  set.clear();
        // LinkedHashSet<Integer> hSet = new LinkedHashSet<>();//jis order mei gaya tha usme print hoga
        // TreeSet<Integer> tset = new TreeSet<>();//null value insert nahi kar sakte kyuki sort karta hai.
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
}
