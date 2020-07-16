import java.util.*;
import sun.reflect.generics.tree.Wildcard;

// won't work for negative sum cycle
//Bellman-Ford works better (better than Dijkstra's) for distributed systems. Unlike Dijksra's where we need to find the minimum value of all vertices, in Bellman-Ford, edges are considered one by one.

class BellmanFord {

  class Edge {
    int src, dest, weight;

    Edge() {
      src = dest = weight = 0;
    }
  }

  int V, E;
  Edge edge[];

  BellmanFord(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[e];
    for (int i = 0; i < e; i++) {
      edge[i] = new Edge();
    }
  }

  void BellmanFordAlgo(BellmanFord graph, int src) {
    int V = graph.V, E = graph.E;
    int dist[] = new int[V];

    // intialize infinity or max value to all entries
    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;

    // Now Relax all edged |v|-1 times.A simple shortest path from src to any other vertex can
    // have at-most |V| - 1 edges

    // ab ab bd bc da.... all seq  = v-1 * e

    for (int i = 1; i < V; i++) {
      for (int j = 0; j < E; j++) {
        int u = graph.edge[j].src;
        int v = graph.edge[j].dest;
        int weight = graph.edge[j].weight;
        if (
          dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]
        ) dist[v] = dist[u] + weight;
      }
    }

    // check negative cycle. We shouldn't get any other shorter path in this step
    for (int j = 0; j < E; ++j) {
      int u = graph.edge[j].src;
      int v = graph.edge[j].dest;
      int weight = graph.edge[j].weight;
      if (
        dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]
      ) System.out.println("Graph contains negative weight cycle");
    }
    printArr(dist, V);
  }

  void printArr(int dist[], int V) {
    System.out.println("Vertex   Distance from Source");
    for (int i = 0; i < V; ++i) System.out.println(i + "\t\t" + dist[i]);
  }

  public static void main(String[] args) {
    int V = 5;
    int E = 8;

    BellmanFord graph = new BellmanFord(V, E);

    graph.edge[0].src = 0;
    graph.edge[0].dest = 1;
    graph.edge[0].weight = -1;

    graph.edge[1].src = 0;
    graph.edge[1].dest = 2;
    graph.edge[1].weight = 4;

    graph.edge[2].src = 1;
    graph.edge[2].dest = 2;
    graph.edge[2].weight = 3;

    graph.edge[3].src = 1;
    graph.edge[3].dest = 3;
    graph.edge[3].weight = 2;

    graph.edge[4].src = 1;
    graph.edge[4].dest = 4;
    graph.edge[4].weight = 2;

    graph.edge[5].src = 3;
    graph.edge[5].dest = 2;
    graph.edge[5].weight = 5;

    graph.edge[6].src = 3;
    graph.edge[6].dest = 1;
    graph.edge[6].weight = 1;

    graph.edge[7].src = 4;
    graph.edge[7].dest = 3;
    graph.edge[7].weight = -3;

    graph.BellmanFordAlgo(graph, 0);
  }
}
