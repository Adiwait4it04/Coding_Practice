import java.util.*;
public class StackFW
{
    public static void pushatbottom(int data,Stack<Integer> s){
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }        
        int top = s.pop();
        System.out.println(s);
        pushatbottom(data,s);
        s.push(top);
    }
    public static void main(String args[]){
        Stack <Integer> n =new Stack<>();
        n.push(1);
        n.push(2);
        n.push(3);
        n.push(4);
        n.push(5);
        pushatbottom(7,n);
        while(!n.isEmpty()){
            System.out.println(n.peek());
            n.pop();
    }
}
}

