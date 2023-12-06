package lukaszspyra.task3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the third task.
 */
public class Task3Test {

  @ParameterizedTest
  @MethodSource("providePairsConnectionsExpectedOutput")
  public void shallCountSeparateGraphs(int[][] input, int connections, String expectedOutput) {
    //given
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Task3 task3 = new Task3(new PrintStream(outputStream));

    //when
    task3.printSeparateGraphs(connections, input);

    //then
    assertEquals(expectedOutput, outputStream.toString());
  }

  private static Stream<Arguments> providePairsConnectionsExpectedOutput() {
    return Stream.of(
        Arguments.of(new int[][]{
            {1, 2},
            {2, 3},
            {4, 5}
        }, 3, "2"),
        Arguments.of(new int[][]{
            {4, 3},
            {1, 4},
            {5, 6}
        }, 3, "2"),
        Arguments.of(new int[][]{
            {1, 2},
            {2, 3},
            {4, 5},
            {3, 4}
        }, 4, "1")
    );
  }

}
