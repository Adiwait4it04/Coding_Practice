import java.util.*;
import java.io.*;
class Hashmap2
{
    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) 
    {
        //  int nums[]={1,3,2,5,1,3,1,5,1};
        //  HashMap<Integer,Integer> map=new HashMap<>();
        //  for (int i = 0; i < nums.length; i++) {
        //     if (map.containsKey(nums[i])) {
        //         map.put(nums[i],map.get(nums[i])+1);
        //     }
        //     else
        //     {
        //         map.put(nums[i],1);
        //     }
        //  }
        //  Set<Integer> key= map.keySet();
        //  for(Integer i:key)
        //  {
        //     if (map.get(i)>nums.length/3) {
        //         System.out.println(i);
        //     }
        //  }

        // HashMap<Character,Integer> map= new HashMap<>();
        // String s= "knee";
        // String t="keet";
        // map.put('k',1);
        // map.put('n',1);
        // map.put('e',2);;
        // for(int i=0;i<t.length();i++)
        // {
        //     if (map.containsKey(t.charAt(i))) 
        //     {
        //         map.put(t.charAt(i),map.get(t.charAt(i)-1));
        //     }
        //     else{
        //         System.out.println("maa chuda");
        //         break;
        //     }
        //  }
        // HashMap<String,String> map= new HashMap<>();
        // map.put("Chennai","Bengaluru");
        // map.put("Mumbai","Delhi");
        // map.put("Goa","Chennai");
        // map.put("Delhi","Goa");
        // map.put("Chennai","Bengaluru");
        // String start="";
        // for(String s: map.keySet())
        // {
        //     if (!map.containsValue(s)) {
        //         start=s;
        //     }
        // }
        // while (!map.isEmpty()) {
        //     System.out.println(start);
        //     String s=start;
        //     start=map.get(start);
        //     map.remove(s);
        // }
        HashMap<Integer,Integer> map= new HashMap<>();
        int arr[]={15,-2,2,-8,1,7,10};
        int sum=0;
        int len=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if (map.containsKey(sum)) 
            {
                len=Math.max(len, i-map.get(sum));
            }
            else
            {
                map.put(sum,i);
            }
        }
        System.out.println(len);
    }
    
}
