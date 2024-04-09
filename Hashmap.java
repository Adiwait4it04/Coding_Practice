import java.util.*;
import java.io.*;
class Hashmap {
public static void main(String[] args) {

    HashMap<String,Integer> map = new HashMap<>();
    map.put("India",120);
    map.put("US",30);
    map.put("US",23);
    System.out.println(map);
    if(map.containsKey("US"))
    {
        System.out.println("Key present");
    }
    else{
        System.out.println("Not present");
    }
    for(Map.Entry<String,Integer> e : map.entrySet()){
        System.out.println(e.getKey());
        System.out.println(e.getValue());
    }
    map.remove("US");
    System.out.println(map);

    }
}