package lukaszspyra.task1;

import lukaszspyra.IntegerParser;

import java.io.PrintStream;
import java.text.ParseException;
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

  List<Integer> readNumberList() {
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

  void printStats(String message) {
    output.print(message);
  }

  void printNumbers(final Map<Integer, List<Integer>> batchProcessedNumbers) {
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

  void task1Usage() {
    output.println("Enter list of integer separated by spaces, confirm with ENTER. Application will print distinct numbers and statistics:");
  }

  void invalidInput() {
    output.println("Invalid input try again.");
  }

}
