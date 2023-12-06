package lukaszspyra.task3;

public class InputGraphData {

  private final int connectionsNumber;
  private final int[][] connectedVertices;


  public InputGraphData(final int connectionsNumber, final int[][] connectedVertices) {
    this.connectionsNumber = connectionsNumber;
    this.connectedVertices = connectedVertices;
  }


  int getConnectionsNumber() {
    return connectionsNumber;
  }

  int[][] getConnectedVertices() {
    return connectedVertices;
  }

}
