public class Kthleveltree {

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
    public static void KthLevel(Node root,int k,int f)
    {
        if (root==null) {
            return;
        }
        if (f==k) {
            System.out.println(root.data);
        }
        KthLevel(root.left, k, f+1);
        KthLevel(root.right, k, f+1);
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
        KthLevel(root, 3, 0);
    }
}
