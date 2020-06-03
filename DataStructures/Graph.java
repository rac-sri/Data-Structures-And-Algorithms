import java.util.List;

public abstract class Graph {
  int numVertices = 0;

  public void addVertex() {
    implementAddVertex();
    numVertices++;b
  }

  public abstract void implementAddVertex();

  public abstract List<Integer> geNeighbors(int v);
}

public class GraphAdjMatrix extends Graph{
    private int[][] adjMatrix;
    
    public List<Integer> getNeighbours(int v){
        List<Integer> neighbours = ArrayList<Integer>();
        for(int i=0;i<getNumVertives)
    }
}