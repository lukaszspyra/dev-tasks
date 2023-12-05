package lukaszspyra.task3;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {

  /**
   * Used as a field to capture state for output unit test.
   */
  private PrintStream out;

  Task3(final PrintStream out) {
    this.out = out;
  }

  void printSeparateGraphs(final int connections, final int[][] input) {
    Map<Integer, List<Integer>> graphModel = createGraphModel(input, connections);

  }

  /**
   * Creates graphs model in form of collection of vertices and corresponding adjacent list
   *
   * @param verticesPairs pair forming connections in graph
   * @param connections   number of connections
   * @return modelled graph
   */
  private Map<Integer, List<Integer>> createGraphModel(final int[][] verticesPairs, int connections) {
    Map<Integer, List<Integer>> verticesWithAdjacents = new HashMap<>();
    for (int i = 0; i < connections; i++) {
      int vertex1 = verticesPairs[i][0];
      int vertex2 = verticesPairs[i][1];
      final List<Integer> vertex1adj = verticesWithAdjacents.getOrDefault(vertex1, new ArrayList<>());
      vertex1adj.add(vertex2);
      verticesWithAdjacents.put(vertex1, vertex1adj);

      final List<Integer> vertex2adj = verticesWithAdjacents.getOrDefault(vertex2, new ArrayList<>());
      vertex2adj.add(vertex1);
      verticesWithAdjacents.put(vertex2, vertex2adj);
    }
    return verticesWithAdjacents;
  }

}
