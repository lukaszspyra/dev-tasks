package lukaszspyra.task1;

import lukaszspyra.Console;

import java.util.IntSummaryStatistics;
import java.util.List;

public class Task1 {

  private final Console console;

  Task1(final Console console) {
    this.console = console;
  }

  void startApp() {
    console.task1Usage();
    final List<Integer> input = console.readNumberList();
    calculateStats(input);
  }


  /**
   * Calculates statistics of given integer list.
   * Includes: count, distinct count, min, max.
   *
   * @param input integers
   */
  void calculateStats(final List<Integer> input) {
    final long size = input.size();
    final IntSummaryStatistics statistics = input.stream()
        .distinct()
        .sorted()
        .peek(console::printProcessedElements)
        .mapToInt(Integer::intValue)
        .summaryStatistics();
    console.printStats("\ncount: " + size + "\n" +
        "distinct: " + statistics.getCount() + "\n" +
        "min: " + statistics.getMin() + "\n" +
        "max: " + statistics.getMax());
  }

}
