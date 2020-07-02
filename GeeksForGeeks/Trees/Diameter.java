package GeeksForGeeks.Trees;

class Node {
  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = right = null;
  }
}

public class Diameter {
  // diameter =  left subtree max height, 1+level left+level right, right subtree diameter
  Node root;

  int diameter(Node node) {
    if (root == null) return 0;

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    int ldiameter = diameter(root.left);
    int rdiamter = diameter(root.right);

    return Math.max(leftHeight + rightHeight, Math.max(ldiameter, rdiamter));
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
