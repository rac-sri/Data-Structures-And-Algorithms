import java.io.*;
import java.util.*;

class Node {
  int data;
  Node left, right;

  Node(int data) {
    this.data = data;
    left = right = null;
  }
}

class Spiral {

  static Node buildTree(String str) {
    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }

    String ip[] = str.split(" ");
    Node root = new Node(Integer.parseInt(ip[0]));

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    int i = 1;
    while (queue.size() > 0 && i < ip.length) {
      Node currNode = queue.peek();
      queue.remove();

      String currVal = ip[i];

      if (!currVal.equals("N")) {
        currNode.left = new Node(Integer.parseInt(currVal));
        queue.add(currNode.left);
      }
      i++;
      if (i >= ip.length) {
        break;
      }
      currVal = ip[i];

      if (!currVal.equals("N")) {
        currNode.right = new Node(Integer.parseInt(currVal));
        queue.add(currNode.right);
      }

      i++;
    }
    return root;
  }

  void inOrder(Node node) {
    if (node == null) {
      return;
    }

    inOrder(node.left);
    System.out.print(node.data + " ");
    inOrder(node.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      SpiralCheck g = new SpiralCheck();
      g.printSpiral(root);
      System.out.println();
    }
  }
}

class SpiralCheck {
  Node root;
  int side = 1;

  void printSpiral(Node node) {
    root = node;
    levelOrder(root);
  }

  void levelOrder(Node node) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      Node temp = q.poll();
      System.out.print(temp.data + " ");

      if (side == 1) { // left to right , or insert right elements first
        if (temp.right != null) {
          q.add(temp.right);
        }
        if (temp.left != null) {
          q.add(temp.right);
        }
      }

      if (side == 1) { // right to left , or insert left elements first
        if (temp.left != null) {
          q.add(temp.right);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
    }
  }
}
