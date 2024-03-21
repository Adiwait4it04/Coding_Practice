import java.util.*;
public class StackAL{
    static class Stack{
         ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty(){
            return list.size()==0;
        }
        public void push(int data){
            list.add(data);
        }
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top =list.remove(list.size()-1);
            return top;
        }
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]){
        Stack n = new Stack();
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

// import java.util.ArrayList;

// public class StackAL {
//     static class Stack {
//         ArrayList<Integer> list = new ArrayList<>();

//         public void push(int data) {
//             list.add(data);
//         }

//         public boolean isEmpty() {
//             return list.size() == 0;
//         }

//         public int pop() {
//             if(isEmpty()) {
//                 return -1;
//             }
//             int top = list.remove(list.size()-1);
//             return top;
//         }

//         public int peek() {
//             if(isEmpty()) {
//                 return -1;
//             }
//             return list.get(list.size()-1);
//         }
//     }
//     public static void main(String args[]) {
//         Stack stack = new Stack();
//         stack.push(1);
//         stack.push(2);
//         stack.push(3);
//         stack.push(4);

//         while(!stack.isEmpty()) {
//             System.out.println(stack.peek());
//             stack.pop();
//         }
//     }
// }