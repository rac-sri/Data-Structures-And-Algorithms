import java.util.*;

class GfG {

  static class Node {
    int data;
    Node left, right;
  }

  static Node newNode(int item) {
    Node temp = new Node();
    temp.data = item;
    temp.left = null;
    temp.right = null;
    return temp;
  }

  static int findDistance(Node root, int x) {
    if (root == null) return -1;

    int dist = -1;

    if (
      (root.data == x) ||
      (dist = findDistance(root.left, x)) >= 0 ||
      (dist = findDistance(root.right, x)) >= 0
    ) return dist + 1;

    return dist;
  }

  public static void main(String[] args) {
    Node root = newNode(5);
    root.left = newNode(10);
    root.right = newNode(15);
    root.left.left = newNode(20);
    root.left.right = newNode(25);
    root.left.right.right = newNode(45);
    root.right.left = newNode(30);
    root.right.right = newNode(35);

    System.out.println(findDistance(root, 45));
  }
}
