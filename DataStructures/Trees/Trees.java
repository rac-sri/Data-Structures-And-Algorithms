// pre in and post order traversing

class Node {
  int key;
  Node left, right;

  public Node(int item) {
    key = item;
  }
}

public class Trees {
  Node root;

  Trees() {
    root = null;
  }

  void printPostOrder(Node node) {
    if (node == null) {
      return;
    }

    printPostOrder(node.left);

    printPostOrder(node.right);

    System.out.print(node.key + " ");
  }

  void printPreOrder(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node.key + " ");

    printPreOrder(node.left);
    printPreOrder(node.right);
  }

  void printInOrder(Node node) {
    if (node == null) {
      return;
    }

    printInOrder(node.left);
    System.out.print(node.key + " ");
    printInOrder(node.right);
  }

  public static void main(String[] args) {
    Trees tree = new Trees();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println("Preorder traversal of binary tree is ");
    tree.printPreOrder(tree.root);

    System.out.println("\nInorder traversal of binary tree is ");
    tree.printInOrder(tree.root);

    System.out.println("\nPostorder traversal of binary tree is ");
    tree.printPostOrder(tree.root);
  }
}
