import java.util.*;

public class lowestancestor {

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
    public static int pathdistance(Node ancestor,int dist,int k)
    {
        if (ancestor==null) {
            return -1;
        }
        if (ancestor.data == k) {
            return 0;
        }
        int left = pathdistance(ancestor.left, dist, k);
        int right=pathdistance(ancestor.right, dist, k);

        if (left==-1 && right==-1) {
            return -1;
        }
        else if (left==-1) {
            return right+1;
        }
        else
        {
            return left+1;
        }
    }
    public static boolean getpath(Node root, ArrayList<Node> path,int k)
    {
        if (root==null) {
            return false;
        }
        if (root.data==k) {
            path.add(root);
            return true;
        }
        if (getpath(root.left, path, k)||getpath(root.right, path, k)) {
            path.add(root);
            return true;
        }
        return false;
    }
    public static Node ancestor(Node root,int a , int b)
    {
        ArrayList<Node> arr1= new ArrayList<>();
        ArrayList<Node> arr2= new ArrayList<>();
        getpath(root, arr1,5 );
        getpath(root, arr2, 8);
        Collections.reverse(arr1);
        Collections.reverse(arr2);
        for(int i=0;i<arr1.size()&&i<arr2.size();i++)
        {
            if (arr1.get(i)!=arr2.get(i)&&i==0) {
                System.out.println(arr1.get(i).data);
                return arr1.get(i);
            }
            else if (arr1.get(i)!=arr2.get(i)) {
                System.out.println(arr1.get(i-1).data);
                return arr1.get(i-1); 
            }
        }
        return null;
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
        Node ancestor=ancestor(root, 5, 8);
        System.out.println("Minimum distance between 5 and 8 = "+(pathdistance(ancestor, 0, 8)+pathdistance(ancestor, 0, 5)));
        
        }
    }

