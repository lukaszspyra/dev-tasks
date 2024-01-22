package lukaszspyra.task3;

import lukaszspyra.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task3 {

  private final Console console;

  Task3(final Console console) {
    this.console = console;
  }

  void startApp() {
    console.task3Usage();
    final InputGraphData graphData = console.readGraphData();
    findSeparateGraphs(graphData);
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
   * @param inputGraphData graph model
   */
  void findSeparateGraphs(InputGraphData inputGraphData) {
    Map<Integer, List<Integer>> graphModel = inputGraphData.getVerticesWithChildren();
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

}
