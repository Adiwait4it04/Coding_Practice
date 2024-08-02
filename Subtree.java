public class Subtree {

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

    public static int subtree(Node root)
    {
        if (root==null) {
            return 0;
        }
        int left = subtree(root.left);
        int right = subtree(root.right);

        int data = root.data;

        int newleft=root.left==null ? 0 : root.left.data;
        int newright=root.right==null ? 0 : root.right.data;
        root.data= left+ newleft +right+ newright;
        return data;        
    }
    public static void preorder(Node root)
    {
        if (root==null) {
            return;
        }
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    } 
    public static void main(String args[])
    {
        //         4 
        //      /     \
        //     1       6
        //    / \     / \
        //   0   2   5   7
        
        //         21 
        //      /     \
        //     2      12
        //    / \     / \
        //   0   0   0   0

        Node root= new Node(4);
        root.left=new Node(1);
        root.left.left=new Node(0);
        root.left.right=new Node(2);
        root.right=new Node(6);
        root.right.left=new Node(5);
        root.right.right=new Node(7);
        subtree(root);
        preorder(root);
    }
}
