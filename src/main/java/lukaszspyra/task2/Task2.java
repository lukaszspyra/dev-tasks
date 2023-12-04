package lukaszspyra.task2;

import java.io.PrintStream;
import java.util.Arrays;

public class Task2 {

  /**
   * Used as a field to capture state for output unit test.
   */
  private PrintStream out;

  Task2(PrintStream out) {
    this.out = out;
  }

  void findPairsSumming13(final int[] input) {
    Arrays.sort(input);
    int targetSum = 13;
    int beginIndex = 0;
    int endIndex = input.length - 1;
    boolean isFirstLine = true;

    while (beginIndex < endIndex) {
      int sum = input[beginIndex] + input[endIndex];
      if (sum < targetSum) {
        beginIndex++;
      } else if (sum > targetSum) {
        endIndex--;
      } else {
        printPair(input[beginIndex], input[endIndex], isFirstLine);
        isFirstLine = false;
        beginIndex++;
      }
    }
  }

  private void printPair(int firstNumber, int secondNumber, boolean isFirstLine) {
    if (isFirstLine) {
      out.printf("%d %d", firstNumber, secondNumber);
    } else {
      out.printf("\n%d %d", firstNumber, secondNumber);
    }
  }

}
