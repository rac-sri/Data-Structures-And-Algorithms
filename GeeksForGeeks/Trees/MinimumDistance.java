// Min distance between two given nodes of a Binary Tree
// Given a binary tree and two node values your task is to find the minimum distance between them.

// Input:
// First line of input contains the number of test cases T. For each test case, there will be only a two lines of input first of which is a string representing the tree as described below:

// The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

// For example:

// For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
// The next line contains two integers denoting two nodes a and b.
// There are multiple test cases. For each test case, this method will be called individually.

// Output:
// The function should return min distance between two node values.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function findDist() which takes the root node of the Tree and the two node values as inputs and returns the minimum distance between the nodes represented by the two given node values.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(Height of the Tree).

// Constraints:
// 1 <= T <= 100
// 1 <= Number of nodes <= 104
// 1 <= Data of a node <= 105

// Example:
// Input
// 1
// 2
// 1 2 3
// 2 3

// Output
// 2

// Explanation:
// Test Case 1: The tree formed is:
//       1
//      /   \
//    2     3
// We need the distance between 2 and 3. Being at node 2, we need to take two steps ahead in order to reach node 3. The path followed will be: 2 -> 1 -> 3. Hence, the result is 2.

// Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
class GfG {

  int findDist(Node root, int a, int b) {
    Node lcanode = lca(root, a, b);

    int lca = lcanode.data;
    int lcaDis = distanceFromRoot(root, lca);

    int aDis = distanceFromRoot(root, a);
    int bDis = distanceFromRoot(root, b);
    return aDis + bDis - (2 * lcaDis);
  }

  Node lca(Node root, int a, int b) {
    if (root == null) {
      return null;
    }
    if (root.data == a || root.data == b) {
      return root;
    }
    Node lheight = lca(root.left, a, b);
    Node rheight = lca(root.right, a, b);

    if (lheight != null && rheight != null) return root;

    return lheight != null ? lheight : rheight;
  }

  int distanceFromRoot(Node node, int x) {
    if (node == null) {
      return -1;
    }

    int dist = -1;
    if (
      (node.data == x) ||
      (dist = distanceFromRoot(node.left, x)) >= 0 ||
      (dist = distanceFromRoot(node.right, x)) >= 0
    ) return dist + 1;

    return dist;
  }
}
