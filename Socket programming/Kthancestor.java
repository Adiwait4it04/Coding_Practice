public class Kthancestor {

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
    
    public static int kthancestor(Node root,int k,int node)
    {
        if (root==null) {
            return -1;
        }
        if (root.data==node) {
            return 0;
        }
        int left=kthancestor(root.left, k, node);
        int right= kthancestor(root.right, k, node);

        if (left==-1 && right==-1) {
            return -1;
        }

        int max= Math.max(left, right);

        if (max+1==k) {
            System.out.println(root.data);
        }

        return max+1;
    }
    public static void main(String args[])
    {
        
        //         4 
        //      /     \
        //     1       6
        //    / \     / \
        //   0   2   5   7
        //        \       \
        //         3       8


        Node root= new Node(4);
        root.left=new Node(1);
        root.left.left=new Node(0);
        root.left.right=new Node(2);
        root.left.right.right=new Node(3);
        root.right=new Node(6);
        root.right.left=new Node(5);
        root.right.right=new Node(7);
        root.right.right.right=new Node(8);

        kthancestor(root, 2, 8);
    }
}
