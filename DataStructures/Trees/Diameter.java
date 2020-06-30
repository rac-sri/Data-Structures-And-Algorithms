//The diameter of a tree (sometimes called the width) is the
// number of nodes on the longest path between two end nodes

// O(N^2)

import java.util.*;

class Node {
  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = right = null;
  }
}

public class Diameter {
  Node root;

  // calculate the diameter
  int diameter(Node root) {
    if (root == null) {
      return 0;
    }

    int lheight = height(root.left);
    int rheight = height(root.right);

    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);

    return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
  }

  int diameter() {
    return diameter(root);
  }

  int height(Node node) {
    if (node == null) {
      return 0;
    }

    return (1 + Math.max(height(node.left), height(node.right)));
  }

  public static void main(String args[]) {
    Diameter tree = new Diameter();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println(
      "The diameter of given binary tree is : " + tree.diameter()
    );
  }
}
