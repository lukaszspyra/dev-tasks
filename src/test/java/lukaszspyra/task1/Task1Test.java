package lukaszspyra.task1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the first task.
 */
public class Task1Test {

  @Test
  public void outputShallBeDistinctSortedWithMeasurements() {
    //given
    int[] input = new int[]{1, 10, 20, 20, 2, 5};
    String expectedOutput = "1 2 5 10 20\n" +
        "count: 6\n" +
        "distinct: 5\n" +
        "min: 1\n" +
        "max: 20";
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Task1 task1 = new Task1(new PrintStream(outputStream));

    //when
    task1.processInput(input);

    //then
    assertEquals(expectedOutput, outputStream.toString());
  }

}
