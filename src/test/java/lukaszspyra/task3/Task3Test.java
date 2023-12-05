package lukaszspyra.task3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the third task.
 */
public class Task3Test {

  @Test
  public void shallCountSeparateGraphs() {
    //given
    int connections = 3;
    int[][] input = new int[][]{
        {4, 3},
        {1, 4},
        {5, 6}
    };
    String expectedOutput = "2";
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Task3 task3 = new Task3(new PrintStream(outputStream));

    //when
    task3.printSeparateGraphs(connections, input);

    //then
    assertEquals(expectedOutput, outputStream.toString());
  }

}
