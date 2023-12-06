package lukaszspyra.task3;

import lukaszspyra.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task3 {

  private final Console console;

  Task3(final Console console) {
    this.console = console;
  }

  void startApp(){
    console.task3Usage();
    final InputGraphData graphData = console.readGraphData();
    findSeparateGraphs(graphData.getConnectionsNumber(), graphData.getConnectedVertices());
  }

  /**
   * Prints number of separated graphs, based on the pairs of connections.
   *
   * <pre>
   * e.g. for the given input:
   *   3
   * 1 2
   * 2 3
   * 4 5
   *
   * visualized as:
   * [1]-[2]-[3]
   *
   * [4]-[5]
   *
   * results in printing 2 for separated graphs.
   * </pre>
   *
   * @param connections number of connections(edges)
   * @param input       pairs of vertices forming connection
   */
  void findSeparateGraphs(final int connections, final int[][] input) {
    Map<Integer, List<Integer>> graphModel = createGraphModel(input, connections);
    int separatedGraphs = countSeparatedGraphs(graphModel);
    console.printNumber(separatedGraphs);
  }

  private int countSeparatedGraphs(final Map<Integer, List<Integer>> graphModel) {
    int coutSeparateGraphs = 0;
    Set<Integer> visitedNodes = new HashSet<>();
    for (Integer rootNode : graphModel.keySet()) {
      if (!visitedNodes.contains(rootNode)) {
        coutSeparateGraphs++;
        visitAllChildrenDFSRecursive(rootNode, graphModel, visitedNodes);
      }
    }
    return coutSeparateGraphs;
  }

  /**
   * Visits all adjacent nodes recursively using depth first search algorithm.
   * Visited nodes are added to the set of values. Recursion stops when new root node is already visited.
   *
   * @param rootNode     current node treated as root
   * @param graphModel   model
   * @param visitedNodes set of visited nodes
   */
  private void visitAllChildrenDFSRecursive(final Integer rootNode, final Map<Integer, List<Integer>> graphModel, final Set<Integer> visitedNodes) {
    visitedNodes.add(rootNode);
    for (Integer newRoot : graphModel.get(rootNode)) {
      if (!visitedNodes.contains(newRoot)) {
        visitAllChildrenDFSRecursive(newRoot, graphModel, visitedNodes);
      }
    }
  }

  /**
   * Creates graphs model in form of collection of vertices and corresponding adjacent list
   *
   * @param verticesPairs pair forming connections in graph
   * @param connections   number of connection
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
