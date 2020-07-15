import java.util.*;

// The Dijkstra's Algorithm doesn't work in the case when the Graph has negative edge weight.

public class Dijkstra {
  static final int V = 9;

  int minDistance(int dist[], Boolean sptSet[]) {
    int min = Integer.MAX_VALUE, minIndex = -1;

    for (int v = 0; v < V; v++) {
      if (sptSet[v] == false && dist[v] <= min) {
        min = dist[v];
        minIndex = v;
      }
    }
    return minIndex;
  }

  void printSolution(int dist[], int n) {
    System.out.println("Vertex   Distance from Source\n");
    for (int i = 0; i < V; i++) System.out.println(
      i + "                " + dist[i] + "\n"
    );
  }

  void dijkstra(int graph[][], int src) {
    int dist[] = new int[V];

    Boolean sptSet[] = new Boolean[V]; // to check if vertex is included in shortest path tree

    // Initialize all distances as INFINITE and stpSet[] as false
    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }

    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
      int u = minDistance(dist, sptSet); // u = src in first iteration

      sptSet[u] = true; // vertex marked done

      for (int v = 0; v < V; v++) {
        if (
          !sptSet[v] &&
          graph[u][v] != 0 &&
          dist[u] != Integer.MAX_VALUE &&
          dist[u] + graph[u][v] < dist[v]
        ) dist[v] = dist[u] + graph[u][v];
      }
    }
    printSolution(dist, V);
  }

  public static void main(String[] args) {
    /* Let us create the example graph discussed above */
    int graph[][] = new int[][] {
      { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
      { 0, 0, 2, 0, 0, 0, 6, 7, 0 },
    };
    Dijkstra t = new Dijkstra();
    t.dijkstra(graph, 0);
  }
}
