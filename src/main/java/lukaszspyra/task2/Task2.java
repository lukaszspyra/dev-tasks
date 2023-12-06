package lukaszspyra.task2;

import lukaszspyra.Console;

import java.util.Collections;
import java.util.List;

public class Task2 {

  private final Console console;

  Task2(final Console console) {
    this.console = console;
  }

  void startApp() {
    console.task2Usage();
    findPairsSumming13(console.readNumberList());
  }

  void findPairsSumming13(final List<Integer> input) {
    Collections.sort(input);
    int targetSum = 13;
    int beginIndex = 0;
    int endIndex = input.size() - 1;
    boolean isFirstLine = true;

    while (beginIndex < endIndex) {
      int sum = input.get(beginIndex) + input.get(endIndex);
      if (sum < targetSum) {
        beginIndex++;
      } else if (sum > targetSum) {
        endIndex--;
      } else {
        console.printPair(input.get(beginIndex), input.get(endIndex), isFirstLine);
        isFirstLine = false;
        beginIndex++;
      }
    }
  }

}
