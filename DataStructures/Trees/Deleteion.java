import java.util.*;

public class Deleteion {

  static class Node {
    int key;
    Node left, right;

    Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }

  static Node root;

  static void inorder(Node temp) {
    if (temp == null) return;

    inorder(temp.left);
    System.out.print(temp.key + " ");
    inorder(temp.right);
  }

  static void deleteDeepest(Node root, Node dNode) {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);

    while (q.isEmpty()) {
      Node temp = q.peek();
      q.remove();

      if (temp.right != null) {
        if (temp.right == dNode) {
          temp.right = null;
          dNode = null;
          return;
        } else q.add(temp.right);
      }

      if (temp.left != null) {
        if (temp.left == dNode) {
          temp.left = null;
          dNode = null;
          return;
        } else q.add(temp.left);
      }
    }
  }

  static void deletion(Node root, int key) {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);

    Node temp = null;
    Node keyNode = null;

    while (!q.isEmpty()) {
      temp = q.peek();
      q.remove();

      if (temp.key == key) {
        keyNode = temp;
      }

      if (temp.left != null) q.add(temp.left);

      if (temp.right != null) q.add(temp.right);
    }

    int x = temp.key;
    deleteDeepest(root, temp);
    keyNode.key = x;
  }

  public static void main(String args[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.left.right = new Node(12);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("Inorder traversal before Deletion:");
    inorder(root);

    int key = 11;
    deletion(root, key);

    System.out.print("\nInorder traversal after Deletion:");
    inorder(root);
  }
}
