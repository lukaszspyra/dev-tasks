package lukaszspyra.task2;

import lukaszspyra.Console;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    Map<Integer, Integer> intsWithOccurrence = new TreeMap<>();
    int requiredSum = 13;
    boolean isFirstLine = true;

    for (int currentNumber : input) {
      intsWithOccurrence.put(currentNumber, incrementQuantity(intsWithOccurrence, currentNumber));
    }
    for (Integer key : intsWithOccurrence.keySet()) {
      int pairingSumKey = requiredSum - key;
      if (key <= pairingSumKey && intsWithOccurrence.containsKey(pairingSumKey)) {
        for (int i = 0; i < intsWithOccurrence.get(pairingSumKey) * intsWithOccurrence.get(key); i++) {
          console.printPair(key, pairingSumKey, isFirstLine);
          if (isFirstLine) isFirstLine = false;
        }
      }
    }
  }

  private static int incrementQuantity(final Map<Integer, Integer> intsWithOccurrence, final int currentNumber) {
    return intsWithOccurrence.getOrDefault(currentNumber, 0) + 1;
  }
}
