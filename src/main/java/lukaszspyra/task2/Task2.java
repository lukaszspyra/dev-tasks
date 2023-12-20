package lukaszspyra.task2;

import lukaszspyra.Console;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {

  private final Console console;

  public Task2(final Console console) {
    this.console = console;
  }

  void startApp() {
    console.task2Usage();
    findPairsSumming13(console.readNumberList());
  }

  public void findPairsSumming13(final List<Integer> input) {
    Map<Integer, Integer> pairsWithOccurrence = new TreeMap<>();
    int requiredSum = 13;
    boolean isFirstLine = true;
    for (int i = 0; i < input.size(); i++) {
      int currentNumber = input.get(i);
      pairsWithOccurrence.put(currentNumber, pairsWithOccurrence.getOrDefault(currentNumber, 0) + 1);
    }

    for (Integer key : pairsWithOccurrence.keySet()) {
      int pairingSumKey = requiredSum - key;
      if (pairsWithOccurrence.containsKey(pairingSumKey) && key <= pairingSumKey) {

        for (int i = 1; i <= pairsWithOccurrence.get(pairingSumKey); i++) {
          for (int j = 1; j <= pairsWithOccurrence.get(key); j++) {
            console.printPair(key, pairingSumKey, isFirstLine);
            isFirstLine = false;
          }
        }
      }
    }
  }

}
