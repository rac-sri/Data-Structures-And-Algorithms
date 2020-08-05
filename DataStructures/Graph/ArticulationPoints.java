import java.io.*;
import java.util.*;

class ArticulationPoints {
  private int V;

  private LinkedList<Integer> adj[];
  int time = 0;
  static final int NIL = -1;

  ArticulationPoints(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList();
    }
  }

  void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
  }

  //  We maintain an array disc[] to store discovery time of vertices. For every node u, we need to find out the earliest visited vertex (the vertex with minimum discovery time) that can be reached from subtree rooted with u. So we maintain an additional array low[] which is defined as follows.
  // A recursive function that find articulation points using DFS
  //         low[u] = min(disc[u], disc[w])
  // where w is an ancestor of u and there is a back edge from
  // some descendant of u to w.
  // u --> The vertex to be visited next
  // visited[] --> keeps tract of visited vertices
  // disc[] --> Stores discovery times of visited vertices
  // parent[] --> Stores parent vertices in DFS tree
  // ap[] --> Store articulation points

  void APUtil(
    int u,
    boolean visited[],
    int disc[],
    int low[],
    int parent[],
    boolean ap[]
  ) {
    int children = 0; // count the children
    visited[u] = true;
    disc[u] = low[u] = ++time;

    Iterator<Integer> i = adj[u].iterator();
    while (i.hasNext()) {
      int v = i.next(); //  v is adjacent of u
      if (!visited[v]) {
        children++;
        parent[v] = u;
        APUtil(v, visited, disc, low, parent, ap);

        // Check if the subtree rooted with v has a connection to
        // one of the ancestors of u
        low[u] = Math.min(low[u], low[v]);

        // u is an articulation point in following cases

        // (1) u is root of DFS tree and has two or more chilren.
        if (parent[u] == NIL && children > 1) ap[u] = true;

        // (2) If u is not root and low value of one of its child
        // is more than discovery value of u.
        if (parent[u] != NIL && low[v] >= disc[u]) ap[u] = true;
      } else if (v != parent[u]) low[u] = Math.min(low[u], disc[v]);
    }
  }
}
