// implementation using adjacent list approach

import java.util.*;

class DataStructure<T> {
  private Map<T, List<T>> map = new HashMap<>(); // for edges

  public void addVertix(T s) {
    map.put(s, new LinkedList<T>());
  }

  public void addEdge(T source, T destination, boolean bidirectional) {
    if (!map.containsKey(source)) {
      addVertix(source);
    }
    if (!map.containsKey(destination)) {
      addVertix(destination);
    }
    map.get(source).add(destination);

    if (bidirectional == true) map.get(destination).add(source);
  }

  public void getVertexCount() {
    System.out.println("Graph has " + map.keySet().size() + " vertex");
  }

  public void getEdgesCount(boolean bidirectional) {
    int count = 0;
    for (T v : map.keySet()) { //for each to iterate over all the vertices
      count += map.get(v).size();
    }

    if (bidirectional == true) {
      count = count / 2;
    }

    System.out.println("THe graph has " + count + " edges");
  }

  public void hasVertex(T s) {
    if (map.containsKey(s)) {
      System.out.println("The key " + s + " is present in the graph");
    } else {
      System.out.println("The key " + s + " is not present in the graph");
    }
  }

  public void hasEdge(T s, T d) {
    if (map.get(s).contains(d)) {
      System.out.println("The graph has an edge between " + s + " and" + d);
    } else {
      System.out.println("The graph has no edge between " + s + " and" + d);
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    for (T v : map.keySet()) {
      builder.append(v.toString() + ": ");
      for (T w : map.get(v)) {
        builder.append(w.toString() + " ");
      }
      builder.append("\n");
    }
    return builder.toString();
  }
}

class Graph {

  public static void main(String args[]) {
    DataStructure<Integer> g = new DataStructure<Integer>();

    g.addEdge(0, 1, true);
    g.addEdge(0, 4, true);
    g.addEdge(1, 2, true);
    g.addEdge(1, 3, true);
    g.addEdge(1, 4, true);

    System.out.println("Graph:\n" + g.toString());

    g.getVertexCount();

    g.getEdgesCount(true);

    g.hasEdge(3, 4);

    g.hasVertex(5);
  }
}
