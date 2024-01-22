package lukaszspyra.task3;

import java.util.List;
import java.util.Map;

public class InputGraphData {

  private final int connectionsNumber;
  private final Map<Integer, List<Integer>> verticesWithChildren;


  public InputGraphData(final int connectionsNumber, final Map<Integer, List<Integer>> verticesWithChildren) {
    this.connectionsNumber = connectionsNumber;
    this.verticesWithChildren = verticesWithChildren;
  }

  int getConnectionsNumber() {
    return connectionsNumber;
  }

  Map<Integer, List<Integer>> getVerticesWithChildren() {
    return verticesWithChildren;
  }

}
