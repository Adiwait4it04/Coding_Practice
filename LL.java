class LL{
    Node head;
    class Node
    {
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(String data){
        Node newnode= new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newnode;
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head= head.next;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode.next.next!=null){
            currNode=currNode.next;
        }
        currNode.next=null;
    }
    public void getsize(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        int count =0;
        while(currNode!=null){
            count++;
            currNode=currNode.next;
        }
        System.out.println("Size of list is: "+count);
    }
    public void reverse(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node prev = head;
        Node currNode = head.next;
        while(currNode!=null){
            Node nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }

    }
    public void print(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+"-->");
            currNode=currNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args)
    {
        LL list = new LL();
        list.addLast("A");
        list.addLast("B"); 
        list.addLast("C");
        list.print();
        // list.deleteFirst();
        // list.print();
        list.getsize();
        list.deleteLast();
        list.print();
        list.getsize();
    }
}