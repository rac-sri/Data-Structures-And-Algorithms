import java.util.*;

class Node {
  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = null;
    right = null;
  }
}

public class LevelOrderTraverse {
  Node root;

  public static void main(String args[]) {
    LevelOrderTraverse tree_level = new LevelOrderTraverse();
    tree_level.root = new Node(1);
    tree_level.root.left = new Node(2);
    tree_level.root.right = new Node(3);
    tree_level.root.left.left = new Node(4);
    tree_level.root.left.right = new Node(5);

    System.out.println("Level order traversal " + "of binary tree is - ");
    tree_level.printLevelOrder();
  }

  void printLevelOrder() {
    Queue<Node> records = new LinkedList<Node>();
    records.add(root);

    while (!records.isEmpty()) {
      Node tempNode = records.poll();

      System.out.print(tempNode.data + " ");

      if (tempNode.left != null) {
        records.add(tempNode.left);
      }
      if (tempNode.right != null) {
        records.add(tempNode.right);
      }
    }
  }
}
