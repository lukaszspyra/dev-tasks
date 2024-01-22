package lukaszspyra.task3;

import lukaszspyra.Console;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the third task.
 */
public class Task3Test {

  @ParameterizedTest
  @MethodSource("providePairsConnectionsExpectedOutput")
  public void shallCountSeparateGraphs(InputGraphData inputGraphData, String expectedOutput) {
    //given
    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Task3 task3 = new Task3(new Console(null, new PrintStream(outputStream), null));

    //when
    task3.findSeparateGraphs(inputGraphData);

    //then
    assertEquals(expectedOutput, outputStream.toString());
  }

  private static Stream<Arguments> providePairsConnectionsExpectedOutput() {
    Map<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>() {{
      put(4, Arrays.asList(3, 1));
      put(1, Arrays.asList(4));
      put(5, Arrays.asList(6));
      put(3, Arrays.asList(4));
      put(6, Arrays.asList(5));
    }};

    Map<Integer, List<Integer>> map2 = new HashMap<Integer, List<Integer>>() {{
      put(1, Arrays.asList(2));
      put(2, Arrays.asList(3, 1));
      put(4, Arrays.asList(5, 3));
      put(3, Arrays.asList(2, 4));
      put(5, Arrays.asList(4));
    }};
    return Stream.of(
        Arguments.of(new InputGraphData(3, map1)
            , "2"),
        Arguments.of(new InputGraphData(4, map2)
            , "1")
    );
  }

}
