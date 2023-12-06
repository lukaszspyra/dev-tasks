package lukaszspyra;

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
    output.println("Enter list of integer separated by spaces, confirm with ENTER. Application will print distinct numbers and statistics:");
  }

  private void invalidInput() {
    output.println("Invalid input try again.");
  }

  public void printPair(int firstNumber, int secondNumber, boolean isFirstLine) {
    if (isFirstLine) {
      output.printf("%d %d", firstNumber, secondNumber);
    } else {
      output.printf("\n%d %d", firstNumber, secondNumber);
    }
  }

  public void task2Usage() {
    output.println("Enter list of integer separated by spaces, confirm with ENTER. Application will all the pairs in the " +
        "list, that sum up to 13 in ascending order. First number will be always not greater that second one");
  }

}
