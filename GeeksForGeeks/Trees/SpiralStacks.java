/*
Level order traversal in spiral form
Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.


 
 

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
The function should print level order traversal in spiral form.

Your Task:
The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 30
0 <= Number of nodes <= 105
1 <= Data of a node <= 105

Example:
Input:
2
1 3 2  
10 20 30 40 60 
Output:
1 3 2
10 20 30 60 40 

Explanation:
Testcase1: The tree is
        1
     /      \
   3       2
So, the spiral level order would be 1 3 2
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
So, the spiral level order would be 10 20 30 60 40
 

Note: The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

*/

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

  void printSpiral(Node root) {
    if (root == null) return;

    Stack<Node> s1 = new Stack<Node>();
    Stack<Node> s2 = new Stack<Node>();

    s1.push(root);

    while (!s1.isEmpty() || !s2.empty()) {
      while (!s1.isEmpty()) {
        Node temp = s1.pop();
        System.out.print(temp.data + " ");

        if (temp.right != null) {
          s2.push(temp.right);
        }
        if (temp.left != null) {
          s2.push(temp.left);
        }
      }

      while (!s2.isEmpty()) {
        Node temp = s2.pop();
        System.out.print(temp.data + " ");

        if (temp.left != null) {
          s1.push(temp.left);
        }
        if (temp.right != null) {
          s1.push(temp.right);
        }
      }
    }
  }
}
