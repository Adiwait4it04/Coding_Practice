public class StackLL{
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=next;
        }
    }
     static class Stack{
        public static Node head;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next= head;
            head= newNode;
        } 
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            Node top=head;
            head=head.next;
            return top.data;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
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
