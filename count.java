import java.util.HashMap;

public class count {
    public static void count(String str)
    {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char c: str.toCharArray())
        {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else
            {
                map.put(c, 1);
            }
        }
        for(char c:map.keySet())
        {
            if (map.get(c)>1) {
                System.out.println(c);
            }
        }
    }
    public static void main(String[] args)
    {
        count("geeksforgeeks");
    }
}
