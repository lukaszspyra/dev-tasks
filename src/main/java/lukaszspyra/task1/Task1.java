package lukaszspyra.task1;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1 {

  private final Console console;
  private final int batchSize;

  Task1(final int batchSize, final Console console) {
    this.batchSize = batchSize;
    this.console = console;
  }

  void startApp() {
    console.task1Usage();
    final List<Integer> input = console.readNumberList();
    console.printNumbers(batchProcessInput(input));
    console.printStats(calculateStats(input));
  }

  /**
   * Batch processes list of integers. Result is distinct and sorted naturally.
   *
   * @param input integers list
   * @return map with key representing batch number and corresponding lists of batched integers
   */
  Map<Integer, List<Integer>> batchProcessInput(final List<Integer> input) {
    return input.stream()
        .distinct()
        .sorted()
        .collect(Collectors.groupingBy(i -> i / batchSize));
  }

  /**
   * Calculates statistics of given integer list.
   * Includes: count, distinct count, min, max.
   *
   * @param input integers
   * @return String with stats
   */
  String calculateStats(final List<Integer> input) {
    final long size = input.size();
    final IntSummaryStatistics statistics = input.stream()
        .distinct()
        .sorted()
        .mapToInt(Integer::intValue)
        .summaryStatistics();
    return "count: " + size + "\n" +
        "distinct: " + statistics.getCount() + "\n" +
        "min: " + statistics.getMin() + "\n" +
        "max: " + statistics.getMax();
  }

}
