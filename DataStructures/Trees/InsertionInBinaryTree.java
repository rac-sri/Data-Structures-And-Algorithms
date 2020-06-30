import java.util.*;

public class InsertionInBinaryTree {

  static class Node {
    int key;
    Node left, right;

    // constructor
    Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }

  static Node root;

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("Inorder traversal before insertion: ");
    inorder(root);

    int key = 12;
    insert(root, key);

    System.out.print("\nInorder traversal after insertion: ");
    inorder(root);
  }

  static void inorder(Node temp) {
    if (temp == null) {
      return;
    }

    inorder(temp.left);
    System.out.print(temp.key + " ");
    inorder(temp.right);
  }

  // use levelOrderTraversing to check empty places

  static void insert(Node node, int value) {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);

    while (!q.isEmpty()) {
      Node temp = q.poll();

      if (temp.left == null) {
        temp.left = new Node(value);
        break;
      } else {
        q.add(temp.left);
      }

      if (temp.right == null) {
        temp.right = new Node(value);
        break;
      } else {
        q.add(temp.right);
      }
    }
  }
}
