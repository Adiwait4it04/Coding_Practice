
public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTrees {
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]); 
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTrees tree = new BinaryTrees();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        
        // Reset idx for a new test case
        BinaryTrees.idx = -1;
        
        int nodes2[] = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1};
        Node root2 = tree.buildTree(nodes2);
        System.out.println(root2.data);
    }
}