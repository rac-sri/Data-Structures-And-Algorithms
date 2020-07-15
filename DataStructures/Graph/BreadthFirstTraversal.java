import java.util.*;

public class BreadthFirstTraversal {

  static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
    adj.get(v).add(u);
  }

  static void BFS(ArrayList<ArrayList<Integer>> adj, int V) {
    boolean visites[] = new boolean[V + 1];
    for (int i = 1; i <= V; i++) {
      visites[i] = false;
    }

    LinkedList<Integer> queue = new LinkedList<Integer>();
    int s = 1;
    visites[s] = true;
    queue.add(s);

    // Mark the current node as
    // visited and enqueue it

    while (queue.size() != 0) {
      s = queue.poll();
      System.out.print(s + " ");

      // Travers the adjacent elements of s

      for (int i = 0; i < adj.get(s).size(); i++) {
        int newNode = adj.get(s).get(i);

        if (visites[newNode] == false) {
          visites[newNode] = true;
          queue.add(newNode);
        }
      }
    }
  }

  public static void main(String[] args) {
    // Creating a graph with 6 vertices
    int V = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(
      V + 1
    );

    for (int i = 0; i < V + 1; i++) adj.add(new ArrayList<Integer>());

    // Adding edges one by one
    addEdge(adj, 1, 2);
    addEdge(adj, 1, 3);
    addEdge(adj, 2, 4);
    addEdge(adj, 2, 5);
    addEdge(adj, 3, 5);
    addEdge(adj, 4, 5);
    addEdge(adj, 4, 6);
    addEdge(adj, 5, 6);

    BFS(adj, V);
  }
}
