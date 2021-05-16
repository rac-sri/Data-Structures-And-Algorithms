public class GraphColor {
  final int V = 4;
  int[] color;

  boolean isSafeToColor(int v, int[][] graphMatrix, int[] color, int c) {
    // check each edge
    for (int i = 0; i < V; i++) {
      if (graphMatrix[v][i] == 1 && c == color[i]) {
        return false;
      }
    }
    return true;
  }

  boolean graphColorUtil(int[][] graphMatrix, int m, int[] color, int v) {
    // all verices are assigned a color then return true
    if (v == V) {
      return true;
    }

    // Try different colors for vertext V
    for (int i = 1; i <= m; i++) {
      // check for assignment safety
      if (isSafeToColor(v, graphMatrix, color, i)) {
        color[v] = i;
        if (graphColorUtil(graphMatrix, m, color, v + 1)) {
          return true;
        }
        // if color doesnt lead to solution
        color[v] = 0;
      }
    }

    // if no color can be assigned to vertex
    return false;
  }

  void printColoringSolution(int color[]) {
    System.out.println("Color schema for verices");
    for (int i = 0; i < V; i++) {
      System.out.println(color[i]);
    }
  }

  boolean graphColoring(int[][] graphMatrix, int m) {
    // initialize all color values as 0
    color = new int[V];
    Arrays.fill(color, 0);

    // call graphcolorutil() for vertex -
    if (!graphColorUtil(graphMatrix, m, color, 0)) {
      return false;
    }

    printColoringSolution(color);
    return true;
  }

  public static void main(String args[]) {
    GraphColor graphColor = new graphColor();

    int graphMatrix[][] = {
      { 0, 1, 1, 1 },
      { 1, 0, 1, 0 },
      { 1, 1, 0, 1 },
      { 1, 0, 1, 0 },
    };
    int m = 3; // Number of colors
    graphColor.graphColoring(graphMatrix, m);
  }
}
