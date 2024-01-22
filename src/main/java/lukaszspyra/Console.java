package lukaszspyra;

import lukaszspyra.task3.InputGraphData;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {

  private final Scanner input;
  private final PrintStream output;
  private final IntegerParser integerParser;

  public Console(final Scanner input, final PrintStream output, final IntegerParser integerParser) {
    this.input = input;
    this.output = output;
    this.integerParser = integerParser;
  }

  public List<Integer> readNumberList() {
    final String line = input.nextLine();
    final String[] strings = line.trim().split("\\s+");
    List<Integer> integers = null;
    try {
      integers = integerParser.parse(strings);
    } catch (ParseException e) {
      invalidInput();
      System.exit(1);
    }
    return integers;
  }

  public InputGraphData readGraphData() {
    int numberOfConnections = readFirstPositiveNumber();
    Map<Integer, List<Integer>> connectedVertices = readPairs(numberOfConnections);
    return new InputGraphData(numberOfConnections, connectedVertices);
  }

  private int readFirstPositiveNumber() {
    final String line = input.nextLine().trim();
    int numberOfConnections = 0;
    try {
      numberOfConnections = integerParser.parse(line);
      if (numberOfConnections <= 0) {
        invalidInput();
        System.exit(1);
      }
    } catch (ParseException e) {
      invalidInput();
      System.exit(1);
    }
    return numberOfConnections;
  }

  private Map<Integer, List<Integer>> readPairs(final int numberOfConnections) {
    Map<Integer, List<Integer>> verticesWithAdjacents = new HashMap<>();
    for (int i = 0; i < numberOfConnections; i++) {
      final String line = input.nextLine().trim();
      final String[] strings = line.split("\\s+");
      if (strings.length != 2) {
        invalidInput();
        System.exit(1);
      }
      try {
        final List<Integer> integers = integerParser.parse(strings);
        fillUpGraphModel(verticesWithAdjacents, integers);
      } catch (ParseException e) {
        invalidInput();
        System.exit(1);
      }
    }
    return verticesWithAdjacents;
  }

  private static void fillUpGraphModel(final Map<Integer, List<Integer>> verticesWithAdjacents, final List<Integer> integers) {
    int vertex1 = integers.get(0);
    int vertex2 = integers.get(1);

    final List<Integer> vertex1adj = verticesWithAdjacents.getOrDefault(vertex1, new ArrayList<>());
    vertex1adj.add(vertex2);
    verticesWithAdjacents.put(vertex1, vertex1adj);

    final List<Integer> vertex2adj = verticesWithAdjacents.getOrDefault(vertex2, new ArrayList<>());
    vertex2adj.add(vertex1);
    verticesWithAdjacents.put(vertex2, vertex2adj);
  }

  public void printStats(String message) {
    output.print(message);
  }

  public void task1Usage() {
    output.println("Application will print distinct numbers and statistics from entered integers.\nType list of integers separated by spaces, confirm with ENTER:");
  }

  private void invalidInput() {
    output.println("Invalid input try again.");
  }

  public void task2Usage() {
    output.println("Application will print all the pairs in the list, that sum up to 13, in ascending order. First number will be not greater that second one.\n" +
        "Enter list of integer separated by spaces, confirm with ENTER:");
  }

  public void task3Usage() {
    output.println("Application will print number of separated graphs.\nThe first line of input shall contain one POSITIVE number n, next exactly n lines shall contain pairs " +
        "of positive integers,\nwhere each pair identifies a connection between two vertices in a graph.\n" +
        "Enter data, each line confirm with ENTER:");
  }

  public void printNumber(final int separatedGraphs) {
    output.print(separatedGraphs);
  }

  public void printPair(final int pairingSumKey, final int currentNumber, final boolean isFirstLine) {
    if (isFirstLine) {
      output.printf("%d %d", pairingSumKey, currentNumber);
    } else {
      output.printf("\n%d %d", pairingSumKey, currentNumber);
    }
  }

  private boolean flaga = true;

  public void printProcessedElements(final Integer e) {
    if (flaga) {
      output.printf("%d", e);
      flaga = false;
    } else {
      output.printf(" %d", e);
    }
  }

}
