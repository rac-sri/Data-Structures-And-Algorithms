import java.util.*;

class Node {
  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = right = null;
  }
}

public class LowestCommonAncestos {

  Node lca(Node root, int n1, int n2) {
    if (root == null) return null;

    if (root.data == n1 || root.data == n2) {
      return root;
    }

    Node leftPosition = lca(root.left, n1, n2);
    Node rightPosition = lca(root.right, n1, n2);

    if (leftPosition != null && rightPosition != null) {
      return root;
    }

    return leftPosition == null ? rightPosition : leftPosition;
  }
}
