public class ancestor {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void findancestor(Node root,int parent,int i)
    {
        if (root==null) {
            return;
        }
        
        if (root.data==i) {
            System.out.print(parent);
        }
        findancestor(root.left, root.data, i);
        findancestor(root.right, root.data, i);
    }

    public static void main(String args[])
    {
        Node root= new Node(4);
        root.left=new Node(1);
        root.left.left=new Node(0);
        root.left.right=new Node(2);
        root.left.right.right=new Node(3);
        root.right=new Node(6);
        root.right.left=new Node(5);
        root.right.right=new Node(7);
        root.right.right.right=new Node(8);
        findancestor(root, -1, 6);
    }
}