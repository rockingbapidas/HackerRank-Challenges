import java.util.*;

public class HackerRankTree {
    public static void main(String[] args) {
        //heightOfBinaryTree();
        lowestAnsecster();
    }

    public static void lowestAnsecster() {
        int n = 7;
        int arr[] = new int[]{3,5,6,4,2,7,8};
        Node root = null;
        while(n-- > 0) {
            int data = arr[n];
            root = insert(root, data);
        }
      	int v1 = 1;
      	int v2 = 2;
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }

    public static Node lca(Node root, int v1, int v2) {
        if(root == null) return null;
        
        return null;
    }

    public static void heightOfBinaryTree() {
        int n = 7;
        int arr[] = new int[]{3,5,6,4,2,7,8};
        Node root = null;
        while(n-- > 0) {
            int data = arr[n];
            root = insert(root, data);
        }
        int height = height(root);
        System.out.println(height);
    }

    public static int height(Node root) {
        // Write your code here.
        if(root == null) return -1;

        int leftCount = height(root.left);
        int rightCount = height(root.right);

        return Math.max(leftCount, rightCount) + 1;
    }

    public static Node insert(Node root, int data) {
      if(root == null) {
          return new Node(data);
      } else {
          Node cur;
          if(data <= root.data) {
              cur = insert(root.left, data);
              root.left = cur;
          } else {
              cur = insert(root.right, data);
              root.right = cur;
          }
          return root;
      }
    }

    public static class Node {
        public int data;
    	public Node left;
        public Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}