import java.util.*;

public class NumbeOfStronglyConnectedComponents {
  int V;
  LinkedList<Integer>[] adjListArray;

  NumbeOfStronglyConnectedComponents(int V) {
    this.V = V;
    adjListArray = new LinkedList[V];

    // Create a new list for each vertex
    // such that adjacent nodes can be stored

    for (int i = 0; i < V; i++) {
      adjListArray[i] = new LinkedList<Integer>();
    }
  }

  void addEdge(int src, int dest) {
    adjListArray[src].add(dest);
    adjListArray[dest].add(src);
  }

  void DFSUtil(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");

    for (int x : adjListArray[v]) {
      if (!visited[x]) DFSUtil(x, visited);
    }
  }

  void connectedComponents() {
    boolean[] visited = new boolean[V];

    for (int v = 0; v < V; v++) {
      if (!visited[v]) {
        DFSUtil(v, visited);
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    NumbeOfStronglyConnectedComponents g = new NumbeOfStronglyConnectedComponents(
      5
    ); // 5 vertices numbered from 0 to 4

    g.addEdge(1, 0);
    g.addEdge(1, 2);
    g.addEdge(3, 4);
    System.out.println("Following are connected components");
    g.connectedComponents();
  }
}
