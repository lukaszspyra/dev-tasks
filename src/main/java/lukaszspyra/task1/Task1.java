package lukaszspyra.task1;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class Task1 {

  /**
   * Used as a field to capture state for output unit test.
   */
  private PrintStream out;

  Task1(PrintStream out) {
    this.out = out;
  }

  void processInput(final int[] input) {
    String stats = calculateStats(input);
    out.print(Arrays.stream(input).distinct().sorted().mapToObj(String::valueOf).collect(Collectors.joining(" ", "", "\n")));
    out.print(stats);
  }

  private String calculateStats(final int[] input) {
    final long size = input.length;
    final IntSummaryStatistics statistics = Arrays.stream(input)
        .distinct()
        .sorted()
        .summaryStatistics();
    return "count: " + size + "\n" +
        "distinct: " + statistics.getCount() + "\n" +
        "min: " + statistics.getMin() + "\n" +
        "max: " + statistics.getMax();
  }

}
