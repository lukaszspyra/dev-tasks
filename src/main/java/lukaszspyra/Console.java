package lukaszspyra;

import lukaszspyra.task3.InputGraphData;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {

  private final Scanner input;
  private final PrintStream output;
  private final IntegerParser integerParser;

  private static boolean isStreamFirstElement = true;

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
    int[][] connectedVertices = readPairs(numberOfConnections);
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

  private int[][] readPairs(final int numberOfConnections) {
    int[][] pairs = new int[numberOfConnections][2];
    for (int i = 0; i < numberOfConnections; i++) {
      final String line = input.nextLine().trim();
      final String[] strings = line.split("\\s+");
      if (strings.length != 2) {
        invalidInput();
        System.exit(1);
      }
      try {
        final List<Integer> integers = integerParser.parse(strings);
        pairs[i][0] = integers.get(0);
        pairs[i][1] = integers.get(1);
      } catch (ParseException e) {
        invalidInput();
        System.exit(1);
      }
    }
    return pairs;
  }

  public void printStats(String message) {
    output.print(message);
  }

  public void printNumbers(final Map<Integer, List<Integer>> batchProcessedNumbers) {
    output.print(batchProcessedNumbers.values()
        .stream()
        .flatMap(List::stream)
        .sorted()
        .findFirst().orElseThrow(() -> new RuntimeException("Empty stream")));
    batchProcessedNumbers.values()
        .stream()
        .flatMap(List::stream)
        .sorted()
        .skip(1)
        .forEach(e -> output.printf(" %d", e));
    output.print("\n");
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

  public void printStreamElements(final int element) {
    if (isStreamFirstElement) {
      output.printf("%d", element);
      isStreamFirstElement = false;
    } else {
      output.printf(" %d", element);
    }
  }

}
