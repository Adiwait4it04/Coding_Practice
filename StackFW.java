import java.util.*;
public class StackFW{
    public static void main(String args[]){
        Stack <Integer> n =new Stack<>();
        n.push(1);
        n.push(2);
        n.push(3);
        n.push(4);
        n.push(5);
        while(!n.isEmpty()){
            System.out.println(n.peek());
            n.pop();
    }
}
}

