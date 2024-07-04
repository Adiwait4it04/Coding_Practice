import java.util.*;
import java.io.*;
import java.lang.*;

class reversestack {
    public static void pushatbottom(Stack<Integer> stack,int data)
    {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int a = stack.pop();
        pushatbottom(stack, data);
        stack.push(a);
    }
    public static void print(Stack<Integer> stack) {
        while (!stack.isEmpty()) 
        {
        System.out.println(stack.pop());
        }
    }
    public static void reverse(Stack<Integer> stack)
    {
        if(stack.isEmpty())
        {
            return;
        }
        int a =stack.pop();
        reverse(stack);
        pushatbottom(stack, a);
    }

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        print(stack); 
   }
    
}