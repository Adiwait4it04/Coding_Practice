import java.util.*;
import java.io.*;
 class Node{
    Node root;
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

class ancestor {
    public static boolean path(Node root , ArrayList<Node> arr,int k)
    {
        if (root==null) {
            return false;
        }
        arr.add(root);
        if (root.data==k) {
            return true;
        }
        boolean ls=path(root.left, arr, k);
        boolean rs=path(root.right, arr, k);
        if (ls||rs) {
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }

    public static Node getpath(Node root,int n1,int n2)
    {
        ArrayList<Node> arr1= new ArrayList<>();
        ArrayList<Node> arr2= new ArrayList<>();
        path(root, arr2, n2);
        path(root, arr1, n1);
        System.out.println(arr1);
        System.out.println(arr2);
        int i=0;
        for(i=0;i<arr1.size()&&i<arr2.size();i++)
        {
            if (arr1.get(i)!=arr2.get(i)) {
                break;
            }
        }
        Node a = arr1.get(i-1);
        
        return a;
    }

    public static int kaam(Node root, int k) {
        if (root == null) {
            return 0;
        }
        if(root.data==k)
        {
            return 1;
        }
        int ls=kaam(root.left, k);
        int rs=kaam(root.right, k);
        if(ls==1||rs==1)
        {
            System.out.println(root.data);
            return 1;
        }
        return 0;
    
    }

       
    public static void main(String[] args)
    {
        ArrayList<Integer>arr=new ArrayList<>();
        Node root= new Node(4);
        root.left=new Node(1);
        root.left.left=new Node(0);
        root.left.right=new Node(2);
        root.left.right.right=new Node(3);
        root.right=new Node(6);
        root.right.left=new Node(5);
        root.right.right=new Node(7);
        root.right.right.right=new Node(8);
        // int k = kaam(root, 7);
        Node j = getpath(root, 8, 5);
        // System.out.println(arr);
        System.out.println(j.data);
        System.out.println(j);

    }
}