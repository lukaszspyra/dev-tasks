package lukaszspyra.task1;

import lukaszspyra.Console;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the first task.
 */
public class Task1Test {

  @Test
  public void outputShallBeDistinctSortedWithMeasurements() {
    //given
    List<Integer> inputList = Arrays.asList(1, 10, 20, 20, 2, 5);
    String expectedOutput = "1 2 5 10 20\n" +
        "count: 6\n" +
        "distinct: 5\n" +
        "min: 1\n" +
        "max: 20";
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final Console testConsole = new Console(new Scanner("test"), new PrintStream(outputStream), null);
    Task1 task1 = new Task1(2, testConsole);

    //when
    testConsole.printNumbers(task1.batchProcessInput(inputList));
    testConsole.printStats(task1.calculateStats(inputList));

    //then
    final String s = outputStream.toString();
    assertTrue(s.contains(expectedOutput));
  }

}
