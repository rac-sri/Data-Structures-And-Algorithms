class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

class MaxLevel {
  int maxLevel;

  MaxLevel() {}
}

class RightOrderView {
  Node root;
  MaxLevel max = new MaxLevel();

  void rightViewUtil(Node node, int level, MaxLevel maxLevel) {
    if (node == null) {
      return;
    }

    if (maxLevel.maxLevel < level) {
      System.out.print(node.data + " ");
      maxLevel.maxLevel = level;
    }

    rightViewUtil(node.right, level + 1, maxLevel);
    rightViewUtil(node.left, level + 1, maxLevel);
  }

  void rightView() {
    rightView(root);
  }

  // A wrapper over rightViewUtil()
  void rightView(Node node) {
    rightViewUtil(node, 1, max);
  }

  public static void main(String args[]) {
    RightOrderView tree = new RightOrderView();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    tree.root.right.left.right = new Node(8);

    tree.rightView();
  }
}
